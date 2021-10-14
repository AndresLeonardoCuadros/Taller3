package co.edu.unbosque.tallerciudadanosde4patas3;

import co.edu.unbosque.tallerciudadanosde4patas3.Info.Pet;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "jsonServlet", value = "/jsonServlet")
public class JsonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Specifying the content type for the response
        response.setContentType("application/json");

        // Dynamically building the data to be returned in json format
        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet("Max", "coco-logo.png"));
        pets.add(new Pet("Firulais", "coco-logo.png"));

        // Adding the data to response, parsing it to json using Gson library
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(pets));

    }

}