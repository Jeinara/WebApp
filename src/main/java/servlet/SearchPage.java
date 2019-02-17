package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/Archive")
public class SearchPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ArrayList<Character> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(DBConnect connect = new DBConnect()) {
           list = connect.getAllCharacters();
       } catch (SQLException e) {
            e.printStackTrace();
       }
       //отсортировать по алфавиту перед отправкой
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/SearchForm.jsp").forward(request,response);
    }

}
