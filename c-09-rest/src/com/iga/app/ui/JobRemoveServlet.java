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
 * Servlet implementation class JobRemoveServlet
 */
@WebServlet("/jobRemove")
public class JobRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JobBS jobsBS = new JobBSImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobRemoveServlet() {
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
			boolean ok = jobsBS.removeById(id);
			if(ok) {
				request.setAttribute("message", "job deleted");
			}else {
				request.setAttribute("erreurs", "job inexistant");
			}
		} catch (Exception e) {
			request.setAttribute("erreurs", e.getMessage());
		}
		response.sendRedirect("jobsList");
	}


}
