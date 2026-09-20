# Casos de prueba: Visibilidad Mejorada E2

## Sin errores (16)

1. Atributo sin visibilidad: `int a;`
2. Atributo `public`: `public int a;`
3. Atributo `private`: `private int a;`
4. Atributo con inicialización y visibilidad: `private int a = 5;`
5. Método sin visibilidad: `int m() {}`
6. Método `public` y `private` con tipo primitivo y con tipo clase
7. Método static sin visibilidad, `public static` y `private static`
8. Método void sin visibilidad, `public void` y `private void`
9. Constructor sin visibilidad: `Clase() {}`
10. Constructor `public` y `private`: `public Clase() {}`, `private Clase() {}`
11. Constructor con argumentos y visibilidad
12. Atributo/método de tipo clase sin visibilidad: `Clase a;` y `Clase m() {}` (conflicto con constructor `Clase()`)
13. Visibilidad + static + void combinados: `public static void m() {}` y `private static void m() {}`
14. Clase con constructor y método de tipo clase con visibilidad: `public Clase() {}` y `private Clase m() {}` juntos (desambiguación constructor vs. método bajo el nuevo lookahead)
15. Clase con todos los miembros mezclados (con y sin visibilidad, en distinto orden)
16. Clase vacía y clase con un solo miembro sin visibilidad

## Con errores (14)

1. Visibilidad duplicada: `public public int a;`
2. Visibilidad contradictoria: `public private int a;`
3. Visibilidad después del tipo: `int public a;`
4. Visibilidad después de `static`: `static public int m() {}`
5. Visibilidad después de `void`: `void public m() {}`
6. Visibilidad después de `idClase` en constructor: `Clase public () {}`
7. Visibilidad sin miembro a continuación: `public }`
8. Visibilidad seguida solo de `;`: `private ;`
9. Palabra parecida no reservada como visibilidad: `publik int a;` (también `privat`, `protected`)
10. Keyword `private` usado como nombre: `int private;` (reserva del nuevo keyword)
11. Visibilidad en variable local dentro de un bloque: `{ public int x; }`
12. Visibilidad en método de interfaz (el feature no aplica a interfaces): `interface I { public int m(); }`
13. Visibilidad duplicada en constructor: `public public Clase() {}`
14. Visibilidad en argumento formal: `int m(public int x) {}`