public class Supermercado {
    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();

        // Clientes con sus carritos
        String[] carritoCliente1 = {"Leche", "Pan", "Huevos", "Cereal", "Mantequilla"};
        String[] carritoCliente2 = {"Manzanas", "Azucar", "Arroz", "Pasta", "Tomates"};
        String[] carritoCliente3 = {"Cerveza", "Carne", "Queso", "Verduras", "Lechuga"};
        String[] carritoCliente4 = {"Galletas", "Refresco", "Cafe", "Sal", "Yogurt"};
        String[] carritoCliente5 = {"Papel Higienico", "Papel Aluminio", "Jabon", "Shampoo", "Detergente"};

        // Crear hilos para representar los clientes
        Thread cliente1 = new Thread(new Cliente("Cliente 1", carritoCliente1, initialTime, 1));
        Thread cliente2 = new Thread(new Cliente("Cliente 2", carritoCliente2, initialTime, 2));
        Thread cliente3 = new Thread(new Cliente("Cliente 3", carritoCliente3, initialTime, 1));
        Thread cliente4 = new Thread(new Cliente("Cliente 4", carritoCliente4, initialTime, 2));
        Thread cliente5 = new Thread(new Cliente("Cliente 5", carritoCliente5, initialTime, 1));
        

        // Iniciar los hilos
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}
