package matrices;

public class ejercicio11 {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];

        //Cargar matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i==j) {
                    matriz[i][j] = 1; 
                }else{
                    matriz[i][j] = 0;
                }
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }

        
    }
}
