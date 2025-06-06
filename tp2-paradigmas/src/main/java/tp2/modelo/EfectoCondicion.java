package main.java.tp2.modelo;

public class EfectoCondicion {
    private final Efecto efecto;
    private final Condicion condicion;

    public EfectoCondicion(Efecto efecto, Condicion condicion) {
        this.efecto = efecto;
        this.condicion = condicion;
    }

    public boolean seCumple() {
        return condicion.seCumple();
    }

    public void aplicar(Juego juego) {
        efecto.aplicar(juego);
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public Condicion getCondicion() {
        return condicion;
    }
}

