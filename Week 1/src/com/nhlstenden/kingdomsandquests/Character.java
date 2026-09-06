package com.nhlstenden.kingdomsandquests;

abstract class Character
{
    private String characterName;
    private int healthPoints;
    private int attack;
    private int defense;
    private int damage;

    public Character(String characterName, int healthPoints, int attack, int defense, int damage)
    {
        this.characterName = characterName;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
    }

    public String getCharacterName()
    {
        return this.characterName;
    }

    public void setCharacterName(String characterName)
    {
        if (characterName == null || characterName.isBlank())
        {
            throw new IllegalArgumentException("characterName cannot be null or blank");
        }

        this.characterName = characterName;
    }

    public int getHealthPoints()
    {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints)
    {
        if (healthPoints < 0)
        {
            throw new IllegalArgumentException("healthPoints cannot be less than 0");
        }

        this.healthPoints = healthPoints;
    }

    public int getAttack()
    {
        return this.attack;
    }

    public void setAttack(int attack)
    {
        if (attack < 0)
        {
            throw new IllegalArgumentException("attack cannot be less than 0");
        }

        this.attack = attack;
    }

    public int getDefense()
    {
        return this.defense;
    }

    public void setDefense(int defense)
    {
        if (defense < 0)
        {
            throw new IllegalArgumentException("defense cannot be less than 0");
        }

        this.defense = defense;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public void setDamage(int damage)
    {
        if (damage < 0)
        {
            throw new IllegalArgumentException("damage cannot be less than 0");
        }

        this.damage = damage;
    }

    public void attack()
    {
        System.out.println(this.characterName + " Attacks for " + this.getAttack() + "!");
    }

    public void defend()
    {
        System.out.println(this.characterName + " Defends for " + this.getDefense() + "!");
    }

    abstract void specialAbility();
}
