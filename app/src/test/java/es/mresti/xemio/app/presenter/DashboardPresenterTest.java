package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.DashboardContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class DashboardPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private DashboardContract.View mDashboardView;
  //
  //private DashboardPresenter mDashboardPresenter;
  //
  //@Before public void setupDashboardPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mDashboardPresenter = new DashboardPresenter(mDashboardView);
  //}
  //
  //@Test public void getUserLogout_firebase() {
  //  doNothing().when(mDashboardPresenter).getUserLogout();
  //}
  //
  //@Test public void getUserStatus_emptyUserShowsMainUi() {
  //  mDashboardPresenter.getUserStatus();
  //  verify(mDashboardView).openMain();
  //}
}
