package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    private int specialAbilityAttackMultiplier;

    public Warrior(String characterName, int healthPoints, int attack, int defense, int damage, int specialAbilityAttackMultiplier)
    {
        super(characterName, healthPoints, attack, defense, damage);
        this.specialAbilityAttackMultiplier = specialAbilityAttackMultiplier;
    }

    public int getSpecialAbilityAttackMultiplier()
    {
        return this.specialAbilityAttackMultiplier;
    }

    public void setSpecialAbilityAttackMultiplier(int specialAbilityAttackMultiplier)
    {
        if (specialAbilityAttackMultiplier < 0)
        {
            throw new IllegalArgumentException("specialAbilityAttackMultiplier cannot be less than 0");
        }

        this.specialAbilityAttackMultiplier = specialAbilityAttackMultiplier;
    }

    @Override
    void specialAbility()
    {
        System.out.println(this.getCharacterName() + "'s attack has been multiplied by " + this.getSpecialAbilityAttackMultiplier() + "!");
    }
}
