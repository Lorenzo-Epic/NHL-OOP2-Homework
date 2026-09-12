package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest
{
    Validator validatorAll;
    Validator validatorUsername;
    Validator validatorEmail;
    Validator validatorBirthdate;
    Validator validatorPassword;

    @BeforeEach
    void setUp()
    {
        this.validatorAll = new Validator(true, false, true, true, true, true, true, 13, true, true);
        this.validatorUsername = new Validator(false, false, true, true, true, true, false, 13, false, true);
        this.validatorEmail = new Validator(false, false, true, true, true, true, false, 13, true, false);
        this.validatorBirthdate = new Validator(false, false, true, true, true, true, true, 13, false, false);
        this.validatorPassword = new Validator(true, false, true, true, true, true, false, 13, false, false);
    }

    @Test
    void validate_checkEverythingAllCorrect_returnsTrue()
    {
        assertTrue(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(1999, 2, 23), "Password123!"));
    }

    @Test
    void validate_checkEverythingUsernameAlreadyExists_returnsFalse()
    {
        this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(1999, 2, 23), "Password123!");
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(1999, 2, 23), "Password123!"));
    }

    @Test
    void validate_checkEverythingInvalidEmailNoAtOrDot_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "lorenzoatnhl", LocalDate.of(1999, 2, 23), "Password123!"));
    }

    @Test
    void validate_checkEverythingInvalidEmailAtNoDot_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "lorenzo@nhl", LocalDate.of(1999, 2, 23), "Password123!"));
    }

    @Test
    void validate_checkEverythingInvalidEmailDotNoAt_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "lorenzo.nhl", LocalDate.of(1999, 2, 23), "Password123!"));
    }

    @Test
    void validate_checkEverythingOneDayTooYoung_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 1), "Password123!"));
    }

    @Test
    void validate_checkEverythingDayOfBirthday_returnsTrue()
    {
        assertTrue(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "Password123!"));
    }

    @Test
    void validate_checkEverythingDayAfterBirthday_returnsTrue()
    {
        assertTrue(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 3), "Password123!"));
    }

    @Test
    void validate_checkEverythingPasswordContainsSpace_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "Password 123!"));
    }

    @Test
    void validate_checkEverythingPasswordDoesNotContainSpecialCharacters_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "Password123"));
    }

    @Test
    void validate_checkEverythingPasswordDoesNotContainNumbers_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "Password!"));
    }

    @Test
    void validate_checkEverythingPasswordDoesNotContainLowercaseSymbols_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "VERYLOUDPASSWORD!"));
    }

    @Test
    void validate_checkEverythingPasswordDoesNotContainUppercaseSymbols_returnsFalse()
    {
        assertFalse(this.validatorAll.validate("EpicGamerLorenzo", "nocivelli.lorenzo@nhlstenden.com", LocalDate.of(2000, 1, 2), LocalDate.of(2013, 1, 2), "veryquietpassword????"));
    }

    @Test
    void validate_checkUsernameOnlyAllElseViolates_returnsTrue()
    {
        assertTrue(this.validatorUsername.validate("EpicGamerLorenzo", "email", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), "paswor"));
    }

    @Test
    void validate_checkEmailOnlyAllElseViolates_returnsTrue()
    {
        this.validatorEmail.validate("EpicGamerLorenzo", "good@email.com", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), "paswor");
        assertTrue(this.validatorUsername.validate("EpicGamerLorenzo", "good@email.com", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), "paswor"));
    }

    @Test
    void validate_checkAgeOnlyAllElseViolates_returnsTrue()
    {
        this.validatorEmail.validate("EpicGamerLorenzo", "suboptimalemail", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), "paswor");
        assertTrue(this.validatorUsername.validate("EpicGamerLorenzo", "bademail", LocalDate.of(2000, 1, 1), LocalDate.of(2013, 1, 1), "paswor"));
    }

    @Test
    void validate_checkPasswordOnlyAllElseViolates_returnsTrue()
    {
        this.validatorEmail.validate("EpicGamerLorenzo", "suboptimalemail", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), "paswor");
        assertTrue(this.validatorUsername.validate("EpicGamerLorenzo", "bademail", LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 1), "1GoodPassword!"));
    }
}
