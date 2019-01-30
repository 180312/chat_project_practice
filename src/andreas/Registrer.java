package andreas;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrer
 */
@WebServlet("/Registrer")
public class Registrer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private BrukereEAO brukereEAO;
	private Brukere brukere;
	private Validering validering;
	

	@Override
	public void init() throws ServletException {
		brukere = brukereEAO.getBrukere();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("brukere", brukere.getBrukere());
		request.getRequestDispatcher("WEB-INF/registrering.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		validering = new Validering(request);
		request.getSession().setAttribute("validering", validering);
		
		if(validering.isAllInputGyldig()) {
			
			String hashpassord = PassordUtil.krypterPassord(request.getParameter("passord"));
			
			Bruker b = new Bruker(
					validering.getFornavn(),
					validering.getEtternavn(),
					validering.getMobil(),
					hashpassord);
			brukere.leggTilBruker(b);
			brukereEAO.oppdaterBrukere(brukere);
			request.getSession().setAttribute("du", b);
			request.getSession().setAttribute("brukere", brukere.getBrukere());
			response.sendRedirect("Meldinger");
		} else {
			response.sendRedirect("Registrer");
		}
		
	}

}
