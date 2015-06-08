package es.mresti.xemio.app;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import es.mresti.xemio.R;
import es.mresti.xemio.app.view.activity.LogInActivity;
import org.junit.After;
import org.junit.Before;
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

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LogInActivityInstrumentationTest {
  private static final String EMAIL = "email@domain.com";
  private static final String ALIAS = "Peter";

  @Rule
  public ActivityTestRule<LogInActivity> mActivityRule = new ActivityTestRule<>(
      LogInActivity.class);

  @Test
  public void sayHello(){
    onView(withId(R.id.emailInput)).perform(typeText(EMAIL), closeSoftKeyboard());
    onView(withId(R.id.aliasInput)).perform(typeText(ALIAS), closeSoftKeyboard());

    onView(withId(R.id.btn_save)).perform(click());
  }
}
