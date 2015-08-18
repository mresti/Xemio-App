package es.mresti.xemio.app.view.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumericValidatorTest {

  @Test public void numericValidator_CorrectNumeric() {
    assertTrue(NumericValidator.isValidText("11"));
  }

  @Test public void numericValidator_InvalidNumeric_OneDot() {
    assertFalse(NumericValidator.isValidText("11."));
  }

  @Test public void numericValidator_InvalidNumeric_OtherSymbol() {
    assertFalse(NumericValidator.isValidText("11-!"));
  }

  @Test public void numericValidator_EmptyString() {
    assertFalse(NumericValidator.isValidText(""));
  }

  @Test public void numericValidator_NullNumeric() {
    assertFalse(NumericValidator.isValidText(null));
  }
}