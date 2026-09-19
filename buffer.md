# Casos de prueba: arreglos inicializados (análisis sintáctico)

Total: **36 tests** (16 sinErrores + 20 conErrores)

## sinErrores (16)

1. **Vacío:** `new int[] {}`
2. **Un elemento:** `new int[] {5}`
3. **Varios literales:** `new int[] {1, 2, 3}`
4. **Otros tipos primitivos:** `boolean`, `char`, con sus literales
5. **Tipo clase:** `new String[] {"a", "b"}` y `new Persona[] {new Persona(), null}`
6. **Elementos con operadores binarios:** `{x + 1, y * z - 2}`
7. **Elementos con operadores unarios y paréntesis:** `{-x, !b, (a + b) * c}`
8. **Elementos con llamadas y accesos encadenados:** `{f(3), obj.m().x}`
9. **Multidimensional con `new` anidados:** `new int[][] { new int[] {1}, new int[] {2, 3} }`
10. **Multidimensional con filas vacías:** `new int[][] { new int[] {}, new int[] {} }`
11. **En declaración de atributo de clase:** `int[] a = new int[] {1, 2};` dentro del cuerpo de la clase
    (la gramática no admite declaraciones locales tipadas: las locales son solo `var`)
12. **Con `var` local:** `var a = new int[] {1, 2};`
13. **En asignación posterior:** `a = new int[] {1, 2};`
14. **Como argumento de llamada o en `return`:** `f(new int[] {1, 2})`, `return new int[] {1};`
15. **Como sentencia por sí solo:** `new int[] {1, 2};`
16. **Varios en un mismo método:** varias inicializaciones seguidas, incluso dentro de `if` o `while`

Casos opcionales, según cómo esté definida la gramática:

- Acceso inmediato: `new int[] {1, 2}[0]`, `new int[] {1, 2}.length`
- Elementos que sean expresiones de asignación, p. ej. `new int[] {a = 5}`. Nota: la asignación
  anidada ya es válida según la gramática actual (el elemento es una `<Expresion>`), por lo que
  rechazarla implicaría cambiar la gramática, no agregar un test.
- Elementos con ternario o posfijo: `new int[] {c ? 1 : 2}`, `new int[] {a++}`

## conErrores (20)

1. **Falta `}` de cierre:** `new int[] {1, 2;`
2. **Falta `{` de apertura:** `new int[] 1, 2};`
3. **Forma abreviada en declaración de atributo:** `int[] a = {1, 2};` dentro del cuerpo de la clase
4. **Forma abreviada en asignación:** `a = {1, 2};`
5. **Coma final:** `{1, 2,}` (solo si el lenguaje no la admite)
6. **Coma inicial:** `{, 1, 2}`
7. **Comas consecutivas:** `{1,, 2}`
8. **Falta coma entre elementos:** `{1 2}`
9. **Expresión incompleta como elemento:** `{1 +, 2}`
10. **Tamaño e inicializador juntos:** `new int[3] {1, 2, 3}`
11. **Falta `]`:** `new int[ {1, 2}`
12. **Falta el tipo:** `new [] {1, 2}`
13. **Faltan los corchetes:** `new int {1, 2}`
14. **Inicializador anidado sin `new`:** `new int[][] { {1, 2}, {3} }`
15. **Delimitadores equivocados:** `new int[] (1, 2)` y `new int[] [1, 2]`
16. **Falta `;` al final de la sentencia:** `a = new int[] {1, 2}`
17. **Inicializador sin cerrar hasta EOF:** `new int[] {1, 2` seguido del fin de archivo, sin `}` ni `;`.
    El error se detecta en el token EOF: `[Error:|n]`
18. **Basura después del inicializador:** `new int[] {1} new int[] {2};` (segundo inicializador sin
    operador binario que lo conecte)
19. **Falta coma entre filas multidimensionales:** `new int[][] { new int[] {1} new int[] {2} }`
20. **Corchetes vacíos sin inicializador:** `new int[]` sin tamaño ni `{`. El `[]` vacío debe exigir
    el inicializador; si va seguido de cualquier otra cosa, es error.