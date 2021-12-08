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
	Personnage perso = new Personnage();
	char valueDeplacement; //variable qui stockera le touche pressée
        
        int oldX;
        int oldY;
        
        int X;
        int Y;
    
    public void premierPlacement(){
        
        printMap.setMap();
        
        ArrayList<Integer> start = printMap.startLevel();
        
        X = start.get(0);
        Y = start.get(1);
                // Premier print pour affiche le niveau + Trouver la position du départ du niveau               
        printMap.placer(X, Y, 'J');
        perso.setXYPerso(X, Y);
	printMap.afficherMatrice(X,Y);
        
    }
    
    public void whileNiveau(){
        
        while(printMap.niveauEsTilTermine() == false) {
                    
            //i++; //pour le debug
            //System.out.println(i);
                        
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
                    deplacer(1);
                }
				
                if(valueDeplacement == 's') {
                    X ++;
                    deplacer(2);
                }
				
                if(valueDeplacement == 'd') {
                    Y ++;
                    deplacer(3);
                }
				
                if(valueDeplacement == 'q') {
                    Y --;
                    deplacer(4);
                }
                
                
            }
        }
        System.out.println("Bravo ! Niveau Terminé !");
    }
        
    public void deplacer(int n){
        
        if(printMap.isPosValide(X, Y) == false){
            System.out.println("Mauvaise case");
        } else if(printMap.isGlaceEpaisse(X, Y) == true) {
            //printMap.placer(X, Y, 'o');
            printMap.placer(oldX, oldY, 'o');
            perso.deplacerPersonnage(n);
        } else {                        
            printMap.placer(oldX, oldY, 'x');
            perso.deplacerPersonnage(n);
            //printMap.placer(X, Y, 'J');
        }
    }
 
	
    
        
}
    

