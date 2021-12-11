package java_package;

//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Print2DArray { //Vue
		
    private int nbLig = 15; // sensé etre les nbr des collonnes et lignes du niveau
    private int nbCol = 19;
    
    static int score = 0;
    int level = 0;
    
    Levels lev = new Levels();
    
    private boolean end = false; // variable niveau est il fini ?
    //private boolean valide = true; //variable qui définis si la position demandée est valide (pas un mur etc...)

    private boolean isPosValide;
    // = 0
    //vide = v = U+2B1A
    //mur = m = U+26DD
    //eau = x = U+26C6
    //glace = o = U+25A6
    //glace épaisse = O = U+25A9
    //debut = d 
    //fin = f = U+26E8
    //joueur = U+24D4
	private static char [][]map;
               


        ArrayList<Integer> startPos = new ArrayList<Integer>();

        public void setMap(int n){
            if (n == 0){
            map = lev.getMap(level);}
            else { map = lev.getMap(n);}
        }
        
        static boolean gameFinished = false;
        
        public boolean getGameFinished(){
            return gameFinished;
        }
        
        public void setIsGameFinished(){
            gameFinished = true;
        }
        
	public ArrayList<Integer> startLevel(){
            for (int i = 0; i < map.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < map[i].length; j++) { //this equals to the column in each row.
                    if (map[i][j] == 'd'){
                        startPos.add(i);
                        startPos.add(j);
                        //System.out.print(i);
                        //System.out.println(";" +j);
                    }
		}
            }
            return (startPos);
        }
            
        
        
	public static void afficherMatrice(int x, int y) {//throws UnsupportedEncodingException {
            int blocInt;
            String blocUni = "";
            
            System.out.println("Score : " + score);       
            System.out.println();
			   
            for (int i = 0; i < map.length; i++) { //this equals to the row in our matrix.
                for (int j = 0; j < map[i].length; j++) { //this equals to the column in each row.
                    if(i == x && j == y){
                        System.out.print("J" + " ");
                    } else {
                    System.out.print( map[i][j] + " ");
                    }
		}
		System.out.println(); //change line on console as row comes to end in the matrix.
            }
            
            System.out.println();
	}

		   
	public static char getCase(int l, int c) { //getter case aux coordonnées demandées
            return map[l][c];
	}
        
        

	public void placer(int l, int c, char t) {
            map[l][c] = t;
	}
        
        public boolean isPosValide(int l, int c){
            if(l < 0 || c < 0 || l > map.length || c > map[0].length) {
                    System.out.println("Erreur de placement."); //si la coordonnée du bloc a placer dépasse les bordures du niveau
                    isPosValide = false;}
            else{
                if(map[l][c] == 'm' || map[l][c] == 'v' || map[l][c] == 'x') { //Si position == glace ou Start ou End
                    System.out.println("Le Pinguin ne peut pas se dépacer ici");
                    isPosValide = false;
                } else {
                    if (map[l][c] == 'o' || map[l][c] == 'd' || map[l][c] == 'f' || map[l][c] == 'G'){ // si le joueur veut aller sur un bloc de mur ou sur un bloc d'éxterieur de mur
                        
                        if(map[l][c] == 'f') { //si next bloc == End, appelle niveau terminé pour changer la valeur t finir le niveau
                            niveauTermine();
                        }
                        isPosValide = true; // print le joueur sur le bloc à la coordonnée demandée
                        score ++;
                    }
                }		
            }
            return isPosValide;
            
        }
        
        public boolean isGlaceEpaisse(int l, int c){
            if (map[l][c] == 'G'){
                return true;
            } else { return false;}
        }
        
	public void niveauTermine() { // set la valeur endo to true
            end = true;
            level ++;
	}
        
        public void newNiveau() { // set la valeur endo to true
            end = false;
	}
	
	public boolean niveauEsTilTermine(){ // retourne la valeur end
            return end;
	}
        
        public void setNiveauTermine(){
            end = false;
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