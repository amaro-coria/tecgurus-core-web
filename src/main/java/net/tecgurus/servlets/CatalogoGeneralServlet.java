package net.tecgurus.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.common.dto.CatalogoGeneralDTO;
import net.tecgurus.core.ejb.business.interf.CatalogoGeneralService;

/**
 * Servlet implementation class CatalogoGeneralServlet
 */
public class CatalogoGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoGeneralService serviceCata;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CatalogoGeneralDTO> list = serviceCata.findAll();
		if(list == null){
			response.getWriter().write("No data");
		}else{
			for(CatalogoGeneralDTO dto : list){
				response.getWriter().println("Catalogo: "+dto.getDscCorCat());
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
