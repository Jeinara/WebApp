package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Character")
public class CharacterPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        CharacterFull character = new CharacterFull();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(DBConnect connect = new DBConnect()) {
            character = connect.getFullCharacter(req.getParameter("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("character", character);
        req.getRequestDispatcher("/WEB-INF/jsp/CharacterPage.jsp").forward(req,resp);
    }
}
