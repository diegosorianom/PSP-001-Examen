public class Cajera extends Thread {
    private int id;
    private Cliente cliente;
    private long initialTime;

    public Cajera(int id, Cliente cliente, long initialTime) {
        this.id = id;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println("La cajera " + id + " ha comenzado con el cliente: " + cliente.getId()
                + " en el tiempo: " + ((System.currentTimeMillis() - initialTime) / 1000) + " segundos");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            int productoId = i + 1;
            System.out.println("La cajera " + id + " escanea el producto: " + productoId
                    + " del cliente: " + cliente.getId());
            int tiempoEscaneo = cliente.getCarroCompra()[i];

            try {
                Thread.sleep(tiempoEscaneo * 1000); // Simula el tiempo de escaneo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La cajera " + id + " ha terminado con el cliente: " + cliente.getId()
                + " en el tiempo: " + ((System.currentTimeMillis() - initialTime) / 1000) + " segundos");
    }
}
