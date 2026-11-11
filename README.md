# Laboratorio 07 — Manejo de Excepciones en Java

**Unidad:** 7 — Manejo de Excepciones  
**Materia:** Programación Orientada a Objetos  

---

## Preguntas de Reflexión

### 1. ¿Cuál es la diferencia entre una excepción chequeada y una no chequeada? ¿Por qué PersonajeNuloException extiende RuntimeException y no Exception?
* **Diferencia:** Las excepciones chequeadas heredan de `Exception` y el compilador exige gestionarlas obligatoriamente. Las no chequeadas heredan de `RuntimeException` y el compilador no obliga a capturarlas.
* **Motivo:** `PersonajeNuloException` extiende `RuntimeException` porque pasar un valor `null` refleja un error de programación o fallo lógico del desarrollador, no una regla de negocio del usuario.

### 2. ¿Para qué sirve el bloque finally? Da un ejemplo real de cuándo es indispensable.
* **Utilidad:** Asegura la ejecución de instrucciones de forma incondicional, ocurra o no una excepción.
* **Ejemplo real:** Es indispensable para cerrar conexiones a bases de datos, archivos o flujos de red, evitando fugas de memoria o bloqueos de recursos.

### 3. ¿Cuál es la diferencia entre throw y throws? Muestra un ejemplo de cada uno tomado de este laboratorio.
* **`throw`:** Lanza explícitamente una excepción en el código. *Ejemplo:* `throw new RecursoInsuficienteException("flechas", 0);`
* **`throws`:** Declara en la firma del método que este puede propagar una excepción chequeada. *Ejemplo:* `public void atacar() throws RpgException`