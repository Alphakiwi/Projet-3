
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.openclassrooms.entrevoisins.NewFunctionality.PresentationActivity;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.LaunchActivityAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private static int ITEMS_COUNT_STAR = 2;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 4
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, new DeleteViewAction()));
        // Then : the number of element is 11

        ITEMS_COUNT = ITEMS_COUNT - 1;
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
    }




    // mes tests que j'ai créé :


    @Test
    public void myNeighboursList_LauchDetailActivity() {

        Intents.init();

        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchActivityAction()));

        intended(hasComponent(PresentationActivity.class.getName()));

    }

    @Test
    public void myNeighboursList_DetailActivity_withGoodName() {

        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());


        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new LaunchActivityAction()));

        ViewInteraction textConfirmJack = onView(withId(R.id.lieuTel));
        textConfirmJack.check(matches(withText("Jack")));

        mDevice.pressBack();


        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchActivityAction()));

        ViewInteraction textConfirmChloé = onView(withId(R.id.lieuTel));
        textConfirmChloé.check(matches(withText("Chloé")));



    }


    @Test
    public void myNeighboursList_ScreenStarWithOnlyFavorite() {

        onView(withId(R.id.list_neighbours_star))
                .check(withItemCount(ITEMS_COUNT_STAR))
                .check(matches(hasDescendant(withText("Caroline"))))
                .check(matches(hasDescendant(withText("Patrick"))));

    }


    // pas demandé

    @Test
    public void myReunionsList_addItem() {

        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        onView(withId(R.id.fab)).perform(click());

        onView(withText("Valider")).perform(click());

        ITEMS_COUNT = ITEMS_COUNT + 1;

        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
    }



}


