package com.iga.app.ui;

import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class JobDetailsServlet
 */
@WebServlet("/jobDetails")
public class JobDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JobBS jobsBS = new JobBSImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long id=-1;
			final String idString = request.getParameter("id");
			if(idString!=null && !idString.trim().isEmpty()) {
				id = Long.parseLong(idString);
			}
			Optional<Job> job = jobsBS.findById(id);
			if(job.isPresent()) {
				request.setAttribute("job", job.get());
			}else {
				request.setAttribute("errors", "job inexistant");
			}
		} catch (Exception e) {
			request.setAttribute("errors", e.getMessage());
		}
		request.getRequestDispatcher("jobDetailsPage.jsp").forward(request, response);;
	}

}
