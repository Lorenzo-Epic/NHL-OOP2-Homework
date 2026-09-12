package com.nhlstenden.uservalidation;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        Validator validator = new Validator(true, true, true, true, true, true, true, 13, true, true);
        validator.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(1999, 2, 23), "Password123!");

//        test invalid username (already exists)
        validator.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(1999, 2, 23), "Password123!");

//        test invalid email (no @)
        validator.validate("EpicGamerReka", "reka.com", LocalDate.of(1999, 2, 23), "Password123!");

//        test user too young
        validator.validate("EpicGamerReka", "reka@gmail.com", LocalDate.of(2020, 2, 23), "Password123!");
    }
}
