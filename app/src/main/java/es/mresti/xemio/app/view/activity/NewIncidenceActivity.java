package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.NewIncidencePresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.NewIncidenceView;

public class NewIncidenceActivity extends BaseActivity implements NewIncidenceView {

  public static final String TAG = "NewIncidenceActivity";
  private NewIncidencePresenter mPresenter;
  private Navigator mNavigator;

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.descInput) EditText mDescInput;
  @Bind(R.id.descInputLayout) TextInputLayout mDescInputLayout;
  @Bind(R.id.subInput) EditText mSubInput;
  @Bind(R.id.subInputLayout) TextInputLayout mSubInputLayout;
  @Bind(R.id.fab_submit) FloatingActionButton mFABSubmit;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, NewIncidenceActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_incidence);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getNewIncidencePresenter(this);
    mPresenter.initializeContext(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mNavigator = new Navigator();
  }

  @OnClick(R.id.fab_submit) void submitIncidence() {
    mSubInputLayout.setErrorEnabled(false);
    mDescInputLayout.setErrorEnabled(false);
    mPresenter.addIncidence(mSubInput.getText().toString(), mDescInput.getText().toString());
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_incidence, menu);
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

    //noinspection SimplifiableIfStatement
    //if (id == R.id.action_save) {
    //call function
    //  return true;
    //}
    return super.onOptionsItemSelected(item);
  }

  @Override public void setSubjectError() {
    mSubInputLayout.setErrorEnabled(true);
    mSubInputLayout.setError(getString(R.string.error_empty_field));
  }

  @Override public void setDescriptionError() {
    mDescInputLayout.setErrorEnabled(true);
    mDescInputLayout.setError(getString(R.string.error_empty_field));
  }

  @Override public void navigateToDashboard() {
    finish();
  }

  @Override public void showNotificationCreated() {
    MaterialDialog dialog =
        new MaterialDialog.Builder(this).title(R.string.dialog_title_new_incidence)
            .content(R.string.dialog_message_new_incidence)
            .positiveText(android.R.string.ok)
            .callback(new MaterialDialog.ButtonCallback() {
              @Override public void onPositive(MaterialDialog dialog) {
                navigateToDashboard();
              }
            })
            .show();
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
