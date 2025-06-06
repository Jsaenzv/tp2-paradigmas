package main.java.tp2.modelo;

public class CartaHechizo extends CartaHechizoTrampa {
    private final TipoHechizo tipo;

    public CartaHechizo(String nombre, EfectoCondicion efectoCondicion, TipoHechizo tipo) {
        super(nombre, efectoCondicion);
        this.tipo = tipo;
    }

    public TipoHechizo getTipo() {
        return tipo;
    }

}
