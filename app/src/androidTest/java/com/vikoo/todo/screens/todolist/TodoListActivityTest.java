package com.vikoo.todo.screens.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.vikoo.todo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by vikoo on 14/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class TodoListActivityTest {

    @Rule
    public ActivityTestRule<TodoListActivity> mActivityRule
            = new ActivityTestRule<>(TodoListActivity.class, true, false);

    public void startActivityWithParams(Date date){
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, TodoListActivity.class);
        if(date != null){
            intent.putExtra(TodoListActivity.EXTRA_DATE, date);
        }
        mActivityRule.launchActivity(intent);
    }

    @Test
    public void launchActivity() throws Exception {
        startActivityWithParams(new Date());
        onView(ViewMatchers.withId(R.id.todo_list_view)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void launchAddActivity() throws Exception {
        startActivityWithParams(new Date());
        onView(ViewMatchers.withId(R.id.btn_add_todo)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.input_layout_title)).check(matches(ViewMatchers.isDisplayed()));
    }

}