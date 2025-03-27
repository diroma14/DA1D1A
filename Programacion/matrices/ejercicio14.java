package matrices;

public class ejercicio14 {
    public static void main(String[] args) {
        int[][] datos = {
            {24,15,50,20},
            {14,200,0,0},
            {1,2,4,5},
            {60,44,21,0}
        }; //X= Cada artículo  Y=Cada sucursal

        //Cantidad total de cada artículo
        for(int x = 0;x < datos.length;x++){
            int totalArticulo = 0;
            for(int y = 0; y < datos[x].length;y++){
                totalArticulo += datos[x][y];
            }

            System.out.println("Artículo " + (x+1) + " : " + totalArticulo);
        }

        //Cantidad sucursal2
        int sucursal2 = 0;
        for(int i=0;i < datos[1].length;i++){
            sucursal2 += datos[1][i];
        }
        System.out.println();
        System.out.println("Sucursal 2 : " + sucursal2);

        //Cantidad artículo3 sucursal1
        System.out.println();
        System.out.println("Artículo 3 Sucursal 1 : " + datos[2][0]);

        //Recaudación de cada sucursal
        System.out.println();
        int dineroSucursal = 0;
        int sucursal = 0;
        for (int y = 0; y < datos[0].length; y++) {  //Columna
            int recaudacion = 0;
            for (int x = 0; x < datos.length; x++) {  //Fila
                recaudacion += datos[x][y];
            }
            System.out.println("Recaudación de la Sucursal " + (y + 1) + " : " + recaudacion);
            if (recaudacion>dineroSucursal) {
                dineroSucursal = recaudacion;
                sucursal = (y+1);
            }
        }

        //Recaudación total
        System.out.println();
        int recaudacionTotal = 0;
        for(int i = 0;i < datos.length; i++){
            for(int j = 0;j < datos[i].length;j++){
                recaudacionTotal += datos[i][j];
            }
        }
        System.out.println("Recaudación total: " + recaudacionTotal);

        //Sucursal de mayor recaudación
        System.out.println();
        System.out.println("Sucursal " + sucursal + " : " + dineroSucursal);
    }
}
