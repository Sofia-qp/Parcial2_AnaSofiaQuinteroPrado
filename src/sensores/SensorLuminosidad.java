package sensores;

import java.util.Random;

/**
 * Sensor de luminosidad. Rango válido: [0, 2000] lux.
 */
public class SensorLuminosidad extends Sensor {

    public static final int MIN = 0;
    public static final int MAX = 2000;
    private static final Random RND = new Random();

    public SensorLuminosidad(String id, int capacidad) {
        super(id, "lux", capacidad);
    }

    @Override
    public int generarLectura() {
        // TODO: implementar

        int valor = RND.nextInt(MAX - MIN + 1) + MIN;

        registrarLectura(valor);

        return valor;
    }

    @Override
    public boolean fueraDeRango(int valor) {
        // TODO: implementar

        return valor < MIN || valor > MAX;
    }
}