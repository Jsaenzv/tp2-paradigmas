package main.java.tp2.modelo;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private static final int MAX_MONSTRUOS = 5;
    private static final int MAX_HECHIZOTRAMPA = 5;
    private final List<MonstruoEnCampo> casillerosMonstruos;
    private final List<HechizoTrampaEnCampo> casillerosHechizosTrampa;
    private final Mazo mazo;
    private final Mazo cementerio;

    public Tablero() {
        casillerosMonstruos = new ArrayList<>();
        casillerosHechizosTrampa = new ArrayList<>();
        mazo = new Mazo();
        cementerio = new Mazo();
    }

    public void agregarCartaAlMazo(Carta carta) {
        mazo.agregarCarta(carta);
    }

    public void colocarMonstruo(MonstruoEnCampo monstruo, List<MonstruoEnCampo> monstruosSacrificados) {
        int nivel = monstruo.getNivel();
        int sacrificiosRequeridos;

        if (nivel >= 1 && nivel <= 4) {
            sacrificiosRequeridos = 0;
        } else if (nivel == 5 || nivel == 6) {
            sacrificiosRequeridos = 1;
        } else {
            sacrificiosRequeridos = 2;
        }

        if (monstruosSacrificados == null) {
            monstruosSacrificados = List.of();
        }
        if (monstruosSacrificados.size() != sacrificiosRequeridos) {
            throw new IllegalArgumentException(
                    "Para invocar un monstruo de nivel " + nivel +
                            " se requieren " + sacrificiosRequeridos + " sacrificio(s)."
            );
        }

        for (MonstruoEnCampo sacrificado : monstruosSacrificados) {
            if (!casillerosMonstruos.contains(sacrificado)) {
                throw new IllegalArgumentException(
                        "El monstruo a sacrificar no está en el campo: " + sacrificado.getNombre()
                );
            }
        }

        for (MonstruoEnCampo sacrificado : monstruosSacrificados) {
            cementerio.agregarCarta(sacrificado.getCarta());
            casillerosMonstruos.remove(sacrificado);
        }

        if (casillerosMonstruos.size() >= MAX_MONSTRUOS) {
            throw new IllegalStateException("No hay espacio para más monstruos en el tablero.");
        }

        casillerosMonstruos.add(monstruo);
    }

    public int espaciosMonstruos() {
        return MAX_MONSTRUOS - casillerosMonstruos.size();
    }

    public int espaciosHechizos() {
        return MAX_HECHIZOTRAMPA - espaciosMonstruos();
    }

    public void colocarHechizoTrampa(HechizoTrampaEnCampo hechizoTrampa) {
        if (casillerosHechizosTrampa.size() >= MAX_HECHIZOTRAMPA) {
            throw new RuntimeException("No hay espacio para más hechizos o trampas en el tablero.");
        }
        casillerosHechizosTrampa.add(hechizoTrampa);
    }

    public void eliminarMonstruo(MonstruoEnCampo monstruo) {
        casillerosMonstruos.remove(monstruo);
    }

    public void eliminarHechizoTrampa(HechizoTrampaEnCampo hechizoTrampa) {
        casillerosHechizosTrampa.remove(hechizoTrampa);
    }

    public void enviarAlCementerio(HechizoTrampaEnCampo cartaEnCampo) {

        boolean estabaEnCampo = casillerosHechizosTrampa.remove(cartaEnCampo);
        if (!estabaEnCampo) {
            throw new IllegalArgumentException(
                    "La carta de hechizo/trampa no se encontró entre las cartas en campo."
            );
        }

        Carta carta = cartaEnCampo.getCarta();
        cementerio.agregarCarta(carta);
    }

    public Mazo getMazo() {
        return mazo;
    }

    public Carta robarCarta() {
        return mazo.robar();
    }

}
