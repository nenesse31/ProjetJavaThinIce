package java_package;


public class Main {

    public static void main(String[] args) {
        
        DeplacerPerso play = new DeplacerPerso();
        Print2DArray print = new Print2DArray();
        
        
        while(print.getGameFinished() == false){
            //print.setNiveauTermine();
            play.premierPlacement();
            play.whileNiveau();
            System.out.println(print.niveauEsTilTermine());
        }
        System.out.println("Vous avez fini le jeu !");

    }

}
