public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;
    private double precision;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles, double precision) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }
        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara con su " + tipoArco + ". Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() {
        return (int) (precision * flechasDisponibles);
    }
}