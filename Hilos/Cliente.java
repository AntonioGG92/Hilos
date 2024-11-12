class Cliente implements Runnable {
    
    private String nombre;
    private String [] carrito;
    private long tiempoInicial;
    private int numeroCaja;
    
    public Cliente(String nombre, String[] carrito, long tiempoInicial, int numeroCaja) {
    	this.nombre = nombre;
    	this.carrito = carrito;
    	this.tiempoInicial = tiempoInicial;
    	this.numeroCaja = numeroCaja;
    }
    
    @Override
    public void run() {
    	System.out.println(nombre + " comienza a ser atendido en la caja" + numeroCaja + "al tiempo: "
    	+(System.currentTimeMillis() - tiempoInicial) + "ms");
    	
    	for (int i = 0; i< carrito.length; i++) {
    		procesarProducto(carrito[i]);
    		System.out.println(nombre + " pasa el producto " + carrito[i] + " por la caja " + numeroCaja + " al tiempo "
    				+ (System.currentTimeMillis() - tiempoInicial) + " ms ");
    	}
    	System.out.println(nombre + " ha terminado en la caja " + numeroCaja + " al tiempo: "
    			+ (System.currentTimeMillis()- tiempoInicial) + " ms");
    }
    
    private void procesarProducto(String producto) {
    	try {
    		Thread.sleep(1000);
    	}catch (InterruptedExeption e) {
    		Thread.currentThread().interrupt();
    	}
    }
}