package nytimes.siddarth.com.nytimes.ui;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;


import nytimes.siddarth.com.nytimes.R;
import nytimes.siddarth.com.nytimes.activity.NewsListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;





@RunWith(AndroidJUnit4.class)
public class NewsListActivityTest {

    private static final String APP_PACKAGE = "nytimes.siddarth.com.nytimes";
    private static final int TIMEOUT = 5000;


    @Rule
    public ActivityTestRule<NewsListActivity> mActivityRule = new ActivityTestRule<>(
            NewsListActivity.class);



    private UiDevice device;

    @Before
    public void startMainActivityFromHomeScreen() {


        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());


        device.pressHome();


        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIMEOUT);


        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(APP_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear out any previous instances
        context.startActivity(intent);


        device.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), TIMEOUT);

    }


    private String getLauncherPackageName() {

        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);


        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }


    @Test
    public void testClickNewsRow(){

        onView(withId(R.id.newsdata_list)).perform(RecyclerViewActions.actionOnItemAtPosition(4,click()));
    }



}