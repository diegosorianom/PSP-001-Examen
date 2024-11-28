import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cajera cajera1 = new Cajera(1);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, new int[] { 2, 3, 1, 3, 2 })); // Cliente 1
        clientes.add(new Cliente(2, new int[] { 5, 2, 1 }));       // Cliente 2
        clientes.add(new Cliente(3, new int[] { 4, 3 }));          // Cliente 3

        long initialTime = 0;

        for (Cliente cliente : clientes) {
            initialTime = cajera1.procesarCompra(cliente, initialTime);
        }
    }
}
