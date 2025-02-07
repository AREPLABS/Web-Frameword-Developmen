package com.mycompany.webserver.Server;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una respuesta HTTP.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class Response {

  // Códigos de estado HTTP comunes como constantes
  public static final int HTTP_OK = 200;
  public static final int HTTP_NOT_FOUND = 404;
  public static final int HTTP_METHOD_NOT_ALLOWED = 405;

  private int statusCode;
  private String contentType;
  private Object body; // Puede ser String o byte[] (para contenido binario)
  private Map<String, String> headers;

  /**
   * Construye una respuesta HTTP con valores por defecto.
   */
  public Response() {
    this.statusCode = HTTP_OK;
    this.contentType = "text/plain";
    this.body = "";
    this.headers = new HashMap<>();
  }

  // Métodos getter y setter
  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setBody(byte[] body) {
    this.body = body;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void addHeader(String key, String value) {
    this.headers.put(key, value);
  }

  public void removeHeader(String key) {
    this.headers.remove(key);
  }

  public String getHeader(String key) {
    return this.headers.get(key);
  }

  /**
   * Representación de la respuesta HTTP como un string.
   * @return La respuesta formateada como string.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb
      .append("HTTP/1.1 ")
      .append(statusCode)
      .append(" ")
      .append(getStatusMessage(statusCode))
      .append("\r\n");
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      sb
        .append(entry.getKey())
        .append(": ")
        .append(entry.getValue())
        .append("\r\n");
    }
    sb.append("\r\n");
    if (body instanceof String) {
      sb.append(body);
    } else if (body instanceof byte[]) {
      // Puedes manejar la conversión de binarios de una manera apropiada
      sb.append("[binary data]");
    }
    return sb.toString();
  }

  /**
   * Obtiene el mensaje de estado para un código de estado HTTP.
   * @param statusCode El código de estado HTTP.
   * @return El mensaje de estado correspondiente.
   */
  private String getStatusMessage(int statusCode) {
    switch (statusCode) {
      case HTTP_OK:
        return "OK";
      case HTTP_NOT_FOUND:
        return "Not Found";
      case HTTP_METHOD_NOT_ALLOWED:
        return "Method Not Allowed";
      default:
        return "Unknown Status";
    }
  }
}
