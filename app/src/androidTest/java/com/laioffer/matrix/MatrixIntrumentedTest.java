package com.laioffer.matrix;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MatrixIntrumentedTest {
    @Rule
    // <ControlPanel>:Test ControlPanel
    public ActivityTestRule<ControlPanel> activityTestRule =
            new ActivityTestRule<>(ControlPanel.class);

    @Test
    public void verifyMatrix() {
        // .check: check if Matrix is displayed
        onView(withText("Matrix")).check(matches(isDisplayed()));
    }

    @Test
    public void verifyLogin() {
        onView(withText("Account")).perform(click());

        //Replace the username & password to your credentials
        onView(withId(R.id.editTextLogin)).perform(ViewActions.clearText()).
                perform(ViewActions.typeText("11111"));
        onView(withId(R.id.editTextPassword)).perform(ViewActions.clearText()).
                perform(ViewActions.typeText("11111"));

        //Check login
        onView(withId(R.id.submit)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Check logcat
        onView(withText("LOGOUT")).check(matches(isDisplayed()));
    }

/*    @Test
    public void verifyReport(){
        onView(withId(R.id.fab)).perform(click());

        try{
            Tread.sleep(3000);
        } catch(exception ex) {
            ex.printStackTrace();
        }

        onView(withText("Police")).check(matches(isDisplayed()));
    }
*/



}
