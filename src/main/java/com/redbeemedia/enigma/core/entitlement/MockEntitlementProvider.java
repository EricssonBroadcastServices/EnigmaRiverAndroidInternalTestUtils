package com.redbeemedia.enigma.core.entitlement;

import com.redbeemedia.enigma.core.entitlement.EntitlementStatus;
import com.redbeemedia.enigma.core.entitlement.IEntitlementProvider;
import com.redbeemedia.enigma.core.entitlement.IEntitlementRequest;
import com.redbeemedia.enigma.core.entitlement.IEntitlementResponseHandler;
import com.redbeemedia.enigma.core.error.UnexpectedError;

public class MockEntitlementProvider implements IEntitlementProvider {
    private final EntitlementStatus responseStatus;

    public MockEntitlementProvider() {
        this(EntitlementStatus.SUCCESS);
    }

    public MockEntitlementProvider(EntitlementStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public void checkEntitlement(IEntitlementRequest entitlementRequest, IEntitlementResponseHandler responseHandler) {
        try {
            responseHandler.onResponse(new EntitlementData(responseStatus));
        } catch (Exception e) {
            responseHandler.onError(new UnexpectedError(e));
        }
    }
}
