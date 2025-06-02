package main.java.tp2.modelo;

public class ColocarCarta implements AccionTurno {
    private CartaEnCampo cartaEnCampo;

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().colocarCarta(cartaEnCampo);
    }
}
