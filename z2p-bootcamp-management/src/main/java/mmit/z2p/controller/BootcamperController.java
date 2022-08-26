package mmit.z2p.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mmit.z2p.model.entity.Batch;
import mmit.z2p.model.entity.Bootcamper;
import mmit.z2p.model.service.BatchService;
import mmit.z2p.model.service.BootcamperService;
import mmit.z2p.model.service.LevelService;

@WebServlet(urlPatterns = {"/bootcampers","/add-bootcamper","/edit-bootcamper","/select-level"})
public class BootcamperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchService batchService;
    private BootcamperService bootcamperService;
    private LevelService levelService;
    public BootcamperController() {
        super();
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	var emf_obj = (EntityManagerFactory)getServletContext().getAttribute("emf");
    	if(emf_obj == null) {
    		emf_obj = Persistence.createEntityManagerFactory("z2p");
    		getServletContext().setAttribute("emf", emf_obj);
    	}
    	batchService = new BatchService(emf_obj.createEntityManager());
    	bootcamperService = new BootcamperService(emf_obj.createEntityManager());
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
		
		if("/bootcampers".equals(action))
			goHomePage(request,response);
		else if("/add-bootcamper".equals(action) || "/edit-bootcamper".equals(action) || "/select-level".equals(action))
			goAddPage(request,response);
	}
		
	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var levelId = request.getParameter("levelId");
		var bootcamperId = request.getParameter("id");
		var batchId = request.getParameter("batchId");
		var batchlist = (levelId == null ? batchService.findByLevelId(1) : batchService.findByLevelId(Integer.parseInt(levelId))) ;
		var obj = (bootcamperId == null ? new Bootcamper() : bootcamperService.findById(Integer.parseInt(bootcamperId)));
		var lvlList = levelService.findAll();
		request.setAttribute("title", "Bootcamper");
		request.setAttribute("bootcamper", obj);
		request.setAttribute("batchlist", batchlist);
		request.setAttribute("levels", lvlList);
		request.setAttribute("levelId", levelId);
		request.setAttribute("batchId", batchId);
		getServletContext().getRequestDispatcher("/bootcamper-add.jsp").forward(request, response);
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var batchId = request.getParameter("batchId");
		var list = (batchId == null ? bootcamperService.findAll() : bootcamperService.findByBatchId(Integer.parseInt(batchId)));
		request.setAttribute("title", "Bootcamper");
		request.setAttribute("bootcampers", list);
		getServletContext().getRequestDispatcher("/bootcamper-home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve date
		var id = request.getParameter("bootcamperId");
		var obj = ("0".equals(id) ? new Bootcamper() : bootcamperService.findById(Integer.parseInt(id)));
		obj.setName(request.getParameter("name"));
		obj.setPhone(request.getParameter("phone"));
		obj.setEmail(request.getParameter("email"));
		obj.setAddress(request.getParameter("address"));
		obj.setBatch(batchService.findById(Integer.parseInt(request.getParameter("batch"))));
		
		// save to db
		bootcamperService.save(obj);
		
		// redirect page
		response.sendRedirect(request.getContextPath().concat("/bootcampers"));
	}

}
