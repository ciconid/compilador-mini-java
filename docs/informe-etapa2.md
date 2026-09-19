# Informe - Etapa 2

**Autor:** Nicolás Cid  
**Materia:** Compiladores e Intérpretes


---

# Nueva Gramática y sus reglas de producción

Los No-Terminales en negrita son nuevos o contienen cambios respecto a la versión original de la gramática provista por
la cátedra.

El no terminal de inicio es <Inicial> y las producciones de la Nueva Gramática de MiniJava son:

| No Terminal                          | Producciones                                                                                                                         |
|--------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| `<Inicial>`                          | `<ListaClases> eof`                                                                                                                  |
| `<ListaClases>`                      | `<Clase> <ListaClases>` \| `<Interfaz> <ListaClases>` \| `ϵ`                                                                         |
| `<Clase>`                            | `class idClase <GenericidadOpcional> <HerenciaOpcional> { <ListaMiembros> }`                                                         |
| `<Interfaz>`                         | `interface idClase  <GenericidadOpcional>  <ExtensionOpcional> { <ListaMetodosInterfaz> }`                                           |
| `<GenericidadOpcional>`              | `< idGen >` \| `ϵ`                                                                                                                   |
| `<HerenciaOpcional>`                 | `extends <TipoReferencia>` \| `implements <TipoReferencia>` \| `ϵ`                                                                   |
| `<ExtensionOpcional>`                | `extends <TipoReferencia>` \| `ϵ`                                                                                                    |
| `<ListaMiembros>`                    | `<Miembro> <ListaMiembros>` \| `ϵ`                                                                                                   |
| `<ListaMetodosInterfaz>`             | `<MetodoInterfaz> <ListaMetodosInterfaz>` \| `ϵ`                                                                                     |
| ***<Miembro\>***                     | `<AtributoOMetodo>` \| `<MetodoStatic>` \| `<MetodoVoid>` \| `<Constructor>`                                                         |
| ***<AtributoOMetodo\>***             | `<Tipo> idMetVar <RestoAtributoOMetodo>`                                                                                             |
| ***<RestoAtributoOMetodo\>***        | `<Atributo>` \| `<Metodo>`                                                                                                           |
| ***<Atributo\>***                    | `;` \| `= <Expresion> ;`                                                                                                             |
| ***<Metodo\>***                      | `<ArgsFormales> <Bloque>`                                                                                                            |
| ***<MetodoStatic\>***                | `static <TipoMetodo> idMetVar <ArgsFormales> <Bloque>`                                                                               |
| ***<MetodoVoid\>***                  | `void idMetVar <ArgsFormales> <Bloque>`                                                                                              |
| `<MetodoInterfaz>`                   | `<TipoMetodo> idMetVar <ArgsFormales> ;`                                                                                             |
| `<Constructor>`                      | `public idClase <ArgsFormales> <Bloque>`                                                                                             |
| `<ModificadorOpcional>`              | `static` \| `ϵ`                                                                                                                      |
| `<TipoMetodo>`                       | `<Tipo>` \| `void`                                                                                                                   |
| `<Tipo>`                             | `<TipoBase> <DimensionesOpcionales>`                                                                                                 |
| `<TipoBase>`                         | `<TipoPrimitivo>` \| `<TipoReferencia>` \| `idGen`                                                                                   |
| `<DimensionesOpcionales>`            | `[] <DimensionesOpcionales>` \| `ϵ`                                                                                                  |
| `<TipoReferencia>`                   | `idClase <TipoGenericoOpcional>`                                                                                                     |
| `<TipoPrimitivo>`                    | `boolean` \| `char` \| `int`                                                                                                         |
| `<TipoGenericoOpcional>`             | `< <InstanciadoOParametrico> >` \| `ϵ`                                                                                               |
| `<InstanciadoOParametrico>`          | `idGen` \| `idClase`                                                                                                                 |
| `<ArgsFormales>`                     | `( <ListaArgsFormalesOpcional> )`                                                                                                    |
| `<ListaArgsFormalesOpcional>`        | `<ListaArgsFormales>` \| `ϵ`                                                                                                         |
| ***<ListaArgsFormales\>***           | `<ArgFormal> <RestoListaArgsFormales>`                                                                                               |
| ***<RestoListaArgsFormales\>***      | `, <ArgFormal> <RestoListaArgsFormales>` \| `ϵ`                                                                                      |
| `<ArgFormal>`                        | `<Tipo> idMetVar`                                                                                                                    |
| `<Bloque>`                           | `{ <ListaSentencias> }`                                                                                                              |
| `<ListaSentencias>`                  | `<Sentencia> <ListaSentencias>` \| `ϵ`                                                                                               |
| ***<Sentencia\>***                   | `;` \| `<AsignacionYLlamada> ;` \| `<VarLocal> ;` \| `<Return> ;` \| `<If>` \| `<While>` \| `<Bloque>`                               |
| ***<AsignacionYLlamada\>***          | `<Expresion>`                                                                                                                        |
| `<VarLocal>`                         | `var idMetVar = <ExpresionCompuesta>`                                                                                                |
| `<Return>`                           | `return <ExpresionOpcional>`                                                                                                         |
| `<ExpresionOpcional>`                | `<Expresion>` \| `ϵ`                                                                                                                 |
| ***<If\>***                          | `<IfBase> <Else>`                                                                                                                    |
| ***<IfBase\>***                      | `if ( <Expresion> ) <Sentencia>`                                                                                                     |
| ***<Else\>***                        | ` else <Sentencia>` \| `ϵ`                                                                                                           |
| `<While>`                            | `while ( <Expresion> ) <Sentencia>`                                                                                                  |
| ***<Expresion\>***                   | `<ExpresionCompuesta> <RestoExpresion>`                                                                                              |
| ***<RestoExpresion\>***              | `<OperadorAsignacion> <ExpresionCompuesta>` \| `ϵ`                                                                                   |
| `<OperadorAsignacion>`               | `=`                                                                                                                                  |
| ***<ExpresionCompuesta\>***          | `<ExpresionBasica> <RestoExpresionCompuesta>`                                                                                        |
| ***<RestoExpresionCompuesta\>***     | `<OperadorBinario> <ExpresionCompuesta>` \| `ϵ`                                                                                      |
| `<OperadorBinario>`                  | `\|\|` \| `&&` \| `==` \| `!=` \| `<` \| `>` \| `<=` \| `>=` \| `+` \| `-` \| `*` \| `/` \| `%`                                      |
| ***<ExpresionBasica\>***             | `<OperadorUnario> <Operando>` \| `<Operando> <OpcionalOperando>`                                                                     |
| ***<OpcionalOperando\>***            | `ϵ` \| `<OperadorUnarioPosfijo>`                                                                                                     |
| ***<OperadorUnarioPosfijo\>***       | `++` \| `--`                                                                                                                         |
| `<OperadorUnario>`                   | `+` \| `−` \| `!`                                                                                                                    |
| `<Operando>`                         | `<Primitivo>` \| `<Referencia>`                                                                                                      |
| `<Primitivo>`                        | `true` \| `false` \| `intLiteral` \| `charLiteral` \| `null`                                                                         |
| ***<Referencia\>***                  | `<Primario> <RestoReferencia>`                                                                                                       |
| ***<RestoReferencia\>***             | `. idMetVar <ArgsActualesOpcionales> <RestoReferencia>` \| `<AccesoArreglo> <RestoReferencia>`  \| `ϵ`                               |
| ***<ArgsActualesOpcionales\>***      | `<ArgsActuales> ` \| `ϵ`                                                                                                             |
| ***<Primario\>***                    | `this `\| `stringLiteral` \| `idMetVar <RestoIdMetVar> `\| `new <RestoNew> `\| `<LlamadaMetodoEstatico>` \| `<ExpresionParentizada>` | 
| ***<RestoIdMetVar\>***               | `ϵ` \| `<ArgsActuales>`                                                                                                              |
| ***<RestoNew\>***                    | `<TipoPrimitivo> <DimensionesConTamanio>` \| `idGen <DimensionesConTamanio>` \| `<TipoReferencia> <RestoTipoReferencia>`             |
| ***<RestoTipoReferencia\>***         | `<DimensionesConTamanio>` \| `<ArgsActuales>`                                                                                        |
| ***<ExpresionParentizada\>***        | `( <Expresion> ) <RestoTernario>`                                                                                                    |
| ***<RestoTernario\>***               | `ϵ` \| `? <Expresion> : <Expresion>`                                                                                                 |
| `<LlamadaMetodoEstatico>`            | `idClase . idMetVar <ArgsActuales>`                                                                                                  |
| ***<DimensionesConTamanio\>***       | `[ <Expresion> ] <RestoDimensionesConTamanio>`                                                                                       |
| ***<RestoDimensionesConTamanio\>***` | `<DimensionesConTamanio>` \| `ϵ`                                                                                                     |
| `<ArgsActuales>`                     | `( <ListaExpsOpcional> )`                                                                                                            |
| `<ListaExpsOpcional>`                | `<ListaExps>` \| `ϵ`                                                                                                                 |
| ***<ListaExps\>***                   | `<Expresion> <RestoListaExps>`                                                                                                       |
| ***<RestoListaExps\>***              | `, <ListaExps>` \| `ϵ`                                                                                                               |
| `<AccesoArreglo>`                    | `[ <Expresion> ]`                                                                                                                    |

---

# Decisiones de diseño, clases utilizadas, etc (agregar descripciones)

# Clases

### Utility

- Primeros
- TokensYLexemas

### Excepciones

- Error Sintáctico

---

# Instrucciones de Compilación y Uso

## Requisitos previos

- JDK 21 instalado
- No requiere tener Gradle instalado previamente (el proyecto incluye el Gradle Wrapper)

## Compilación

Desde la raíz del proyecto, ejecutar:

**Linux / macOS:**
​```
./gradlew jar
​```

**Windows:**
​```
gradlew.bat jar
​```

Esto genera el ejecutable en:
​```
build/libs/Compilador.jar
​```

## Uso

Una vez compilado, el compilador se invoca desde la línea de comandos pasando como parámetro el archivo fuente de
MiniJava. El comando es el mismo en Linux, macOS y Windows, ya que se ejecuta a través de `java`:

​```
java -jar build/libs/Compilador.jar programa1.java
​```

Donde `programa1.java` es el archivo fuente de MiniJava a compilar (se acepta cualquier extensión).





---

# Logros

* Operadores Posfijos E2
* Atributos inicializados E2