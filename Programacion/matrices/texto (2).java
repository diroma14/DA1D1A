package matrices;

import java.util.HashMap;

public class texto {
    public static void main(String[] args) {
        String texto = "They should make an augment that brings back hextech chests. It’s super rare tho";

        HashMap<Character, Integer> frecuencia = new HashMap<>();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

           
            if (frecuencia.containsKey(c)) {
                frecuencia.put(c, frecuencia.get(c) + 1);
            } else {
                frecuencia.put(c, 1);
            }
        }

        
        System.out.println(frecuencia);
    }
}

