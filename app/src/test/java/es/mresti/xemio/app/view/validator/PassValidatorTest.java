package es.mresti.xemio.app.view.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassValidatorTest {

  @Test public void characterValidator_CorrectAllCharacters_Pass_1() {
    assertTrue(PassValidator.isValidText("asdASDn12!"));
  }

  @Test public void characterValidator_CorrectAllCharacters_Pass_2() {
    assertTrue(PassValidator.isValidText("asdASDn12$"));
  }

  @Test public void characterValidator_CorrectAllCharacters_Pass_3() {
    assertTrue(PassValidator.isValidText("asdASDn12$%&"));
  }

  @Test public void characterValidator_CorrectLowersCharacters() {
    assertTrue(PassValidator.isValidText("asdASDn12$%&"));
  }

  @Test public void characterValidator_CorrectUppersCharacters() {
    assertTrue(PassValidator.isValidText("asdASDn12$%&"));
  }

  @Test public void characterValidator_CorrectCharacters() {
    assertTrue(PassValidator.isValidText("asdASDn12$%&"));
  }

  @Test public void characterValidator_CorrectNumeric() {
    assertTrue(PassValidator.isValidText("123456"));
  }

  @Test public void characterValidator_CorrectSymbol() {
    assertTrue(PassValidator.isValidText("!#$%&/"));
  }

  @Test public void characterValidator_CorrectAlphaNumeric() {
    assertTrue(PassValidator.isValidText("123owSM"));
  }

  @Test public void characterValidator_InvalidAlphaNumericSpace() {
    assertFalse(PassValidator.isValidText("Hello world 2015"));
  }

  @Test public void characterValidator_InvalidAllCharactersSpace() {
    assertFalse(PassValidator.isValidText("Hello world, 2015!!"));
  }

  @Test public void characterValidator_InvalidTooShort() {
    assertFalse(PassValidator.isValidText("12aA@"));
  }

  @Test public void characterValidator_InvalidTooLong() {
    assertFalse(PassValidator.isValidText("1234ab@1234ab@1234ab@1234ab@"));
  }

  @Test public void characterValidator_InvalidSpaceaSymbol() {
    assertFalse(PassValidator.isValidText("1234abA$v 1234abA$"));
  }

  @Test public void characterValidator_EmptyString() {
    assertFalse(PassValidator.isValidText(""));
  }

  @Test public void characterValidator_NullNumeric() {
    assertFalse(PassValidator.isValidText(null));
  }
}
