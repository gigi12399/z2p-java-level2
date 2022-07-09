package com.mmit;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mmit.entity.Batch;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/batches","/batch-add"})
public class BatchController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();
		
		List<Batch> list = (ArrayList<Batch>) context.getAttribute("batches");
		if(list == null) {
			list = new ArrayList<Batch>();
			list.add(new Batch("Batch 1", LocalDate.parse("2022-07-12")));
			list.add(new Batch("Batch 2", LocalDate.parse("2022-08-23")));
			
			context.setAttribute("batches", list);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/batch.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get data from parameter
		String batch_name = req.getParameter("batch");
		String start_date = req.getParameter("start_date");
		
		// create application scope
		ServletContext context = getServletConfig().getServletContext();
		
		// create list and get batch list from app scope
		List<Batch> list = (ArrayList<Batch>) context.getAttribute("batches");
		
		//  add batch obj to list
		if(list == null) {
			list = new ArrayList<Batch>();
		}
		list.add(new Batch(batch_name, LocalDate.parse(start_date)));
		
		// add list to application
		context.setAttribute("batches", list);
		
		// invoke
		resp.sendRedirect(req.getContextPath() + "/batches");
	}
}
