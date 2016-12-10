package net.tecgurus.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.common.dto.ClienteDTO;
import net.tecgurus.core.ejb.business.inter.ClienteService;

/**
 * Servlet implementation class ClienteServlet
 */
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteService serviceCte;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nombre");
		if(name == null || name.isEmpty()){
			response.getWriter().println("No name provided");
		}else{
			List<ClienteDTO> list = serviceCte.findByName(name);
			if(list == null){
				response.getWriter().println("No matches");
			}else{
				for(ClienteDTO d : list){
					response.getWriter().println("Client: "+d.getNomCte());
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
