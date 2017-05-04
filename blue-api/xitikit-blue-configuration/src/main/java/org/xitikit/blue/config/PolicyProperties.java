package org.xitikit.blue.config;

import lombok.Data;

/**
 * Copyright Xitikit.org 2017
 *
 * @author J. Keith Hoopes
 */
@Data
public class PolicyProperties {
    /**
     * This is the exact name of the policy web flow given after it was created.
     * This will often be the name you typed in when configuring the policy, but with
     * a prefix of "B2C_1_" added to it.
     */
    private String name;
    /**
     * This is the registered redirect url inside of Azure for the named policy web flow.
     * The value will be passed along with the request when redirecting the user to Azure.
     * When the user finished authentication, it will be the url to which she is sent.
     */
    private String redirect;
    /**
     * Optional. If you have configured azure to use your custom HTML and CSS, this is the
     * endpoint where the template resource can be found. Remember that JAvaScript is not allowed.
     */
    private String template;
}