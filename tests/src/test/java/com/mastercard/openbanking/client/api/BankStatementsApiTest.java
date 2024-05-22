/*
 * Open Banking
 * OpenAPI specification for Finicity APIs.  Open Banking solutions in the US are provided by Finicity, a Mastercard company.
 *
 * The version of the OpenAPI document: 1.17.1
 * Contact: apisupport@mastercard.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.mastercard.openbanking.client.api;

import com.mastercard.openbanking.client.ApiException;
import com.mastercard.openbanking.client.model.CustomerAccountMultipleStatements;
import com.mastercard.openbanking.client.model.ErrorMessage;
import java.io.File;
import com.mastercard.openbanking.client.model.StatementReportAck;
import com.mastercard.openbanking.client.model.StatementReportConstraints;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BankStatementsApi
 */
@Disabled
public class BankStatementsApiTest {

    private final BankStatementsApi api = new BankStatementsApi();

    /**
     * Generate Statement Report
     *
     * Generate a Statement Report for the given accounts under the given customer.  This is a premium service. A billable event will be created upon the successful generation of the Statement Report.  Before calling this API, a consumer must be created for the given customer ID (see Consumers APIs).  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void generateStatementReportTest() throws ApiException {
        String customerId = null;
        StatementReportConstraints statementReportConstraints = null;
        String callbackUrl = null;
        StatementReportAck response = api.generateStatementReport(customerId, statementReportConstraints, callbackUrl);
        // TODO: test validations
    }

    /**
     * Get Customer Account Multiple Statements
     *
     * This endpoint retrieves account statements for a given customer. The maximum number of statements that can be returned is 24.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomerAccountMultipleStatementTest() throws ApiException {
        String customerId = null;
        String accountId = null;
        String index = null;
        CustomerAccountMultipleStatements response = api.getCustomerAccountMultipleStatement(customerId, accountId, index);
        // TODO: test validations
    }

    /**
     * Get Customer Account Statement
     *
     * Retrieve the customer&#39;s bank statements in PDF format. Up to 24 months of history is available depending on the financial institution. Since this is a premium service, charges incur per each successful statement retrieved.  For certified financial institutions, statements are available for the following account types: * Checking * Savings * Money market * CDs * Investments * Mortgage * Credit cards * Loans * Line of credit * Student Loans  Note: setting the timeout to 180 seconds is recommended to allow enough time for a response.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomerAccountStatementTest() throws ApiException {
        String customerId = null;
        String accountId = null;
        Integer index = null;
        String type = null;
        File response = api.getCustomerAccountStatement(customerId, accountId, index, type);
        // TODO: test validations
    }

}
