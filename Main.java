public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Sistema con Manejo de Excepciones ===");

        Druida druida = new Druida("Sylva", 7, 200, 180, 120, "Oso");
        Nigromante nigromante = new Nigromante("Malachar", 6, 240, 220, 5, "Sombra");

        // Escenario 1 — Turno normal sin excepción
        MotorCombate motor = new MotorCombate();
        motor.ejecutarTurno(druida, nigromante);

        // Escenario 2 — Personaje derrotado intenta atacar
        try {
            druida.recibirDanio(9999);
        } catch (Exception e) {}
        motor.ejecutarTurno(druida, nigromante);

        // Escenario 3 — Arquero sin flechas
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);

        // Escenario 4 — Curar aliado derrotado
        Druida druida2 = new Druida("Sylva2", 7, 200, 180, 120, "Oso");
        Personaje personajeDerrotado = new Nigromante("Caído", 1, 0, 100, 0, "Muerte");
        try {
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("\nNo se pudo curar: " + e.getMessage());
        }

        // Escenario 5 — Daño negativo con finally
        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        // Escenario 6 — Mostrar bitácora completa
        motor.mostrarBitacora();
    }
}