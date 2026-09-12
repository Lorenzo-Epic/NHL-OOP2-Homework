package com.nhlstenden.uservalidation.validatormodules;

public interface VerifyPassword
{
    static boolean validatePassword(String password, boolean isPasswordSpacesAllowed, boolean isPasswordSpecialCharactersMandatory,
                                    boolean isPasswordNumbersRequired, boolean isPasswordLowercaseSymbolRequired,
                                    boolean isPasswordUppercaseSymbolRequired)
    {

        if (!isPasswordSpacesAllowed && !validateSpacesNotAllowed(password))
        {
            return false;
        }

        if (isPasswordSpecialCharactersMandatory && !validateSpecialCharactersMandatory(password))
        {
            return false;
        }

        if (isPasswordNumbersRequired && !validateNumbersMandatory(password))
        {
            return false;
        }

        if (isPasswordLowercaseSymbolRequired && !validateLowercaseSymbolMandatory(password))
        {
            return false;
        }

        return !isPasswordUppercaseSymbolRequired || validateUppercaseSymbolMandatory(password);
    }

    static boolean validateSpacesNotAllowed(String password)
    {
        if (password.contains(" "))
        {
            System.out.println("spaces in password not allowed!");
            return false;
        }
        return true;
    }

    static boolean validateSpecialCharactersMandatory(String password)
    {
        if (!password.matches(".*[^a-zA-Z0-9\\s].*"))
        {
            System.out.println("special characters in password are mandatory!");
            return false;
        }
        return true;
    }

    static boolean validateNumbersMandatory(String password)
    {
        if (!password.matches(".*[0-9].*"))
        {
            System.out.println("numbers characters in password are mandatory!");
            return false;
        }
        return true;
    }

    static boolean validateLowercaseSymbolMandatory(String password)
    {
        if (!password.matches(".*[a-z].*"))
        {
            System.out.println("lowercase symbols in password are mandatory!");
            return false;
        }
        return true;
    }

    static boolean validateUppercaseSymbolMandatory(String password)
    {
        if (!password.matches(".*[A-Z].*"))
        {
            System.out.println("uppercase symbols in password are mandatory!");
            return false;
        }
        return true;
    }
}
