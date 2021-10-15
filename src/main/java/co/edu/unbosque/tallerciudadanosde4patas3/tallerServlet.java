package co.edu.unbosque.tallerciudadanosde4patas3;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// Developer: Andres Leonardo Cuadros
// Organization: Universidad el Bosque

@WebServlet(name = "tallerServlet", value = "/taller-servlet")
public class tallerServlet extends HttpServlet {
private String message;
private String rol;

    public void init() {
      message = "Welcome";
      rol ="";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //The data is taken
        String email=request.getParameter("email");
        String password=request.getParameter("password");
     // Cookies are created
        Cookie cookieEmail = new Cookie("username", email);
        cookieEmail.setMaxAge(3600);
        response.addCookie(cookieEmail);
        Cookie cookieRol = new Cookie("rol", "");
        cookieRol.setMaxAge(3600);
        response.addCookie(cookieRol);

        PrintWriter out = response.getWriter();
// The Credentials are validated
if(!password.equals("") && !email.equals("")){
    rol = "official";
    out.println("<html><head>");
    out.println("<meta http-equiv='refresh' content='30; URL=table.html'>");
    out.println("</head><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
//It is redirected to where it belongs
}else if(email.equals("wildfly") && password.equals("O6ifkko09h4Gq7jd")){
    rol = "proprietary";
    out.println("<html><head>");
    out.println("<meta http-equiv='refresh' content='30; URL=form.html'>");
    out.println("</head><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
}





    }

    public void destroy() {
    }
}