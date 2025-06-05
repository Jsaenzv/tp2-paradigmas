package tp2.modelo;

public class MonstruoEnCampo implements CartaEnCampo {
    private final CartaMonstruo carta;
    private boolean estaBocaArriba;
    private ModoCarta modo;

    public MonstruoEnCampo(CartaMonstruo carta, boolean estaBocaArriba, ModoCarta modo) {
        this.carta = carta;
        this.estaBocaArriba = estaBocaArriba;
        this.modo = modo;
    }

    public void cambiarModo(ModoCarta nuevoModo) {
        this.modo = nuevoModo;
    }

    public boolean estaEnModoAtaque() {
        return modo.esAtaque();
    }

    public CartaMonstruo getCarta() {
        return carta;
    }

    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    public void ponerBocaArriba() {
        estaBocaArriba = true;
    }

    @Override
    public String toString() {
        return "CartaEnCampo{" +
                "carta=" + carta +
                ", visibilidad=" + visibilidad +
                ", modo=" + modo +
                '}';
    }
}
