package fr.eni.tests;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAffichageImage
 */
@WebServlet("/ServletAffichageImage")
public class ServletAffichageImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAffichageImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
 
			// Création d'un flux de données de sortie
			DataOutput output = new DataOutputStream( response.getOutputStream() );
			// Type de données à afficher
			response.setContentType("image/jpeg");
 
			// Récupération du nom de l'image en paramètre
			// Aussi possible en récupérant via la BDD
			String nomImage = request.getParameter("nomImage");
 
			File file = null;
			FileInputStream in = null;
 
			// Chemin d'accès utilisé + nom du fichier à afficher
			String filePath = "C:/uploads/2/"+nomImage;
 
			file = new File(filePath);				
 
			/*
			 * Dans le cas ou l'image n'est pas présente dans le répertoire
			 * On affiche une image par defaut 'Image Introuuvable'
			 */
//			if(!file.exists())
//			{
//				String path = session.getServletContext().getRealPath("")+"/img/imageIntrouvable.jpg"+
//				file = new File(path);				  
//			}
 
			// Déclaration du flux d'entrée avec l'image à afficher
			in = new FileInputStream(file);
 
			// Détermination de la taille du fichier
			response.setContentLength((int)file.length());
 
			// Déclaration du buffer
			byte buffer[]=new byte[4096];
			int nbLecture;
 
			// Tant que l'on peut lire le fichier avec le buffer on écrit l'image
			while( (nbLecture = in.read(buffer)) != -1 )
			{				
				output.write(buffer,0,nbLecture);					
			}	
 
			// fermeture du flux d'entrée
			in.close();
 
		}
		catch (IOException e)
		{
		    e.printStackTrace();		
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
