package java_package;

public class Print2DArray {
		
    private int nbLig = 15;
    private int nbCol = 19;
    
    private boolean end = false;
		
	
	
	private static char [][]map = {
         { 0x23, 0x23, 0x23,0x23, 0x23, 0x23 },
         { 0x23, 'M', 'M', 'M', 'M', 0x23 },
         { 'M', 'S', 'o', 'o', 'E', 'M' },
         { 0x23, 'M', 'M', 'M', 'M', 0x23 },
         { 0x23, 0x23, 0x23,0x23, 0x23, 0x23 }
      };

		      
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

		   
	public static char getCase(int l, int c) {
		return map[l][c];
	}

	public void placer(int l, int c, char t) {
		
		if(t == 'J') {
			if(l < 0 || c < 0 || l > map.length || c > map[0].length) {
                            System.out.println("Erreur de placement.");
                            return;}
			else{
                            if(map[l][c] == 'o' || map[l][c] == 'S' || map[l][c] == 'E') { //Si position == glace
                                if(map[l][c] == 'E') {
                                        niveauTermine();
                                    }
                                map[l][c] = t;
                            }		
                        }
		} else {
			if(t == 'x') { //si le bloc à placer est de la glace fondue:
				map[l][c] = t;
			}
		}
		
		
		
	}
	
	public void niveauTermine() {
		end = true;
	}
	
	public boolean niveauEsTilTermine(){
		return end;
	}
	
	
}