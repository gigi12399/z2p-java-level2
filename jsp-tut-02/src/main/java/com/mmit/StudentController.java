package com.mmit;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mmit.entity.Batch;
import com.mmit.entity.Student;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/students", "/student-add", "/add-student" })
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();
		
		List<Batch> list = (ArrayList<Batch>)context.getAttribute("batches");
		if(list == null) {
			list = new ArrayList<Batch>();
			list.add(new Batch("Batch 1", LocalDate.parse("2022-07-12")));
			list.add(new Batch("Batch 2", LocalDate.parse("2022-08-23")));
			
			context.setAttribute("batches", list);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println("action name: " + action);
		String title_value = "";
		String page = "";
		if("/students".equals(action)) {
			title_value = "Student";
			page = "/students.jsp";
		}
		else if("/student-add".equals(action)) {
			title_value = "Student|Add";
			page = "/student-add.jsp";
			
		}
		req.setAttribute("title", title_value);
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get data from parameter
		String name = req.getParameter("stdName");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("email");
		String batchName = req.getParameter("batch");
		String old_std = req.getParameter("old");
		
		// create student and assign data
		Student new_student = new Student();
		new_student.setName(name);
		new_student.setPhone(phone);
		new_student.setEmail(mail);
		new_student.setOldStudent(old_std == null ? false : true);
		new_student.setRegisterDate(LocalDate.now());
		new_student.setBatch(batchName);
		
		// get session object
		HttpSession session = req.getSession(true);
		
		// get or create student list from session object
		List<Student> list =(ArrayList<Student>) session.getAttribute("students");
		if(list == null) {
			list = new ArrayList<Student>();
		}
		
		// add student obj to list 
		list.add(new_student);
		
		// add list to session
		session.setAttribute("students", list);
		
		//invoke
		resp.sendRedirect(req.getContextPath() + "/students");// project name/ students(get)
	}
}
