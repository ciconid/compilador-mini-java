# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

MiniJava compiler in Java 21 for a university compilers course, built in stages ("etapas"): 1 = lexical, 2 = syntactic, 3 = semantic (in progress on branch `etapa-3`). Code, comments, docs, and commit messages are in Spanish. Language spec and per-stage requirements ("Pautas") are PDFs in `docs/`; stage reports are `docs/informe-etapaN.md`.

## Rules (from AGENTS.md)

- Read the relevant source code before answering questions or making changes.
- Be concise.
- Ask for clarification instead of making assumptions.
- Check `docs/` for specifications and reference material.
- Don't ask whether to create a plan; you'll be prompted when one is needed.
- Don't compile or run tests unless the user explicitly asks.
- Avoid writing code comments unless they're truly necessary.

## Commands

```bash
./gradlew build                     # compile + run all tests
./gradlew test                      # all tests
./gradlew test --tests 'sintactico.TesterDeCasosConErrores'          # one tester class
./gradlew test --tests 'sintactico.TesterDeCasosConErrores.test1[*nombreArchivo*]'  # one case (parameterized)
./gradlew jar                       # -> build/libs/Compilador.jar (Main-Class org.example.Main)
java -jar build/libs/Compilador.jar <archivo.java>
```

## Architecture

Pipeline (packages under `src/main/java/org/example/`):
`sourcemanager` (char-by-char reader, `END_OF_FILE = (char) 26`) → `analizadorlexico.AnalizadorLexico.proximoToken()` returns `Token` records → `analizadorsintactico.AnalizadorSintactico`, a recursive-descent parser that parses the whole file **in its constructor** (`inicial()`), using FIRST sets from `Primeros` and token names from `TokensYLexemas` → `analizadorsemantico` (stage 3: symbol table `TablaDeSimbolos`, entity hierarchy `EntidadDeclarable` → `ClaseOInterfaz`/`Metodo`/`Constructor`/`Parametro`, and the `Tipo` hierarchy; still mostly stubs).

Errors are unchecked exceptions (`ErrorLexico`, `ErrorSintactico`, `ErrorSemantico`). Compilation stops at the first error.

Entry points: there is one `main` class per stage. `MainEtapa1` (lexer only), `MainEtapa2` (lexer + parser) and `Main` (current stage, used by the jar) are kept separately because each stage's testers bind to its own main class.

## Output contract and tests

The course testers call `main(new String[]{path})` directly and assert on stdout, so the output format is part of the spec:
- On success the program prints `[SinErrores]`.
- On error it prints `[Error:<lexema>|<linea>]`, which must match the case file's first line minus its first 3 chars (e.g. `///[Error:A1|7]`).

Testers (`src/test/java/{lexico,sintactico,semantico}/...`) are JUnit 4 `Parameterized` (run via the vintage engine). Each one loads every file in a hard-coded `resources/...` directory, relative to the project root. Test-case directories:
- `resources/<etapa>/{sinErrores,conErrores}`: the course staff's cases ("cátedra").
- `resources/<etapa>/<NombreCompañero>/{sinErrores,conErrores}`: classmates' cases (SS, TB, NC subpackages).
- `resources/semantico/catedra/`: the course staff's cases for stage 3.

`resources/lexico/SantiSalamanca/ignorados/` holds cases that are intentionally not run. Each tester's `init` field type selects which `Main*` class it exercises.
