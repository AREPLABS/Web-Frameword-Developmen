import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mycompany.webserver.Server.HTTPServer;
import com.mycompany.webserver.Server.Route;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import org.junit.jupiter.api.*;

class HTTPServerTest {

  private ServerSocket mockServerSocket;
  private Socket mockSocket;
  private BufferedReader mockReader;
  private BufferedWriter mockWriter;

  @BeforeEach
  void setUp() throws IOException {
    mockServerSocket = mock(ServerSocket.class);
    mockSocket = mock(Socket.class);
    mockReader = mock(BufferedReader.class);
    mockWriter = mock(BufferedWriter.class);
  }

  @Test
  void testStaticFilesConfiguration() {
    HTTPServer.staticfiles("/assets");
    // Verificar si se configuró correctamente la ruta de archivos estáticos
    assertEquals("src/main/resources/assets", HTTPServer.staticFilesPath);
  }

  @Test
  void testGetRouteRegistration() {
    HTTPServer.get("/test", (req, res) -> "Test Response");
    List<Route> routes = HTTPServer.routes;
    assertFalse(routes.isEmpty());
    assertEquals("/test", routes.get(0).getPath());
  }

  @Test
  void testHandleClientRequest_InvalidRequest() throws IOException {
    when(mockSocket.getInputStream())
      .thenReturn(new ByteArrayInputStream("INVALID REQUEST".getBytes()));
    when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

    HTTPServer.handleClientRequest(mockSocket);
    verify(mockSocket, times(1)).close();
  }

  @Test
  void testHandleClientRequest_ValidGetRequest() throws IOException {
    String request = "GET /hello HTTP/1.1\r\n\r\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(
      request.getBytes()
    );
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    when(mockSocket.getInputStream()).thenReturn(inputStream);
    when(mockSocket.getOutputStream()).thenReturn(outputStream);

    HTTPServer.get("/hello", (req, res) -> "Hello Test");
    HTTPServer.handleClientRequest(mockSocket);

    String response = outputStream.toString();
    assertTrue(response.contains("200 OK"));
    assertTrue(response.contains("Hello Test"));
  }
}
