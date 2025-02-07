package com.mycompany.webserver.Server;

/**
 * Clase que representa una ruta.
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class Route {

  private String path;
  private RouteHandler handler;

  /**
   * Construye una ruta.
   *
   * @param path La ruta de la solicitud.
   * @param handler El manejador de la ruta.
   */
  public Route(String path, RouteHandler handler) {
    this.path = path;
    this.handler = handler;
  }

  /**
   * Obtiene la ruta de la solicitud.
   * @return path La ruta de la solicitud.
   */
  public String getPath() {
    return path;
  }

  /**
   * Obtiene el manejador de la ruta.
   * @return handler El manejador de la ruta.
   */
  public RouteHandler getHandler() {
    return handler;
  }
}
