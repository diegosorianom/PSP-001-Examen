import java.util.ArrayList;

public class Main {
    private static final int[] carrera = {1000, 1500, 2000, 2500, 500}; // Duración de cada tramo de la carrera
    private static final int corredores = 5; // Corredores totales
    private static final double tiempo_extra = 1.20; // 20% de tiempo extra

    public static void main(String[] args) {
        System.out.println("[S] Comienza la carrera");

        // Duración máxima de la carrera (tiempo base + tiempo extra)
        int tiempoMaximo = (int) (sumarTiempo(carrera) * tiempo_extra);
        System.out.println("[S] La carrera durará: " + (tiempoMaximo / 100) + " minutos ");

        // Creamos el objeto corredor
        Thread[] hilos = new Thread[corredores];
        for (int i = 0; i < corredores; i++) {
            hilos[i] = new Thread(new Corredor(i +  1, i + 1, carrera[i]));
            hilos[i].start();

            try {
                hilos[i].join(); // Esperamos a que el corredor actual termine antes de iniciar el siguiente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[S] Todos los corredores han llegado al final");

        // Esperamos el tiempo máximo para cerrar la carrera
        try {
            Thread.sleep(tiempoMaximo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[S] La carrera ha terminado");
    }

    public static int sumarTiempo(int[] tiempos) {
        // Calculamos el tiempo base de la carrera a base de sumar los tramos
        int suma = 0;
        for (int tiempo : tiempos) {
            suma += tiempo;
        }
        return suma;
    }
}