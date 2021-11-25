package java_package;

import java.util.Scanner;

//!!!! attention: valeur ligne = x ,valeur colonne = y !!!!!!!

public class Main {

	public static void main(String[] args) {
		Print2DArray printMap = new Print2DArray();
		Personnage perso = new Personnage();
		char valueDeplacement;
		
		while(printMap.niveauEsTilTermine() == false) {
		
			printMap.placer(perso.getXPerso(), perso.getYPerso(), 'J');
			printMap.afficherMatrice();
			
			Scanner touche = new Scanner(System.in);
			valueDeplacement = touche.next().charAt(0);
			
				
			if(valueDeplacement != 'z' && valueDeplacement != 's' && valueDeplacement != 'q' && valueDeplacement != 'd') {
				System.out.println("Mauvaise Touche");
			}
			else {
				printMap.placer(perso.getXPerso(), perso.getYPerso(), 'x'); //x = glace fondue
				
				if(valueDeplacement == 'z') {
					perso.deplacerPersonnage(1);
				}
				
				if(valueDeplacement == 's') {
					perso.deplacerPersonnage(2);
				}
				
				if(valueDeplacement == 'd') {
					perso.deplacerPersonnage(3);
				}
				
				if(valueDeplacement == 'q') {
					perso.deplacerPersonnage(4);	
				}
				
				printMap.placer(perso.getXPerso(), perso.getYPerso(), 'J');
				printMap.afficherMatrice();
			}
		}
		
		System.out.println("Bravo ! Niveau Terminé !");
		

		
		

	}

}
