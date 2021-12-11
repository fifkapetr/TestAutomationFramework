package ness;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.ness.NessMainPage;

public class NessTests extends WebTestCase {

    @Test
    public void letsTalkTest() {
        new NessMainPage(true)
                .clickLetsTalkButton()
                .fillFirstName("Petr")
                .fillLastName("Testing")
                .selectContactReason("Sales Inquiry")
                .fillEmail("testing@randomrandom.uk")
                .clickSubmit();
    }

    @Test
    public void contactTest() {
        new NessMainPage(true)
                .clickContactAnchor()
                .fillFirstName("Petr")
                .fillLastName("Testing")
                .selectContactReason("Sales Inquiry")
                .fillEmail("testing@randomrandom.uk")
                .clickSubmit();
    }

    @Test
    public void openSlovakiaTalentRecruit() {
        new NessMainPage(true)
                .clickCareersAnchor()
                .clickSlovakiaAnchor()
                .clickFirstApply();
    }
}
