package mmit.z2p.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mmit.z2p.model.entity.Course;
import mmit.z2p.model.service.BatchService;
import mmit.z2p.model.service.CourseService;
import mmit.z2p.model.service.LevelService;

@WebServlet(urlPatterns = {"/courses","/add-course","/edit-course","/delete-course"},loadOnStartup = 1)
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CourseController() {
        super();
    }
    private LevelService levelService;
    private CourseService courseService;
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	var emf_obj = (EntityManagerFactory)getServletContext().getAttribute("emf");
    	if(emf_obj == null) {
    		emf_obj = Persistence.createEntityManagerFactory("z2p");
    		getServletContext().setAttribute("emf", emf_obj);
    	}
    	courseService = new CourseService(emf_obj.createEntityManager());
    	levelService = new LevelService(emf_obj.createEntityManager());
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	var emf_obj = (EntityManagerFactory)getServletContext().getAttribute("emf");
    	if(emf_obj != null && emf_obj.isOpen()) {
    		emf_obj.close();
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getServletPath();
		if("/courses".equals(action))
			goHomePage(request,response);
		else if("/add-course".equals(action) || "/edit-course".equals(action))
			goAddPage(request,response);
		else if("/delete-course".equals(action))
			deleteCourse(request,response);
	}

	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("id");
		// delete from db
		courseService.deleteById(Integer.parseInt(id));
		//redirect
		response.sendRedirect(request.getContextPath().concat("/courses"));
	}

	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var courseId = request.getParameter("id"); // if it comes from add course url, null
		var list = levelService.findAll();
		var obj = (courseId == null ? new Course() : courseService.findById(Integer.parseInt(courseId)));
		request.setAttribute("title", "Course");
		request.setAttribute("levels", list);
		request.setAttribute("course", obj);
		getServletContext().getRequestDispatcher("/course-add.jsp").forward(request, response);
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("levelId");
		var list = (id == null) ? courseService.findAll() : courseService.findByLevelId(Integer.parseInt(id));
		request.setAttribute("title", "Course");
		request.setAttribute("courses", list);
		getServletContext().getRequestDispatcher("/course-home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("courseId");
		var course = ("0".equals(id) ? new Course() : courseService.findById(Integer.parseInt(id)));
		
		// get data from request
		course.setLevel(levelService.findById(Integer.parseInt(request.getParameter("level"))));
		course.setName(request.getParameter("name"));
		course.setContent(request.getParameter("outline"));
		
		// save to database
		courseService.save(course);
		
		// redirect other route
		response.sendRedirect(request.getContextPath().concat("/courses"));
	}

}
