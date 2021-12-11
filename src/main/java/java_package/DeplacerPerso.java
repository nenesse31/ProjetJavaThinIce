/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_package;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DeplacerPerso {
    
        Print2DArray printMap = new Print2DArray();
	//Personnage perso = new Personnage();
	char valueDeplacement; //variable qui stockera le touche pressée
        
        int i = 0;
        
        static int oldX;
        static int oldY;
        
        static int X;
        static int Y;
        
        static int OX;
        static int OY;
    
    public void premierPlacement(){
        printMap.newNiveau();
        printMap.setMap(0);
        
        ArrayList<Integer> start = printMap.startLevel();
        
        X = start.get(0);
        Y = start.get(1);
                // Premier print pour affiche le niveau + Trouver la position du départ du niveau               
        printMap.placer(X, Y, 'J');
        //perso.setXYPerso(X, Y);
	printMap.afficherMatrice(X,Y);
        
    }
    
    public void whileNiveau(){
        
        while(printMap.niveauEsTilTermine() == false) {
                    
            //i++; //pour le debug
            //System.out.println(i);
            
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
                    deplacer();
                }
				
                if(valueDeplacement == 's') {
                    X ++;
                    deplacer();
                }
				
                if(valueDeplacement == 'd') {
                    Y ++;
                    deplacer();
                }
				
                if(valueDeplacement == 'q') {
                    Y --;
                    deplacer();
                }
                
                if(valueDeplacement == '2') {
                    printMap.setMap(2);
                }
                
                printMap.afficherMatrice(X,Y);
                
            }
        }
        System.out.println("Bravo ! Niveau Terminé !");
    }
     
    int glace = 4;
    
    public void deplacer(){
        
        glace ++;
        
        if(printMap.isGlaceEpaisse(X, Y) == true) {
            glace = 1;
        }
        
        
        if(printMap.isPosValide(X, Y) == false){
            System.out.println("Mauvaise case");
            X = oldX;
            Y = oldY;
        } else if(glace == 3) {
            System.out.println("Glace epaisse");
            printMap.placer(oldX, oldY, 'o');
           } else {
           printMap.placer(oldX, oldY, 'x');
           
        }
        
    }
    
}
    

