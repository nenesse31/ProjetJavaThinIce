
package java_package;



import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author inesmassoud
 */
public class MenuAcceuil { 
    
    public String MenuAcceuil() {
  
        //Menu d'acceuil
        System.out.println("\033[1;34m Bienvenue à Club Penguin Thin Ice \n");
        
        System.out.println("\033[32m But du jeu : Emmener le penguin jusqu'à l'arrivée ! ( 'f' ) \n ");
        
        //Règles du jeu
        System.out.println("                        \033[31m Règles du jeu : \n");
        
        System.out.println("- Lorsque le penguin se déplace sur la glace fine ( 'o' ), celle-ci fond pour laisser place à de l'eau ( 'x' ). Il ne peut pas repasser dessus. ");
        System.out.println("- Le plateau est entouré de murs ( 'm' ) et de différents obstacles ");
        System.out.println("- Sur certain niveau il existe de la banquise épaisse ( 'G' ). Le penguin peut passer dessus 2 fois avant qu'elle ne se transforme en eau ");
        System.out.println("- Des potions ( 'P' ) et des tunnels ( 'U' )peuvent être mis à disposition pour faciliter l'avancée du penguin. N'hésitez pas à les utiliser ;) ");
        System.out.println("- ATTENTION ! Des ennemis peuvent se trouver sur votre chemin ! Evitez les autant que vous pouvez !  \n");
 
        //Touches utilisées pour jouer
        System.out.println("Pour jouer, servez-vous des touches alphabétique (Z Q S D) ou de votre pad numérique (2 4 6 8) ");
        
        
        //Demande du nom du joeur 
        Scanner in = new Scanner(System.in);
        System.out.println("Quel est votre pseudo ? ");
        String name = in.next();
        System.out.println("C'est à votre tour de jouer " + name + ". Amusez-vous bien :) ");
        
        //Partie
        System.out.println("Que voulez vous faire ? Nouvelle partie ou continuer une partie sauvegardée ? ( N / S) ");
        String partie = in.next();
        int stop = 0 ;
        while (stop == 0){
           partie = in.next();
           if (partie.equals("N") || partie.equals("S") ) { 
               stop = 1;
           } 
           else {
               System.out.println("Mauvais choix. Saisir N (nouvelle partie) ou S (partie sauvegardée)");
           }
        }
        System.out.println("C'est à votre tour de jouer " + name + ". Amusez-vous bien :) ");
        
        return name;
    
    }
    



    public static void writeFile() {
        try {
            String content = "TutorialsPoint is one the best site in the world";
            File file = new File("C:\\Users\\TutorialsPoint7\\Desktop\\abc.txt");
            if (!file.exists()) {
               file.createNewFile();
            } 
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
      } 
   } 

    
}