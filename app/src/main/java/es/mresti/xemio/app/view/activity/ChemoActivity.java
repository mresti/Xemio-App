package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;

public class ChemoActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.spinner1) Spinner mSpinner_chemo;

  @InjectView(R.id.btn_next) Button btn_next;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ChemoActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chemo);

    ButterKnife.inject(this);
    this.initialize();
  }

  public void addListenerOnSpinnerItemSelection() {
    mSpinner_chemo.setOnItemSelectedListener(new CustomOnItemSelectedListener());
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    addListenerOnSpinnerItemSelection();
    this.mNavigator = new Navigator();
  }

  /**
   * Goes to the user chemo screen.
   */
  @OnClick(R.id.btn_next) void navigateToVerified() {
    this.mNavigator.navigateToPass(this);
  }
}
