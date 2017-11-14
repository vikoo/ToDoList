package com.vikoo.todo.screens.addtodo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.vikoo.todo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by vikoo on 14/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class AddTodoActivityTest {

    @Rule
    public ActivityTestRule<AddTodoActivity> mActivityRule
            = new ActivityTestRule<>(AddTodoActivity.class);

    private void loadUi(String title, String desc){
        onView(withId(R.id.input_title)).perform(replaceText(title));
        onView(withId(R.id.input_desc)).perform(replaceText(desc));
    }

    @Test
    public void launchActivity() throws Exception {
        onView(withId(R.id.btn_add_todo)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testError_titleNull() throws Exception {
        loadUi("", "test");
        onView(withId(R.id.btn_add_todo)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText(R.string.error_todo_title)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testError_descNull() throws Exception {
        loadUi("test ", "");
        onView(withId(R.id.btn_add_todo)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText(R.string.error_todo_desc)).check(matches(ViewMatchers.isDisplayed()));
    }

}