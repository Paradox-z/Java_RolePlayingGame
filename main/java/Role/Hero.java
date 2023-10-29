package Role;

public class Hero {

    private String name;
    private int hp;        //hit point
    private int maxhp;
    private int attack;
    private int defend;
    private int gold;  //profit


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

