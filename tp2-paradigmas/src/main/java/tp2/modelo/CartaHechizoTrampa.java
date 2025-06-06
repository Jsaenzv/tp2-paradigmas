package main.java.tp2.modelo;

public abstract class CartaHechizoTrampa extends Carta {
    protected EfectoCondicion efectoCondicion;

    public CartaHechizoTrampa(String nombre, EfectoCondicion efecto) {
        super(nombre);
        this.efectoCondicion = efecto;
    }

    void aplicarEfecto(Juego juego) {
        efectoCondicion.aplicar(juego);
    }

    public EfectoCondicion getEfectoCondicion(Juego juego) {
       return efectoCondicion;
    }
}
