package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ForgottenPassPage;
import com.qualityhouse.serenity.steps.libraries.ForgottenPasswordActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForgottenPassStepDefinitions {

    @Steps
            private ForgottenPasswordActions roki;

    ForgottenPassPage forgottenPassPage;

    @Given("^John is on the forgotten password page$")
            public void forgottenPassPageIsOpen(){
        forgottenPassPage.open();
    }

    @When("^John submit password request with \"([^\"]*)\" email$")
    public void johnSubmitPasswordRequestWithEmail(String email) {
        roki.requestsNewPasswordResetRequestWithEmail(email);

    }


    @Then("^success message \"([^\"]*)\" should be displayed$")
    public void successMessageShouldBeDisplayed(String successMessage)
    {

        assertThat( roki.readsTextFrom(forgottenPassPage.successMessage))
                .as("Success message should be displayed")
                .containsIgnoringCase(successMessage);
    }
}
