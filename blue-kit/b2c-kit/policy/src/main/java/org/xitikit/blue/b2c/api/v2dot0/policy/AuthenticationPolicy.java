package org.xitikit.blue.b2c.api.v2dot0.policy;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public interface AuthenticationPolicy{

  /**
   * @return {@link String}: the name of the
   *   configured or custom policy in Azure AD B2C.   *
   *   Example: "B2C_1_Xitikit_ChangeEmail"
   *
   * @see AuthenticationPolicy::setName
   */
  String getName();

  /**
   * @param name {@link String}: the name of the
   *   configured or custom policy in Azure AD B2C.   *
   *
   *   Example: "B2C_1_Xitikit_ChangeEmail"
   *
   * @see AuthenticationPolicy::getName
   */
  void setName(final String name);

  /**
   * @return {@link String}: the url to be used to redirect
   *   the user that is currently on/in your website or
   *   application to the "Azure AD B2C" policy.
   *
   *   Example: "https://localhost:8443/change-email"
   *
   * @see AuthenticationPolicy::getRedirectUrl
   */
  String getRedirectUrl();

  /**
   * @param redirectUrl {@link String}: the url to be used
   *   to redirect user that is currently on/in you website or
   *   application to the Azure AD B2C policy.
   *
   *   Example: "https://localhost:8443/change-email"
   *
   * @see AuthenticationPolicy::getRedirectUrl
   */
  void setRedirectUrl(final String redirectUrl);

  /**
   * @return {@link String}: The url that will be used by the
   *   "Azure AD B2C" directory to retrieve the html that will be
   *   used for inserting the B2C elements, CSS, and JavaScript.
   *
   * @see AuthenticationPolicy::setTemplateUrl
   */
  String getTemplateUrl();

  /**
   * @param templateUrl {@link String}: The url that will be used
   *   by the "Azure AD B2C" directory to retrieve the html that will
   *   be used for inserting the B2C elements, CSS, and JavaScript.
   *
   * @see AuthenticationPolicy::getTemplateUrl
   */
  void setTemplateUrl(final String templateUrl);

  /**
   * @return true if this policy isor should not be used.
   */
  boolean isDisabled();

  void setDisabled(final boolean disabled);
}