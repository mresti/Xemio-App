package es.mresti.xemio.app.view.validator;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.regex.Pattern;

/**
 * A validator for {@link android.widget.EditText}.
 */
public class NumericValidator implements TextWatcher {

  /**
   * Numeric validation pattern.
   */
  public static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

  private boolean mIsValid = false;

  public boolean isValid() {
    return mIsValid;
  }

  /**
   * Validates if the given input is a numeric string.
   *
   * @param text The text to validate.
   * @return {@code true} if the input is a numeric string. {@code false} otherwise.
   */
  public static boolean isValidText(CharSequence text) {
    return text != null && NUMERIC_PATTERN.matcher(text).matches();
  }

  @Override final public void afterTextChanged(Editable editableText) {
    mIsValid = isValidText(editableText);
  }

  @Override final public void beforeTextChanged(CharSequence s, int start, int count, int after) {
  }

  @Override final public void onTextChanged(CharSequence s, int start, int before, int count) {
  }
}
