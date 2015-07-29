package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import fr.ganfra.materialspinner.MaterialSpinner;

public class CancerActivity extends BaseActivity {
  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  private static final String[] ITEMS =
      { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6" };

  private ArrayAdapter<String> adapter1;

  MaterialSpinner spinner2;

  @InjectView(R.id.btn_next) Button mBtn_next;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, CancerActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cancer);

    ButterKnife.inject(this);
    this.initialize();
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

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Xemio");
    builder.setMessage("Esteban, su cuenta ha sido verificada.");
    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        Log.w(mLOGTAG, "OK verificado pulsado");
      }
    });
    builder.show();
  }

  /**
   * Goes to the user chemo screen.
   */
  @OnClick(R.id.btn_next) void navigateToVerified() {
    this.mNavigator.navigateToChemo(this);
  }

  private void initSpinner() {
    spinner2 = (MaterialSpinner) findViewById(R.id.spinner4);
    spinner2.setAdapter(adapter1);
  }
}
