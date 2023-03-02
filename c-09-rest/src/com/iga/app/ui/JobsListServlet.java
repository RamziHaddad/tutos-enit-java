package com.iga.app.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iga.app.domain.Job;
import com.iga.app.service.JobBS;
import com.iga.app.service.JobBSImpl;

/**
 * Servlet implementation class JobsListServlet
 */
@WebServlet("/jobsList")
public class JobsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JobBS jobsBS = new JobBSImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Job> jobs;
		try {
			jobs = jobsBS.findAll();
			request.setAttribute("jobs", jobs);
		} catch (Exception e) {
			request.setAttribute("errors", e.getMessage());
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("jobsListPage.jsp").forward(request, response);
		
	}

}
