package co.edu.unbosque.tallerciudadanosde4patas3;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "multiPartServlet", value = "/multiPartServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class multiPartServlet extends HttpServlet {
    private String UPLOAD_DIRECTORY = "uploads";
    private String message;
    private String theAlphaNumericS;
    private StringBuilder builder;
    private String fileName;
    private int i;

    public void init() {
        message = "";
        fileName ="";
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
        i = 15;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("form/html");

        System.out.println("PetName: " + request.getParameter("petName"));

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        for (int m = 0; m < i; m++) {
            int index = (int)(theAlphaNumericS.length() * Math.random());
            builder.append(theAlphaNumericS.charAt(index));
            builder.toString();
             fileName = builder.toString();
        }

        try {
            for (Part part : request.getParts()) {
                fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/table.html");
    }
}