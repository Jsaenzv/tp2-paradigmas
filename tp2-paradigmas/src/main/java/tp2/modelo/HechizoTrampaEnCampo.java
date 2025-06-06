package main.java.tp2.modelo;

public abstract class HechizoTrampaEnCampo extends Carta implements CartaEnCampo {

    protected boolean estaBocaArriba;
    protected Jugador propietario;
    protected Integer turnoColocada;
    protected EfectoCondicion efectoCondicion;

    @Override
    public Integer getTurnoColocada() {
        return turnoColocada;
    }

    public HechizoTrampaEnCampo(String nombre, boolean estaBocaArriba, Jugador propietario) {
        super(nombre);
        this.estaBocaArriba = estaBocaArriba;
        this.propietario = propietario;
        turnoColocada = propietario.getJuego().getNumeroTurno();
    }

    abstract public Carta getCarta();

    public void aplicarEfecto(Juego juego) {
        efectoCondicion.aplicar(juego);
    }

    @Override
    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    @Override
    public void ponerBocaArriba() {
        estaBocaArriba = true;
    }

    public Jugador getPropietario() {
        return propietario;
    }

}
