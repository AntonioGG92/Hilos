class Cliente implements Runnable {
    private String nombre;
    private String[] carrito;
    private long initialTime;
    private int numCaja;

    public Cliente(String nombre, String[] carrito, long initialTime, int numCaja) {
        this.nombre = nombre;
        this.carrito = carrito;
        this.initialTime = initialTime;
        this.numCaja = numCaja;
    }
    @Override
    public void run() {
        System.out.println(nombre + " comienza a ser atendido en la caja " + numCaja + " al tiempo: "
                + (System.currentTimeMillis() - initialTime) + " ms");

        for (int i = 0; i < carrito.length; i++) {
            procesarProducto(carrito[i]);
            System.out.println(nombre + " pasa el producto " + carrito[i] + " por la caja " + numCaja + " al tiempo: "
                    + (System.currentTimeMillis() - initialTime) + " ms");
        }
        System.out.println(nombre + " ha terminado en la caja " + numCaja + " al tiempo: "
                + (System.currentTimeMillis() - initialTime) + " ms");
    }

    private void procesarProducto(String producto) {
        try {
            Thread.sleep(1000); // Emula el tiempo de procesar cada producto (1 segundo).
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}