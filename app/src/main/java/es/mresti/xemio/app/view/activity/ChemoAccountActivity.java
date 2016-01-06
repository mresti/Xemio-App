package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.ChemoAccountContract;
import es.mresti.xemio.app.presenter.ChemoAccountPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import es.mresti.xemio.app.view.navigation.Navigator;
import java.util.HashMap;

public class ChemoAccountActivity extends BaseActivity implements ChemoAccountContract.View {

  private ChemoAccountContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mChemoDatasRef;
  private FirebaseListAdapter<HashMap> mChemoListAdapter;

  // UI items
  @Bind(R.id.listChemo) ListView mChemoList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ChemoAccountActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chemo);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new ChemoAccountPresenter(this);
    mChemoDatasRef = mActionsListener.getChemoRef();
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

  @Override protected void onStart() {
    super.onStart();

    mChemoListAdapter =
        new FirebaseListAdapter<HashMap>(mChemoDatasRef, HashMap.class, R.layout.list_1_item,
            this) {
          @Override protected void populateView(View v, final HashMap model) {
            final String key = ChemoAccountActivity.this.mChemoListAdapter.getModelKey(model);
            ((TextView) v.findViewById(R.id.item_title)).setText(model.get("chemo").toString());
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                showChemoDialog(key, model.get("chemo").toString());
              }
            });
          }
        };
    mChemoList.setAdapter(mChemoListAdapter);
    mChemoListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mChemoList.setSelection(mChemoListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mChemoListAdapter.cleanup();
  }

  private void showChemoDialog(final String key, String chemo) {
    AlertDialog.Builder builder = new AlertDialog.Builder(ChemoAccountActivity.this);
    builder.setTitle(getString(R.string.dialog_select_chemo));
    builder.setMessage(chemo);

    String positiveText = getString(android.R.string.ok);
    builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // positive button logic
        mActionsListener.setRegisterChemo(key);
      }
    });

    String negativeText = getString(android.R.string.cancel);
    builder.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // negative button logic
      }
    });

    AlertDialog dialog = builder.create();
    // display dialog
    dialog.show();
  }

  @Override public void openDashboard() {
    mNavigator.navigateToDashboard(this);
    finish();
  }
}
