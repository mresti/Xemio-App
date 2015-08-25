package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.CancerPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.CancerView;
import fr.ganfra.materialspinner.MaterialSpinner;

public class CancerActivity extends BaseActivity implements CancerView {

  private CancerPresenter presenter;
  private Navigator mNavigator;
  private ArrayAdapter<String> adapter;

  // UI items
  @Bind(R.id.btn_next) Button mBtn_next;
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.spinner) MaterialSpinner mSpinner;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, CancerActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cancer);
    ButterKnife.bind(this);
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
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    mSpinner.setAdapter(adapter);
  }

  /**
   * Goes to the user chemo screen.
   */
  @OnClick(R.id.btn_next) void navigateToVerified() {
    presenter.setCancer();
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

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
