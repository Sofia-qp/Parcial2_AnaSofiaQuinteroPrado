# Comprensión del diseño — Enunciado A
**Nombre:** Ana Sofia Quintero Prado
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Este documento evidencia que entendiste el
contrato de diseño **antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Sensor` es una clase abstracta y no una clase concreta? Menciona
qué método obliga a cada subclase a implementar y qué gana el sistema con eso.

> Tu respuesta: Sensor es una clase abstracta porque representa las caracteísticas 
> comunes de todos los sensores, pero como tal no tiene sentido crear un sensor genérico
> por lo que obliga a las subclases a generar métodos como generarLectura() y fueraDeRango(),
> aplicando polimorfismo.

---

### 2. Composición vs. agregación
Explica con tus palabras la diferencia entre `NodoIoT ◆— Sensor` (composición)
y `CentroMonitoreo ◇— NodoIoT` (agregación). Da un ejemplo de qué pasaría con
los sensores si se elimina el nodo, y qué pasaría con los nodos si se elimina
el centro.

> Tu respuesta: En la composición NodoIoT ◆— Sensor, los sensores pertenecen
> al nodo y dependen de su existencia, si el nodo se elimina los sensores también 
> desaparecen,en la agregación CentroMonitoreo ◇— NodoIoT`, el centro agrupa nodos
> existentes pero,si el centro se elimina, los nodos pueden seguir funcionando.

---

### 3. Asociación
En `TecnicoMantenimiento — NodoIoT`, ¿quién es dueño de quién? ¿Por qué se
modela como N:M y no como composición?

> Tu respuesta: En la asociación TecnicoMantenimiento — NodoIoT, ninguno es dueño 
> de otro ya que un tecnico puede ser asignado a varios nodos, o un nodo puede ser
> reviado por varios técnicos, por eso la relación es de muchos a muchos N:M, no es
> composición porque ambas clases pueden existir independientemente.

---

### 4. Dependencia
¿Por qué `Lectura` **depende** de `ValidadorLectura` en lugar de **tenerlo**
como atributo? ¿Qué diferencia práctica hay entre pasar un `ValidadorLectura`
como parámetro versus guardarlo en un campo?

> Tu respuesta: Lectura depende de `ValidadorLectura` porque solo la utiliza para verifivar
> si una lectura es valida en un momento específico, el validador se recibe como parámetro
> pero no alcanza a ser atributo, eso reduce el acoplamiento y mantiene una relación temporal
> entre ambas clases.

---

### 5. Listas
En este proyecto se usan dos estructuras de datos distintas:
- `int[] ultimasLecturas` en `Sensor`
- `ArrayList<Sensor>` en `NodoIoT`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
ventaja tiene el `int[]` con buffer circular frente a un `ArrayList` para el
historial de lecturas?

> Tu respuesta: `int[] ultimasLecturas` se utilizo porque el historial de lecturas
> tiene una capacidad fija y funciona mediante un buffer circular, permitiendo reutilizar
> posiciones sin tener mayor consumo de memoria, ArrayList<Sensor>` se usa  en `NodoIoT`
> porque la cantidad de sensores puede variar dinámicamente.
> 