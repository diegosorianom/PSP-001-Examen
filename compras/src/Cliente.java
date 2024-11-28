public class Cliente {
    private int id;
    private int[] carroCompra;

    public Cliente(int id, int[] carroCompra) {
        this.id = id;
        this.carroCompra = carroCompra;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }
    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }
}
