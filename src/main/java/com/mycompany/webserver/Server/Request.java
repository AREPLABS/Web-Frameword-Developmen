package com.mycompany.webserver.Server;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una solicitud HTTP.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class Request {

  private String path;
  private Map<String, String> queryParams = new HashMap<>();

  /**
   * Construye una solicitud HTTP.
   *
   * @param path La ruta de la solicitud.
   */
  public Request(String path) {
    this.path = path;
    parseQueryParams();
  }

  private void parseQueryParams() {
    if (path.contains("?")) {
      String[] parts = path.split("\\?");
      path = parts[0];
      String query = parts[1];
      for (String param : query.split("&")) {
        String[] keyValue = param.split("=");
        queryParams.put(keyValue[0], keyValue[1]);
      }
    }
  }

  public String getPath() {
    return path;
  }

  public String getQueryParam(String key) {
    return queryParams.get(key);
  }
}
