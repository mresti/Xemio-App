package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class CancerActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.spinner1) Spinner mSpinner_cancer;

  @InjectView(R.id.btn_next) Button mBtn_next;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, CancerActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cancer);

    ButterKnife.inject(this);
    this.initialize();
  }

  public void addListenerOnSpinnerItemSelection() {
    mSpinner_cancer.setOnItemSelectedListener(new CustomOnItemSelectedListener());
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    addListenerOnSpinnerItemSelection();
    this.mNavigator = new Navigator();
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Xemio");
    builder.setMessage("Esteban, su cuenta ha sido verificada.");
    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        Log.w(mLOGTAG, "OK verificado pulsado");
      }
    });
    builder.show();
  }

  /**
   * Goes to the user chemo screen.
   */
  @OnClick(R.id.btn_next) void navigateToVerified() {
    this.mNavigator.navigateToChemo(this);
  }
}
