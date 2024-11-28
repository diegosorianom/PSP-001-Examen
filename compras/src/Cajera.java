public class Cajera {
    private int id;

    public Cajera(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public long procesarCompra(Cliente cliente, long initialTime) {
        System.out.println("La cajera ha comenzado con el cliente: " + cliente.getId() + " en el tiempo: " + (initialTime / 1000) + " segundos");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            int productoId = i + 1;
            System.out.println("La cajera escanea el producto: " + productoId);
            int tiempoEscaneo = cliente.getCarroCompra()[i];

            try {
                Thread.sleep(tiempoEscaneo * 1000); // Convertir segundos a milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            initialTime += tiempoEscaneo * 1000; // Convertir segundos a milisegundos
        }

        System.out.println("La cajera ha terminado con el cliente: " + cliente.getId() + " en el tiempo: " + (initialTime / 1000) + " segundos");
        return initialTime;
    }
}
