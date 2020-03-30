package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.AddressDetails;
import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.LoginPage;
import com.qualityhouse.serenity.steps.libraries.RegistrationActions;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static com.qualityhouse.serenity.page_objects.components.RegistrationFormComponent.REGISTER_BUTTON;
import static com.qualityhouse.serenity.page_objects.components.RegistrationFormComponent.REGISTRATION_ALERT;
import static com.qualityhouse.serenity.utils.Randomiser.randomizeValue;
import static com.qualityhouse.serenity.utils.TestObjectFactory.prepareTestObjectFrom;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationStepsDefinitions
{
    public HomePage homePage;

    @Steps
    private RegistrationActions mitko;

    @Given( "^(?:.*) has started an account registration with \"(.*)\" email$" )
    public void registrationProcessIsStarted( String email )
    {
        mitko.startsRegistrationWithEmail( randomizeValue( email ) );
    }

    @When( "^(?:.*) enters his personal details:$" )
    public void userEntersPersonalDetailsInRegistrationForm( @Transpose Map<String, String> rawUserData )
    {
        User user = prepareTestObjectFrom( User.class,
                rawUserData );
        randomizeValue( user.getEmail() );
        mitko.entersHisPersonalDetails( user );
    }

    @When( "^s?he enters his|her address details:$" )
    public void he_enters_his_address_details( @Transpose Map<String, String> rawAddressDetails )
    {
        AddressDetails addressDetails = prepareTestObjectFrom( AddressDetails.class,
                rawAddressDetails );

        mitko.entersHisAddressDetails( addressDetails );
    }

    @When( "^he submits his registration details$" )
    public void heSubmitsHisRegistrationDetails()
    {
        mitko.clicksOn( REGISTER_BUTTON );
    }

    @Then( "^error \"([^\"]*)\" message should display$" )
    public void errorMessageShouldDisplay( String errorMessage )
    {
        assertThat( mitko.readsTextFrom( REGISTRATION_ALERT ) ).containsIgnoringCase( errorMessage );
    }

    @Then("^the registration is successful$")
    public void the_registration_is_successful() {
        SoftAssertions assertSoftly = new SoftAssertions();
        assertSoftly.assertThat( mitko.canSeeElement( homePage.logOutMenu) )
                .as("Logout menu should be visible, when user is logged in")
                .isTrue();


    }
}
