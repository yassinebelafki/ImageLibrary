package com.first.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.first.DAO.filesDAO;
import com.first.entity.Files;

@WebServlet("/imageupload")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path="C:/Users/YASSINE/Desktop/JAVA/images/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "fileupload": {
			uploadfile(request, response);
			break;
		}
		case "listingimages": {
			listingimages(request, response);
			break;
		}
		default: {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		}

	}

	private void listingimages(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			List<Files> files=new filesDAO().listing();
			request.setAttribute("fileslist", files);
			request.setAttribute("path", path);
			request.getRequestDispatcher("listingimages.jsp").forward(request, response);
		
	}

	public void uploadfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		try {
			List<FileItem> images = upload.parseRequest(request);
			for (FileItem image : images) {
				String path = image.getName();
				String name = path.substring(path.lastIndexOf("\\") + 1);
				File file = new File("C:/Users/YASSINE/Desktop/JAVA/images/" + name);
				if (!file.exists()) {
					image.write(file);
					new filesDAO().addFileDetails(new Files(name));
				}
			}
			listingimages(request, response);
		} catch (FileUploadException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "listingimages": {
			listingimages(request, response);
			break;
		}
		default: {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		}

	}
}
