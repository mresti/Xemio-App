package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.adapter.HistoryRecyclerAdapter;
import es.mresti.xemio.app.view.utils.DataDivider;

public class ListIncidencesActivity extends BaseActivity {

  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ListIncidencesActivity.class);
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
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // RecyclerView
    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);

    // RecyclerView layout manager
    final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(mLayoutManager);

    // RecyclerView ItemDecoration (divider)
    final RecyclerView.ItemDecoration itemDecoration = new DataDivider(this);
    recyclerView.addItemDecoration(itemDecoration);

    // RecyclerView adapter
    final HistoryRecyclerAdapter historyRecyclerAdapter = new HistoryRecyclerAdapter();
    recyclerView.setAdapter(historyRecyclerAdapter);

    final GestureDetector mGestureDetector = new GestureDetector(ListIncidencesActivity.this,
        new GestureDetector.SimpleOnGestureListener() {

          @Override public boolean onSingleTapUp(MotionEvent e) {
            return true;
          }
        });

    recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
      @Override
      public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
          Toast.makeText(ListIncidencesActivity.this,
              "The Item Clicked is: " + recyclerView.getChildLayoutPosition(child),
              Toast.LENGTH_SHORT).show();

          return true;
        }

        return false;
      }

      @Override public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

      }

      @Override public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

      }
    });
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
    return super.onOptionsItemSelected(item);
  }
}
