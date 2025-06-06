package main.java.tp2.modelo;

public class HechizoEnCampo extends HechizoTrampaEnCampo {
    CartaHechizo hechizo;


    @Override
    public Carta getCarta() {
        return hechizo;
    }

    @Override
    public void aplicarEfecto(Juego juego) {
        hechizo.aplicarEfecto(juego);
    }

    public HechizoEnCampo(CartaHechizo hechizo, boolean estaBocaArriba, Jugador propietario) {
        super(hechizo.getNombre(), estaBocaArriba, propietario);
    }
}
