package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    private static final int SPECIAL_ABILITY_DAMAGE_MULTIPLIER = 2;

    public Archer(String characterName, int healthPoints, int attack, int defense, int damage)
    {
        super(characterName, healthPoints, attack, defense, damage);
    }

    @Override
    void specialAbility()
    {
        System.out.println(this.getCharacterName() + "'s damage has been multiplied by " + SPECIAL_ABILITY_DAMAGE_MULTIPLIER + "!");
    }
}
