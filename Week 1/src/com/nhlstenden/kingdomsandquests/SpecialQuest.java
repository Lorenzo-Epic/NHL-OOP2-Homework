package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class SpecialQuest extends Quest
{
    private List<GameItem> itemsReward;

    public SpecialQuest(String questName, Character opponent, int difficultyLevel, int xpReward, List<GameItem> itemsReward)
    {
        super(questName, opponent, difficultyLevel, xpReward);
        this.itemsReward = itemsReward;
    }

    public List<GameItem> getItemsReward()
    {
        return this.itemsReward;
    }

    public void setItemsReward(List<GameItem> itemsReward)
    {
        if (itemsReward == null || itemsReward.isEmpty())
        {
            throw new IllegalArgumentException("itemsReward cannot be null or empty");
        }
        for (Object itemsRewardItem : itemsReward)
        {
            if (itemsRewardItem == null)
            {
                throw new IllegalArgumentException("itemsReward cannot contain null");
            }
        }

        this.itemsReward = new ArrayList<>(itemsReward);
    }
}
