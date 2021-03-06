package webProject.bean;

public class Character {

    private String name;
    private String membership;
    private int floor;
    private String img;
    private boolean isBoss;

    public boolean isBoss() {
        return isBoss;
    }
    public void setBoss(boolean boss) {
        isBoss = boss;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMembership() {
        return membership;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
