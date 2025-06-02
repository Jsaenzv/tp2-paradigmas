package tp2.paradigmas.modelo;

public class ActivarCarta implements AccionTurno{

    private CartaEnCampo cartaEnCampo;

    @Override
    public void ejecutar(Turno turno) {
        turno.getJugador().activarCarta(cartaEnCampo);
    }
}
