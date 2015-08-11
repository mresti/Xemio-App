package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.CancerPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.CancerView;
import fr.ganfra.materialspinner.MaterialSpinner;

public class CancerActivity extends BaseActivity implements CancerView {

  private static final String mLOGTAG = "LogsAndroid";
  private CancerPresenter presenter;
  private Navigator mNavigator;
  private static final String[] ITEMS =
      { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6" };
  private ArrayAdapter<String> adapter1;
  private MaterialSpinner spinner2;

  // UI items
  @InjectView(R.id.btn_next) Button mBtn_next;
  @InjectView(R.id.progress) ProgressBar mProgress;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, CancerActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cancer);

    ButterKnife.inject(this);
    this.initialize();
    presenter = PresenterFactory.getCancerPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    String[] ITEMS = {
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 6", "Item 2", "Item 3",
        "Item 4", "Item 5", "Item 6", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"
    };
    adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    initSpinner();

    MaterialDialog dialog = new MaterialDialog.Builder(this).title(R.string.app_name)
        .content(R.string.dialog_user_ok)
        .neutralText(R.string.dialog_ok)
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onNeutral(MaterialDialog dialog) {
            Log.w(mLOGTAG, "OK verificado pulsado");
          }
        })
        .show();
  }

  /**
   * Goes to the user chemo screen.
   */
  @OnClick(R.id.btn_next) void navigateToVerified() {
    presenter.setCancer();
  }

  private void initSpinner() {
    spinner2 = (MaterialSpinner) findViewById(R.id.spinner4);
    spinner2.setAdapter(adapter1);
  }

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
  }

  @Override public void navigateToChemoScreen() {
    this.mNavigator.navigateToChemo(this);
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return null;
  }
}
