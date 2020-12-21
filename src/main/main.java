package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		//test input
//        //Enter data using BufferReader 
//        BufferedReader reader =  
//                   new BufferedReader(new InputStreamReader(System.in)); 
//         
//        // Reading data using readLine 
//        String name = "";
//		try {
//			name = reader.readLine();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//  
//        // Printing the read line 
//        System.out.println(name); 
		
//		Ville ville = new Ville("test");
//		
//		System.out.println(ville.getLimiteRessource("ACIER"));
//		
//		Entrepot entrepot1 = new Entrepot();
//		
//		System.out.println(entrepot1.isConstructible());
//		
//		ville.constructBatiment(new Entrepot());
//		
//		Ressource.ACIER.gainRessource(100);
//		Ressource.BOIS.gainRessource(100);
//		Ressource.PIERRE.gainRessource(100);
//		
//		ville.constructBatiment(new Entrepot());
//		
//		System.out.println(ville.getLimiteRessource("ACIER"));
//		
//		Ressource.ACIER.gainRessource(50);
//		Ressource.BOIS.gainRessource(50);
//		Ressource.PIERRE.gainRessource(100);
//		
//		ville.constructBatiment(new Carriere());
//		
//		System.out.println(Ville.getBatiments().size());
//		
//		System.out.println(Ressource.PIERRE.getCroissance());
//		
//		System.out.println(Ressource.PIERRE.getQuantite());
//		
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(Ressource.PIERRE.getQuantite());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame fenetre = new JFrame("The PouiGame");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		fenetre.setLocationRelativeTo(null);
		fenetre.setAlwaysOnTop(true);
		fenetre.setVisible(true);
	}

}
