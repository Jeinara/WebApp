package webProject.bean;

public class CharacterExtra extends CharacterFull{

    private String nationality;
    private String profession;

    public CharacterExtra(){
    }
    public CharacterExtra(Character chr){
        super(chr);
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
}
