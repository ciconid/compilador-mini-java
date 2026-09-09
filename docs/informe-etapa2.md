## Producciones BNF

    El no terminal de inicio es <Inicial> y las producciones de la Nueva Gramática de MiniJava son:

| No Terminal | Producciones |
|---|---|
| `<Inicial>` | `<ListaClases> eof` |
| `<ListaClases>` | `<Clase> <ListaClases>` \| `<Interfaz> <ListaClases>` \| `ϵ` |
| `<Clase>` | `class idClase <GenericidadOpcional> <HerenciaOpcional> { <ListaMiembros> }` |
| `<Interfaz>` | `interface idClase < <GenericidadOpcional> > <ExtensionOpcional> { <ListaMetodosInterfaz> }` |
| `<GenericidadOpcional>` | `< idGen >` \| `ϵ` |
| `<HerenciaOpcional>` | `extends <TipoReferencia>` \| `implements <TipoReferencia>` \| `ϵ` |
| `<ExtensionOpcional>` | `extends <TipoReferencia>` \| `ϵ` |
| `<ListaMiembros>` | `<Miembro> <ListaMiembros>` \| `ϵ` |
| `<ListaMetodosInterfaz>` | `<MetodoInterfaz> <ListaMetodosInterfaz>` \| `ϵ` |
| `<Miembro>` | `<Tipo> idMetVar <RestoMiembro>` \| `static <TipoMetodo> idMetVar <ArgsFormales> <Bloque>` \| `void idMetVar <ArgsFormales> <Bloque>` \| `public idClase <ArgsFormales> <Bloque>` |
| `<RestoMiembro>` | `;` \| `<ArgsFormales> <Bloque>` |
| `<Atributo>` | `<Tipo> idMetVar ;` |
| `<Metodo>` | `<ModificadorOpcional> <TipoMetodo> idMetVar <ArgsFormales> <Bloque>` |
| `<MetodoInterfaz>` | `<TipoMetodo> idMetVar <ArgsFormales> ;` |
| `<Constructor>` | `public idClase <ArgsFormales> <Bloque>` |
| `<ModificadorOpcional>` | `static` \| `ϵ` |
| `<TipoMetodo>` | `<Tipo>` \| `void` |
| `<Tipo>` | `<TipoBase> <DimensionesOpcionales>` |
| `<TipoBase>` | `<TipoPrimitivo>` \| `<TipoReferencia>` \| `idGen` |
| `<DimensionesOpcionales>` | `[] <DimensionesOpcionales>` \| `ϵ` |
| `<TipoReferencia>` | `idClase <TipoGenericoOpcional>` |
| `<TipoPrimitivo>` | `boolean` \| `char` \| `int` |
| `<TipoGenericoOpcional>` | `< <InstanciadoOParametrico> >` \| `ϵ` |
| `<InstanciadoOParametrico>` | `idGen` \| `idClase` |
| `<ArgsFormales>` | `( <ListaArgsFormalesOpcional> )` |
| `<ListaArgsFormalesOpcional>` | `<ListaArgsFormales>` \| `ϵ` |
| `<ListaArgsFormales>` | `<ArgFormal> <RestoListaArgsFormales>` |
| `<RestoListaArgsFormales>` | `, <ArgFormal> <RestoListaArgsFormales>` \| `ϵ` |
| `<ArgFormal>` | `<Tipo> idMetVar` |
| `<Bloque>` | `{ <ListaSentencias> }` |
| `<ListaSentencias>` | `<Sentencia> <ListaSentencias>` \| `ϵ` |
| `<Sentencia>` | `;` \| `<AsignacionYLlamada> ;` \| `<VarLocal> ;` \| `<Return> ;` \| `<If>` \| `<While>` \| `<Bloque>` |
| `<AsignacionYLlamada>` | `<Expresion>` |
| `<VarLocal>` | `var idMetVar = <ExpresionCompuesta>` |
| `<Return>` | `return <ExpresionOpcional>` |
| `<ExpresionOpcional>` | `<Expresion>` \| `ϵ` |
| `<If>` | `if ( <Expresion> ) <Sentencia>` \| `if ( <Expresion> ) <Sentencia> else <Sentencia>` |
| `<While>` | `while ( <Expresion> ) <Sentencia>` |
| `<Expresion>` | `<ExpresionCompuesta> <OperadorAsignacion> <ExpresionCompuesta>` \| `<ExpresionCompuesta>` |
| `<OperadorAsignacion>` | `=` |
| `<ExpresionCompuesta>` | `<ExpresionBasica>` \| `<ExpresionBasica> <OperadorBinario> <ExpresionCompuesta>` |
| `<OperadorBinario>` | `\|\|` \| `&&` \| `==` \| `!=` \| `<` \| `>` \| `<=` \| `>=` \| `+` \| `-` \| `*` \| `/` \| `%` |
| `<ExpresionBasica>` | `<OperadorUnario> <Operando>` \| `<Operando>` |
| `<OperadorUnario>` | `+` \| `−` \| `!` |
| `<Operando>` | `<Primitivo>` \| `<Referencia>` |
| `<Primitivo>` | `true` \| `false` \| `intLiteral` \| `charLiteral` \| `null` |
| `<Referencia>` | `<Primario> <RestoReferencia>` |
| `<RestoReferencia>` | `. idMetVar <RestoReferenciaEncadenadas>` \| `<AccesoArreglo> <RestoReferencia>` \| `ϵ` |
| `<RestoReferenciaEncadenadas>` | `<ArgsActuales> <RestoReferencia>` \| `<RestoReferencia>` |
| `<Primario>` | `this `\| `stringLiteral` \| `idMetVar <RestoIdMetVar> `\| `new <RestoNew> `\| `<LlamadaMetodoEstatico>` \| `<ExpresionParentizada>` | 
| `<RestoIdMetVar>` | `ϵ` \| `<ArgsActuales>` |
| `<RestoNew>` | `<TipoPrimitivo> <DimensionesConTamanio>` \| `idGen <DimensionesConTamanio>` \| `<TipoReferencia> <RestoTipoReferencia>` |
| `<RestoTipoReferencia>` | `<DimensionesConTamanio>` \| `<ArgsActuales>` |
| `<ExpresionParentizada>` | `( <Expresion> )` |
| `<LlamadaMetodoEstatico>` | `idClase . idMetVar <ArgsActuales>` |
| `<DimensionesConTamanio>` | `[ <Expresion> ] <DimensionesConTamanio>` \| `[ <Expresion> ]` |
| `<ArgsActuales>` | `( <ListaExpsOpcional> )` |
| `<ListaExpsOpcional>` | `<ListaExps>` \| `ϵ` |
| `<ListaExps>` | `<Expresion> , <ListaExps>` \| `<Expresion>` |
| `<AccesoArreglo>` | `[ <Expresion> ]` |
