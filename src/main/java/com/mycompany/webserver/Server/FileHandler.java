package com.mycompany.webserver.Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

  private static final String BASE_PATH = "src/main/resources/public";

  public static byte[] serveStaticFile(String path) throws IOException {
    if (path.equals("/")) {
      path = "/index.html";
    }

    Path filePath = Paths.get(BASE_PATH + path);

    // Si no encuentra el archivo, buscar en la carpeta de imágenes
    if (!Files.exists(filePath)) {
      filePath = Paths.get(IMAGE_PATH + path);
    }

    if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
      return Files.readAllBytes(filePath);
    } else {
      return null; // Archivo no encontrado
    }
  }

  public static String getContentType(String filePath) {
    if (filePath.endsWith(".html")) return "text/html";
    if (filePath.endsWith(".css")) return "text/css";
    if (filePath.endsWith(".js")) return "application/javascript";
    if (filePath.endsWith(".png")) return "image/png";
    if (
      filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")
    ) return "image/jpeg";
    return "application/octet-stream";
  }
}
