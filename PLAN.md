# Plan Etapa 4 – Chequeo de sentencias (versión básica, incremental con placeholders)

## Contexto

La etapa 4 extiende el sintáctico para que construya el AST del cuerpo de cada método/constructor, lo asocie a su
entrada en la TS y, tras `chequeoDeclaraciones()`, la TS ejecute `chequeoSentencias()` (resolución de nombres + chequeo
de tipos por delegación: cada nodo chequea lo suyo y le pide a sus hijos que se chequeen). Referencias:
`docs/Pautas Etapa 4.pdf`, `docs/MiniJava-Semantica-Completa-2026.pdf` (secciones 9–14), clases 09/10/11.

La cátedra recomienda avanzar en incrementos testeables: los nodos aún no implementados se representan con
**placeholders** (`NodoSentenciaPendiente`, `NodoExpresionPendiente`) cuyo `chequear()` no falla y devuelve un
`TipoPendiente` que conforma con todo. Así los casos SinErrores pasan desde el primer incremento y los ConErrores se
van poniendo verdes a medida que se reemplazan placeholders por nodos reales.

Decisiones tomadas:
- Versión básica: no se persiguen logros E4 que requieran trabajo extra.
- Lo que el parser ya acepta por logros E2 (ternario, posfijos, inicialización de arreglos, diamante, atributos
  inicializados) se **chequea como Java**. Eso cumple los logros *Ternario E4*, *Atributos Inicializados –
  Chequeado!* y *Postfijos – Chequeado*, que se declaran en el informe.
- Lo que la documentación de la materia no especifica se resuelve como en Java.
- Se crea `MainEtapa3`; `Main` pasa a ser etapa 4.

Regla de trabajo (CLAUDE.md): antes de implementar cada incremento se escriben sus casos en
`resources/semantico2/NicolasCid/{sinErrores,conErrores}` (convención `<n>_FB_<desc>.java`, o `L_..._E2` si usan
sintaxis de logros E2) y se piden aprobados. Al cerrar cada incremento se propone un mensaje de commit.

## Diseño general

**Paquete** `org.example.analizadorsemantico.ast` (los métodos de `Tipo`/TS que usen los nodos pasan a `public`).

**Sentencias** (`NodoSentencia`, abstracta, `void chequear()`):
`NodoBloque` (lista de sentencias + locales del ámbito), `NodoVacia`, `NodoVarLocal(tokenNombre, expr)`,
`NodoReturn(tokenReturn, expr?)`, `NodoIf(tokenIf, cond, then, else?)`, `NodoWhile(tokenWhile, cond, cuerpo)`,
`NodoSentenciaExpresion(expr)` (exige asignación o llamada), `NodoSentenciaPendiente`.

**Expresiones** (`NodoExpresion`, abstracta, `Tipo chequear()`, `boolean esAsignable()`, `boolean esLlamada()` –
alternativa 1 de la clase 11, default `false`):
`NodoAsignacion(tokenIgual, izq, der)`, `NodoExpBinaria(op, izq, der)`, `NodoExpUnaria(op, operando)`,
`NodoPosfijo(op, operando)`, `NodoTernario(tokenInterrogacion, cond, siV, siF)`, `NodoExpresionPendiente`.

**Operandos/primarios** (cada uno con `encadenado` opcional):
`NodoLiteral(token)`, `NodoThis`, `NodoParentizada(expr)` (conserva tipo, nunca asignable ni llamada, tampoco su
encadenado), `NodoAccesoVar(token)`, `NodoLlamadaMetodo(token, args)` (receptor implícito),
`NodoLlamadaEstatica(tokenClase, token, args)`, `NodoNewObjeto(TipoReferencia, args)` (diamante incluido),
`NodoNewArreglo(tipoBase, tamaños)`, `NodoInicializadorArreglo`.

**Encadenados** (`NodoEncadenado`, `Tipo chequear(Tipo receptor)`):
`NodoAtributoEncadenado(token)` (incluye `length` de arreglos), `NodoLlamadaEncadenada(token, args)`,
`NodoAccesoArreglo(tokenCorchete, indice)`. `esAsignable/esLlamada` de una cadena = las del último eslabón.

**Tipos**: se agregan `TipoNull`, `TipoPendiente` (temporal) y `boolean conformaCon(Tipo destino)` en `Tipo`
(si el destino es `TipoPendiente` → `true`). Vistas de miembros desde el receptor con sustitución genérica
(reusar `instanciar(parametro, argumento)` existente en `Tipo`, `Metodo`, `Atributo`).

**TS** (`TablaDeSimbolos`): contexto de chequeo `claseActual`, `unidadActual`, pila de bloques/locales;
`chequeoSentencias()` recorre cada clase **no predefinida** y sólo sus unidades **declaradas en ella** (no las heredadas
por consolidación; guardar la lista de unidades propias al parsear) y llama `bloque.chequear()`. El constructor por
defecto recibe un `NodoBloque` vacío.

**Tokens de error** (según casos de cátedra): variable no declarada → su id; asignación incompatible o no asignable →
`=`; argumentos mal tipados → nombre del método; operador mal tipado → el operador; local repetida → su id.

**Parser** (`AnalizadorSintactico`): los métodos de sentencias/expresiones pasan de `void` a devolver nodos según una
EDT sobre la gramática actual. La recursión de `restoExpresionCompuesta`/`restoReferencia` recibe el nodo izquierdo
como parámetro (atributo heredado, clase 11). El AST respeta la estructura del parse actual (no se reordena
precedencia).

## Incrementos

Cada incremento deja todos los SinErrores (cátedra + propios, etapas 1–4) en verde.

- ✅ **0. Infraestructura de tests y mains**
   - Copiar `Main` → `MainEtapa3`; testers de `src/test/java/semantico/**` usan `MainEtapa3`.
   - Arreglar `src/test/java/semantico2/catedra/*` (package `semantico2.catedra`, `import org.example.Main`, paths
     `resources/semantico2/catedra/...`) y crear `semantico2/NC/*` apuntando a `resources/semantico2/NicolasCid/`.
   - `Main` llama `TablaDeSimbolos.ts.chequeoSentencias()` (vacío por ahora). Actualizar CLAUDE.md (etapa 4,
     MainEtapa3, `semantico2`).
   - Verifica: 5 SinErrores de cátedra pasan; etapa 3 sigue igual.

- ✅ **1. Esqueleto AST + placeholders**
   - `NodoSentencia`, `NodoBloque` y `NodoSentenciaPendiente`; `Unidad` guarda su `NodoBloque` (vacío por defecto).
   - `bloque()` devuelve `NodoBloque`; `sentencia()` devuelve `NodoSentenciaPendiente` para todo salvo bloques
     anidados; se asocia el bloque a la unidad en `metodo*()`/`constructor()`.
   - `chequeoSentencias()` recorre `unidadesDeclaradas` de cada clase/interfaz con `claseActual`/`unidadActual`.

- ✅ **2. Sentencias de control y expresiones sin nombres**
   - Binarios sin precedencia y asociativos a izquierda (gramática original `ExpComp → ExpComp op ExpBasica`):
     `restoExpresionCompuesta(ladoIzq)` arma `((a op b) op c)`; el ternario queda por encima de los binarios.
   - Tokens de error: operador (binario/unario), `if`/`while` (condición), `return`.
   - `NodoExpresion`, `NodoExpresionPendiente` y `TipoPendiente` (movidos desde el incremento 1); las expresiones del
     parser pasan a devolver nodos.
   - `NodoVacia`, `NodoIf`, `NodoWhile` (cond `boolean`), `NodoReturn` (void / no void /
     constructor, resultado void prohibido).
   - `NodoLiteral`, `NodoExpBinaria`, `NodoExpUnaria`, `NodoParentizada`; `conformaCon` para primitivos, `null`
     y `String`. El resto de los operandos sigue como `NodoExpresionPendiente`.
   - Casos: `if (4+true)`, `while (1)`, `return 'a'` en método int, `return 1` en void/constructor, etc.

- ✅ **3. Variables y asignación**

   Se empiezan a resolver nombres: las variables dejan de ser placeholder y aparecen las sentencias de declaración,
   asignación y expresión.
   - **Ámbitos**: la TS mantiene una pila de ámbitos de locales. `NodoBloque.chequear()` apila uno al entrar y lo
     desapila al salir, así una local deja de ser visible al terminar su bloque y los bloques hermanos pueden repetir
     nombres.
   - **`NodoVarLocal(tokenNombre, inicializador)`**: chequea el inicializador *antes* de registrar la variable (así
     `var x = x + 1` no se ve a sí misma, y si hay un atributo `x` se usa ese). Es error si el nombre coincide con un
     parámetro o con una local visible, o si el inicializador es `null` o void. La local toma exactamente el tipo del
     inicializador. `NodoIf`/`NodoWhile` rechazan una `NodoVarLocal` como cuerpo directo (then, else o cuerpo).
   - **`NodoAccesoVar(token)`**: busca local (del ámbito actual hacia afuera) → parámetro de la unidad → atributo de
     la clase actual (la tabla consolidada ya incluye los heredados). Si cae en un atributo y la unidad es estática,
     es error. Es asignable.
   - **`NodoAsignacion(tokenIgual, izq, der)`**: el lado izquierdo tiene que ser asignable y el tipo del derecho
     conformar con el del izquierdo. Devuelve el tipo del izquierdo, así sirve como expresión (`return x = 3`).
   - **`NodoSentenciaExpresion(expresion, tokenPuntoYComa)`**: sólo acepta asignaciones o llamadas. Se agregan a
     `NodoExpresion` los servicios `esAsignable()`/`esAsignacion()`/`esLlamada()` (default `false`;
     `NodoParentizada` siempre `false`; el placeholder `true` en asignable y llamada para no dar errores falsos).
   - El cuerpo de if/else/while se chequea con `chequearComoCuerpo()`, que `NodoVarLocal` redefine para dar error.
   - Soporte en la TS/entidades: getters de parámetros, atributos, condición de estático de la unidad y clase
     actual.
   - Tokens de error: el id (variable no declarada, local repetida, var inválida), `=` (asignación), `;` (expresión
     que no es sentencia).
   - Casos (17–36 conErrores, 06–11 sinErrores): variables no declaradas, atributo en estático, asignaciones
     inválidas, locales repetidas/fuera de ámbito/usadas en su inicializador, var como cuerpo de if/else/while.
     Cubre `semIIError01` y `semIIError05`.

- ✅ **4. Conformidad de referencias, this y creación de objetos**

   Se completa la conformidad para tipos no primitivos y se agregan `this` y `new Clase(...)`. Hoy un tipo
   referencia sólo conforma con otro igual, y `this`/`new` son placeholder.

   **Conformidad**
   - **`TipoReferencia.conformaCon(destino)`**: conforma si:
     1. son iguales (nombre y argumento genérico), o
     2. el destino es `Object`, o
     3. algún supertipo directo (superclase o interfaz implementada/extendida) conforma con el destino, recursivo
        hacia arriba.

     Al subir se aplica la sustitución genérica: si `class Final extends Intermedia<String>` e
     `Intermedia<U> extends Base<U>`, el supertipo de `Final` es `Intermedia<String>` y el de éste `Base<String>`.
     Así `Final` conforma con `Base<String>` pero no con `Base<Object>` (argumentos invariantes).
   - **`TipoArreglo`**: sólo con un arreglo idéntico o con `Object` (`String[]` no conforma con `Object[]`).
   - **`TipoParametro`**: sólo consigo mismo (ya es así): `T` no conforma con `Object` ni al revés.
   - **`==`/`!=`** ya usan `conformaCon` en ambas direcciones, así que comparar clases sin relación pasa a ser error
     solo.

   **`this`**
   - **`NodoThis`**: error en método estático (token `this`). Su tipo es la clase actual con su parámetro (dentro
     de `Caja<T>`, `Caja<T>`). No es asignable (`this.x` llega con encadenados, incremento 6).

   **`new Clase(...)`**
   - **`NodoNewObjeto(tipo, diamante, args)`** chequea, en orden:
     1. el tipo es válido (reuso `estaBienDeclarado` de etapa 3: la clase existe, no recibe argumento si no es
        genérica, el argumento es válido);
     2. es una **clase**, no interfaz;
     3. si es genérica tiene argumento (sin argumento ni diamante es raw → error);
     4. existe un constructor con esa aridad;
     5. cada argumento conforma con su formal visto con la sustitución (`new Caja<String>(x)`: un parámetro `T` se
        chequea como `String`).

     Tipo resultante: el tipo completo (`Caja<String>`). Es válido como sentencia (`new A1();`) y no es asignable
     (lo que necesita `semIIError03`).
   - Token de error: el nombre de la clase (análogo al nombre del método en llamadas).

   **Diamante (`new Caja<>()`)**
   - `NodoExpresion` suma `chequear(Tipo esperado)`, que por defecto ignora el esperado y llama a `chequear()`. Los
     contextos que conocen el tipo esperado lo pasan: asignación (tipo del izquierdo), `return` (tipo de retorno) y,
     en el incremento 5, argumentos (tipo del formal).
   - El diamante busca, entre los ancestros de la clase creada, el que tiene el nombre del tipo esperado, y si ese
     ancestro usa el parámetro de la clase, infiere el argumento de ahí. Ej.: `class C<T> implements I<T>` →
     `I<String> x = new C<>()` infiere `C<String>`.
   - Sin contexto (`var c = new Caja<>()`) se infiere `Caja<Object>`, como en Java. Límite conocido: sin contexto
     no se infiere desde los argumentos del constructor (`new Caja<>(3)` da error porque no hay boxing).
   - `NodoParentizada` pasa el tipo esperado a su expresión interna.

   **Implementación**
   - `TipoReferencia.instanciarMiembro(tipo)`: ve un tipo de un miembro (o supertipo) desde el receptor, sustituyendo
     el parámetro de la clase por el argumento del receptor. Se reusa en los incrementos 5 y 6.
   - `Unidad.chequearArgumentos(args, receptor, token)`: rutina de argumentos compartida por constructores y, en el
     incremento 5, métodos (pasa el formal como tipo esperado a cada argumento).
   - `ClaseOInterfaz.getTipoPropio()` (`Caja<T>`), usado por `this` y por la inferencia del diamante
     (`TipoReferencia.inferirArgumento`).

   **Casos** (usan parámetros y atributos para fijar el tipo destino, porque un `var` toma el tipo exacto de su
   inicializador)
   - conErrores: superclase → subclase, clases sin relación, interfaz → clase; genéricos invariantes; arreglos
     invariantes; `T` → `Object` en `Caja<T>`; `==` entre clases sin relación; `this` en estático; `new` de
     interfaz, de clase inexistente, raw, con argumento sobre no genérica, con aridad sin constructor y con argumento
     mal tipado; diamante sin contexto asignado luego a `Caja<String>`.
   - sinErrores: subclase → superclase en varios niveles, clase → interfaz y superinterfaces, todo → `Object`
     (incluidos arreglos), `null` → referencias; cadena genérica `Final` → `Base<String>`; `this`, `this == null`;
     `new` con y sin argumentos, constructor por defecto, genéricos con parámetros `T`, `new A1();` como sentencia;
     diamante en asignación, `return`, `var` y a través de una interfaz.
   - Cubre `semIIError02` y `semIIError03`.

- ✅ **5. Llamadas**

   Las llamadas sin receptor y las estáticas dejan de ser placeholder.
   - **`NodoLlamadaMetodo(token, args)`** (`m(a, b)`): busca `(nombre, aridad)` en los métodos de la clase actual
     (incluidos heredados). En un método estático sólo puede seleccionar métodos estáticos. Es llamada (válida como
     sentencia) y su tipo es el retorno del método.
   - **`NodoLlamadaEstatica(tokenClase, token, args)`** (`Clase.m(...)`): la clase tiene que existir y el método
     tiene que ser estático. Incluye las predefinidas (`System.printIln(...)`, `Object.debugPrint(...)`).
   - **Argumentos**: una sola rutina compartida con constructores: misma cantidad que la aridad elegida, cada uno se
     chequea y su tipo tiene que conformar con el formal (sin buscar otra sobrecarga si no conforma).
   - **Resultados void**: como `TipoVoid` no conforma con nada, una llamada void como operando, argumento,
     inicializador, lado derecho o `return` falla sola con los chequeos ya existentes.
   - Token de error: el nombre del método.
   - Casos: método inexistente o con otra aridad, argumentos mal tipados, método de instancia desde estático,
     `Clase.m()` sobre un método de instancia, usos de resultados void. Cubre `semIIError04`.

- ✅ **6. Encadenados**

   `restoReferencia` deja de devolver placeholder: cada eslabón (`NodoEncadenado`) envuelve al anterior como
   receptor, lo chequea primero y trabaja sobre su tipo. Una variable de tipo interfaz también ve los métodos de
   `Object` (como en Java).
   - **`NodoAtributoEncadenado(token)`** (`.x`): el receptor tiene que ser una clase; el tipo del atributo se ve
     con la sustitución del receptor (si `c` es `Caja<String>`, `c.dato` es `String`). Sobre un arreglo sólo existe
     `length` (int, no asignable).
   - **`NodoLlamadaEncadenada(token, args)`** (`.m(...)`): busca `(nombre, aridad)` en el tipo del receptor (clase o
     interfaz, de instancia o estático), con la misma sustitución en formales y retorno. Sobre un arreglo sólo existe
     `toString()`.
   - **`NodoAccesoArreglo(token, indice)`** (`[i]`): el receptor tiene que ser arreglo y el índice int; quita una
     dimensión. Es asignable.
   - Receptores inválidos: primitivos, `null`, void, parámetros de tipo sin sustituir; `Object` no permite indexar
     ni `length`.
   - **Propiedades estructurales**: `esAsignable`/`esLlamada` de una cadena son las de su último eslabón, salvo que
     el primario sea una expresión parentizada (`(o).m();` y `(o).x = 1` se rechazan).
   - Casos: atributos/métodos inexistentes en el receptor, encadenados sobre primitivos o `T`, `length` asignado,
     `crearA().x;` como sentencia, genéricos vistos desde el receptor. Cubre `semIICorrecto04/05`.

- ✅ **7. Arreglos y extras de E2**

   Lo que el parser acepta por logros de la etapa 2 se chequea como en Java.
   - **`NodoNewArreglo(tipoBase, tamaños)`**: tipo base válido en el contexto (no raw), cada tamaño int; el tipo es
     el base con tantas dimensiones como tamaños. No es válida como sentencia.
   - **`NodoInicializadorArreglo`** (`new int[][]{{1}, {2, 3}}`): cada elemento conforma con el tipo base en su nivel;
     un elemento que es a su vez `{...}` se chequea un nivel más abajo.
   - **`NodoPosfijo(op, operando)`** (`x++`): operando int y asignable; el resultado es int, no asignable. Como en
     Java, es válido como sentencia.
   - **`NodoTernario(tokenInterrogacion, cond, siV, siF)`**: condición boolean; si una rama conforma con la otra,
     el tipo es el de la más general (p. ej. `null` y `String` → `String`). Entre referencias sin relación, como
     en Java, es el supertipo común más específico (si hay varios mínimos se elige la clase); entre primitivos
     distintos es error.
   - **Atributos inicializados**: el parser guarda la expresión en el `Atributo` y la TS la chequea en contexto de
     instancia de su clase (sin unidad actual); el tipo tiene que conformar con el del atributo. Como en Java, no
     se puede usar por nombre simple un atributo propio declarado más abajo.
   - Casos: tamaños no int, elementos mal tipados en inicializadores, posfijo sobre no-int o no asignable, ramas
     incompatibles del ternario, inicializadores de atributos mal tipados. Cubre `semIICorrecto03`.

- ✅ **8. Genericidad fina y contexto estático**

   Ajustes de genericidad que no se resuelven sólo con la sustitución.
   - **Origen de los parámetros**: `TipoParametro` guarda la clase/interfaz que lo declara, para que un `T`
     conservado por herencia sin argumento (`Derivada extends Base`) no se confunda con un `T` propio del
     descendiente. La igualdad y la conformidad comparan nombre y origen.
   - **Contexto estático**: el parámetro de tipo de la clase no puede aparecer en el cuerpo de un método estático
     (`new T[10]`, `new Caja<T>()`).
   - **Tipos raw**: la etapa 3 no los rechazaba. Ahora atributos, parámetros, retornos, tipos base de arreglos,
     argumentos genéricos y creaciones usan `estaBienUsado`; sólo la referencia directa de `extends`/`implements`
     puede omitir el argumento. El caso de etapa 3 que aceptaba `Caja<Lista>` pasó a conErrores.
   - **Genéricos anidados** (`Caja<Caja<String>>`): casos que, junto con los raws, cubren Genericidad Avanzada E4.
   - Casos: herencia sin argumento con parámetros homónimos, `T` en cuerpos estáticos, raw types.

- [ ] **9. Cierre**

   Se eliminan los placeholders y se arma la entrega.
   - Confirmar que el parser ya no genera placeholders y borrar `NodoSentenciaPendiente`,
     `NodoExpresionPendiente` y `TipoPendiente` (y los casos especiales que los contemplan en `conformaCon`).
   - `docs/informe-etapa4.md`: cómo compilar y correr, diagrama de clases del AST (`docs/diagrama.puml`) y logros
     (Ternario E4, Atributos Inicializados – Chequeado!, Postfijos – Chequeado, Genericidad Avanzada E4); actualizar
     `docs/check.sh` si aplica.

## Archivos críticos

- `src/main/java/org/example/analizadorsintactico/AnalizadorSintactico.java` (EDT: métodos devuelven nodos)
- `src/main/java/org/example/analizadorsemantico/TablaDeSimbolos.java` (contexto + `chequeoSentencias`)
- `.../analizadorsemantico/{Unidad,Metodo,Constructor,Clase,ClaseOInterfaz}.java` (bloque, unidades propias,
  búsqueda de miembros)
- `.../analizadorsemantico/Tipo*.java` (`conformaCon`, `TipoNull`, `TipoPendiente`)
- nuevo `.../analizadorsemantico/ast/*`
- `src/main/java/org/example/{Main,MainEtapa3}.java`
- `src/test/java/semantico2/**`, `src/test/java/semantico/**`

## Verificación (sólo cuando lo pidas)

- `./gradlew test --rerun-tasks --tests 'semantico2.*'` tras cada incremento: SinErrores siempre verdes, ConErrores
  del incremento verdes.
- `./gradlew test --rerun-tasks` completo para confirmar que etapas 1–3 no se rompen.
- `./gradlew jar && java -jar build/libs/Compilador.jar <caso>` para ver el mensaje de error.
