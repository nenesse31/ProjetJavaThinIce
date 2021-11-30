package java_package;

import java.util.Scanner;

//!!!! attention: valeur ligne = x ,valeur colonne = y !!!!!!!

public class Main {

    public static void main(String[] args) {
            
        Print2DArray printMap = new Print2DArray();
	Personnage perso = new Personnage();
	char valueDeplacement; //variable qui stockera le touche pressée
	int i =0;
        
        int X;
        int Y;
                // Premier print pour affiche le niveau                
        printMap.placer(perso.getXPerso(), perso.getYPerso(), 'J', false);
	printMap.afficherMatrice();
                
                
                //boucle while qui tourne jusqu'a ce que le niveau soit terminé
	while(printMap.niveauEsTilTermine() == false) {
                    
            i++; //pour le debug
            System.out.println(i);
                        
			
			
            Scanner touche = new Scanner(System.in);
            valueDeplacement = touche.next().charAt(0); //scanner touche 
			
				
            if(valueDeplacement != 'z' && valueDeplacement != 's' && valueDeplacement != 'q' && valueDeplacement != 'd') {
		System.out.println("Mauvaise Touche");
            }
            else {
								
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
                X = perso.getXPerso();
                Y = perso.getYPerso();
                System.out.println(""+X +Y);
                
                X = perso.getOldxPerso();
                Y = perso.getOldyPerso();
                System.out.println(""+X +Y);
                
                   // sinon remettre de la glace a la pace du joueur
                if (printMap.placer(perso.getXPerso(), perso.getYPerso(), 'J', true) == true){
                    printMap.placer(perso.getXPerso(), perso.getYPerso(), 'J', false);
                    printMap.placer(perso.getOldxPerso(), perso.getOldyPerso(), 'x', false);
                } else { 
                    System.out.println("Mauvaise case");
                    X = perso.getOldxPerso();
                    Y = perso.getOldyPerso();
                    
                    perso.setXPerso(X);
                    perso.setYPerso(Y);
                }
                
                X = perso.getXPerso();
                Y = perso.getYPerso();
                System.out.println(""+X +Y);
                
                X = perso.getOldxPerso();
                Y = perso.getOldyPerso();
                System.out.println(""+X +Y);
                    // replacer le joueur à sa place initiale
                   //x = glace fondue, placement glace fondue a l'ancien emplacement du personnage
                printMap.afficherMatrice();
                
                }
                
            }
	
	System.out.println("Bravo ! Niveau Terminé !");
    
    }

}
