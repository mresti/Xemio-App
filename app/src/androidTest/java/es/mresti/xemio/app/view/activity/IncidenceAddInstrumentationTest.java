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

@RunWith(AndroidJUnit4.class) @LargeTest public class IncidenceAddInstrumentationTest {
  private static final String SUBJECT = "Incidence Subject";
  private static final String DESCRIPTION = "Incidence Description";

  @Rule public ActivityTestRule<IncidenceAddActivity> mActivityRule =
      new ActivityTestRule<>(IncidenceAddActivity.class);

  @Test public void addIncidenceSuccess_newActivity() {
    onView(withId(R.id.subInput)).perform(typeText("Incidence Subject"));
    onView(withId(R.id.descInput)).perform(typeText(DESCRIPTION), closeSoftKeyboard());
    onView(withId(R.id.fab_submit)).perform(click());

    onView(withId(R.id.viewpager));
  }

  @Test public void addIncidenceFailed_subjectFail_sameActivity() {
    onView(withId(R.id.subInput)).perform(typeText(""));
    onView(withId(R.id.descInput)).perform(typeText(DESCRIPTION), closeSoftKeyboard());
    onView(withId(R.id.fab_submit)).perform(click());

    onView(withId(R.id.subInput)).check(matches(withText("")));
  }

  @Test public void addIncidenceFailed_descriptionFail_sameActivity() {
    onView(withId(R.id.subInput)).perform(typeText(SUBJECT));
    onView(withId(R.id.descInput)).perform(typeText(""), closeSoftKeyboard());
    onView(withId(R.id.fab_submit)).perform(click());

    onView(withId(R.id.descInput)).check(matches(withText("")));
  }
}
