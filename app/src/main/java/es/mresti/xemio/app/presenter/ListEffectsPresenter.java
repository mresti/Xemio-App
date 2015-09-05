package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.ListEffectsInteractor;
import es.mresti.xemio.app.view.ListEffectView;

public class ListEffectsPresenter implements Presenter {
  private ListEffectView mListEffectView;
  private ListEffectsInteractor mListEffectsInteractor;
  private Context mContext;

  public static ListEffectsPresenter newInstance(ListEffectView view,
      ListEffectsInteractor interactor) {
    ListEffectsPresenter presenter = new ListEffectsPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private ListEffectsPresenter(ListEffectView view, ListEffectsInteractor interactor) {
    mListEffectView = view;
    mListEffectsInteractor = interactor;
  }

  private void initialize() {
    mListEffectsInteractor.setPresenter(this);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  public void initializeContext(Context c) {
    mContext = c;
    mListEffectsInteractor.initialize(mContext);
  }

  public Firebase getRef() {
    return mListEffectsInteractor.getEffectListRef();
  }
}






