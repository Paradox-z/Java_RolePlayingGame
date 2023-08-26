package Role;

public class Hero {

    private String name;  //姓名
    private int hp;  //血量
    private int maxhp;  //最大血量
    private int attack;  //攻击
    private int defend;  //防御
    private int gold;  //金币


    public Hero() { }
    public Hero(String name, int hp, int maxhp, int attack, int defend, int gold) {
        this.name = name;
        this.hp = hp;
        this.maxhp = maxhp;
        this.attack = attack;
        this.defend = defend;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", maxhp=" + maxhp +
                ", attack=" + attack +
                ", defend=" + defend +
                ", gold=" + gold +
                '}';
    }
}

