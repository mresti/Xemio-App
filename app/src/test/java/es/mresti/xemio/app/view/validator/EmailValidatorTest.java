package es.mresti.xemio.app.view.validator;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmailValidatorTest {

  @Test
  public void emailValidator_CorrectEmail() {
    assertTrue(EmailValidator.isValidEmail("name@domain.com"));
  }

  @Test
  public void emailValidator_CorrectEmail_SubDomain() {
    assertTrue(EmailValidator.isValidEmail("name@domain.co.uk"));
  }

  @Test
  public void emailValidator_InvalidEmail_NoDomain() {
    assertFalse(EmailValidator.isValidEmail("name@domain"));
  }

  @Test
  public void emailValidator_InvalidEmail_DoubleDot() {
    assertFalse(EmailValidator.isValidEmail("name@domain..com"));
  }

  @Test
  public void emailValidator_InvalidEmail_NoUsername() {
    assertFalse(EmailValidator.isValidEmail("@domain.com"));
  }

  @Test
  public void emailValidator_EmptyString() {
    assertFalse(EmailValidator.isValidEmail(""));
  }

  @Test
  public void emailValidator_NullEmail() {
    assertFalse(EmailValidator.isValidEmail(null));
  }

}