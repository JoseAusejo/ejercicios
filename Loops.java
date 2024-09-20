import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota;
        double mediaEvaluaciones = 0;
        int cantidadEvaluaciones;

        System.out.println("¿Cuántas notas quieres ingresar?");
        cantidadEvaluaciones = obtenerCantidadEvaluaciones(teclado);

        for (int i = 0; i < cantidadEvaluaciones; i++) {
            nota = obtenerNota(teclado);
            mediaEvaluaciones += nota;
        }

        double mediaFinal = mediaEvaluaciones / cantidadEvaluaciones;
        System.out.println("La media de evaluaciones para Matrix es: " + mediaFinal);
    }

    private static int obtenerCantidadEvaluaciones(Scanner teclado) {
        int cantidad = 0;
        while (true) {
            try {
                cantidad = Integer.parseInt(teclado.nextLine());
                if (cantidad < 1) {
                    System.out.println("Por favor, introduce un número válido (1 o más):");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número:");
            }
        }
        return cantidad;
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
}
