public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas;
    private String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas, String maldicion) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.maldicion = maldicion;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        mana -= 15;
        System.out.println("[" + nombre + "] aplica la maldición " + maldicion + " y drena la esencia vital.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 40 + (almasAbsorbidas * 15);
    }

    @Override
    public void lanzarHechizo() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(nombre);
        if (mana < 20) throw new RecursoInsuficienteException("mana", mana);
        mana -= 20;
        System.out.println(nombre + " lanza: ¡Maldición oscura! (maná restante: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }
}