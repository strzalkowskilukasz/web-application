package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    //1. żeby klasa była servletem musi dziedziczyć z klasy HttpServlet
    //2. dodanie adnotacji @WebServlet za sciezka "/" - to jest strona główna
    //3. nadpisanie metody doGet
    //4.


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");

        rd.forward(req, resp);
    }
}
