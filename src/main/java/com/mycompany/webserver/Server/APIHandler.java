package com.mycompany.webserver.Server;

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
        "{ \"titulo\": \"El señor de los anillos\", \"autor\": \"J.R.R. Tolkien\", \"anio\": 1954, \"imagen\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIr1UuugXCIim35lyIBMaHQXLXtZqUQnnxDg&s\" }," +
        "{ \"titulo\": \"1984\", \"autor\": \"George Orwell\", \"anio\": 1949, \"imagen\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfD0yb_KpMaWW5j-rBLbtPSBv0NGqXeD6DRw&s\" }," +
        "{ \"titulo\": \"Matar a un ruiseñor\", \"autor\": \"Harper Lee\", \"anio\": 1960, \"imagen\": \"https://b2clibrerianacional.vtexassets.com/arquivos/ids/261910/Portada.jpg?v=638644955855100000\" }," +
        "{ \"titulo\": \"Orgullo y prejuicio\", \"autor\": \"Jane Austen\", \"anio\": 1813, \"imagen\": \"https://images.cdn3.buscalibre.com/fit-in/360x360/46/6b/466b0b47e932561b186c56358acbe55e.jpg\" }," +
        "{ \"titulo\": \"Crimen y castigo\", \"autor\": \"Fiódor Dostoyevski\", \"anio\": 1866, \"imagen\": \"https://images.cdn1.buscalibre.com/fit-in/360x360/ea/1f/ea1fc691874fa49ce341d876a981e2c1.jpg\" }," +
        "{ \"titulo\": \"Las aventuras de Sherlock Holmes\", \"autor\": \"Arthur Conan Doyle\", \"anio\": 1892, \"imagen\": \"https://www.planetadelibros.com/usuaris/libros/fotos/347/original/portada_las-aventuras-de-sherlock-holmes_arthur-conan-doyle_202203181004.jpg\" }" +
        "] }"
      );
    } else {
      return "{ \"message\": \"Ruta no encontrada\" }";
    }
  }
}
