package com.mycompany.webserver.Server;

import static com.mycompany.webserver.Server.HTTPServer.get;
import static com.mycompany.webserver.Server.HTTPServer.staticfiles;

import java.io.IOException;

public class WebApplication {

  public static void main(String[] args) throws IOException {
    staticfiles("/webroot");
    //get("/hello", (req, resp) -> "Hello " + req.getValues("name"));
    get(
      "/app/pi",
      (req, resp) -> {
        return String.valueOf(Math.PI);
      }
    );

    get(
      "/app/e",
      (req, resp) -> {
        return String.valueOf(Math.E);
      }
    );
    HTTPServer.start(args);
  }
}
