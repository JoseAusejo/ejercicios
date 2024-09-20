import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();
        String respuesta;

        do {
            System.out.println("Escribe el nombre de tu película favorita:");
            String peliculaNombre = teclado.nextLine();

            System.out.println("Ahora escribe la fecha de lanzamiento (año):");
            int fechaDeLanzamiento = obtenerFechaDeLanzamiento(teclado);

            System.out.println("Por último, dinos qué nota le das a esta película (0-10):");
            double nota = obtenerNota(teclado);

            peliculas.add(new Pelicula(peliculaNombre, fechaDeLanzamiento, nota));

            System.out.println("¿Quieres ingresar otra película? (sí/no)");
            respuesta = teclado.nextLine();
        } while (respuesta.equalsIgnoreCase("sí"));

        mostrarPeliculas(peliculas);
    }

    private static int obtenerFechaDeLanzamiento(Scanner teclado) {
        int fecha = 0;
        while (true) {
            try {
                fecha = Integer.parseInt(teclado.nextLine());
                if (fecha < 1888 || fecha > 2024) {
                    System.out.println("Por favor, introduce un año válido (1888-2024):");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número para el año:");
            }
        }
        return fecha;
    }

    private static double obtenerNota(Scanner teclado) {
        double nota = -1;
        while (true) {
            try {
                nota = Double.parseDouble(teclado.nextLine());
                if (nota < 0 || nota > 10) { // Validando rango de notas
                    System.out.println("Por favor, introduce una nota válida (0-10):");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número para la nota:");
            }
        }
        return nota;
    }

    private static void mostrarPeliculas(List<Pelicula> peliculas) {
        System.out.println("\nPelículas ingresadas:");
        for (Pelicula pelicula : peliculas) {
            System.out.println("Película: " + pelicula.nombre +
                    ", Fecha de lanzamiento: " + pelicula.fechaDeLanzamiento +
                    ", Nota: " + pelicula.nota);
        }
    }

    static class Pelicula {
        String nombre;
        int fechaDeLanzamiento;
        double nota;

        Pelicula(String nombre, int fechaDeLanzamiento, double nota) {
            this.nombre = nombre;
            this.fechaDeLanzamiento = fechaDeLanzamiento;
            this.nota = nota;
        }
    }
}
