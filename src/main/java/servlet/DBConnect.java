package servlet;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect implements AutoCloseable{
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/home?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    //private static final String URL = "jdbc:mysql://172.17.0.4:3306/home?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    DBConnect() throws SQLException {
        System.out.println("Creating connection to database...");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Successfully");
        stmt = con.createStatement();
        pstmt = con.prepareStatement(
                "SELECT * FROM `home`.`character` WHERE `name` = ?");
    }
    DBConnect(String user, String password) throws SQLException {
        System.out.println("Creating connection to database...");
        con = DriverManager.getConnection(URL, user, password);
        System.out.println("Successfully");
        stmt = con.createStatement();
        pstmt = con.prepareStatement(
                "SELECT * FROM `home`.`character` WHERE `name` = ?");
    }


    public ArrayList<Character> getAllCharacters() {

        String GET_CHARACTERS = "SELECT * FROM `home`.`character`;";
        ArrayList<Character> list = new ArrayList<>();
        try(ResultSet rs = stmt.executeQuery(GET_CHARACTERS)) {
            while (rs.next()) {
                Character chara = new Character();
                chara.setName(rs.getString("name"));
                chara.setFloor(rs.getInt("floor"));
                String membership = rs.getString("membership");
                if((membership.equals("свободен"))||(membership.equals("свободна"))){
                    chara.setMembership("самсусами");
                } else {
                    chara.setMembership(membership);
                }
                chara.setImg(rs.getString("img"));
                list.add(chara);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CharacterFull getFullCharacter(String name) throws SQLException {
        //Получить имя
        pstmt.setString(1, name);
        CharacterFull chara = new CharacterFull();
        try(ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()){
                chara.setName(rs.getString("name"));
                chara.setFloor(rs.getInt("floor"));
                //прописать все остальные пункты
                String membership = rs.getString("membership");
                if((membership.equals("свободен"))||(membership.equals("свободна"))){
                    chara.setMembership("самсусами");
                } else {
                    chara.setMembership(membership);
                }
                chara.setImg(rs.getString("img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chara;
    }

    @Override
    public void close() throws SQLException {
        con.close();
        stmt.close();
        pstmt.close();
    }
}
