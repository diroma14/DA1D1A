package matrices;

public class ejercicio15 {
    public static void main(String[] args) {
        String[][] equipos = {
            {"Raimon", "Royal Academy"},
            {"Zeus", "Occult"},
            {"Alpine", "Kirkwood"},
            {"Farm", "Brainwashing"},
            {"Raimon", "Zeus"},
            {"Shuriken", "Cloister Divinity"},
            {"Raimon", "Wild"},
            {"Mary Times", "Rampart"},
            {"Universal", "Shamshir"},
            {"Raimon", "Prominence"},
            {"Genesis", "Diamond Dust"},
            {"Dark Emperors", "Raimon"},
            {"Chaos", "Epsilon"},
            {"Fire Dragon", "Genesis"},
            {"Raimon", "Genesis"}
        };
        
        int[][] resultados = {
            {3, 1}, // Raimon vs Royal Academy
            {2, 2}, // Zeus vs Occult
            {1, 0}, // Alpine vs Kirkwood
            {4, 3}, // Farm vs Brainwashing
            {2, 1}, // Raimon vs Zeus
            {0, 1}, // Shuriken vs Cloister Divinity
            {3, 2}, // Raimon vs Wild
            {1, 1}, // Mary Times vs Rampart
            {2, 0}, // Universal vs Shamshir
            {5, 3}, // Raimon vs Prominence
            {1, 2}, // Genesis vs Diamond Dust
            {0, 4}, // Dark Emperors vs Raimon
            {3, 3}, // Chaos vs Epsilon
            {2, 5}, // Fire Dragon vs Genesis
            {4, 2}  // Raimon vs Genesis
        };

        for (int i = 0; i < equipos.length; i++) {
            String resultado;
            if (resultados[i][0] > resultados[i][1]) {
                resultado = "Gana el equipo local.";
            }else if(resultados[i][0] < resultados[i][1]){
                resultado= "Gana el equipo visitante.";
            }else{
                resultado="Empate.";
            }

            System.out.println(equipos[i][0] + " " + resultados[i][0] + " - " + resultados[i][1] + " " + equipos[i][1] + " | " + resultado);
        }


        
    }
}
