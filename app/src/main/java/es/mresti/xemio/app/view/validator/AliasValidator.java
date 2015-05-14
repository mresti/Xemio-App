package es.mresti.xemio.app.view.validator;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * An nickname format validator for {@link android.widget.EditText}.
 */
public class AliasValidator implements TextWatcher {

  private boolean mIsValid = false;

  public boolean isValid(){
    return mIsValid;
  }

  /**
   * Validates if the given input is a valid email address.
   *
   * @param text The email to validate.
   * @return {@code true} if the input is a valid email. {@code false} otherwise.
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
