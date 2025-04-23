package matrices;

public class ejercicio13 {
    public static void main(String[] args) {
        int conductores = 3;
        String[] nombreConductores = {"Antonio", "Julia", "Pedro"};

        int[][] kilometros = 
        {{10,20,30,40,50,60,70},
        {10,20,30,40,50,60,80},
        {20,30,29,30,20,30,29}};

        //Total kms

        int[] totalkm = new int[3];

        for (int i = 0; i < kilometros.length; i++) {
            int suma = 0;
            for (int j = 0; j < kilometros[i].length; j++) {
                suma += kilometros[i][j];
            }
            totalkm[i]=suma;
        }
        
        for(int i = 0;i < conductores; i++){
            System.out.println(nombreConductores[i] + ": " + totalkm[i]);
        }
        
    }
}
