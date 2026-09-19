# Instrucciones: casos de prueba para el operador ternario en el analizador sintáctico de MiniJava

## Contexto

Se agregó el operador condicional ternario a la gramática. La regla nueva es:

    <ExpresionParentizada> ::= ( <Expresion> ) <RestoTernario>
    <RestoTernario>        ::= ? <Expresion> : <Expresion> | ε

Consecuencias del diseño:

- La condición **debe** ir entre paréntesis. `c ? a : b` sin paréntesis es un error sintáctico.
- Se agregaron dos tokens nuevos: `?` y `:`.
- El ternario es una expresión, así que puede aparecer en cualquier lugar donde la gramática acepte una `<Expresion>`.
- Es asociativo a derecha.
- Como el ternario "nace" dentro de un operando, `1 + (c) ? a : b` se parsea como `1 + ((c) ? a : b)`. Es distinto de
  Java, pero es el comportamiento esperado acá.

## Tarea

Creá los casos de prueba de abajo usando la sintaxis real de MiniJava y la estructura de los tests existentes (clase,
método, tipos, declaraciones). Cada fragmento es solo la parte relevante. Envolvelo en lo mínimo necesario para que sea
un programa válido (clase, método, variables declaradas con los tipos correctos). Todos los identificadores usados en
los casos sin errores tienen que estar declarados con tipos coherentes (`int`, `boolean`), para que el único motivo de
fallo posible sea el sintáctico.

Organización sugerida:

- Un archivo por caso.
- Nombres : mantener nomenclatura actual

## Casos SIN errores sintácticos

### Básicos

1. `esMayor = (edad >= 18) ? true : false;` (el del enunciado)
2. Ramas con literales enteros: `x = (a > b) ? 1 : 2;`
3. Ramas con variables: `m = (a > b) ? a : b;`
4. Condición que es solo una variable boolean: `x = (flag) ? 1 : 0;`
5. Condición compuesta: `x = (a > 0 && b < 10) ? 1 : 0;`
6. Condición con paréntesis extra: `x = ((a > b)) ? a : b;`

### Ramas con distintas expresiones

7. Aritmética en las ramas: `x = (c) ? a + 1 : b * 2;`
8. Llamadas a métodos: `x = (c) ? f(x) : g(y);`
9. Operadores unarios: `x = (c) ? -a : +b;` y `p = (c) ? !p : q;`
10. Accesos encadenados: `x = (o != null) ? o.campo : 0;` (adaptar a lo que soporte MiniJava)
11. Ramas con paréntesis: `x = (c) ? (a + b) : (a - b);`

### Anidamiento

12. En la rama falsa: `x = (a) ? 1 : (b) ? 2 : 3;`
13. En la rama verdadera: `x = (a) ? (b) ? 1 : 2 : 3;`
14. En la condición: `x = ((a) ? b : c) ? 1 : 2;`

### Contextos donde aparece una expresión

15. Inicialización de variable local (si MiniJava lo permite): `int m = (a > b) ? a : b;`
16. Argumento de llamada: `imprimir((a > b) ? a : b);`
17. `return (n < 0) ? -n : n;`
18. Condición de `if` o `while`: `if ((a) ? b : c) ...` (sintácticamente válido)
19. Como operando: `x = 1 + (c) ? a : b;` y `x = ((c) ? a : b) + 1;`

### Regresión (verificar que no se rompió lo viejo)

20. Parentizadas sin ternario: `x = (a);`, `x = (a + b) * c;`, `x = ((a));`, `x = (a) + (b);`

### Extras

21. Formato con saltos de línea y espacios raros: `x = (c)\n?\na\n:\nb;`
22. Varios ternarios seguidos en un mismo programa, en sentencias distintas.

## Casos CON errores sintácticos

### Faltan piezas

1. Falta `:`: `x = (c) ? a;`
2. Falta `?`: `x = (c) a : b;`
3. Falta rama verdadera: `x = (c) ? : b;`
4. Falta rama falsa: `x = (c) ? a : ;`
5. Faltan ambas ramas: `x = (c) ? : ;`
6. Solo el `?`: `x = (c) ?;`
7. Condición vacía: `x = () ? a : b;`

### Paréntesis

8. Paréntesis sin cerrar: `x = (c ? a : b;`
9. Condición sin paréntesis: `x = c ? a : b;` (error porque la gramática exige paréntesis en la condición)

### Tokens repetidos o mal ubicados

10. `?` doble: `x = (c) ? ? a : b;`
11. `:` doble: `x = (c) ? a : : b;`
12. `:` antes de `?`: `x = (c) : a ? b;`
13. Tres ramas: `x = (c) ? a : b : d;`
14. `:` suelto sin ternario: `x = (c) : a;`

### Contexto

15. Falta `;` al final: `x = (c) ? a : b`
16. Sentencia (declaración) dentro de una rama: `x = (c) ? int y : 2;`
17. Ternario como sentencia suelta sin asignación: `(c) ? a : b;`
    - Solo es error si la gramática de sentencias no acepta una expresión cualquiera como sentencia. Verificar contra la
      gramática real y clasificar el caso como OK o ERROR según corresponda.
