package com.nhlstenden.uservalidation.validatormodules;

import java.time.LocalDate;
import java.time.Period;

public interface VerifyAge
{
    static boolean isValid(LocalDate dateOfBirth, int minimumAge)
    {
        if (Period.between(dateOfBirth, LocalDate.now()).getYears() < minimumAge)
        {
            System.out.println("user too young!");
            return false;
        }
        return true;
    }

    static boolean isValid(LocalDate dateOfBirth, int minimumAge, LocalDate dateToTestFrom)
    {
        if (Period.between(dateOfBirth, dateToTestFrom).getYears() < minimumAge)
        {
            System.out.println("user too young!");
            return false;
        }
        return true;
    }
}
