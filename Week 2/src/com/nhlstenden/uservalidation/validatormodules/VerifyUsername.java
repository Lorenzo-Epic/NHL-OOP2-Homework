package com.nhlstenden.uservalidation.validatormodules;

import com.nhlstenden.uservalidation.Storage;

import java.util.List;

public interface VerifyUsername
{
    static boolean isValid(String username, List<Storage> storedDetails)
    {
        if (storedDetails.isEmpty())
        {
            return true;
        }

        for (Storage storedDetail : storedDetails)
        {
            if (storedDetail.getUsername().equals(username))
            {
                System.out.println("username already exists!");
                return false;
            }
        }
        return true;
    }
}
