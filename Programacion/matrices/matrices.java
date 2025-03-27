package matrices;

public class matrices {
    public static void main(String[] args) {
        //int[]matriz = new int[10]
        //No es lo mismo un array que un array list, las matrices usan arrays
        int[] matriz = new int[5];

        matriz[0] = 15;
        matriz[1] = 20;
        matriz[2] = 66;
        matriz[3] = 0;
        matriz[4] = -19;

        //Tambien se usa
        //int[] matriz = {15,20,30,15,19};

        System.out.println(matriz[0]);

        for(int i=0;i<matriz.length;i++){
            System.out.println("Valor de índice " + (i + 1) + " = " + matriz[i]);
        }


        //Para dos dimensiones
        int[][] matriz2d = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10}
        };

        System.out.println();

        System.out.println(matriz2d.length);
        for(int i=0;i<matriz2d.length;i++){
            for(int e=0;e<matriz2d[i].length;e++){
                System.out.println("Valor de x " + (e + 1) + " e y " + (i + 1) + " : " + matriz2d[i][e]);
            }
        }

    }
}
