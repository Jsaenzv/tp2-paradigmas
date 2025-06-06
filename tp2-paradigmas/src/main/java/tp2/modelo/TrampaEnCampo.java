package main.java.tp2.modelo;

public class TrampaEnCampo extends HechizoTrampaEnCampo{

    CartaTrampa trampa;

    public TrampaEnCampo(CartaTrampa trampa, boolean estaBocaArriba, Jugador propietario) {
        super(trampa.getNombre(), estaBocaArriba, propietario);
        this.trampa = trampa;
    }

    @Override
    public Carta getCarta() {
        return trampa;
    }

}
