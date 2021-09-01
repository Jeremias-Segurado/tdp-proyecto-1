package launcher;

import gui.*;
import entities.*;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            	    Student yo = setStudent();            	   
            		SimplePresentationScreen window = new SimplePresentationScreen(yo);            		
            		window.setVisible(true);            		
            	}catch(Exception e) { e.printStackTrace(); }
            }
        });
    }
	
	private static Student setStudent() {				
		int id = 110274;
		String lastName = "Segurado Negrin";
		String firstName = "Jeremias Eloy";
		String mail = "jere_segurado@yahoo.com";
		String githubURL = "https://github.com/Jeremias-Segurado/tdp-proyecto-1";
		String pathPhoto = "/images/Foto_personal.jpg";		 		
		return new Student(id, lastName, firstName, mail, githubURL, pathPhoto);
	}
}