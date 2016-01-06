package es.mresti.xemio.app.view.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import es.mresti.xemio.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class) @LargeTest public class LoginAccountActivityInstrumentationTest {
  private static final String EMAIL = "name@domain.com";
  private static final String EMAIL_FAILED = "name@domain..com";
  private static final String PASS = "123456";
  private static final String PASS_FAILED = "12345";
  private static final String SUBJECT = "Incidence Subject";
  private static final String DESCRIPTION = "Incidence Description";

  @Rule public ActivityTestRule<LoginActivity> mActivityRule =
      new ActivityTestRule<>(LoginActivity.class);

  @Test public void loginSuccess_newActivity() {
    onView(withId(R.id.emailInput)).perform(typeText("test@xemio.com"));
    onView(withId(R.id.passInput)).perform(typeText(PASS), closeSoftKeyboard());
    onView(withId(R.id.btn_next)).perform(click());

    onView(withId(R.id.viewpager));
  }

  @Test public void loginFailed_emailError_sameActivity() {
    onView(withId(R.id.emailInput)).perform(typeText(EMAIL_FAILED));
    onView(withId(R.id.passInput)).perform(typeText(PASS), closeSoftKeyboard());
    onView(withId(R.id.btn_next)).perform(click());

    onView(withId(R.id.emailInput)).check(matches(withText(EMAIL_FAILED)));
  }

  @Test public void loginFailed_passError_sameActivity() {
    onView(withId(R.id.emailInput)).perform(typeText(EMAIL));
    onView(withId(R.id.passInput)).perform(typeText(PASS_FAILED), closeSoftKeyboard());
    onView(withId(R.id.btn_next)).perform(click());

    onView(withId(R.id.passInput)).check(matches(withText(PASS_FAILED)));
  }

  @Test public void loginSuccess_addIncidenceSuccess() {
    onView(withId(R.id.emailInput)).perform(typeText("test@xemio.com"));
    onView(withId(R.id.passInput)).perform(typeText(PASS), closeSoftKeyboard());
    onView(withId(R.id.btn_next)).perform(click());

    onView(withId(R.id.viewpager));

    onView(withId(R.id.action_incidence)).perform(click());

    onView(withId(R.id.subInput)).perform(typeText(SUBJECT));
    onView(withId(R.id.descInput)).perform(typeText(DESCRIPTION), closeSoftKeyboard());
    onView(withId(R.id.fab_submit)).perform(click());

    onView(withId(android.R.id.button1)).perform(click());

    onView(withId(R.id.viewpager));
  }
}
