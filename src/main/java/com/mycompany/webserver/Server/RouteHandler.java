package com.mycompany.webserver.Server;

@FunctionalInterface
public interface RouteHandler {
  String handle(Request req, Response res);
}
