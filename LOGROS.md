# Logros: orden de implementación

De más fácil a más difícil, según el estado actual del proyecto.

No se implementan: Entrega Anticipada, Imbatibilidad y Kudos. Dependen de cuándo se entrega y de cómo corrige la cátedra.

## 1. Multi-Detección de Errores

- **Es un cambio transversal.** Todo el diseño asume que el análisis corta en el primer error (30 `throw new ErrorSemantico`). Habría que juntar los errores en una lista, recuperarse en cada declaración y, cuando hay nombres repetidos, descartar las dos entidades.
- **La consolidación se vuelve frágil.** `consolidar()` hace casts del tipo `(Clase) superclase.getReferenciada()` que asumen que la segunda pasada no encontró errores. Con recuperación, las entidades inválidas se tienen que saltear para no provocar errores en cascada o excepciones.
- **Interacción con el orden:** si se hace después de los demás logros, también hay que adaptar su código. Si se hace antes, todo logro nuevo tiene que escribirse pensando en la recuperación.

## 2. Métodos Genéricos: el más difícil

- **Sintaxis:** `<T> T m(T x)` hace que un miembro pueda empezar con `<`. Eso cambia los conjuntos de primeros de la gramática LL(1).
- **Alcance de los parámetros de tipo:** hoy el contexto de validación es solo la clase (`estaBienDeclarado(ClaseOInterfaz contexto)`), y pasaría a ser la clase más el método.
- **Redefinición como en Java:** hay que comparar signaturas sin importar cómo se llama el parámetro de tipo. `<T> void m(T)` redefine a `<U> void m(U)`, y eso no lo cubre el `esIgual` actual.
- **Instanciación:** hay que combinarla con los parámetros de tipo de la clase.
