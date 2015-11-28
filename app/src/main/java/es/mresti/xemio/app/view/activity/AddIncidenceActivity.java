package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.AddIncidenceContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.AddIncidencePresenter;

public class AddIncidenceActivity extends BaseActivity implements AddIncidenceContract.View {

  private AddIncidenceContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.descInput) EditText mDescInput;
  @Bind(R.id.subInput) EditText mSubInput;
  @Bind(R.id.fab_submit) FloatingActionButton mFABSubmit;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, AddIncidenceActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_incidence);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new AddIncidencePresenter(this);
    mActionsListener.initializeActions(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void resume() {
    super.onResume();
  }

  @Override public void pause() {
    super.onPause();
  }

  @Override public void setSubjectError() {

  }

  @Override public void setDescriptionError() {
  }

  @Override public void openDashboard() {
    finish();
  }

  @Override public void showNotificationCreated() {
    MaterialDialog dialog =
        new MaterialDialog.Builder(this).title(R.string.dialog_title_new_incidence)
            .content(R.string.dialog_message_new_incidence)
            .positiveText(android.R.string.ok)
            .callback(new MaterialDialog.ButtonCallback() {
              @Override public void onPositive(MaterialDialog dialog) {
                openDashboard();
              }
            })
            .show();
  }

  @OnClick(R.id.fab_submit) void submitIncidence() {
    mActionsListener.addIncidence(mSubInput.getText().toString(), mDescInput.getText().toString());
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_send, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == android.R.id.home) {
      finish();
    }
    return super.onOptionsItemSelected(item);
  }
}