package main.java.tp2.modelo;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    public static final Object MAX_MAGIA_TRAMPA = 5;
    private String nombre;
    private Integer puntosVida;
    private List<Carta> mano;
    private Tablero tableroPropio;
    private Juego juego;

    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosVida = 8000;
        this.mano = new ArrayList<Carta>();
    }

    public Integer getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(Integer puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Mazo getMazo() {
        return tableroPropio.getMazo();
    }

    public Carta robarCarta() {
        return tableroPropio.robarCarta();
    }

    public void invocarMonstruo(MonstruoEnCampo monstruoInvocado, List<MonstruoEnCampo> monstruosSacrificados) {
        tableroPropio.colocarMonstruo(monstruoInvocado, monstruosSacrificados);
    }

    public void activarHechizo(CartaHechizo hechizo) {
        tableroPropio.colocarHechizoTrampa(new HechizoEnCampo(hechizo, true, this));
        hechizo.aplicarEfecto(juego);
    }

    public void activarTrampa(CartaTrampa trampa) {
        tableroPropio.colocarHechizoTrampa(new TrampaEnCampo(trampa, true, this));
        trampa.aplicarEfecto(juego);
    }

    public void rendirse() {
        juego.rendirJugador(this);
    }


    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    public Juego getJuego() {
        return juego;
    }
    public void setTableroPropio(Tablero tableroPropio) {
        this.tableroPropio = tableroPropio;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void enviarAlCementerio(HechizoTrampaEnCampo cartaEnCampo) {

    }

    public Tablero getTableroPropio() {
        return tableroPropio;
    }

    public Jugador getOponente() {
        for (Jugador jugador : juego.getJugadores()) {
            if (!jugador.equals(this)) {
                return jugador;
            }
        }
        throw new IllegalStateException("No se encontró un oponente para el jugador " + this.nombre);
    }

    public void colocarCartaHechizoTrampa(HechizoTrampaEnCampo carta) {
        tableroPropio.colocarHechizoTrampa(carta);
    }
}
