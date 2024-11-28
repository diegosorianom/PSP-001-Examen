public class Main {
    public static void main(String[] args) {
        // Crear los clientes
        Cliente cliente1 = new Cliente(1, new int[] { 2, 3, 1, 3, 2 }); // Tiempo en segundos
        Cliente cliente2 = new Cliente(2, new int[] { 5, 2, 1 });       // Tiempo en segundos

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        // Crear las cajeras como hilos
        Cajera cajera1 = new Cajera(1, cliente1, initialTime);
        Cajera cajera2 = new Cajera(2, cliente2, initialTime);

        // Iniciar los hilos
        cajera1.start();
        cajera2.start();
    }
}
