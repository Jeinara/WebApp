package webProject.servlet;

import webProject.bean.BossExtra;
import webProject.bean.CharacterExtra;
import webProject.bean.CharacterFull;
import webProject.dataBase.DBSelect;

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

        //TODO проверить, почему фейлится часть запроса на боссе
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(DBSelect select = new DBSelect()) {
            String bool = req.getParameter("boss");
            if(Boolean.valueOf(bool)){
                BossExtra character = select.getFullBoss(req.getParameter("name"));
                req.setAttribute("character", character);
                req.getRequestDispatcher("/WEB-INF/jsp/BossPage.jsp").forward(req,resp);
            }else {
                CharacterExtra character = select.getFullCharacter(req.getParameter("name"));
                req.setAttribute("character", character);
                req.getRequestDispatcher("/WEB-INF/jsp/CharacterPage.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
