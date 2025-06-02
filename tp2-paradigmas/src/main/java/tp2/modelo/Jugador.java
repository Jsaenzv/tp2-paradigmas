package main.java.tp2.modelo;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Integer puntosVida;
    private List<Carta> mano;
    private Tablero tableroPropio;
    private Juego juego;

    public Jugador() {}

    public Jugador(String nombre, Tablero tableroPropio, Juego juego) {
        this.nombre = nombre;
        this.puntosVida = 8000;
        this.mano = new ArrayList<Carta>();
        this.tableroPropio = tableroPropio;
        this.juego = juego;
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
        tableroPropio.robarCarta();
    }

    public void invocarMonstruo(MonstruoEnCampo monstruo) {
        tableroPropio.colocarMonstruo(monstruo);
    }

    public void activarHechizo(CartaHechizo hechizo) {
        tableroPropio.colocarHechizoTrampa(new HechizoTrampaEnCampo(hechizo, VisibilidadCarta.BOCA_ARRIBA));
        hechizo.resolverEfecto(juego);
    }

    public void activarTrampa(CartaHechizo trampa) {
        tableroPropio.colocarHechizoTrampa(new HechizoTrampaEnCampo(trampa, VisibilidadCarta.BOCA_ARRIBA));
        trampa.resolverEfecto(juego);
    }

    public void rendirse() {
        juego.rendirJugador(this);
    }

    public void atacar(MonstruoEnCampo monstruoAtacante, MonstruoEnCampo monstruoDefensor) {
        juego.resolverAtaque(this, monstruoAtacante, monstruoDefensor);
    }

}
