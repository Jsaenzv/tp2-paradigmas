package tp2.paradigmas.modelo;

public class InvocarMonstruo implements AccionTurno {
    CartaEnCampo cartaEnCampo;

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().invocarMonstruo(cartaEnCampo);
    }
}
