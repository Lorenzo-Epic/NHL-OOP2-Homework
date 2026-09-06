package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    private int specialAbilityDefendMultiplier;

    public Mage(String characterName, int healthPoints, int attack, int defense, int damage, int specialAbilityDefendMultiplier)
    {
        super(characterName, healthPoints, attack, defense, damage);
        this.specialAbilityDefendMultiplier = specialAbilityDefendMultiplier;
    }

    public int getSpecialAbilityDefendMultiplier()
    {
        return this.specialAbilityDefendMultiplier;
    }

    public void setSpecialAbilityDefendMultiplier(int specialAbilityDefendMultiplier)
    {
        if (specialAbilityDefendMultiplier < 0)
        {
            throw new IllegalArgumentException("specialAbilityDefendMultiplier cannot be less than 0");
        }

        this.specialAbilityDefendMultiplier = specialAbilityDefendMultiplier;
    }

    @Override
    void specialAbility()
    {
        System.out.println(this.getCharacterName() + "'s defense has been multiplied by " + this.getSpecialAbilityDefendMultiplier() + "!");
    }
}

