package tp2.modelo;

public class InvocarMonstruo implements AccionTurno {
    private CartaEnCampo carta;

    public InvocarMonstruo(CartaEnCampo cartaEnCampo) {this.carta = cartaEnCampo;}

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().invocarMonstruo((MonstruoEnCampo) carta);
    }
}
