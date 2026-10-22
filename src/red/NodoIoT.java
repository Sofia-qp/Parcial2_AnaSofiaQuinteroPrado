package red;

import sensores.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nodo IoT que COMPONE sensores.
 * Los sensores se crean dentro del nodo (composición real).
 */
public class NodoIoT {

    private String id;
    private ArrayList<Sensor> sensores;

    public NodoIoT(String id) {
        this.id = id;
        this.sensores = new ArrayList<>();
    }

    /**
     * Crea y agrega un sensor del tipo indicado dentro del nodo.
     * Tipo: "TEMPERATURA", "HUMEDAD", "LUMINOSIDAD".
     * Retorna el sensor creado, o null si el tipo es inválido.
     */
    public Sensor agregarSensor(String tipo, String idSensor, int capacidad) {
        // TODO: implementar (polimorfismo + composición)

        Sensor sensor = null;

        if (tipo.equals("TEMPERATURA")) {
            sensor = new SensorTemperatura(idSensor, capacidad);
        } else if (tipo.equals("HUMEDAD")) {
            sensor = new SensorHumedad(idSensor, capacidad);
        } else if (tipo.equals("LUMINOSIDAD")) {
            sensor = new SensorLuminosidad(idSensor, capacidad);
        }

        if (sensor != null) {
            sensores.add(sensor);
        }

        return sensor;
    }

    /**
     * Promedio de temperatura del nodo. Retorna 0 si no hay sensores de temperatura.
     * Pista: usar instanceof para filtrar.
     */
    public double promedioTemperatura() {
        // TODO: implementar

        double suma = 0;
        int cantidad = 0;

        for (Sensor sensor : sensores) {

            if (sensor instanceof SensorTemperatura) {
                suma += sensor.promedioUltimasLecturas();
                cantidad++;
            }
        }

        if (cantidad == 0) {
            return 0;
        }

        return suma / cantidad;
    }

    /**
     * Lista de sensores cuya última lectura está fuera de rango.
     */
    public List<Sensor> sensoresFueraDeRango() {
        // TODO: implementar

        List<Sensor> fuera = new ArrayList<>();

        for (Sensor sensor : sensores) {

            if (sensor.getCantidadLecturas() > 0) {

                int[] lecturas = sensor.getUltimasLecturas();

                int ultimaPos =
                        (sensor.getIndiceActual() - 1 + lecturas.length)
                                % lecturas.length;

                int ultimaLectura = lecturas[ultimaPos];

                if (sensor.fueraDeRango(ultimaLectura)) {
                    fuera.add(sensor);
                }
            }
        }

        return fuera;
    }

    public String getId() { return id; }
    public ArrayList<Sensor> getSensores() { return sensores; }
}