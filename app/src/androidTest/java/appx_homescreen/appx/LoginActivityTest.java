package appx_homescreen.appx;

//Some Espresso Related imports
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.util.Log;

import android.support.test.InstrumentationRegistry;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*; //not()


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */


public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity>{
    private LoginActivity mActivity;

    public LoginActivityTest()
    {
        super(LoginActivity.class);
    }

    // The standard JUnit 3 setUp method run for for every test
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }


    public void testCreateAndValidateAccount_sameActivity()
    {
        /** NOTE: YOU NEED TO CHANGE THE ADDRESS AFTER EACH TIME YOU RUN THIS TEST (OR UPDATE DATABASE VERSION IN APP_X_USERS FILE)*/
        String emailAdr = "smithj@gmail.com";
        String firstName = "John";

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.link_to_register)).perform(click());

        onView(withId(R.id.prefix_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Mr."))).perform(click());
        onView(withId(R.id.prefix_spinner)).check(matches(withSpinnerText(is("Mr."))));

        onView(withId(R.id.editFirstName)).perform(typeText(firstName), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editLastName)).perform(typeText("Smith"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.editOccupation)).perform(typeText("Unknown"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editOrg)).perform(typeText("VCU"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.edLevel_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Some College"))).perform(click());
        onView(withId(R.id.edLevel_spinner)).check(matches(withSpinnerText(containsString("College"))));

        onView(withId(R.id.editEmail)).perform(clearText(), typeText(emailAdr), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editPassword)).perform(typeText("test"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.register)).perform(click());
        try { //we want to wait because RegisterActivity.class also waits before transitioning here
            Thread.sleep(2100);
            // Do some stuff
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editUsername)).check(matches(withText(emailAdr)));

        onView(withId(R.id.editPassword)).perform(typeText("test"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());

        //get the text which the fragment shows
        ViewInteraction fragmentText = onView(withId(R.id.welcomeUser));

        //check the fragments text is now visible in the activity
        fragmentText.check(matches(isDisplayed()));
        fragmentText.check(matches(withText("Welcome, " + firstName + "!")));

    }

}




