package es.mresti.xemio.app.view.validator;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AlphaNumericValidatorTest {

    @Test
    public void alphaNumericValidator_CorrectAlpha(){
        assertTrue(AlphaNumericValidator.isValidText("Hello world"));
    }

    @Test
    public void alphaNumericValidator_CorrectNumeric(){
        assertTrue(AlphaNumericValidator.isValidText("12345"));
    }

    @Test
    public void alphaNumericValidator_CorrectAlphaNumeric(){
        assertTrue(AlphaNumericValidator.isValidText("Hello world 2015"));
    }

    @Test
    public void numericValidator_InvalidAlphaNumeric_OtherSymbol(){
        assertFalse(AlphaNumericValidator.isValidText("Hello world, 2015!!"));
    }

    @Test
    public void alphaNumericValidator_EmptyString(){
        assertFalse(AlphaNumericValidator.isValidText(""));
    }

    @Test
    public void alphaNumericValidator_NullNumeric(){
        assertFalse(AlphaNumericValidator.isValidText(null));
    }
}