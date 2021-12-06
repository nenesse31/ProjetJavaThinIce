package java_package;

import java.util.ArrayList;
import java.util.Scanner;

//!!!! attention: valeur ligne = x ,valeur colonne = y !!!!!!!



public class Main {

    public static void main(String[] args) {
        
        ReadFile readF = new ReadFile();
        Print2DArray printMap = new Print2DArray();
	Personnage perso = new Personnage();
	char valueDeplacement; //variable qui stockera le touche pressée
	int i =0;
        
        int oldX;
        int oldY;
        
        int X;
        int Y;
        
        readF.readFile();
    
        
        /*
        ArrayList<Integer> start = printMap.startLevel();
        
        X = start.get(0);
        Y = start.get(1);
                // Premier print pour affiche le niveau + Trouver la position du départ du niveau               
        printMap.placer(X, Y, 'J');
        perso.setXYPerso(X, Y);
	printMap.afficherMatrice();
                
                
                //boucle while qui tourne jusqu'a ce que le niveau soit terminé
	while(printMap.niveauEsTilTermine() == false) {
                    
            i++; //pour le debug
            System.out.println(i);
                        
            X = perso.getXPerso();
            Y = perso.getYPerso();
            
            oldX = X;
            oldY = Y;
            
            Scanner touche = new Scanner(System.in);
            valueDeplacement = touche.next().charAt(0); //scanner touche 
		
            
				
            if(valueDeplacement != 'z' && valueDeplacement != 's' && valueDeplacement != 'q' && valueDeplacement != 'd') {
		System.out.println("Mauvaise Touche");
            }
            else {
								
                if(valueDeplacement == 'z') {
                    X --;
                    if(printMap.isPosValide(X, Y) == false){
                        System.out.println("Mauvaise case");
                    } else {
                        printMap.placer(oldX, oldY, 'x');
                        perso.deplacerPersonnage(1);
                        printMap.placer(X, Y, 'J');
                    }
                }
				
                if(valueDeplacement == 's') {
                    X ++;
                    if(printMap.isPosValide(X, Y) == false){
                        System.out.println("Mauvaise case");
                    } else {
                        printMap.placer(oldX, oldY, 'x');
                        perso.deplacerPersonnage(2);
                        printMap.placer(X, Y, 'J');
                    }
                }
				
                if(valueDeplacement == 'd') {
                    Y ++;
                    if(printMap.isPosValide(X, Y) == false){
                        System.out.println("Mauvaise case");
                    } else {
                        printMap.placer(oldX, oldY, 'x');
                        perso.deplacerPersonnage(3);
                        printMap.placer(X, Y, 'J');
                    }
                }
				
                if(valueDeplacement == 'q') {
                    Y --;
                    if(printMap.isPosValide(X, Y) == false){
                        System.out.println("Mauvaise case");
                    } else {
                        printMap.placer(oldX, oldY, 'x');
                        perso.deplacerPersonnage(4);
                        printMap.placer(X, Y, 'J');
                    }	
                }
                
 
                System.out.println(""+oldX +oldY);
                    // replacer le joueur à sa place initiale
                   //x = glace fondue, placement glace fondue a l'ancien emplacement du personnage
                printMap.afficherMatrice();
                
                }
                
            }*/
	
	System.out.println("Bravo ! Niveau Terminé !");
    
    }

}
