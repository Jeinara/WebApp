package webProject.servlet;

import webProject.bean.Character;
import webProject.dataBase.DBSelect;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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
        try(DBSelect select = new DBSelect()) {
           list = select.getAllCharacters();
       } catch (SQLException e) {
            e.printStackTrace();
       }
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/SearchForm.jsp").forward(request,response);
    }

}
