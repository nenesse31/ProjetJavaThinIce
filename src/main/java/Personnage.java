

public class Personnage { //modele
	
    private int xPerso;
    private int yPerso;
    private int oldxPerso;
    private int oldyPerso;
	
	//Constructeur	
    public Personnage() {
    	xPerso = 2; // //position initiale du personnage pour le début du niveau
	yPerso = 1;
    }
	
	//Getter
    public int getXPerso() {
    	return xPerso;
    }
	
    public int getYPerso() {
    	return yPerso;
    }
    
    public int getOldxPerso() {
    	return this.oldxPerso;
    }
    public int getOldyPerso() {
    	return this.oldyPerso;
    }
	
    	//Setter
    public void setXYPerso(int newX, int newY) {    
    	xPerso = newX;
        yPerso = newY;
    }
	
    public void setYPerso(int newY) {
    	yPerso = newY;
        System.out.println("newY"+newY);
    }
    
    /*public void setOldxPerso() {
    	this.xPerso = this.oldxPerso;
    }
    public void setOldyPerso() {
    	this.xPerso = this.oldyPerso;
    }*/
	
    public void deplacerPersonnage(int direction) {
        
        this.oldxPerso = xPerso;
        this.oldyPerso = yPerso;
                
    	switch(direction) {
    		//Haut
    	case 1:
    		this.xPerso --;
       		break;
		//Bas	
	case 2:
		this.xPerso ++;
		break;
		//Droite
	case 3:
		this.yPerso ++;
		break;
            //Gauche
	case 4:
		this.yPerso --;
		break;
	default:
            System.out.println("Ceci n'est pas une direction valide.");		
	}
    }   
}
