# Plan Etapa 4 – Chequeo de sentencias

## Estado

La implementación está completa: los 10 incrementos (infraestructura, AST con placeholders, sentencias de control,
variables, conformidad/`this`/`new`, llamadas, encadenados, arreglos y extras de E2, genericidad fina, cierre)
están hechos, los placeholders se borraron y todos los tests pasan. El informe es `docs/informe-etapa4.md`, con los
diagramas `docs/diagrama-ast-{sentencias,expresiones,llamadas}.puml`. Los logros están en `LOGROS.md`.

## Decisiones tomadas

- Se chequea como Java lo que el parser acepta por logros E2 (ternario, posfijos, inicialización de arreglos,
  diamante, atributos inicializados). Lo que la documentación no especifica también se resuelve como Java.
- Logros E4 declarados: Ternario, Atributos Inicializados, Postfijos, Genericidad Avanzada y Entrega Anticipada.
- Resueltos como Java: `toString()` sobre variables de tipo interfaz; tipo del ternario con ramas referencia sin
  relación = supertipo común más específico (si hay varios mínimos, la clase); referencia adelantada prohibida en
  inicializadores de atributos. Entre primitivos distintos el ternario es error (MiniJava no tiene conversiones).
- Diamante sin contexto infiere `Object` (no infiere desde los argumentos del constructor).
- Se respeta la semántica aunque contradiga casos propios de etapa 3: no hay tipos raw (tampoco como argumento,
  `Caja<Lista>`) y los parámetros de tipo se distinguen por su origen (`A1<T> extends Caja` no redefine con el `T` de
  `Caja`). Esos casos se movieron a conErrores o se corrigieron.
- Tokens de error: el operador; `if`/`while`/`return`; el id de la variable; `=` en asignaciones, destinos no
  asignables e inicializadores de atributos; `;` en expresiones que no son sentencia; el nombre de la clase en `new` y
  en tipos inválidos; el nombre del método o miembro en llamadas y accesos; `this`; `[` en indexación y tamaños;
  `{` en inicializadores de arreglos; `?` en el ternario; `T` en contexto estático.

## Próximo paso: revisar casos de prueba sin contemplar

Buscar situaciones de `docs/MiniJava-Semantica-Completa-2026.pdf` (secciones 9–14) y de las pautas que todavía no
tengan un caso en `resources/semantico2/NicolasCid/`, sobre todo combinaciones entre funcionalidades. Por ejemplo:

- [x] Recorrer la semántica sección por sección y anotar cada regla que no tenga un caso conErrores o sinErrores.
- [x] Combinaciones: genéricos con encadenados y arreglos, ternarios y posfijos dentro de cadenas, diamante en
      inicializadores de arreglos y de atributos, `this` y llamadas en inicializadores de atributos.
- [x] Contexto estático en todas sus formas (atributos, `this` y llamadas implícitas, también dentro de
      parentizadas o subexpresiones). Que las unidades heredadas no se vuelvan a chequear no es observable con un
      caso (un atributo no puede ocultar a uno heredado).
- [x] Constructores: `return` en constructores, constructor por defecto, `new` con argumentos genéricos.
- [x] Predefinidas: métodos de `System`, `Object` y `String` con argumentos mal tipados o como receptores.
- [x] Comparar con los casos de cátedra (`resources/semantico2/catedra/`) para ver qué patrones no cubrimos.
- [x] Correr los casos nuevos (conErrores 144–185, sinErrores 44–53): pasan todos sin cambios en el código.

Mismo flujo de trabajo: proponer los casos, esperar aprobación, agregarlos y, si alguno falla, corregir el código.

## Verificación (sólo cuando se pida)

- `./gradlew test --rerun-tasks` (hace falta `--rerun-tasks` si sólo cambiaron casos en `resources/`).
- `./gradlew jar && java -jar build/libs/Compilador.jar <caso>` para ver el mensaje de error.
