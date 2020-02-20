package fr.eni.tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ServletUpload
 */
@WebServlet("/upload")
// Préciser de supporter l'upload d'une image multipaart/data-form d'une jsp
@MultipartConfig
public class ServletUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Récupération de l'objet "file" uploadé
		Part filePart = request.getPart("file");
		// Récupération du nom du fichier + extension
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		// Transformation de l'image en stram d'octets
		InputStream fileContent = filePart.getInputStream();
		int i = 2;
		// Chemin de destination du fichier uploadé
		File uploads = new File("C:/uploads/" + i);
		// Chemin de destination + fichier concerné
		File file = new File(uploads, fileName);
		// crée le répertoire de destination si non existant
		uploads.mkdir();

		// copie du fichier s'il existe
		if (!fileName.isEmpty()) {
			Files.copy(fileContent, file.toPath());
		}

		// Envoi du nom de l'image en attribut
		// On peut aussi appeler une requête SQL : DAL -> BLL -> Servlet
		// Pour stocker le nom de l'image (ou adresse) dans la BDD
		request.setAttribute("imageName", fileName);
		RequestDispatcher rd = request.getRequestDispatcher("/ServletImage");
		rd.forward(request, response);
	}

}
