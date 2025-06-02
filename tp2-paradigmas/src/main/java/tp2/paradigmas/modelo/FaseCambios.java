package tp2.paradigmas.modelo;

public class FaseCambios implements EstadoTurno{

    @Override
    public void ejecutarFase(Turno turno, AccionTurno accion) {
        accion.ejecutar(turno);
        turno.cambiarFase(new FaseFinal());
    }
}
