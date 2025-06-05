package tp2.controlador;
import tp2.modelo.*;
import tp2.vista.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controlador {
    private Juego juego;
    private Vista vista;
    private Jugador jugadorActual;

    public Controlador() {
        this.vista = new Vista();

        String nombreJugador1 = vista.nombreJugador("nombre del jugador 1");
        String nombreJugador2 = vista.nombreJugador("nombre del jugador 2");

        this.juego = new Juego();
        juego.iniciar(new Jugador(nombreJugador1, null, null), new Jugador(nombreJugador2, null, null));
        //this.jugadorActual = juego.getJugador1();
    }

    private void fasePrincipal() {
        List<CartaMonstruo> monstruosEnMano= new ArrayList<>();
        List<CartaHechizo> hechizosEnMano = new ArrayList<>();
        List<AccionTurno> accionesAEjecutar = new ArrayList<>();
        List<HechizoTrampaEnCampo> hechizosTrampaEnCampo = new ArrayList<>();

        for(Carta carta : jugadorActual.getMano()) {
            if(carta instanceof CartaMonstruo) {
                monstruosEnMano.add((CartaMonstruo) carta);
            }else if(carta instanceof CartaHechizo) {
                hechizosEnMano.add((CartaHechizo) carta);
            }
        }

        for(HechizoTrampaEnCampo hechizo : jugadorActual.getHechizosEnTablero()) {
            if(hechizo.estaBocaArriba()) {
                hechizosTrampaEnCampo.add(hechizo);
            }
        }

        if(!monstruosEnMano.isEmpty()) {
            Integer monstruoElegido = vista.elegirMonstruo(monstruosEnMano);
            if(monstruoElegido >= 0) {
                ModoCarta modoElegido = vista.elegirModo() == 1 ? ModoCarta.ATAQUE : ModoCarta.DEFENSA;
                VisibilidadCarta caraElegida = vista.elegirCara() == 1 ? VisibilidadCarta.BOCA_ARRIBA : VisibilidadCarta.BOCA_ABAJO;
                accionesAEjecutar.add( new InvocarMonstruo(new MonstruoEnCampo(monstruosEnMano.get(monstruoElegido), caraElegida.estaBocaArriba(), modoElegido)));
            }
        }

        if(!hechizosEnMano.isEmpty()) {
            Set<Integer> hechizosElegidos = new HashSet<>();
            Integer hechizoElegido = vista.elegirHechizo(hechizosEnMano);

            while (hechizoElegido >= 0) {
                while (hechizosElegidos.contains(hechizoElegido)) {
                    vista.imprimirError("Ya invocaste este hechizo. Elegí otro");
                    hechizoElegido = vista.elegirHechizo(hechizosEnMano);
                    if (hechizoElegido < 0) break;
                }

                if (hechizoElegido < 0) break;

                VisibilidadCarta caraElegida = vista.elegirCara() == 1 ? VisibilidadCarta.BOCA_ARRIBA : VisibilidadCarta.BOCA_ABAJO;

                accionesAEjecutar.add(new ColocarCarta(new HechizoTrampaEnCampo(hechizosEnMano.get(hechizoElegido), caraElegida.estaBocaArriba())));
                hechizosElegidos.add(hechizoElegido);

                hechizoElegido = vista.elegirHechizo(hechizosEnMano);
            }

        }

        if (!hechizosTrampaEnCampo.isEmpty()) {
            Set<Integer> hechizosElegidos = new HashSet<>();
            Integer hechizoElegido = vista.elegirHechizo(hechizosTrampaEnCampo);

            while (hechizoElegido >= 0) {
                while (hechizosElegidos.contains(hechizoElegido)) {
                    vista.imprimirError("Ya activaste este hechizo. Elegí otro");
                    hechizoElegido = vista.elegirHechizo(hechizosTrampaEnCampo);
                    if (hechizoElegido < 0) break;
                }

                if (hechizoElegido < 0) break;

                accionesAEjecutar.add(new ActivarCarta(hechizosTrampaEnCampo.get(hechizoElegido)));
                hechizosElegidos.add(hechizoElegido);

                hechizoElegido = vista.elegirHechizo(hechizosTrampaEnCampo);
            }
        }

        this.juego.avanzarTurno(accionesAEjecutar);
    }

    public void iniciarJuego() {
        AccionNula accionNula = new AccionNula();
        while(!juego.verificarCondicionVictoria().hayGanador()) {
            this.juego.avanzarTurno(accionNula);
            this.juego.avanzarTurno(accionNula);
            fasePrincipal();

        }
    }

}
