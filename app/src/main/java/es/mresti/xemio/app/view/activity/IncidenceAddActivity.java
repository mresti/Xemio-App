package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.IncidenceAddContract;
import es.mresti.xemio.app.presenter.IncidenceAddPresenter;
import es.mresti.xemio.app.view.navigation.Navigator;

public class IncidenceAddActivity extends BaseActivity implements IncidenceAddContract.View {

  private IncidenceAddContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.descInput) EditText mDescInput;
  @Bind(R.id.subInput) EditText mSubInput;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, IncidenceAddActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incidence_add);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new IncidenceAddPresenter(this);
    setSupportActionBar(mToolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
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
    AlertDialog.Builder builder = new AlertDialog.Builder(IncidenceAddActivity.this);
    builder.setTitle(getString(R.string.dialog_title_new_incidence));
    builder.setMessage(getString(R.string.dialog_message_new_incidence));

    String positiveText = getString(android.R.string.ok);
    builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // positive button logic
        openDashboard();
      }
    });

    AlertDialog dialog = builder.create();
    // display dialog
    dialog.show();
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
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }
}