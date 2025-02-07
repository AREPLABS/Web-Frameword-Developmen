package com.mycompany.webserver.Server;

/**
 * Interfaz funcional que representa un manejador de rutas.
 *
 * @author Diego Chicuazuque
 * @param req La solicitud HTTP.
 * @param res La respuesta HTTP.
 * @version 1.0
 */
@FunctionalInterface
public interface RouteHandler {
  String handle(Request req, Response res);
}
