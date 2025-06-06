package main.java.tp2.modelo;

public class FaseCambios implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionUsuario accion) {
        accion.ejecutarAccion(turno);
        turno.cambiarFase(new FaseFinal());
    }
}
