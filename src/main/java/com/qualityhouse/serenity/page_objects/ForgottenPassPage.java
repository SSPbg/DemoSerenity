package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl( "http://automationpractice.com/index.php?controller=password" )

public class ForgottenPassPage extends PageObject {

    @FindBy( id = "email")
    public WebElementFacade emailForgotPass;

    @FindBy( css = "button.btn.btn-default.button.button-medium span")
    public WebElementFacade submitPasswordButton;

    @FindBy( className = "alert-success")
    public WebElementFacade successMessage;
}
