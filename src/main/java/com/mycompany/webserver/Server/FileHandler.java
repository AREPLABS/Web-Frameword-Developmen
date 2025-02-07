package com.mycompany.webserver.Server;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase que se encarga de manejar los archivos estáticos del servidor.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 *
 */
public class FileHandler {

  private static final String BASE_PATH = "src/main/resources/public";
  private static final String IMAGE_PATH = "src/main/resources/imagenes";

  public static byte[] serveStaticFile(String path) throws IOException {
    if (path.equals("/")) {
      path = "/index.html";
    } else if (path.startsWith("/imagenes/")) {
      Path filePath = Paths.get(IMAGE_PATH + path);
      if (Files.exists(filePath)) {
        return Files.readAllBytes(filePath);
      }
    }
    Path filePath = Paths.get(BASE_PATH, path);

    if (!Files.exists(filePath)) {
      filePath = Paths.get(IMAGE_PATH, path);
    }

    if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
      return Files.readAllBytes(filePath);
    } else {
      // Puedes devolver un archivo de error 404 o similar
      String errorMessage = "<html><body><h1>404 Not Found</h1></body></html>";
      return errorMessage.getBytes(StandardCharsets.UTF_8); // Devuelve un mensaje de error HTML
    }
  }

  public static String getContentType(String path) {
    if (path.endsWith(".css")) return "text/css";
    if (path.endsWith(".js")) return "application/javascript";
    if (path.endsWith(".html")) return "text/html";
    if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
    if (path.endsWith(".png")) return "image/png";
    if (path.endsWith(".gif")) return "image/gif";
    if (path.endsWith(".ico")) return "image/x-icon"; // Para favicons
    return "text/plain"; // Por defecto
  }
}
