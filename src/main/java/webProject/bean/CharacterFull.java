package webProject.bean;

public class CharacterFull extends Character {

    private String nickname;
    private String sex;
    private String post;
    private String social;
    private String character;
    private String portrait;
    private String skills;
    private String bio;
    private String phobias;
    private String die;
    private String goal;
    private String age;
    private String sin;

    public CharacterFull(){}

    public CharacterFull(Character chr){
        this.setName(chr.getName());
        this.setBoss(chr.isBoss());
        this.setMembership(chr.getMembership());
        this.setFloor(chr.getFloor());
        this.setImg(chr.getImg());
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSin() {
        return sin;
    }
    public void setSin(String sin) {
        this.sin = sin;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getSocial() {
        return social;
    }
    public void setSocial(String social) {
        this.social = social;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getPhobias() {
        return phobias;
    }
    public void setPhobias(String phobias) {
        this.phobias = phobias;
    }
    public String getDie() {
        return die;
    }
    public void setDie(String die) {
        this.die = die;
    }
    public String getGoal() {
        return goal;
    }
    public void setGoal(String goal) {
        this.goal = goal;
    }
}
