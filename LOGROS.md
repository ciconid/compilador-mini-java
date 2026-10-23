# Logros de la etapa 4

Lista de `docs/Pautas Etapa 4.pdf`. Los completados se declaran en `docs/informe-etapa4.md`.

## Completados

- ✅ **Ternario E4**: las expresiones ternarias están correctamente tipadas (`NodoTernario`).
- ✅ **Atributos Inicializados – Chequeado!**: los inicializadores de atributos se chequean como en Java, incluida la
  referencia adelantada (`Atributo.chequearInicializador()`).
- ✅ **Postfijos – Chequeado**: `++` y `--` sólo sobre operandos `int` asignables (`NodoPosfijo`).
- ✅ **Genericidad Avanzada E4**: genéricos anidados en expresiones y sentencias, diamante como en Java y sin tipos
  raw (`Tipo.estaBienUsado`, `TipoReferencia.inferirArgumento`).

## Pendientes

- [ ] **Instanceof**: operador `instanceof` con una clase o interfaz no genérica a la derecha; sin arreglos ni
  variable asociada.
- [ ] **Visibilidad – Chequeada**: los accesos a atributos, métodos y constructores respetan los modificadores de
  visibilidad, como en Java.
- [ ] **Super! E4**: `super` para acceder a métodos o atributos de un ancestro, o para invocar su constructor.
- [ ] **Métodos Genéricos E4**: métodos genéricos bien usados y con cuerpos bien tipados, como en Java, con
  parámetros de tipo sin cotas (ni siquiera `Object` implícita).
- [ ] **Variables Locales Clásicas Controladas**: las declaraciones de variables clásicas (en todas sus variantes)
  están bien tipadas.
- [ ] **For E4**: `for` clásico (inicialización con asignación o `var`, condición `boolean`, actualización con
  asignación) y `for` de iteradores sobre la interfaz predefinida `MiniIterable<T>`.
- [ ] **Todos los Caminos llevan al Retorno sin código muerto**: cada camino de un método llega a un `return` y no
  hay código inalcanzable, como en Java.
- [ ] **Floats y Coerción**: literales `float` y coerción de `int` a `float`, `int` a `char`, `char` a `int`, y de
  `char` e `int` a `String`, en los mismos contextos que Java.
- [ ] **Minilambdas E4**: lambdas sin tipos en los parámetros y con una única expresión como cuerpo; sin capturar
  locales ni parámetros externos, y sin `this`.
- [ ] **Multi-Detección de Errores Semánticos en Sentencias**: ante un error en una sentencia o expresión, el
  compilador se recupera y sigue al menos con la próxima sentencia.

## No dependen de la implementación

- **Imbatibilidad Semántica II**: pasar toda la batería de prueba de la cátedra.
- **Entrega Anticipada Semántica II**: entregar 48 hs antes de la fecha límite.
- **Grandioso Laburo!**: la entrega tiene sólo algunos errores menores.
