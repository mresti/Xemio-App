package es.mresti.xemio.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Cheeses;
import es.mresti.xemio.app.view.adapter.SimpleStringRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheeseListFragment extends Fragment {

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    RecyclerView rv =
        (RecyclerView) inflater.inflate(R.layout.fragment_cheese_list, container, false);
    setupRecyclerView(rv);
    return rv;
  }

  private void setupRecyclerView(RecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
        getRandomSublist(Cheeses.sCheeseStrings, 30)));
  }

  private List<String> getRandomSublist(String[] array, int amount) {
    ArrayList<String> list = new ArrayList<>(amount);
    Random random = new Random();
    while (list.size() < amount) {
      list.add(array[random.nextInt(array.length)]);
    }
    return list;
  }
}
