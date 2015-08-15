package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import es.mresti.xemio.R;
import fr.ganfra.materialspinner.MaterialSpinner;

public class IncidenceActivity extends BaseActivity {
  private ArrayAdapter<String> adapter1;
  private MaterialSpinner spinner2;

  @InjectView(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, IncidenceActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
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
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    String[] ITEMS = {
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 6", "Item 2", "Item 3",
        "Item 4", "Item 5", "Item 6", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"
    };
    adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    initSpinner();
  }

  private void initSpinner() {
    spinner2 = (MaterialSpinner) findViewById(R.id.spinner4);
    spinner2.setAdapter(adapter1);
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
}
