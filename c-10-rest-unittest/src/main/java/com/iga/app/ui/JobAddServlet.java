package com.iga.app.ui;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iga.app.domain.Job;
import com.iga.app.service.JobBS;
import com.iga.app.service.JobBSImpl;

/**
 * Servlet implementation class JobAddServlet
 */
@WebServlet("/jobAdd")
public class JobAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JobBS jobsBS = new JobBSImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Job job = null;
		try {
			final String title = request.getParameter("title");
			final String minSalaryString = request.getParameter("minSalary");
			final String maxSalaryString = request.getParameter("maxSalary");
			job = new Job(title,Double.parseDouble(minSalaryString),Double.parseDouble(maxSalaryString));
			//si erreurs je le ferai dans l'exception
			job = jobsBS.save(job);
			request.setAttribute("job", job);//envoi pour affichage
			response.sendRedirect("jobsList");
		} catch (Exception e) {
			request.setAttribute("job", job);//envoi pour reremplir le formulaire
			request.setAttribute("erreurs", e.getMessage());
			response.sendRedirect("jobAddPage.jsp");
		}

	}


}
