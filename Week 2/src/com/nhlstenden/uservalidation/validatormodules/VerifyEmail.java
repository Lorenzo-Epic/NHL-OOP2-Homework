package com.nhlstenden.uservalidation.validatormodules;

public interface VerifyEmail
{
    //    very simple validator, I know
    static boolean isValid(String email)
    {
        if (!email.contains("@") || !email.contains("."))
        {
            System.out.println("email invalid!");
            return false;
        }
        return true;
    }
}
