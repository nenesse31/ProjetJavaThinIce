package java_package;


public class Main {

    public static void main(String[] args) {
        
        DeplacerPerso play = new DeplacerPerso();
        Print2DArray print = new Print2DArray();
        MenuAcceuil menu = new MenuAcceuil();
        
        //menu.writeFile();
       
        menu.MenuAcceuil();
        
        while(print.getGameFinished() == false){
            play.premierPlacement();
            play.whileNiveau();
        }
        
        System.out.println("Vous avez fini le jeu !");

    }

}
