package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class VerifyActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_verify) Button mBtn_verify;

  @InjectView(R.id.btn_retry) Button mBtn_retry;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VerifyActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_verify) void navigateToVerified() {
    this.mNavigator.navigateToCancer(this);
  }

  /**
   * Goes to the user verified screen.
   */
  @OnClick(R.id.btn_retry) void retryNewEmail() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Xemio");
    builder.setMessage("Esteban " + getText(R.string.str_dialog_reply));
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        positiveButton();
      }
    });
    builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        negativeButton();
      }
    });
    builder.show();
  }

  public void positiveButton() {
    Log.w(mLOGTAG, "OK pulsado");
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Xemio");
    builder.setMessage(
        "Esteban ha sido enviado un email a su cuenta de correo con un nuevo código de activación.");
    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        Log.w(mLOGTAG, "OK verificado pulsado");
      }
    });
    //builder.setPositiveButton("OK", null);
    //builder.setNegativeButton("CANCELAR", null);
    builder.show();
  }

  public void negativeButton() {
    Log.w(mLOGTAG, "Cancel pulsado");
    finish();
  }
}
