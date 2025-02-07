package com.mycompany.webserver.Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que representa el servidor HTTP.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class HTTPServer {

  public static List<Route> routes = new ArrayList<>();
  public static String staticFilesPath = "src/main/resources/public";

  /**
   * Método principal que inicia el servidor.
   *
   * @param args Los argumentos de la línea de comandos.
   * @throws IOException Si ocurre un error de entrada/salida.
   */
  public static void main(String[] args) throws IOException {
    staticfiles("/public");
    get(
      "/hello",
      (req, res) -> {
        String name = req.getQueryParam("name");
        if (name == null) {
          name = "World";
        }
        return "Hello " + name;
      }
    );
    get("/pi", (req, res) -> String.valueOf(Math.PI));

    ServerSocket serverSocket = new ServerSocket(8080);
    while (true) {
      Socket clientSocket = serverSocket.accept();
      handleClientRequest(clientSocket);
    }
  }

  /**
   * Configura la ruta de los archivos estáticos.
   *
   * @param path La ruta de los archivos estáticos.
   */
  public static void staticfiles(String path) {
    staticFilesPath = "public" + path;
  }

  /**
   * Registra una ruta y su manejador.
   * @param path
   * @param handler
   */
  public static void get(String path, RouteHandler handler) {
    routes.add(new Route(path, handler));
  }

  /**
   * Maneja una solicitud de cliente.
   *
   * @param clientSocket El socket del cliente.
   * @throws IOException Si ocurre un error de entrada/salida.
   */
  public static void handleClientRequest(Socket clientSocket)
    throws IOException {
    BufferedReader in = new BufferedReader(
      new InputStreamReader(clientSocket.getInputStream())
    );
    BufferedWriter out = new BufferedWriter(
      new OutputStreamWriter(clientSocket.getOutputStream())
    );

    String requestLine = in.readLine();
    if (requestLine == null) {
      clientSocket.close();
      return;
    }

    System.out.println("Solicitud recibida: " + requestLine);
    String[] requestParts = requestLine.split(" ");
    if (requestParts.length < 2) {
      clientSocket.close();
      return;
    }

    String method = requestParts[0];
    String path = requestParts[1];

    if (method.equals("GET")) {
      handleGetRequest(path, out);
    } else {
      sendResponse(
        out,
        "405 Method Not Allowed",
        "text/plain",
        "Método no permitido"
      );
    }

    clientSocket.close();
  }

  private static void handleGetRequest(String path, BufferedWriter out)
    throws IOException {
    Request req = new Request(path);
    Response res = new Response();
    for (Route route : routes) {
      if (route.getPath().equals(req.getPath())) {
        String responseBody = route.getHandler().handle(req, res);
        sendResponse(
          out,
          res.getStatusCode() + " OK",
          res.getContentType(),
          responseBody
        );
        return;
      }
    }

    if (req.getPath().equals("/")) {
      req = new Request("/index.html");
    }

    if (req.getPath().startsWith("/api")) {
      String jsonResponse = APIHandler.handleAPIRequest(req.getPath());
      sendResponse(out, "200 OK", "application/json", jsonResponse);
      return;
    }

    byte[] fileContent = FileHandler.serveStaticFile(req.getPath());
    if (fileContent != null) {
      sendResponse(
        out,
        "200 OK",
        FileHandler.getContentType(req.getPath()),
        new String(fileContent)
      );
    } else {
      sendResponse(out, "404 Not Found", "text/plain", "Archivo no encontrado");
    }
  }

  private static void sendResponse(
    BufferedWriter out,
    String status,
    String contentType,
    String content
  ) throws IOException {
    try {
      out.write("HTTP/1.1 " + status + "\r\n");
      out.write("Content-Type: " + contentType + "\r\n");
      out.write("\r\n");
      out.write(content);
      out.flush();
    } catch (SocketException e) {
      System.err.println("Error al enviar la respuesta: " + e.getMessage());
    }
  }
}
