package tp2.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Mazo {
    protected List<Carta> mazo;

    public Mazo() {
        this.mazo = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        this.mazo.add(carta);
    }

    public void mezclar() {
        Collections.shuffle(this.mazo);
    }

    public List<Carta> getCartas() {
        return this.mazo;
    }

    public boolean estaVacio() {
        return this.mazo.isEmpty();
    }

    public Carta robar() {
        return this.mazo.getFirst();
    }
}
