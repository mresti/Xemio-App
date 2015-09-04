package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.afollestad.materialdialogs.MaterialDialog;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.ChemoPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.ChemoView;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class ChemoActivity extends BaseActivity implements ChemoView {

  public static final String TAG = "ChemoActivity";
  private Navigator mNavigator;
  private Firebase mChemoDatasRef;
  private FirebaseListAdapter<HashMap> mChemoListAdapter;
  private ChemoPresenter mPresenter;

  // UI items
  @Bind(R.id.btn_next) Button mBtn_next;
  @Bind(R.id.listChemo) ListView mChemoList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ChemoActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chemo);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getChemoPresenter(this);
    mNavigator = new Navigator();
    mBtn_next.setVisibility(View.GONE);
    mPresenter.initializeContext(this.getContext());
    mChemoDatasRef = mPresenter.getRef();
  }

  @Override protected void onStart() {
    super.onStart();

    mChemoListAdapter =
        new FirebaseListAdapter<HashMap>(mChemoDatasRef, HashMap.class, R.layout.item_list_1_tv,
            this) {

          @Override protected void populateView(View v, final HashMap model) {
            final String key = ChemoActivity.this.mChemoListAdapter.getModelKey(model);
            ((TextView) v.findViewById(R.id.item_title)).setText(model.get("chemo").toString());
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                selectChemoItem(key, model.get("chemo").toString());
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

  private void selectChemoItem(final String key, String chemo) {
    MaterialDialog dialog = new MaterialDialog.Builder(this).title(R.string.dialog_select_chemo)
        .content(chemo)
        .positiveText(android.R.string.ok)
        .negativeText(android.R.string.cancel)
        .callback(new MaterialDialog.ButtonCallback() {
          @Override public void onPositive(MaterialDialog dialog) {
            mPresenter.setChemo(key);
          }

          @Override public void onNegative(MaterialDialog dialog) {
          }
        })
        .show();
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void navigateToDashboardScreen() {
    mNavigator.navigateToDashboard(this);
  }
}
