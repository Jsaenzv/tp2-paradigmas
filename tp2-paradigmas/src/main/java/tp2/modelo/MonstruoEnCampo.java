package main.java.tp2.modelo;

public class MonstruoEnCampo extends Carta implements CartaEnCampo {
    private final CartaMonstruo carta;
    private boolean estaBocaArriba;
    private ModoCarta modo;
    private Jugador propietario;
    private Integer turnoColocada;

    public MonstruoEnCampo(CartaMonstruo carta, boolean estaBocaArriba, ModoCarta modo) {
        super(carta.getNombre());
        this.carta = carta;
        this.estaBocaArriba = estaBocaArriba;
        this.modo = modo;
    }

    @Override
    public Integer getTurnoColocada() {
        return 0;
    }

    public ModoCarta getModo() {
        return modo;
    }

    public void cambiarModo(ModoCarta nuevoModo) {
        this.modo = nuevoModo;
    }

    public boolean estaEnModoAtaque() {
        return modo.esAtaque();
    }

    public Carta getCarta() {
        return carta;
    }

    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    public void ponerBocaArriba() {
        estaBocaArriba = true;
    }

    @Override
    public Jugador getPropietario() {
        return propietario;
    }

    public int getNivel() {
        return carta.getNivel();
    }

    public String getNombre() {
        return carta.getNombre();
    }
}
