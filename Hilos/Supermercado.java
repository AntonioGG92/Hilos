import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Supermercado {
    private static final Lock lockCaja1 = new ReentrantLock();
    private static final Lock lockCaja2 = new ReentrantLock();

    public static void main(String[] args) {
        long tiempoInicial = System.currentTimeMillis();

        String[] carritoCliente1 = {"Leche", "Pan", "Huevos", "Cereal", "Mantequilla"};
        String[] carritoCliente2 = {"Manzanas", "Azucar", "Arroz", "Pasta", "Tomates"};
        String[] carritoCliente3 = {"Cerveza", "Carne", "Queso", "Verduras", "Lechuga"};
        String[] carritoCliente4 = {"Galletas", "Refresco", "Cafe", "Sal", "Yogurt"};
        String[] carritoCliente5 = {"Papel Higienico", "Papel Aluminio", "Jabon", "Shampoo", "Detergente"};

        Thread cliente1 = new Thread(() -> {
            lockCaja1.lock();
            try {
                new Cliente("Cliente 1", carritoCliente1, tiempoInicial, 1).run();
            } finally {
                lockCaja1.unlock();
            }
        });

        Thread cliente2 = new Thread(() -> {
            lockCaja2.lock();
            try {
                new Cliente("Cliente 2", carritoCliente2, tiempoInicial, 2).run();
            } finally {
                lockCaja2.unlock();
            }
        });

        Thread cliente3 = new Thread(() -> {
            lockCaja1.lock();
            try {
                new Cliente("Cliente 3", carritoCliente3, tiempoInicial, 1).run();
            } finally {
                lockCaja1.unlock();
            }
        });

        Thread cliente4 = new Thread(() -> {
            lockCaja2.lock();
            try {
                new Cliente("Cliente 4", carritoCliente4, tiempoInicial, 2).run();
            } finally {
                lockCaja2.unlock();
            }
        });

        Thread cliente5 = new Thread(() -> {
            lockCaja1.lock();
            try {
                new Cliente("Cliente 5", carritoCliente5, tiempoInicial, 1).run();
            } finally {
                lockCaja1.unlock();
            }
        });

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}

       