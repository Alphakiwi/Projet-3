package com.openclassrooms.entrevoisins.utils;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class VerifyTextAction  implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "verify text";
    }

    @Override
    public void perform(UiController uiController, View view) {

        ViewInteraction text = onView(withId(R.id.item_list_name));
        text.check(matches(withText("Jack")));



    }
}