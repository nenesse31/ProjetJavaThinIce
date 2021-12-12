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
	
	char valueDeplacement; //variable qui stockera le touche pressée
        
        int i = 0;
        
        static int score = 0;
        //static int debutScore = 0;
        
        static int oldX;
        static int oldY;
        
        static int X;
        static int Y;

    
    public void premierPlacement(){

        printMap.newNiveau();
                
        X = printMap.getxStart();
        Y = printMap.getyStart();
       
                // Premier print pour affiche le niveau + Trouver la position du départ du niveau               
        printMap.placer(X, Y, 'J');
       
	printMap.afficherMatrice(score,potion);
        
    }
    
    public void whileNiveau(){
        
        while(printMap.niveauEsTilTermine() == false) {
                    
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
                
                printMap.afficherMatrice(score,potion);
                
            }
        }
        System.out.println("Bravo ! Niveau Terminé !");
        
        if(printMap.isAnyMoreLevel() == false){
            printMap.setGameFinished();
        }
    }
     
    int glace = 4;
    static int potion = 0;

    
    public void deplacer(){
        
        glace ++;
        
        if(printMap.isGlaceEpaisse(X, Y) == true) {
            glace = 1;
        }
        
        if(printMap.isPosValide(X, Y) == false){
           
            System.out.println("Mauvaise case");
            X = oldX;
            Y = oldY;
            
        } else {
            score ++;
            
            if(printMap.getCase(X, Y)=='f'){
                printMap.niveauTermine();
            }
           
            if(printMap.getCase(X, Y)=='U'){
                
               printMap.tunnelTP();
        
                X = printMap.getxTP();
                Y = printMap.getyTP();
                
                printMap.placer(oldX, oldY, 'x');     
                printMap.placer(X, Y, 'J');

                
            } else if (printMap.isPosValide(X, Y)== true ){
            
            
            printMap.placer(oldX, oldY, 'x');
            
            if(glace == 2) {
            
                System.out.println("Glace epaisse");
                printMap.placer(oldX, oldY, 'o');
            
            }
            if(printMap.isTondeuse(X,Y) == true){
               
                tondeuse();
                
            }
            if(printMap.isPotion(X,Y)){
                
                potion = 5;
                 
            }
            
            if(potion > 0 && potion < 5){
                printMap.placer(oldX, oldY, 'o');
                potion --;
            } else { 
                potion --;
            }
            printMap.placer(X,Y,'J');
            
            }
            
        }
        
        //System.out.println();
            
        
        
    }
    

    
    
    int tondeuseX;
    int tondeuseY;
    boolean mur;
    
    public void tondeuse(){
            
            mur = false;
            
            tondeuseX = X;
            tondeuseY = Y;
            
            if (oldX < X){
                //aller vers le bas X++
                while (mur == false ){
                    if(printMap.getCase(tondeuseX,tondeuseY) == 'm'){
                        mur = true;
                    } else {
                    printMap.placer(tondeuseX, tondeuseY, 'x');
                    tondeuseX ++;
                    score ++; }
                }
                tondeuseX --;                
            }
            if (oldX > X){
                //aller vers le haut X--
                while (mur == false ){
                    if(printMap.getCase(tondeuseX,tondeuseY) == 'm'){
                        mur = true;
                    } else {
                    printMap.placer(tondeuseX, tondeuseY, 'x');
                    tondeuseX --;
                    score ++; }
                }
                tondeuseX ++;                
            }
            if (oldY < Y){
                //aller vers la droite Y++
                while (mur == false ){
                    if(printMap.getCase(tondeuseX,tondeuseY) == 'm'){
                        mur = true;
                    } else {
                    printMap.placer(tondeuseX, tondeuseY, 'x');
                    tondeuseY ++;
                    score ++; }
                }
                tondeuseY --;
            }
            if (oldY < Y){
                //aller vers la gauche Y--
                while (mur == false ){
                    if(printMap.getCase(tondeuseX,tondeuseY) == 'm'){
                        mur = true;
                    } else {
                    printMap.placer(tondeuseX, tondeuseY, 'x');
                    tondeuseY --;
                    score ++; }
                }
                tondeuseY ++;                
            }
            
            printMap.placer(tondeuseX,tondeuseY,'T');
            
        }
    

}