
# 🌐 Desarrollo de Framework Web
---

## 🚀 Descripción del Proyecto

Este proyecto tiene como objetivo mejorar un servidor web existente, que actualmente soporta archivos HTML, JavaScript, CSS e imágenes, convirtiéndolo en un framework web completamente funcional. Este nuevo framework permitirá el desarrollo de aplicaciones web con servicios REST en el backend. 

El framework proporcionará herramientas para que los desarrolladores puedan:
- 💡 Definir servicios REST utilizando funciones lambda.
- 🔄 Gestionar los valores de las consultas dentro de las peticiones.
- 📂 Especificar la ubicación de los archivos estáticos.

---

## 🛠️ Características y Alcance del Proyecto

### 1️⃣ **Método GET para Servicios REST**  
Implementar un método `get()` que permita a los desarrolladores definir servicios REST utilizando funciones lambda.  
**Ejemplo de uso:**
```java
get("/hello", (req, res) -> "¡Hola mundo!");
```
Esta característica permite definir rutas de manera simple y clara, asignando URL a expresiones lambda específicas que gestionan las peticiones y respuestas. 🚀

---

### 2️⃣ **Mecanismo de Extracción de Parámetros de Consulta**  
Desarrollar un mecanismo para extraer parámetros de consulta de las peticiones entrantes y hacerlos accesibles dentro de los servicios REST.  
**Ejemplo de uso:**
```java
get("/hello", (req, res) -> "Hola " + req.getValues("name"));
```
Este mecanismo facilita la creación de servicios REST dinámicos, permitiendo a los desarrolladores acceder y utilizar fácilmente los parámetros de consulta dentro de las implementaciones. 🌟

---

### 3️⃣ **Especificación de la Ubicación de Archivos Estáticos**  
Introducir el método `staticfiles()` para permitir a los desarrolladores definir la carpeta donde se encuentran los archivos estáticos.  
**Ejemplo de uso:**
```java
staticfiles("webroot/public");
```
El servidor buscará los archivos estáticos en el directorio especificado, como `target/classes/webroot/public`. Esto facilita la organización y gestión de los recursos estáticos de la aplicación. 📁

---

### 4️⃣ **Tareas Adicionales**  
Crear un ejemplo que demuestre cómo se desarrollarían aplicaciones en el servidor.  
**Ejemplo de código para un desarrollador web:**
```java
public static void main(String[] args) {
    staticfiles("/webroot");
    get("/hello", (req, resp) -> "¡Hola " + req.getValues("name"));
    get("/pi", (req, resp) -> {
        return String.valueOf(Math.PI); 
    });
}
```
---


## 🔧 Instrucciones de Configuración

### 1️⃣ **Clonar el Repositorio:**
```bash
git clone https://github.com/tuusuario/web-framework-development.git
cd web-framework-development
```

### 2️⃣ **Instalar Dependencias:**
Asegúrate de tener [Java 21](https://openjdk.java.net/projects/jdk/21/) instalado.

### 3️⃣ **Construir el Proyecto:**
Utiliza Maven para compilar el proyecto:
```bash
mvn clean install
```

### 4️⃣ **Ejecutar el Servidor:**
Inicia el servidor ejecutando:
```bash
mvn exec:java 
```

¡El servidor estará ejecutándose localmente! Ahora puedes probarlo visitando `http://localhost:8080` en tu navegador. 🌐

---

## 💡 Uso

### 1️⃣ **Servir Archivos Estáticos:**
Coloca tus archivos estáticos (HTML, CSS, JS, imágenes) en el directorio `public`. El servidor los servirá automáticamente en sus respectivas rutas. 🖼️

### 2️⃣ **Crear Servicios REST:**
Define tus servicios REST utilizando funciones lambda dentro de la clase `APIHandler`. Ejemplo:
```java
public static String handleAPIRequest(String path) {
    if (path.equals("/api/hello")) {
        return "{ \"message\": \"Hola, bienvenido a la API\" }";
    } else {
        return "{ \"message\": \"Ruta no encontrada\" }";
    }
}
```

### 3️⃣ **Gestionar Consultas:**
Puedes gestionar los parámetros de consulta dentro de tus peticiones para crear respuestas dinámicas. ⚡

### 4️⃣ **Modificar Rutas de Archivos Estáticos:**
La ubicación de los archivos estáticos como imágenes se puede configurar modificando el directorio `resources/imagenes`. 🖥️

---

### Flujo de Comunicación 🔄

1. **Petición del Cliente:** El cliente envía una petición HTTP al servidor.
2. **Manejo de la Petición:** El servidor verifica si la petición corresponde a un archivo estático o a una ruta de la API.
3. **Generación de la Respuesta:** El servidor procesa la petición y genera una respuesta adecuada con los datos requeridos.
4. **Respuesta al Cliente:** El servidor envía la respuesta generada al cliente.

---

## ⚙️ **Tecnologías Utilizadas**

Este proyecto está desarrollado con las siguientes tecnologías y herramientas:

- **Java** ☕️: Lenguaje de programación principal.
- **HTTP Server** 🚀: Servidor HTTP personalizado.
- **Lambdas** 🦸: Usadas en diversas clases para manejar las peticiones y respuestas de manera más funcional.
- **Maven** 📦: Herramienta de construcción para gestionar dependencias y empaquetado.
- **JUnit** 🧪: Framework de pruebas unitarias.
- **CSS** 🎨: Estilos para la parte frontend.
- **JavaScript** 💻: Lógica de interacción en el navegador.

---

## 🚀 **Cómo Ejecutar el Proyecto**

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tuusuario/tu-repo.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd tu-repo
    ```

3. Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```

4. Ejecuta el servidor:
    ```bash
    mvn exec:java
    ```

5. Abre tu navegador y accede a `http://localhost:8080` para ver la página web y realizar peticiones a la API.
---
## 📜 **Rutas de la API**

### 1. **`/api/hello`** 🌟
   - **Método**: GET
   - **Descripción**: Retorna un mensaje de bienvenida.
   - **Respuesta**:
     ```json
     { "message": "Hola, bienvenido a la API" }
     ```

### 2. **`/api/libros`** 📚
   - **Método**: GET
   - **Descripción**: Devuelve una lista de libros con sus detalles.
   - **Respuesta**:
     ```json
     {
       "libros": [
         {
           "titulo": "El señor de los anillos",
           "autor": "J.R.R. Tolkien",
           "anio": 1954,
           "imagen": "https://images.unsplash.com/photo-1506466010722-395aa2bef877"
         },
         {
           "titulo": "1984",
           "autor": "George Orwell",
           "anio": 1949,
           "imagen": "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c"
         },
         {
           "titulo": "Matar a un ruiseñor",
           "autor": "Harper Lee",
           "anio": 1960,
           "imagen": "https://images.unsplash.com/photo-1589829085413-56de8ae18c73"
         }
       ]
     }
     ```
### 2. **`/pi`** 📚
- **Método**: GET
   - **Descripción**: Retorna el numero pi
   - **Respuesta**:
     ```
     3,141592654
     ```
---
### 📝Estado del arte de
---
### 📝 **Uso de Funciones Lambda en Servicios REST**

Una de las características más poderosas de este framework es la capacidad de definir servicios REST utilizando funciones **lambda**. Las lambdas permiten que los desarrolladores escriban código de manera más compacta y legible, sin la necesidad de crear clases adicionales para manejar cada ruta del servidor. Esto facilita la creación de servicios REST de una manera concisa y expresiva.

#### 📡 **Método GET para Servicios REST con Lambda**

El método `get()` permite a los desarrolladores definir rutas de servicios REST utilizando expresiones lambda. Esto simplifica la implementación de servicios REST, ya que no necesitas crear una clase o método separado para cada ruta, sino que puedes definirlo directamente en el punto donde configures las rutas del servidor.

**Ejemplo de uso:**

```java
get("/hello", (req, res) -> "¡Hola mundo!");
```

En este ejemplo, cuando se realiza una solicitud `GET` a la ruta `/hello`, el servidor responderá con la cadena `"¡Hola mundo!"`. La lambda `(req, res) -> "¡Hola mundo!"` maneja la solicitud y respuesta de manera directa, sin necesidad de clases adicionales.

#### 🌍 **Definiendo Rutas REST con Parámetros de Consulta utilizando Lambda**

Además de las rutas básicas, puedes utilizar parámetros de consulta dentro de las lambdas para crear servicios REST dinámicos. Por ejemplo, si necesitas un servicio que salude a un usuario cuyo nombre se pasa como parámetro en la consulta, puedes hacerlo de la siguiente manera:

**Ejemplo de uso:**

```java
get("/hello", (req, res) -> "Hola " + req.getValues("name"));
```

Aquí, el valor de `"name"` se obtiene de la consulta de la URL, y el servidor responderá con un saludo personalizado. Si haces una solicitud a:

```
http://localhost:8080/hello?name=Pedro
```

El servidor responderá con:

```
Hola Pedro
```

#### 💡 **Ventajas del Uso de Lambda en Servicios REST**

- **Código más limpio y sencillo**: No necesitas clases y métodos extra para definir simples rutas de REST.
- **Mayor legibilidad**: Las funciones lambda permiten ver de un vistazo lo que hace cada ruta sin tener que leer código adicional.
- **Desarrollo ágil**: Puedes definir rápidamente nuevas rutas REST sin crear mucha infraestructura adicional, acelerando el desarrollo de tu aplicación.

### 🧑‍💻 **Resumen de la Sintaxis de Lambda**

Cada ruta REST es definida con un método `get()` o `post()`, donde el primer parámetro es la ruta de la URL, y el segundo parámetro es la lambda que maneja la solicitud y genera la respuesta.

```java
get("/ruta", (req, res) -> "Respuesta a la ruta");
```

- **`req`**: El objeto de la solicitud que contiene la información de la petición (por ejemplo, parámetros de consulta, cuerpo, etc.).
- **`res`**: El objeto de respuesta que permite configurar la respuesta que el servidor enviará al cliente.

---

Con esta sección puedes explicar el uso de funciones lambda en tu framework de manera clara y didáctica, resaltando sus beneficios y proporcionando ejemplos prácticos para los desarrolladores. ¡Espero que te sea útil! 😄
---
## 🧑‍💻 Contribuir

¡Te invitamos a contribuir! Si encuentras algún problema o deseas añadir nuevas características, no dudes en hacer un fork del repositorio y enviar un pull request. 🌟

### Pasos para Contribuir:
1. Haz un fork del repositorio.
2. Crea una nueva rama: `git checkout -b nombre-de-la-caracteristica`
3. Haz commit de tus cambios: `git commit -m 'Añadir nueva característica'`
4. Haz push a tu rama: `git push origin nombre-de-la-caracteristica`
5. Crea un pull request con una descripción de los cambios.

---
## 📬 **Licencia**

Este proyecto está bajo la **Licencia MIT**. Puedes ver los detalles de la licencia en el archivo `SECURITY`.

---

¡Espero que esta estructura sea lo que necesitas! 🎉
