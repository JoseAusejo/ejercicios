import java.util.Scanner;

public class niños {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("🌈 ¡Bienvenido(a) a Screen Match! 🌈");
        System.out.println("🎥 Hoy vamos a hablar de la película 'Matrix'.");

        int fechaDeLanzamiento = 1999;
        double media = 0;

        System.out.println("✨ ¿Quieres ser un crítico de cine y dar tu propia nota? (sí/no)");
        String respuesta = teclado.nextLine();

        if (respuesta.equalsIgnoreCase("sí")) {
            media = ingresarNotas(teclado);
        } else {
            System.out.println("👌 No hay problema, usaremos algunas notas mágicas para calcular la media.");
            media = (8.2 + 6.0 + 9.0) / 3; // Media predeterminada
        }

        mostrarResultados(media, fechaDeLanzamiento);
    }

    private static double ingresarNotas(Scanner teclado) {
        double sumaNotas = 0;
        int contadorNotas = 0;

        System.out.println("🔮 ¡Fantástico! Introduce tus notas (0-10) y escribe -1 cuando termines:");

        while (true) {
            double nota = obtenerNota(teclado);
            if (nota == -1) break; // Salir del bucle

            sumaNotas += nota;
            contadorNotas++;
        }

        if (contadorNotas > 0) {
            return sumaNotas / contadorNotas; // Calcular la media
        } else {
            System.out.println("❌ No ingresaste ninguna nota. Usaremos las notas mágicas.");
            return (8.2 + 6.0 + 9.0) / 3;
        }
    }

    private static double obtenerNota(Scanner teclado) {
        double nota = -1;
        while (true) {
            try {
                System.out.print("✨ Introduce tu nota: ");
                nota = teclado.nextDouble();
                teclado.nextLine(); // Limpiar el buffer

                if (nota >= 0 && nota <= 10) {
                    return nota;
                } else if (nota == -1) {
                    return nota; // Permite cancelar la acción
                } else {
                    System.out.println("⚠️ ¡Ups! Debes introducir una nota válida (0-10) o -1 para terminar.");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida. Por favor, introduce un número:");
                teclado.next(); // Limpiar el buffer en caso de error
            }
        }
    }

    private static void mostrarResultados(double media, int fechaDeLanzamiento) {
        System.out.println("📊 La media de tus evaluaciones para 'Matrix' es: " + media);

        String sinopsis = """
                🌟 'Matrix' es una paradoja fascinante.
                La mejor película del fin del milenio.
                Lanzada en: %d
                """.formatted(fechaDeLanzamiento);
        System.out.println(sinopsis);

        int clasificacion = (int) (media / 2);
        System.out.println("⭐ Clasificación (0-5): " + clasificacion);
    }
}
