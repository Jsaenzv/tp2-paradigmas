package tp2.paradigmas.modelo;

public class ColocarCarta implements AccionTurno {
    private CartaEnCampo cartaEnCampo;

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().colocarCarta(cartaEnCampo);
    }
}
