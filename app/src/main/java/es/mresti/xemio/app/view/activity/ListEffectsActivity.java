package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.ListEffectsPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.ListEffectView;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class ListEffectsActivity extends BaseActivity implements ListEffectView {
  public static final String TAG = "ListEffectsActivity";
  private Navigator mNavigator;
  private Firebase mEffectsDatasRef;
  private FirebaseListAdapter<HashMap> mEffectsListAdapter;
  private ListEffectsPresenter mPresenter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listTreatment) ListView mEffectsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ListEffectsActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_incidences);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getListEffectsPresenter(this);
    mNavigator = new Navigator();
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mPresenter.initializeContext(this.getContext());
    mEffectsDatasRef = mPresenter.getRef();
  }




  

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
