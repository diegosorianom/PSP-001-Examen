import java.util.Random;

public class Alumno implements Runnable{
    private final int id; // Identificador de cada alumno
    private final int[] examen; // El alumno obtiene el tiempo de cada pregunta del examen y lo guarda en su propio vector
    private final Random random;

    public Alumno(int id, int[] examen) {
        this.id = id;
        this.examen = examen;
        this.random = new Random();
    }

    @Override
    public void run() {
        int tiempoTotal = 0;

        for (int i = 0; i < examen.length; i++) {
            int preguntaId = i + 1;
            System.out.println("[S] El alumno: " + id + " comienza la pregunta " + preguntaId);

            int tiempoBase = examen[i]; // Tiempo que el profesor ha pensado que durará la pregunta
            int factor = random.nextInt(3) + 1; // Factor aleatorio que determina la velocidad del alumno
            int ajuste = random.nextInt(tiempoBase / 2 + 1); // Numero aleatorio entre 0 y la mitad del tiempo base

            // En función del factor aleatorio y el ajuste determinamos cuanto tarda un alumno en hacer la pregunta
            int tiempoPregunta = tiempoBase; // Por defecto el alumno tardará lo establecido
            if (factor == 1) {
                tiempoPregunta += ajuste; // Lo hace más lento
            } else if (factor == 3) {
                tiempoPregunta -= ajuste; // Lo hace más deprisa
            }

            // Simulamos el tiempo para la pregunta
            try {
                Thread.sleep(tiempoPregunta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempoTotal += tiempoPregunta;

            System.out.println("[P] El alumno " + id + " ha terminado la pregunta " + preguntaId + " en " + (tiempoTotal / 100) +  " minutos");
        }
        System.out.println("[E] El alumno " + id + " ha terminado el examen en " + (tiempoTotal / 100) + " minutos ");
    }
}
