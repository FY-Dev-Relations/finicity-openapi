package com.mastercard.openbanking.client.api;

import com.mastercard.openbanking.client.ApiException;
import com.mastercard.openbanking.client.test.BaseTest;
import com.mastercard.openbanking.client.test.utils.AccountUtils;
import com.mastercard.openbanking.client.test.ModelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppRegistrationApiTest extends BaseTest {

    private final AppRegistrationApi api = new AppRegistrationApi(apiClient);

    @Test
    void registerAppTest() {
        try {
            var application = ModelFactory.newApplication();
            var registeredApplication = api.registerApp(application);
            assertNotNull(registeredApplication.getPreAppId());
            assertEquals("P", registeredApplication.getStatus());
        } catch (ApiException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getAppRegistrationStatusTest() {
        try {
            var statuses = api.getAppRegistrationStatus(null, null, null, null, null, null, null, null);
            assertNotNull(statuses.getNumberOfRecordsPerPage());
            assertNotNull(statuses.getPageNumber());
            assertNotNull(statuses.getTotalPages());
            assertNotNull(statuses.getTotalRecords());
        } catch (ApiException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void modifyAppRegistrationTest() {
        try {
            var application = ModelFactory.newApplication();
            var preAppId = api.registerApp(application).getPreAppId();
            application.setAppDescription("Updated description");
            var updatedApplication = api.modifyAppRegistration(String.valueOf(preAppId), application);
            assertEquals(preAppId, updatedApplication.getPreAppId());
            assertEquals("P", updatedApplication.getStatus());
        } catch (ApiException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void migrateInstitutionLoginAccountsTest() {
        try {
            var accountApi = new AccountsApi(apiClient);
            var existingAccount = AccountUtils.getCustomerAccounts(accountApi, CUSTOMER_ID).get(0);
            var existingInstitutionLoginId = existingAccount.getInstitutionLoginId();
            // Enable this to actually migrate accounts
            // var accounts = api.migrateInstitutionLoginAccounts(CUSTOMER_ID, String.valueOf(existingInstitutionLoginId));
            // assertTrue(accounts.getAccounts().size() > 0);
        } catch (ApiException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void setCustomerAppIDTest() {
        try {
            api.setCustomerAppID(CUSTOMER_ID, "1234");
        } catch (ApiException e) {
            // {"code":10007,"message":"invalid application id"}
            logApiException(e);
            assertErrorCodeEquals(10007, e);
            assertErrorMessageEquals("invalid application id", e);
        }
    }
}
