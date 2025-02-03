package com.mycompany.webserver.Server;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class HTTPServer {

  private static Map<String, BiFunction<String, String, String>> servicios = new HashMap<>();

  public static void start(String[] args) throws IOException {
    try {
      ServerSocket serverSocket = new ServerSocket(35000);
      System.out.println("Servidor iniciado en el puerto 35000");
      boolean running = true;
      while (running) {
        try (Socket clientSocket = serverSocket.accept()) {
          System.out.println(
            "Cliente conectado desde " + clientSocket.getInetAddress()
          );
          handleRequest(clientSocket);
        } catch (IOException e) {
          System.err.println("Error en la conexión: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.err.println("Error en el servidor: " + e.getMessage());
    }
  }

  private static void handleRequest(Socket clientSocket) throws IOException {
    BufferedReader in = new BufferedReader(
      new InputStreamReader(clientSocket.getInputStream())
    );
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    String requestLine = in.readLine();
    System.out.println("Solicitud recibida: " + requestLine);
    String[] requestParts = requestLine.split(" ");
    if (requestParts.length < 2) return;

    String method = requestParts[0];
    String path = requestParts[1];

    if (path.startsWith("/api/hello")) {
      String jsonResponse = APIHandler.handleAPIRequest(path);
      sendResponse(out, "200 OK", "application/json", jsonResponse);
    } else {
      if (path.equals("/") || path.equals("/index.html")) {
        path = "/index.html"; // Asegurarse de que la ruta sea correcta
      }
      File staticFile = new File(
        "src/main/java/com/mycompany/webserver/Public" + path
      );
      if (staticFile.exists() && staticFile.isFile()) {
        BufferedReader reader = new BufferedReader(new FileReader(staticFile));
        StringBuilder contentBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          contentBuilder.append(line).append("\n");
        }
        reader.close();
        String fileResponse = contentBuilder.toString();
        String contentType = FileHandler.getContentType(path);
        sendResponse(out, "200 OK", contentType, fileResponse);
      } else {
        sendResponse(
          out,
          "404 Not Found",
          "text/html",
          "<h1>404 Not Found</h1>"
        );
      }
    }
    in.close();
    out.close();
  }

  private static void sendResponse(
    PrintWriter out,
    String status,
    String contentType,
    String content
  ) {
    out.println("HTTP/1.1 " + status);
    out.println("Content-Type: " + contentType);
    out.println("\r\n" + content);
  }
}
