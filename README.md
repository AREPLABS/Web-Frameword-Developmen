# Web-Frameword-Developmen

Project Statement: Web Framework Development for REST Services and Static File Management
Objective:
This project aims to enhance an existing web server, which currently supports HTML files, JavaScript, CSS, and images, by converting it into a fully functional web framework. This framework will enable the development of web applications with backend REST services. The new framework will provide developers with tools to define REST services using lambda functions, manage query values within requests, and specify the location of static files.

Project Scope and Features:
1. GET Static Method for REST Services:
Implement a get() method that allows developers to define REST services using lambda functions.
Example Usage:
get("/hello", (req, res) -> "hello world!");
This feature will enable developers to define simple and clear routes within their applications, mapping URLs to specific lambda expressions that handle the requests and responses.
2. Query Value Extraction Mechanism:
Develop a mechanism to extract query parameters from incoming requests and make them accessible within the REST services.
Example Usage:
get("/hello", (req, res) -> "hello " + req.getValues("name"));
This functionality will facilitate the creation of dynamic and parameterized REST services, allowing developers to easily access and utilize query parameters within their service implementations.
3. Static File Location Specification:
Introduce a staticfiles() method that allows developers to define the folder where static files are located.
Example Usage:
staticfiles("webroot/public");
The framework will then look for static files in the specified directory, such as target/classes/webroot/public, making it easier for developers to organize and manage their application's static resources.

4. Additional Tasks:
Build an example demonstrating how applications would be developed on your server.
Example of How a Web Developer May Use the New Framework:
This simple code will start a web server and serve a web application with static files located in “target/classes/webroot.” The GET REST services will respond to the following requests:

http://localhost:8080/App/hello?name=Pedro
http://localhost:8080/App/pi
In the example, REST services are published with the “/App” prefix; this is just a suggestion, and you may choose otherwise.


    public static void main(String[] args) {
        staticfiles("/webroot");
        get("/hello", (req, resp) -> "Hello " + req.getValues("name"));
        get("/pi", (req, resp) -> {
            return String.valueOf(Math.PI); 
        });
    }
  
The code should also respond to requests for static files:

http://localhost:8080/index.html
Deliverables:
The source code of the developed project was uploaded to a public GitHub repository.
The project should be built using Maven and Git.
The README should describe the project, its architecture, how to run it, and examples of the tests performed.
The repository should be professionally structured.
Outcome:
Upon completion, this project will equip developers with a robust framework for developing scalable and maintainable web applications and deepen their understanding of key technical concepts. Through hands-on experience, developers will gain knowledge of the HTTP protocol architecture, the architecture of the internet, and the architecture of distributed applications. The practical application of these concepts within the framework will enhance their ability to design and implement efficient and effective web services, fostering a comprehensive understanding of modern web development practices.

