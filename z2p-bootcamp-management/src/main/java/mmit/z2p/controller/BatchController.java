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
import mmit.z2p.model.service.BatchService;
import mmit.z2p.model.service.LevelService;

@WebServlet(urlPatterns = {"/batches","/add-batch","/edit-batch"}, loadOnStartup = 1)
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchService batchService;
    private LevelService levelService;
    public BatchController() {
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
		
		if("/batches".equals(action))
			goHomePage(request,response);
		else if("/add-batch".equals(action) || "/edit-batch".equals(action))
			goAddPage(request,response);
	}
		

	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id =request.getParameter("id");
		var obj = id == null ? new Batch() : batchService.findById(Integer.parseInt(id));
		var list = levelService.findAll();
		request.setAttribute("title", "Batch");
		request.setAttribute("batch", obj);
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/batch-add.jsp").forward(request, response);
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var levelId = request.getParameter("levelId"); // null if it comes from batch link
		var list = levelId == null ? batchService.findAll() : batchService.findByLevelId(Integer.parseInt(levelId));
		request.setAttribute("title", "Batch");
		request.setAttribute("batches", list);
		getServletContext().getRequestDispatcher("/batch-home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// retrieve date
		var id = request.getParameter("batchId");
		var batch = ("0".equals(id) ? new Batch() : batchService.findById(Integer.parseInt(id)));
		batch.setLevel(levelService.findById(Integer.parseInt(request.getParameter("level"))));
		batch.setName(request.getParameter("name"));
		batch.setStartDate(LocalDate.parse(request.getParameter("startDate")));
		
		// save to db
		batchService.save(batch);
		
		// redirect page
		response.sendRedirect(request.getContextPath().concat("/batches"));
	}

}
