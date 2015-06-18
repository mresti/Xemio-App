package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;


public class CalendarDetailsActivity extends BaseActivity{
  private String EXTRA_NAME;

  @InjectView(R.id.datepicker) TextView mDateTextView;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, IncidenceActivity.class);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incidence);

    EXTRA_NAME = (String) getText(R.string.new_incidence);

    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle(EXTRA_NAME);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  /**
   * Goes to the datepicker dialog.
   */
  @OnClick(R.id.datepicker)
  void setDate() {
    AlertDialog.Builder builder =
        new AlertDialog.Builder(this);
    builder.setTitle("Dialog");
    builder.setMessage("Lorem ipsum dolor ....");
    builder.setPositiveButton("OK", null);
    builder.setNegativeButton("Cancel", null);
    builder.show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_incidence, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if(id == android.R.id.home){
      finish();
    }

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_save) {
      //call function
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
