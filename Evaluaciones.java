import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evaluaciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Double> notas = new ArrayList<>();
        String opcion;

        System.out.println("Bienvenido al sistema de evaluación de películas.");

        do {
            opcion = mostrarMenu(teclado);

            switch (opcion) {
                case "1":
                    double nota = obtenerNota(teclado);
                    if (nota != -1) {
                        notas.add(nota);
                        System.out.println("Nota agregada.");
                    }
                    break;
                case "2":
                    calcularYMostrarMedia(notas);
                    break;
                case "3":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción correcta.");
            }
        } while (!opcion.equals("3"));
    }

    private static String mostrarMenu(Scanner teclado) {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar una nota");
        System.out.println("2. Calcular y mostrar la media");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
        return teclado.nextLine();
    }

    private static double obtenerNota(Scanner teclado) {
        double nota = -1;
        while (true) {
            try {
                System.out.print("Introduce la nota (0-10) o -1 para cancelar: ");
                nota = teclado.nextDouble();
                teclado.nextLine(); // Limpiar el buffer

                // Validando que la nota esté en el rango de 0 a 10
                if (nota >= 0 && nota <= 10) {
                    return nota;
                } else if (nota == -1) {
                    return nota; // Permite cancelar la acción
                } else {
                    System.out.println("Por favor, introduce una nota válida (0-10) o -1 para cancelar:");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número:");
                teclado.next(); // Limpiar el buffer en caso de error
            }
        }
    }

    private static void calcularYMostrarMedia(List<Double> notas) {
        if (notas.isEmpty()) {
            System.out.println("No se han ingresado evaluaciones.");
            return;
        }

        double mediaEvaluaciones = 0;
        for (double nota : notas) {
            mediaEvaluaciones += nota;
        }

        double mediaFinal = mediaEvaluaciones / notas.size();
        System.out.printf("La media de evaluaciones es: %.2f\n", mediaFinal);
    }
}
