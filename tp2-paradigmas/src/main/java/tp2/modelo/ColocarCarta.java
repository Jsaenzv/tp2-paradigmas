package tp2.modelo;

public class ColocarCarta implements AccionTurno {
    private CartaEnCampo cartaEnCampo;

    public ColocarCarta(CartaEnCampo cartaEnCampo) {this.cartaEnCampo = cartaEnCampo;}

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().colocarCarta(cartaEnCampo);
    }
}
