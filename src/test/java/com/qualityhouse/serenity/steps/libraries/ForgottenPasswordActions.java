package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.ForgottenPassPage;
import net.thucydides.core.annotations.Step;

public class ForgottenPasswordActions extends BasesActions
{

    private ForgottenPassPage forgottenPassPage;

    @Step
    public void requestsNewPasswordResetRequestWithEmail(String email) {
        fillsFieldWithData( forgottenPassPage.emailForgotPass,
                email);
        clicksOn(forgottenPassPage.submitPasswordButton);
    }


}
