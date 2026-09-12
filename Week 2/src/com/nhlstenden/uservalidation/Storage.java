package com.nhlstenden.uservalidation;

import java.time.LocalDate;

public class Storage
{
    private String username;
    private String email;
    private LocalDate dateOfBirth;
    private int passwordHash;

    public Storage(String username, String email, LocalDate dateOfBirth, int passwordHash)
    {
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.passwordHash = passwordHash;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        if (username == null || username.isBlank())
        {
            throw new IllegalArgumentException("username cannot be null or blank");
        }

        this.username = username;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be null or blank");
        }

        this.email = email;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public int getPasswordHash()
    {
        return this.passwordHash;
    }

    public void setPasswordHash(int passwordHash)
    {
        if (passwordHash < 0)
        {
            throw new IllegalArgumentException("passwordHash cannot be less than 0");
        }

        this.passwordHash = passwordHash;
    }
}
