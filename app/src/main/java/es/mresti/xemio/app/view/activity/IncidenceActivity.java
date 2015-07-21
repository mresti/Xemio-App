package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import java.util.Calendar;

public class IncidenceActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {
  private String EXTRA_NAME;

  @InjectView(R.id.datepicker) TextView mDateTextView;

  @InjectView(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, IncidenceActivity.class);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incidence);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    setSupportActionBar(mToolbar);

    EXTRA_NAME = (String) getText(R.string.new_incidence);
    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
    String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
    //dateTextView.setText(date);
  }

  /**
   * Goes to the datepicker dialog.
   */
  @OnClick(R.id.datepicker)
  void setDate() {
    Calendar now = Calendar.getInstance();
    DatePickerDialog dpd = DatePickerDialog.newInstance(
        IncidenceActivity.this,
        now.get(Calendar.YEAR),
        now.get(Calendar.MONTH),
        now.get(Calendar.DAY_OF_MONTH)
    );
    dpd.show(getFragmentManager(), "Datepickerdialog");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_incidence, menu);
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
    //if (id == R.id.action_save) {
      //call function
    //  return true;
    //}
    return super.onOptionsItemSelected(item);
  }
}
