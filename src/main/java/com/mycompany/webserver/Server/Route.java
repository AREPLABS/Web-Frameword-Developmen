package com.mycompany.webserver.Server;

public class Route {

  private String path;
  private RouteHandler handler;

  public Route(String path, RouteHandler handler) {
    this.path = path;
    this.handler = handler;
  }

  public String getPath() {
    return path;
  }

  public RouteHandler getHandler() {
    return handler;
  }
}
