import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContadorPalabras {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ContadorPalabras <archivo>");
            return;
        }

        Path archivo = Path.of(args[0]);

        if (!Files.exists(archivo)) {
            System.err.println("El archivo no existe: " + archivo);
            return;
        }

        Map<String, Integer> frecuencias = new HashMap<>();
        int totalPalabras = 0;

        try (BufferedReader lector = Files.newBufferedReader(archivo)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                linea = linea.toLowerCase();
                linea = linea.replaceAll("[^\\p{L}\\p{N}\\s]", "");

                if (linea.isBlank()) {
                    continue;
                }

                for (String palabra : linea.trim().split("\\s+")) {
                    frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                    totalPalabras++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
            return;
        }

        Map<String, Integer> ordenadas = new TreeMap<>(frecuencias);


        try {
            Path directorioSalida = Path.of("salida");
            Files.createDirectories(directorioSalida);
            Path archivoSalida = directorioSalida.resolve("frecuencias.txt");

            try (PrintWriter escritor = new PrintWriter(Files.newBufferedWriter(archivoSalida))) {
                escritor.printf("%-20s %s%n", "PALABRA", "FRECUENCIA");
                escritor.println("-------------------------------");
                for (Map.Entry<String, Integer> e : ordenadas.entrySet()) {
                    escritor.printf("%-20s %d%n", e.getKey(), e.getValue());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir resultados: " + e.getMessage());
            return;
        }

        String masFrecuente = "";
        int max = 0;
        for (Map.Entry<String, Integer> e : frecuencias.entrySet()) {
            if (e.getValue() > max) {
                masFrecuente = e.getKey();
                max = e.getValue();
            }
        }

        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Palabras diferentes: " + frecuencias.size());
        System.out.println("Palabra más frecuente: " + masFrecuente + " (" + max + ")");
    }
}