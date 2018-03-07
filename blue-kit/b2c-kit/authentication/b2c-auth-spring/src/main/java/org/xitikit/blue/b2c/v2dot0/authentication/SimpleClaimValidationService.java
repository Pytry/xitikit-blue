package org.xitikit.blue.b2c.v2dot0.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.xitikit.blue.api.b2c.v2dot0.configuration.AuthenticationProperties;
import org.xitikit.blue.common.properties.B2CProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static org.xitikit.blue.b2c.v2dot0.authentication.TimeComparison.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Component
public class SimpleClaimValidationService implements ClaimValidationService{

    private static final Logger log = LoggerFactory.getLogger(SimpleClaimValidationService.class);

    private final B2CProperties b2CProperties;

    private final AuthenticationProperties authenticationProperties;

    @Autowired
    public SimpleClaimValidationService(
        final B2CProperties b2CProperties,
        final AuthenticationProperties authenticationProperties){

        Assert.notNull(b2CProperties, "Missing required parameter 'b2CProperties' (org.xitikit.bluekit.b2c.v2dot0.authentication.interfaces.ClaimValidationService::new)");
        Assert.notNull(b2CProperties, "Missing required parameter 'authenticationProperties' (org.xitikit.bluekit.b2c.v2dot0.authentication.interfaces.ClaimValidationService::new)");

        this.b2CProperties = b2CProperties;
        this.authenticationProperties = authenticationProperties;
    }

    @Override
    public boolean validateAudience(final BlueWebToken token){

        return b2CProperties
            .getAppId()
            .equals(token.getAudience());
    }

    @Override
    public boolean validateNotBefore(
        @Nonnull final BlueWebToken token,
        @Nullable final Long now){

        Assert.notNull(token, "Missing required parameter 'token' (org.xitikit.bluekit.b2c.v2dot0.authentication.interfaces.ClaimValidationService::validateNotBefore)");

        // While unlikely, it's ok to be equal.
        return comparisonOf(
            token.getNotBefore(),
            paddedNow(now)
        ).isLessOrEqual();
    }

    private Long paddedNow(final Long now){

        return now == null ? null :
            now + authenticationProperties
                .getNotBefore()
                .getPaddingInMilliseconds();
    }

    @Override
    public boolean validateIssuer(@Nonnull final BlueWebToken blueWebToken){

        Assert.notNull(blueWebToken, "'blueWebToken' is required.");
        return VerificationUtil.validateIssuer(blueWebToken);
    }

    @Override
    public boolean validateExpiration(@Nonnull final BlueWebToken blueWebToken, final long now){

        Assert.notNull(blueWebToken, "'blueWebToken' is required.");
        return VerificationUtil.validateExpiration(blueWebToken, now);
    }
}
