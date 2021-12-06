package java_package;

import java.util.ArrayList;

public class Print2DArray { //Vue
		
    private int nbLig = 15; // sensé etre les nbr des collonnes et lignes du niveau
    private int nbCol = 19;
    
    private boolean end = false; // variable niveau est il fini ?
    //private boolean valide = true; //variable qui définis si la position demandée est valide (pas un mur etc...)

    private boolean isPosValide;
    
    
	private static char [][]map = {           //fichier csv a faire
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',  0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 'M', 'S', 'o', 'o', 'o', 'o', 0x23, 0x23, 0x23, 0x23, 0x23, 'E', 'M', 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         { 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23, 0x23 },
         
        };
               
        private static char [][]entity={
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            };

        ArrayList<Integer> startPos = new ArrayList<Integer>();

        
	public ArrayList<Integer> startLevel(){
            for (int i = 0; i < map.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < map[i].length; j++) { //this equals to the column in each row.
                    if (map[i][j] == 'S'){
                        startPos.add(i);
                        startPos.add(j);
                        //System.out.print(i);
                        //System.out.println(";" +j);
                    }
		}
            }
            return (startPos);
        }
            
        
        
	public static void afficherMatrice() {
			   
            System.out.println();
			   
            for (int i = 0; i < map.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < map[i].length; j++) { //this equals to the column in each row.
                    System.out.print(map[i][j] + " ");
		}
		System.out.println(); //change line on console as row comes to end in the matrix.
            }
            
            System.out.println();
	}

		   
	public static char getCase(int l, int c) { //getter case aux coordonnées demandées
            return map[l][c];
	}
        
        

	public void placer(int l, int c, char t) {
		
            if(t == 'J') { //si le "bloc" à placer est  le joueur
		map[l][c] = t;
            } else {
        	if(t == 'x') { //si le bloc à placer est de la glace fondue:
                        map[l][c] = t;
                } 
            }
	}
        
        public boolean isPosValide(int l, int c){
            if(l < 0 || c < 0 || l > map.length || c > map[0].length) {
                    System.out.println("Erreur de placement."); //si la coordonnée du bloc a placer dépasse les bordures du niveau
                    isPosValide = false;}
            else{
                if(map[l][c] == 'M' || map[l][c] == 0x23 || map[l][c] == 'x') { //Si position == glace ou Start ou End
                    System.out.println("Le Pinguin ne peut pas se dépacer ici");
                    isPosValide = false;
                   
                     
                } else {
                    if (map[l][c] == 'o' || map[l][c] == 'S' || map[l][c] == 'E'){ // si le joueur veut aller sur un bloc de mur ou sur un bloc d'éxterieur de mur
                        
                        if(map[l][c] == 'E') { //si next bloc == End, appelle niveau terminé pour changer la valeur t finir le niveau
                            niveauTermine();
                        }
                        isPosValide = true; // print le joueur sur le bloc à la coordonnée demandée
                        
                    }
                        
                }		
            }
            return isPosValide;
            
        }
        
	public void niveauTermine() { // set la valeur endo to true
            end = true;
	}
	
	public boolean niveauEsTilTermine(){ // retourne la valeur end
            return end;
	}
	
        /*public void positionNonValide(){
            this.valide = false;
        }
        
        public void positionValide(){
            this.valide = true;
        }
        
        public boolean positionEstElleValide(){
            return valide;
        }*/
	
}