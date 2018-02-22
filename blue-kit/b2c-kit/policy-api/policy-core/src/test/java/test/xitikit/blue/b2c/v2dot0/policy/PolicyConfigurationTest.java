package test.xitikit.blue.b2c.v2dot0.policy;

import org.junit.jupiter.api.Test;
import org.xitikit.blue.b2c.v2dot0.policy.*;

import static org.junit.jupiter.api.Assertions.*;

class PolicyConfigurationTest{

    @Test
    void testDefaultWYSIWYG(){

        PolicyConfiguration props = new PolicyConfiguration();
        assertNull(props.getEditProfile());
        assertNull(props.getResetPassword());
        assertNull(props.getSignIn());
        assertNull(props.getSignOut());
        assertNull(props.getSignUp());
        assertNull(props.getSignUpOrSignIn());
    }

    @Test
    void testAllArgsWYSIWYG(){

        PolicyConfiguration props = new PolicyConfiguration(
            null, null, null, null, null, null, null
        );
        assertNull(props.getEditProfile());
        assertNull(props.getEditProfile());
        assertNull(props.getResetPassword());
        assertNull(props.getSignIn());
        assertNull(props.getSignOut());
        assertNull(props.getSignUp());
        assertNull(props.getSignUpOrSignIn());

        props = new PolicyConfiguration(
            null,
            new EditProfilePolicy(),
            new ResetPasswordPolicy(),
            new SignInPolicy(),
            new SignOutPolicy(),
            new SignUpPolicy(),
            new SignUpOrSignInPolicy()
        );

        assertNotNull(props.getEditProfile());
        assertNotNull(props.getResetPassword());
        assertNotNull(props.getSignIn());
        assertNotNull(props.getSignOut());
        assertNotNull(props.getSignUp());
        assertNotNull(props.getSignUpOrSignIn());
    }

    @Test
    void testSetterWYSIWYG(){

        PolicyConfiguration props = new PolicyConfiguration();
        assertNull(props.getEditProfile());
        assertNull(props.getResetPassword());
        assertNull(props.getSignIn());
        assertNull(props.getSignOut());
        assertNull(props.getSignUp());
        assertNull(props.getSignUpOrSignIn());

        props.setSignUp(new SignUpPolicy());
        props.setSignIn(new SignInPolicy());
        props.setSignUpOrSignIn(new SignUpOrSignInPolicy());
        props.setResetPassword(new ResetPasswordPolicy());
        props.setEditProfile(new EditProfilePolicy());
        props.setSignOut(new SignOutPolicy());
    }
}