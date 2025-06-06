package main.java.tp2.modelo;

import java.util.List;

public class AccionInvocarMonstruo implements AccionFasePrincipal {
    private final CartaMonstruo carta;
    private final ModoCarta modo;
    private final boolean estaBocaArriba;
    private List<MonstruoEnCampo> monstruosSacrificados;

    public AccionInvocarMonstruo(CartaMonstruo carta, ModoCarta modo, boolean estaBocaArriba, List<MonstruoEnCampo> monstruosSacrificados) {
        this.carta = carta;
        this.modo = modo;
        this.estaBocaArriba = estaBocaArriba;
        this.monstruosSacrificados = monstruosSacrificados;
    }

    @Override
    public void ejecutarAccion(Turno turno) {
        Jugador jugador = turno.getJugador();
        jugador.invocarMonstruo(new MonstruoEnCampo(carta, estaBocaArriba, modo), monstruosSacrificados);
    }

}
