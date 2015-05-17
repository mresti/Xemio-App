package es.mresti.xemio.app.view.validator;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * A validator for {@link android.widget.EditText}.
 */
public class ContentValidator implements TextWatcher {

  private boolean mIsValid = false;

  public boolean isValid(){
    return mIsValid;
  }

  /**
   * Validates if the given input is not an empty string.
   *
   * @param text The text to validate.
   * @return {@code true} if the input is not an empty string. {@code false} otherwise.
   */
  public static boolean isValidText(CharSequence text) {
    return text != null && !text.toString().isEmpty();
  }

  @Override
  final public void afterTextChanged(Editable editableText) {
    mIsValid = isValidText(editableText);
  }

  @Override
  final public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

  @Override
  final public void onTextChanged(CharSequence s, int start, int before, int count) { }
}
