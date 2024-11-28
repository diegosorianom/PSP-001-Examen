
public class Main {
    private static final int[] examen = {1000, 1500, 2000, 500}; // Vector con la duración en milisegundos asignada a cada pregunta
    private static final int alumnos = 5; // Cantidad de alumnos que van a tener que hacer el examen
    private static final double tiempo_extra = 1.25; // 25% de tiempo extra asignado

    public static void main(String[] args) {
        System.out.println("Comienza el examen");;

        // Tiempo máximo de espera del profesor
        int tiempoMaximo = (int) (sumarTiempo(examen) * tiempo_extra);

        // Creación del alumno
        Thread[] hilos = new Thread[alumnos];
        for (int i = 0; i < alumnos; i++) {
            hilos[i] = new Thread(new Alumno(i + 1, examen));
            hilos[i].start();
        }
        System.out.println("El examen durará: " +  (tiempoMaximo / 100) + " minutos ");
        System.out.println("El profesor espera las entregas");

        // Esperamos el tiempo máximo para cerrar el examen
        try {
            Thread.sleep(tiempoMaximo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El tiempo ha terminado, el profesor se va ya. ");
        System.exit(0);
    }

    public static int sumarTiempo(int[] tiempos) {
        int suma = 0;
        for (int tiempo : tiempos) {
            suma += tiempo;
        }
        return suma;
    }
}