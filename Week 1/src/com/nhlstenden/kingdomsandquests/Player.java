package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    public static final int XP_TO_LEVEL_UP = 200;
    private String userName;
    private List<Character> characters;
    private List<Quest> quests;
    private int xp;
    private int level;
    private List<GameItem> gameItems;

    public Player(String userName, List<Character> characters, List<Quest> quests, int xp, List<GameItem> gameItems)
    {
        this.userName = userName;
        this.characters = characters;
        this.quests = quests;
        this.xp = 0;
        this.level = 0;
        this.gameItems = gameItems;

        this.addXp(xp);
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        if (userName == null || userName.isBlank())
        {
            throw new IllegalArgumentException("userName cannot be null or blank");
        }

        this.userName = userName;
    }

    public List<Character> getCharacters()
    {
        return this.characters;
    }

    public void setCharacters(List<Character> characters)
    {
        this.characters = new ArrayList<>(characters);
    }

    public List<Quest> getQuests()
    {
        return this.quests;
    }

    public void setQuests(List<Quest> quests)
    {
        this.quests = new ArrayList<>(quests);
    }

    public int getXp()
    {
        return this.xp;
    }

    public void setXp(int xp)
    {
        if (xp < 0)
        {
            throw new IllegalArgumentException("xp cannot be less than 0");
        }

        this.xp = xp;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int level)
    {
        if (level < 0)
        {
            throw new IllegalArgumentException("level cannot be less than 0");
        }

        this.level = level;
    }

    public List<GameItem> getGameItems()
    {
        return this.gameItems;
    }

    public void setGameItems(List<GameItem> gameItems)
    {
        this.gameItems = new ArrayList<>(gameItems);
    }

    public void addXp(int xp)
    {
        int totalXp = xp + this.getXp();
        int xpLeftToAdd = xp + this.getXp();
        while (xpLeftToAdd >= XP_TO_LEVEL_UP)
        {
            xpLeftToAdd = xpLeftToAdd - XP_TO_LEVEL_UP;
            this.setLevel(this.getLevel() + 1);
        }
        this.setXp(totalXp);
    }

    public void selectQuest(Quest quest, Character character)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("quests cannot be null");
        }
        if (character == null)
        {
            throw new IllegalArgumentException("character cannot be null");
        }

        if (quest.hasEnoughXpForQuest(this.getXp()))
        {
            this.addXp(quest.getXpReward());

            if (quest instanceof SpecialQuest)
            {
                List<GameItem> newGameItems = new ArrayList<>();

                if (this.getGameItems() != null)
                {
                    newGameItems.addAll(this.getGameItems());
                }

                newGameItems.addAll(((SpecialQuest) quest).getItemsReward());

                this.setGameItems(newGameItems);
            }
        }
    }
}
