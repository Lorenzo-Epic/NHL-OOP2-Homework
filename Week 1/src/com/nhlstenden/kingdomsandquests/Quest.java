package com.nhlstenden.kingdomsandquests;

public class Quest
{
    public static final int NEEDED_XP_DIFFICULTY_MULTIPLICATION_FACTOR = 10;
    private String questName;
    private Character opponent;
    private int difficultyLevel;
    private int xpReward;

    public Quest(String questName, Character opponent, int difficultyLevel, int xpReward)
    {
        this.questName = questName;
        this.opponent = opponent;
        this.difficultyLevel = difficultyLevel;
        this.xpReward = xpReward;
    }

    public String getQuestName()
    {
        return this.questName;
    }

    public void setQuestName(String questName)
    {
        if (questName == null || questName.isBlank())
        {
            throw new IllegalArgumentException("questName cannot be null or blank");
        }

        this.questName = questName;
    }

    public Character getOpponent()
    {
        return this.opponent;
    }

    public void setOpponent(Character opponent)
    {
        if (opponent == null)
        {
            throw new IllegalArgumentException("opponent cannot be null");
        }

        this.opponent = opponent;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel)
    {
        if (difficultyLevel < 0)
        {
            throw new IllegalArgumentException("difficultyLevel cannot be less than 0");
        }

        this.difficultyLevel = difficultyLevel;
    }

    public int getXpReward()
    {
        return this.xpReward;
    }

    public void setXpReward(int xpReward)
    {
        if (xpReward < 0)
        {
            throw new IllegalArgumentException("xpReward cannot be less than 0");
        }

        this.xpReward = xpReward;
    }

    public boolean hasEnoughXpForQuest(int playerXp)
    {
        return (this.getDifficultyLevel() * NEEDED_XP_DIFFICULTY_MULTIPLICATION_FACTOR <= playerXp);
    }
}
