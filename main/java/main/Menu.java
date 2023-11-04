package main;

import Role.Hero;
import Role.Monster;
import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private List<Monster> monsters=new ArrayList<>();
    private List<Hero> heroes=new ArrayList<>();

    private Hero hero=new Hero();



    public  void startGame() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from hero");
        while(resultSet.next()){
            Hero hero1 = new Hero();
            hero1.setName(resultSet.getString(1));
            hero1.setHp(resultSet.getInt(2));
            hero1.setMaxhp(resultSet.getInt(3));
            hero1.setAttack(resultSet.getInt(4));
            hero1.setDefend(resultSet.getInt(5));
            hero1.setGold(resultSet.getInt(6));
            heroes.add(hero1);
        }

        System.out.println("Your load, please choose the character you like! (Type one of the displaying number.)");
        for (int i=0;i<heroes.size();i++) {
            System.out.println((i+1)+" "+heroes.get(i));
        }

        Scanner input=new Scanner(System.in);
        int i = input.nextInt();

        hero=heroes.get(i-1);

        test.MENU=1;

        ResultSet rs= statement.executeQuery("select * from monster");

        while(rs.next()){
            Monster monster = new Monster();
            monster.setName(rs.getString(1));
            monster.setHp(rs.getInt(2));
            monster.setAttack(rs.getInt(3));
            monster.setDefend(rs.getInt(4));
            monster.setGold(rs.getInt(5));
            monsters.add(monster);
        }

    }

    public void beginnerVillage(){
        Scanner input=new Scanner(System.in);
        for(;;){
            System.out.println("Welcome challenger "+hero.getName()+" to our Adventure country.");
            System.out.println("1. Character status");
            System.out.println("2. Mall");
            System.out.println("3. Martial club");
            System.out.println("4. Wilds");
            String choose=input.next();
            if(choose.equals("1")){
                System.out.println(hero);
            }
            else if(choose.equals("4")){
                test.MENU=2;
                break;
            }
            else if(choose.equals("2")){
                test.MENU=3;
                break;
            }else if(choose.equals("3")){
                test.MENU=4;
                break;
            }
        }
    }

    public Monster getMonster(){
        // create a Random object
        Random random = new Random();
        // use random.nextInt(x)
        // a random integer among [0, x - 1]
        // randomIndex is the index from an arbitrary element in list.
        int randomIndex = random.nextInt(monsters.size());

        return monsters.get(randomIndex);
    }

    public Hero getHero(){
        // create a Random object
        Random random = new Random();
        // use random.nextInt(x)
        // a random integer among [0, x - 1]
        // randomIndex is the index from an arbitrary element in list.
        int randomIndex = random.nextInt(heroes.size());

        return heroes.get(randomIndex);
    }

    public void store(){
        Scanner input=new Scanner(System.in);

        for (;;){
            System.out.println("欢迎勇者"+hero.getName()+"来到商城！");
            System.out.println("1、购买武器");
            System.out.println("2、购买护甲");
            System.out.println("3、购买生命值上限");
            System.out.println("4、查看英雄状态");
            System.out.println("5、回城");
            String choose=input.next();

            if(choose.equals("1")){
                if(hero.getGold() >= 20){
                    hero.setAttack(hero.getAttack() + 10);
                    hero.setGold(hero.getGold() - 20);
                    System.out.println("购买成功,攻击加10点，花费20金币");
                }
                else{
                    System.out.println("购买失败，金币不足");
                }
            }
            else if(choose.equals("2")){
                if(hero.getGold() >= 20){
                    hero.setDefend(hero.getDefend() + 5);
                    hero.setGold(hero.getGold() - 20);
                    System.out.println("购买成功,防御加10点，花费20金币");
                }
                else{
                    System.out.println("购买失败，金币不足");
                }
            }
            else if(choose.equals("3")){
                if(hero.getGold() >= 20){
                    hero.setMaxhp(hero.getMaxhp() + 15);
                    hero.setGold(hero.getGold() - 20);
                    System.out.println("购买成功,生命加15点，花费20金币");
                }
                else{
                    System.out.println("购买失败，金币不足");
                }
            }
            else if(choose.equals("4")){
                System.out.println(hero);
            }
            else if(choose.equals("5")){
                test.MENU=1;
                break;
            }
        }
    }

    public void solo(){
        Scanner input=new Scanner(System.in);

        for (;;){
            System.out.println("欢迎勇者"+hero.getName()+"来到武馆！");
            System.out.println("1、查看英雄榜");
            System.out.println("2、决斗");
            System.out.println("3、回城");
            String choose=input.next();

            if(choose.equals("1")){
                System.out.println("英雄榜");
                for (int i=0;i<heroes.size();i++) {
                    System.out.println((i+1)+" "+heroes.get(i));
                }
            }
            else if(choose.equals("2")){
                Hero soloHero = getHero();

                for(;;){
                    int lose = hero.getAttack()-soloHero.getDefend();
                    System.out.println(hero.getName()+"超强攻击，给"+soloHero.getName()+"来了一套组合拳打脚踢");
                    soloHero.setHp(soloHero.getHp()-lose);
                    System.out.println(soloHero.getName()+"剩余"+soloHero.getHp());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(soloHero.getHp()<=0){
                        System.out.println(hero.getName()+"胜利，获得"+soloHero.getGold()+"金币");
                        hero.setGold(hero.getGold()+soloHero.getGold());
                        break;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lose = soloHero.getAttack()-hero.getDefend();
                    System.out.println(soloHero.getName()+"直接给"+hero.getName()+"一个超级暴击");

                    hero.setHp(hero.getHp()-lose);
                    System.out.println(hero.getName()+"剩余"+hero.getHp()+"/"+hero.getMaxhp());

                    if(hero.getHp()<=0){
                        System.out.println("You Died");
                        System.exit(0);
                        break;
                    }
                }

            }
            else if(choose.equals("3")){
                test.MENU=1;
                break;
            }
        }
    }
    public void wilds(){

        Scanner input=new Scanner(System.in);
        Monster monster=getMonster();
        for(;;){
            System.out.println("欢迎勇者"+hero.getName()+"来到野外！");
            System.out.println("1、查看状态");
            System.out.println("2、查看怪物信息");
            System.out.println("3、砍怪");
            System.out.println("4、回城");
            String choose=input.next();

            if(choose.equals("1")){
                System.out.println(hero);
            }
            else if(choose.equals("2")){
                System.out.println(monster);
            }
            else if(choose.equals("3")){
                for(;;){
                    int lose = hero.getAttack()-monster.getDefend();
                    System.out.println(hero.getName()+"施展技能，给"+monster.getName()+"来了一套拳打脚踢");
                    monster.setHp(monster.getHp()-lose);
                    System.out.println(monster.getName()+"剩余"+monster.getHp());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(monster.getHp()<=0){
                        System.out.println(hero.getName()+"胜利，获得"+monster.getGold()+"金币");
                        hero.setGold(hero.getGold()+monster.getGold());
                        monster=getMonster();
                        break;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lose = monster.getAttack()-hero.getDefend();
                    System.out.println(monster.getName()+"直接给"+hero.getName()+"一个暴击");

                    hero.setHp(hero.getHp()-lose);
                    System.out.println(hero.getName()+"剩余"+hero.getHp()+"/"+hero.getMaxhp());


                    if(hero.getHp()<=0){
                        System.out.println("You Died");
                        System.exit(0);
                        break;
                    }
                }
            }
            else if(choose.equals("4")){
                test.MENU=1;
                break;
            }
        }
    }
}
