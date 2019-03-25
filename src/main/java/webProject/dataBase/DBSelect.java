package webProject.dataBase;

import webProject.bean.BossExtra;
import webProject.bean.Character;
import webProject.bean.CharacterExtra;
import webProject.bean.CharacterFull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBSelect implements AutoCloseable {
    private DBConnect connect;

    //TODO добавить недостающие пункты из БД в бобы, из бобов в выборку, из выборки на страничку
    //добавить последнее место проживания
    public DBSelect() throws SQLException  {
        connect = new DBConnect();
    }

    public ArrayList<Character> getAllCharacters() {
        String GET_CHARACTERS = "SELECT * FROM `home`.`character` where dead = 0 order by `name`;";

        ArrayList<Character> list = new ArrayList<>();
        try(Statement stmt = connect.con.createStatement(); ResultSet rs = stmt.executeQuery(GET_CHARACTERS)) {
            while (rs.next()) {
                Character chr = new Character();
                fillMainCharacterInfo(chr,rs);
                list.add(chr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CharacterExtra getFullCharacter(String name) {

        String GET_CHARACTERS = "SELECT * FROM home.`character` " +
                "left join home.aboutCharacter on `character`.id = aboutCharacter.id_character " +
                "left join home.mainAbout on `character`.id = mainAbout.id_character " +
                "where `character`.`name` = ?";
        CharacterExtra chr = new CharacterExtra();
        try (PreparedStatement pstmt = connect.con.prepareStatement(GET_CHARACTERS)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                fillMainCharacterInfo(chr, rs);
                fillFullCharacterInfo(chr, rs);
                fillExtraCharacterInfo(chr, rs);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chr;
    }
    public BossExtra getFullBoss(String name) {
        String GET_CHARACTERS = "SELECT * FROM home.`character` " +
                "left join home.aboutBoss on `character`.id = aboutBoss.id_character " +
                "left join home.mainAbout on `character`.id = mainAbout.id_character " +
                "where `character`.`name` = ?";
        BossExtra chr = new BossExtra();
        try (PreparedStatement pstmt = connect.con.prepareStatement(GET_CHARACTERS)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                fillMainCharacterInfo(chr, rs);
                fillFullCharacterInfo(chr, rs);
                fillExtraBossInfo(chr, rs);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chr;
    }

    private void fillMainCharacterInfo(Character chr, ResultSet rs) throws SQLException {
        chr.setName(rs.getString("name"));
        chr.setFloor(rs.getInt("floor"));
        String membership = rs.getString("membership");
        if((membership.equals("свободен"))||(membership.equals("свободна"))){
            chr.setMembership("ветер");
        } else {
            chr.setMembership(membership);
        }
        chr.setImg(rs.getString("img"));
        chr.setBoss(rs.getBoolean("isBoss"));
    }
    private void fillFullCharacterInfo(CharacterFull chr, ResultSet rs) throws SQLException {
        chr.setNickname(rs.getString("nickname"));
        chr.setAge(rs.getString("age"));
        chr.setSex(rs.getString("sex"));
        chr.setSin(rs.getString("sin"));
        chr.setPost(rs.getString("post"));
        chr.setSocial(rs.getString("social"));
        chr.setCharacter(rs.getString("character"));
        chr.setPortrait(rs.getString("portrait"));
        chr.setSkills(rs.getString("skills"));
        chr.setBio(rs.getString("bio"));
        chr.setPhobias(rs.getString("phobias"));
        chr.setDie(rs.getString("die"));
        chr.setGoal(rs.getString("goal"));
    }
    private void fillExtraCharacterInfo(CharacterExtra chr, ResultSet rs) throws SQLException{
        chr.setNationality(rs.getString("nationality"));
        chr.setProfession(rs.getString("profession"));
    }
    private void fillExtraBossInfo(BossExtra chr, ResultSet rs) throws SQLException{
        chr.setNature(rs.getString("nature"));
    }

    @Override
    public void close() throws SQLException {
        connect.close();
    }


}
