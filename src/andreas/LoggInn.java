package andreas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoggInn
 */
@WebServlet("/LoggInn")
public class LoggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<Bruker> brukere = (List<Bruker>) request.getSession().getAttribute("brukere");
		
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		
		Bruker bruker = brukere.stream().filter(x -> x.getMobil().equals(mobil)).findAny().orElse(null);
		
		if( bruker != null && PassordUtil.sjekkPassord(passord, bruker.getPassord())) {
			
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("brukere", brukere);
			session.setAttribute("du", bruker);
			request.getSession().setAttribute("feilmelding", "");
			response.sendRedirect("Meldinger");
		} else {
			request.getSession().setAttribute("feilmelding", "Feil brukernavn eller passord");
			response.sendRedirect("LoggInn");
		}
		
		
 	}

}
