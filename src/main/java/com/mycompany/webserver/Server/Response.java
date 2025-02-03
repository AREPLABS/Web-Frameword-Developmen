package com.mycompany.webserver.Server;

import java.util.HashMap;
import java.util.Map;

public class Response {

  private int statusCode;
  private String contentType;
  private String body;
  private Map<String, String> headers;

  public Response() {
    this.statusCode = 200; // Código de estado por defecto
    this.contentType = "text/plain"; // Tipo de contenido por defecto
    this.body = "";
    this.headers = new HashMap<>();
  }

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

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void addHeader(String key, String value) {
    this.headers.put(key, value);
  }
}
