package com.nhlstenden.uservalidation;

import com.nhlstenden.uservalidation.validatormodules.VerifyAge;
import com.nhlstenden.uservalidation.validatormodules.VerifyEmail;
import com.nhlstenden.uservalidation.validatormodules.VerifyPassword;
import com.nhlstenden.uservalidation.validatormodules.VerifyUsername;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validator
{
    private boolean isPasswordVerified;
    private boolean isPasswordSpacesAllowed;
    private boolean isPasswordSpecialCharactersMandatory;
    private boolean isPasswordNumbersRequired;
    private boolean isPasswordLowercaseSymbolRequired;
    private boolean isPasswordUppercaseSymbolRequired;
    private boolean isAgeVerified;
    private int minimumAge;
    private boolean isEmailVerified;
    private boolean isUsernameVerified;
    private List<Storage> storedDetails = new ArrayList<>();

    public Validator(boolean isPasswordVerified, boolean isPasswordSpacesAllowed, boolean isPasswordSpecialCharactersMandatory, boolean isPasswordNumbersRequired, boolean isPasswordLowercaseSymbolRequired, boolean isPasswordUppercaseSymbolRequired, boolean isAgeVerified, int minimumAge, boolean isEmailVerified, boolean isUsernameVerified)
    {
        this.isPasswordVerified = isPasswordVerified;
        this.isPasswordSpacesAllowed = isPasswordSpacesAllowed;
        this.isPasswordSpecialCharactersMandatory = isPasswordSpecialCharactersMandatory;
        this.isPasswordNumbersRequired = isPasswordNumbersRequired;
        this.isPasswordLowercaseSymbolRequired = isPasswordLowercaseSymbolRequired;
        this.isPasswordUppercaseSymbolRequired = isPasswordUppercaseSymbolRequired;
        this.isAgeVerified = isAgeVerified;
        this.minimumAge = minimumAge;
        this.isEmailVerified = isEmailVerified;
        this.isUsernameVerified = isUsernameVerified;
    }

    public boolean isPasswordVerified()
    {
        return this.isPasswordVerified;
    }

    public void setPasswordVerified(boolean passwordVerified)
    {

        this.isPasswordVerified = passwordVerified;
    }

    public boolean isPasswordSpacesAllowed()
    {
        return this.isPasswordSpacesAllowed;
    }

    public void setPasswordSpacesAllowed(boolean passwordSpacesAllowed)
    {

        this.isPasswordSpacesAllowed = passwordSpacesAllowed;
    }

    public boolean isPasswordSpecialCharactersMandatory()
    {
        return this.isPasswordSpecialCharactersMandatory;
    }

    public void setPasswordSpecialCharactersMandatory(boolean passwordSpecialCharactersMandatory)
    {

        this.isPasswordSpecialCharactersMandatory = passwordSpecialCharactersMandatory;
    }

    public boolean isPasswordNumbersRequired()
    {
        return this.isPasswordNumbersRequired;
    }

    public void setPasswordNumbersRequired(boolean passwordNumbersRequired)
    {

        this.isPasswordNumbersRequired = passwordNumbersRequired;
    }

    public boolean isPasswordLowercaseSymbolRequired()
    {
        return this.isPasswordLowercaseSymbolRequired;
    }

    public void setPasswordLowercaseSymbolRequired(boolean passwordLowercaseSymbolRequired)
    {

        this.isPasswordLowercaseSymbolRequired = passwordLowercaseSymbolRequired;
    }

    public boolean isPasswordUppercaseSymbolRequired()
    {
        return this.isPasswordUppercaseSymbolRequired;
    }

    public void setPasswordUppercaseSymbolRequired(boolean passwordUppercaseSymbolRequired)
    {

        this.isPasswordUppercaseSymbolRequired = passwordUppercaseSymbolRequired;
    }

    public boolean isAgeVerified()
    {
        return this.isAgeVerified;
    }

    public void setAgeVerified(boolean ageVerified)
    {

        this.isAgeVerified = ageVerified;
    }

    public int getMinimumAge()
    {
        return this.minimumAge;
    }

    public void setMinimumAge(int minimumAge)
    {
        if (minimumAge < 0)
        {
            throw new IllegalArgumentException("minimumAge cannot be less than 0");
        }

        this.minimumAge = minimumAge;
    }

    public boolean isEmailVerified()
    {
        return this.isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified)
    {

        this.isEmailVerified = emailVerified;
    }

    public boolean isUsernameVerified()
    {
        return this.isUsernameVerified;
    }

    public void setUsernameVerified(boolean usernameVerified)
    {

        this.isUsernameVerified = usernameVerified;
    }

    public List<Storage> getStoredDetails()
    {
        return this.storedDetails;
    }

    public void setStoredDetails(List<Storage> storedDetails)
    {
        if (storedDetails == null || storedDetails.isEmpty())
        {
            throw new IllegalArgumentException("storedDetails cannot be null or empty");
        }
        for (Object storedDetailsItem : storedDetails)
        {
            if (storedDetailsItem == null)
            {
                throw new IllegalArgumentException("storedDetails cannot contain null");
            }
        }

        this.storedDetails = new ArrayList<>(storedDetails);
    }

//    ------------------------METHODS------------------------

    //    boolean return not used in this project but can be used in a larger program to verify if the input was valid or not
    public boolean validate(String username, String email, LocalDate dateOfBirth, String password)
    {
//        reject blank inputs
        if (username.isBlank())
        {
            throw new IllegalArgumentException("username cannot be blank");
        }

        if (email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be blank");
        }

        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

        if (password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be blank");
        }

//        Validate inputs...
        if (this.isUsernameVerified() && !VerifyUsername.isValid(username, this.getStoredDetails()))
        {
            return false;
        }

        if (this.isEmailVerified() && !VerifyEmail.isValid(email))
        {
            return false;
        }

        if (this.isAgeVerified && !VerifyAge.isValid(dateOfBirth, this.getMinimumAge()))
        {
            return false;
        }

        if (this.isPasswordVerified && !VerifyPassword.validatePassword(password, this.isPasswordSpacesAllowed,
            this.isPasswordSpecialCharactersMandatory, this.isPasswordNumbersRequired, this.isPasswordLowercaseSymbolRequired,
            this.isPasswordUppercaseSymbolRequired))
        {
            return false;
        }

        this.storeUserData(username, email, dateOfBirth, this.hashPassword(password));
        return true;
    }

    public boolean validate(String username, String email, LocalDate dateOfBirth, LocalDate dateToTestFrom, String password)
    {
//        reject blank inputs
        if (username.isBlank())
        {
            throw new IllegalArgumentException("username cannot be blank");
        }

        if (email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be blank");
        }

        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

        if (dateToTestFrom == null)
        {
            throw new IllegalArgumentException("dateToTestFrom cannot be null");
        }

        if (password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be blank");
        }

//        Validate inputs...
        if (this.isUsernameVerified() && !VerifyUsername.isValid(username, this.getStoredDetails()))
        {
            return false;
        }

        if (this.isEmailVerified() && !VerifyEmail.isValid(email))
        {
            return false;
        }

        if (this.isAgeVerified && !VerifyAge.isValid(dateOfBirth, this.getMinimumAge(), dateToTestFrom))
        {
            return false;
        }

        if (this.isPasswordVerified && !VerifyPassword.validatePassword(password, this.isPasswordSpacesAllowed,
            this.isPasswordSpecialCharactersMandatory, this.isPasswordNumbersRequired, this.isPasswordLowercaseSymbolRequired,
            this.isPasswordUppercaseSymbolRequired))
        {
            return false;
        }

        this.storeUserData(username, email, dateOfBirth, this.hashPassword(password));
        return true;
    }

    //    actually creates the storage class and adds it to the list of stored data
    private void storeUserData(String username, String email, LocalDate dateOfBirth, int passwordHash)
    {
        Storage storage = new Storage(username, email, dateOfBirth, passwordHash);
        this.getStoredDetails().add(storage);
    }

    //    I am aware that this is not secure, it's just an example :P
    public int hashPassword(String password)
    {
        return password.hashCode();
    }
}
