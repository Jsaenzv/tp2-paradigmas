package tp2.modelo;

public class ActivarCarta implements AccionTurno{

    private CartaEnCampo cartaEnCampo;

    public ActivarCarta(CartaEnCampo cartaEnCampo) {this.cartaEnCampo = cartaEnCampo;}

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().activarCarta(cartaEnCampo);
    }
}
