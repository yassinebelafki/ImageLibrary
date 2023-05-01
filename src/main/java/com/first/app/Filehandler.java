package com.first.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.DAO.filesDAO;
import com.first.entity.Files;

@WebServlet("/filehandler")
public class Filehandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "view": {
				int id=Integer.valueOf(request.getParameter("id"));
				viewImage(request,response,id);
			break;
		}
		case "delete": {
			int id=Integer.valueOf(request.getParameter("id"));
			deleteImage(request,response,id);
		break;
	}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
			
	}

	private void deleteImage(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
			filesDAO.deleteItem(id);
			listingimages(request,response);
	}

	private void viewImage(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
			Files file = filesDAO.getImage(id);
			request.setAttribute("image",file);
			request.setAttribute("path", "C:/Users/YASSINE/Desktop/JAVA/images/");
			request.getRequestDispatcher("view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "update": {
			String id = request.getParameter("id");
			String caption = request.getParameter("caption");
			String label = request.getParameter("label");
			System.out.println(caption);
			System.out.println(label);
			filesDAO.updateInfo(id, caption, label);
			listingimages(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

	}

	private void listingimages(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Files> files = new filesDAO().listing();
		request.setAttribute("fileslist", files);
		request.setAttribute("path", "C:/Users/YASSINE/Desktop/JAVA/images/");
		request.getRequestDispatcher("listingimages.jsp").forward(request, response);

	}

}
