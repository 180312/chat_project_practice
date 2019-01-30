package andreas;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Meldinger
 */
@WebServlet("/Meldinger")
public class Meldinger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MessagesEAO messagesEAO;
	private Messages messages;
	private int id;
	
	

	@Override
	public void init() throws ServletException {
		id = 1;
		messages = messagesEAO.getMessages();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("du") == null) {
			response.sendRedirect("Registrer");
			
		} else {
			request.getSession().setAttribute("messages", messages.getMessages());
			request.getRequestDispatcher("WEB-INF/meldinger.jsp").forward(request, response);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bruker b = (Bruker) request.getSession().getAttribute("du");
		messages.leggTilMelding((new Melding(b.getFornavn(),request.getParameter("melding"), id)));
		id++;
		messagesEAO.updateMessages(messages);
		request.getSession().setAttribute("messages", messages.getMessages());
		response.sendRedirect("Meldinger");
		
	}

}
