package webProject.bean;

public class BossExtra extends CharacterFull {

    private String nature;

    public BossExtra(){
    }
    public BossExtra(Character chr){
        super(chr);
    }

    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {
        this.nature = nature;
    }

}
