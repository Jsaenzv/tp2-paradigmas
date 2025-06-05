package tp2.modelo;

public abstract class HechizoTrampaEnCampo implements CartaEnCampo {

    protected boolean estaBocaArriba;

    abstract public Carta getCarta();

    @Override
    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    @Override
    public void ponerBocaArriba() {
        estaBocaArriba = true;
    }

    @Override
    public String toString() {
        return "CartaEnCampo{" +
                "carta=" + carta +
                ", visibilidad=" + visibilidad +
                '}';
    }

}
