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

  private int statusCode;
  private String contentType;
  private String body;
  private Map<String, String> headers;

  /**
   * Construye una respuesta HTTP.
   */
  public Response() {
    this.statusCode = 200; // Código de estado por defecto
    this.contentType = "text/plain"; // Tipo de contenido por defecto
    this.body = "";
    this.headers = new HashMap<>();
  }

  /**
   * Obtiene el código de estado de la respuesta.
   * @return statusCode El código de estado de la respuesta.
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Establece el código de estado de la respuesta.
   * @param statusCode El código de estado de la respuesta.
   */
  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * Obtiene el tipo de contenido de la respuesta.
   * @return contentType El tipo de contenido de la respuesta.
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Establece el tipo de contenido de la respuesta.
   * @param contentType El tipo de contenido de la respuesta.
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   * Obtiene el cuerpo de la respuesta.
   * @return body El cuerpo de la respuesta.
   */
  public String getBody() {
    return body;
  }

  /**
   * Establece el cuerpo de la respuesta.
   * @param body El cuerpo de la respuesta.
   */
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * Obtiene los encabezados de la respuesta.
   * @return headers Los encabezados de la respuesta.
   */
  public Map<String, String> getHeaders() {
    return headers;
  }

  /**
   * Establece los encabezados de la respuesta.
   * @param headers Los encabezados de la respuesta.
   */
  public void addHeader(String key, String value) {
    this.headers.put(key, value);
  }
}
