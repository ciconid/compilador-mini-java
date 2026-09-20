# Casos de prueba: Visibilidad Mejorada E2

## Sin errores (14)

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
13. Clase con todos los miembros mezclados (con y sin visibilidad, en distinto orden)
14. Clase vacía y clase con un solo miembro sin visibilidad

## Con errores (13)

1. Visibilidad duplicada: `public public int a;`
2. Visibilidad contradictoria: `public private int a;`
3. Visibilidad después del tipo: `int public a;`
4. Visibilidad después de `static`: `static public int m() {}`
5. Visibilidad después de `void`: `void public m() {}`
6. Visibilidad después de `idClase` en constructor: `Clase public () {}`
7. Visibilidad sin miembro a continuación: `public }`
8. Visibilidad seguida solo de `;`: `private ;`
9. Visibilidad usada como nombre: `int public;`
10. Palabra similar mal escrita (`publik`, `privat`) como visibilidad
11. `protected` (no soportado): `protected int a;`
12. Visibilidad en variable local dentro de un bloque: `{ public int x; }`
13. Visibilidad en método de interfaz (si el enunciado no lo permite): `interface I { public int m(); }`