package main;

import JDBC.Select;
import Role.Hero;
import Role.Monster;

import java.util.List;

public class test {
//    public static void main(String[] args) {
//        Select s = new Select();  // Class, Function, choose the appropriate to utilise.
//
//        String sql = "select name,hp,maxhp,attack,defend,gold from hero";  // select action
//        List<Hero> list = s.getForList(Hero.class,sql);  // retrive all data elements from the whole table.
//        //System.out.println("\tname\tprice\tauthor\tnum");
//        list.forEach(System.out::println);
//
//        String sql1 = "select name,hp,attack,defend,gold from monster";  // select action
//        List<Monster> list1 = s.getForList(Monster.class,sql1);  // retrieve all data elements from the whole table.
//        list1.forEach(System.out::println);
//
//    }
    public static int MENU = 0;

    public static void main(String[] args) throws Exception {
        Menu menu=new Menu();
        for (; ; ) {
            if (MENU == 0) {
                menu.startGame();
            } else if (MENU == 1) {
                menu.beginnerVillage();
            } else if (MENU == 2) {
                menu.wilds();
            }
            else if(MENU == 3){
                menu.store();
            }
            else if(MENU == 4){
                menu.solo();
            }
        }
    }
}
