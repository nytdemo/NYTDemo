package nytimes.siddarth.com.nytimes.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import nytimes.siddarth.com.nytimes.activity.NewsListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NewsDetailActivityTest {

    @Rule
    public ActivityTestRule<NewsListActivity> mActivityRule = new ActivityTestRule<>(
            NewsListActivity.class);


    @Before
    public void addData(){


    }

    @Test
    public void testBackClick(){

      //  onView(withId(android.R.id.home)).perform(click());
    }
}
