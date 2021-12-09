package ness;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.ness.NessMainPage;

public class NessTests extends WebTestCase {

    @Test
    public void contactUsFormFill() {
        new NessMainPage(true)
                .clickLetsTalkButton()
                .fillFirstName("Petr")
                .fillLastName("Testing")
                .selectContactReason("Sales Inquiry")
                .fillEmail("testing@randomrandom.uk")
                .clickSubmit();
    }
}
