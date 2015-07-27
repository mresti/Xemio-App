package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;


public class DashboardActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.toolbar) Toolbar mToolbar;

  @InjectView(R.id.btn_inci) Button mBtn_inci;

  @InjectView(R.id.btn_web) Button mBtn_web;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, DashboardActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    setSupportActionBar(mToolbar);
    Log.i(mLOGTAG, "estoy en el inicialize");

    Snackbar.make(findViewById(R.id.main_content), "¡¡Bienvenido <alias>!!",
        Snackbar.LENGTH_LONG).setAction("Action", null).show();
  }

  /**
   * Goes to the xemio website.
   */
  @OnClick(R.id.btn_web)
  void navigateToXemioWeb() {
    this.mNavigator.navigateToXemioWeb(this);
  }

  /**
   * Goes to the incidence screen.
   */
  @OnClick(R.id.btn_inci)
  void navigateToIncidence() {
    this.mNavigator.navigateToNewIncidence(this);
  }
}
