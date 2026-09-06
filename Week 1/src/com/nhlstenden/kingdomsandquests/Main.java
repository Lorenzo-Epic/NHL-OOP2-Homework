package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Mage sander = new Mage("Sander", 10, 5, 20, 10, 2);
        Warrior bob = new Warrior("bob", 1, 1, 1, 1, 0);
        GameItem europeanCredits = new GameItem("Nine whole european credits");
        SpecialQuest oopQuest = new SpecialQuest("Understanding OOP2", sander, 2, 10000, List.of(europeanCredits));
        Player student = new Player("NHL Student", List.of(bob), List.of(oopQuest), 400, null);

        System.out.println("Before completing quest");

        System.out.println("Player XP: " + student.getXp());
        System.out.println("Player Level: " + student.getLevel());
        System.out.println("Player Items: ");
        if (student.getGameItems() == null)
        {
            System.out.println("None!");
        }

        student.selectQuest(oopQuest, bob);

        System.out.println("After completing quest");

        System.out.println("Player XP: " + student.getXp());
        System.out.println("Player Level: " + student.getLevel());
        System.out.println("Player Items: ");
        for (GameItem item : student.getGameItems())
        {
            System.out.println(item.getName());
        }
    }
}
