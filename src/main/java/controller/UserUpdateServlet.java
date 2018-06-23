package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/users/update")
public class UserUpdateServlet extends HttpServlet {

    UserDao userDao;

   public UserUpdateServlet () {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));

        try {
            User user = userDao.findById(id);

            req.setAttribute("user", user);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/form-edit.jsp");
        rd.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName"); // ten string to name z inputa odpowiedniego pola pliku .jsp
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        //2. Na podstawie danych utworz obiekt User

        userDao.update(new User(id, firstName, lastName, email));
    } catch (SQLException e) {
        e.printStackTrace(); // tu możemy przekierować jak coś pojdzie nie tak do 404- nowy jsp.
    }

        resp.sendRedirect("/users");
    //3. Zapisz obiekt do bazy
    //4. Przekieruj użytkownika do listy userów

}
}
