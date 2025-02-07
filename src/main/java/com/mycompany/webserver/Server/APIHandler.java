package com.mycompany.webserver.Server;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase que maneja las peticiones a la API.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class APIHandler {

  /**
   * Maneja las peticiones a la API.
   *
   * @param path La ruta de la petición.
   * @return La respuesta a la petición.
   */
  public static String handleAPIRequest(String path) {
    if (path.equals("/api/hello")) {
      return "{ \"message\": \"Hola, bienvenido a la API\" }";
    } else if (path.equals("/api/libros")) {
      return (
        "{ \"libros\": [" +
        "{ \"titulo\": \"El señor de los anillos\", \"autor\": \"J.R.R. Tolkien\", \"anio\": 1954, \"imagen\": \"/imagenes/lotr.jpg\" }," +
        "{ \"titulo\": \"1984\", \"autor\": \"George Orwell\", \"anio\": 1949, \"imagen\": \"/imagenes/1984.jpg\" }," +
        "{ \"titulo\": \"Matar a un ruiseñor\", \"autor\": \"Harper Lee\", \"anio\": 1960, \"imagen\": \"/imagenes/mockingbird.jpg\" }," +
        "{ \"titulo\": \"Orgullo y prejuicio\", \"autor\": \"Jane Austen\", \"anio\": 1813, \"imagen\": \"/imagenes/pride.jpg\" }," +
        "{ \"titulo\": \"Crimen y castigo\", \"autor\": \"Fiódor Dostoyevski\", \"anio\": 1866, \"imagen\": \"/imagenes/crimen.jpg\" }," +
        "{ \"titulo\": \"Las aventuras de Sherlock Holmes\", \"autor\": \"Arthur Conan Doyle\", \"anio\": 1892, \"imagen\": \"/imagenes/sherlock.png\" }" +
        "] }"
      );
    } else {
      return "{ \"message\": \"Ruta no encontrada\" }";
    }
  }
}
