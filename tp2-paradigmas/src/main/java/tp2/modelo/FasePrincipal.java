package main.java.tp2.modelo;

public class FasePrincipal implements EstadoTurno {

    @Override
    public void ejecutarFase(Turno turno, AccionUsuario accion) {
        if (!(accion instanceof AccionFasePrincipal accionFP)) {
            throw new RuntimeException("Acción no permitida en Fase Principal 1");
        }
        accionFP.ejecutarAccion(turno);
        turno.cambiarFase(new FaseCambios());
    }
}
