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
- Versión básica, **sin logros E4** por ahora.
- Lo que el parser ya acepta por logros E2 (ternario, posfijos, inicialización de arreglos, diamante, atributos
  inicializados) se **chequea como Java**.
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

- [x] 0. **Infraestructura de tests y mains**
   - Copiar `Main` → `MainEtapa3`; testers de `src/test/java/semantico/**` usan `MainEtapa3`.
   - Arreglar `src/test/java/semantico2/catedra/*` (package `semantico2.catedra`, `import org.example.Main`, paths
     `resources/semantico2/catedra/...`) y crear `semantico2/NC/*` apuntando a `resources/semantico2/NicolasCid/`.
   - `Main` llama `TablaDeSimbolos.ts.chequeoSentencias()` (vacío por ahora). Actualizar CLAUDE.md (etapa 4,
     MainEtapa3, `semantico2`).
   - Verifica: 5 SinErrores de cátedra pasan; etapa 3 sigue igual.

- [ ] 1. **Esqueleto AST + placeholders**
   - Clases abstractas, `NodoBloque`, placeholders y `TipoPendiente`; `Unidad` guarda su `NodoBloque`.
   - `bloque()` devuelve `NodoBloque`; `sentencia()` devuelve `NodoSentenciaPendiente` para todo; se asocia el bloque
     a la unidad en `metodo*()`/`constructor()`.
   - `chequeoSentencias()` recorre unidades propias con contexto seteado.

- [ ] 2. **Sentencias de control y expresiones sin nombres**
   - `NodoVacia`, `NodoBloque` anidado, `NodoIf`, `NodoWhile` (cond `boolean`), `NodoReturn` (void / no void /
     constructor, resultado void prohibido).
   - `NodoLiteral`, `NodoExpBinaria`, `NodoExpUnaria`, `NodoParentizada`; `conformaCon` para primitivos, `null`
     y `String`. El resto de los operandos sigue como `NodoExpresionPendiente`.
   - Casos: `if (4+true)`, `while (1)`, `return 'a'` en método int, `return 1` en void/constructor, etc.

- [ ] 3. **Variables y asignación**
   - `NodoVarLocal` (no repetir parámetro ni local visible, inicializador no `null`/void, var como cuerpo directo de
     if/else/while es error), ámbitos en `NodoBloque`.
   - `NodoAccesoVar` (local → parámetro → atributo; atributo en contexto estático es error), `NodoAsignacion`,
     `NodoSentenciaExpresion` (sólo asignación o llamada; el placeholder cuenta como llamada válida).
   - Cubre `semIIError01`, `semIIError05`, `semIICorrecto01/02`.

- [ ] 4. **Conformidad de referencias, this y creación de objetos**
   - `conformaCon` para `TipoReferencia` (ancestros e interfaces con sustitución, invariancia de argumentos),
     `TipoArreglo` (invariante, conforma con Object), `TipoParametro` (sólo consigo mismo), `TipoNull`.
   - `==`/`!=` entre referencias, `NodoThis` (prohibido en estático), `NodoNewObjeto` (clase no interfaz, sin raw,
     constructor por aridad, args conformes, diamante inferido del tipo esperado).
   - Cubre `semIIError02`, `semIIError03`.

- [ ] 5. **Llamadas**
   - `NodoLlamadaMetodo` (búsqueda `(nombre, aridad)` en la clase actual; en estático sólo estáticos),
     `NodoLlamadaEstatica` (`Clase.m`, debe ser estático), args conformes con formales vistos desde el receptor,
     resultado void no usable como valor.
   - Cubre `semIIError04`.

- [ ] 6. **Encadenados**
   - Atributo / llamada / indexación encadenados sobre el tipo estático del receptor con sustitución; `length` y
     `toString()` de arreglos; receptor `T`, primitivo o `null` no admite punto; restricciones de primario
     parentizado en sentencias y destinos.
   - Cubre `semIICorrecto04/05`.

- [ ] 7. **Arreglos y extras de E2**
   - `NodoNewArreglo` (tamaños int, tipo base válido), `NodoInicializadorArreglo` (elementos conformes, como Java).
   - `NodoPosfijo` (operando int asignable), `NodoTernario` (cond boolean, tipo resultante como Java),
     atributos inicializados (el parser construye la expresión del atributo y la TS la chequea en contexto de
     instancia de su clase). Cubre `semIICorrecto03`.

- [ ] 8. **Genericidad fina y contexto estático**
   - `TipoParametro` conserva la clase que lo declara (herencia sin argumento conserva el parámetro de origen).
   - Parámetro de tipo prohibido en cuerpos estáticos (`new T[10]`, `var x = new Caja<T>()`), tipos raw en cuerpos.
   - Verificar si la etapa 3 ya rechaza raw types en declaraciones (no lo vi en `TipoReferencia.estaBienDeclarado`).

- [ ] 9. **Cierre**
   - Confirmar que el parser ya no genera placeholders y borrar `NodoSentenciaPendiente`,
     `NodoExpresionPendiente` y `TipoPendiente`.
   - `docs/informe-etapa4.md` con diagrama de clases del AST (`docs/diagrama.puml`), cómo compilar/correr, logros
     (ninguno); actualizar `docs/check.sh` si aplica.

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
