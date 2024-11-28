import java.util.Random;

public class Corredor implements Runnable {
    private final int id;
    private final int tramo;
    private final int tiempoBase;
    private final Random random;

    public Corredor(int id, int tramo, int tiempoBase) {
        this.id = id;
        this.tramo = tramo;
        this.tiempoBase = tiempoBase;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("[I" + id + "] El corredor " + id + " comienza el tramo " + tramo);

        int factor = random.nextInt(3) + 1;
        int ajuste = random.nextInt(tiempoBase / 2 + 1);
        int tiempoTramo = tiempoBase;

        if (factor == 1) {
            tiempoTramo += ajuste;
        } else if (factor == 3) {
            tiempoTramo -= ajuste;
        }

        try {
            Thread.sleep(tiempoTramo);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        System.out.println("[F" + id + "] El corredor " + id + " ha finalizado el tramo " + tramo + " en " + (tiempoTramo / 100) + " minutos ");
    }
}
