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
import com.mastercard.openbanking.client.model.ErrorMessage;
import com.mastercard.openbanking.client.model.Transaction;
import com.mastercard.openbanking.client.model.Transactions;
import com.mastercard.openbanking.client.model.TransactionsReportAck;
import com.mastercard.openbanking.client.model.TransactionsReportConstraints;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TransactionsApi
 */
@Disabled
public class TransactionsApiTest {

    private final TransactionsApi api = new TransactionsApi();

    /**
     * Generate Transactions Report
     *
     * Generate a Transaction Report for the given accounts under the given customer. This service retrieves up to 24 months of transaction history for the given customer. It then uses this information to generate the Transaction Report.  This is a premium service. A billable event will be created upon the successful generation of the Transactions Report.  Before calling this API, a consumer must be created for the given customer ID (see Consumers APIs).  There cannot be more than 24 months between &#x60;fromDate&#x60; and &#x60;toDate&#x60;.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void generateTransactionsReportTest() throws ApiException {
        String customerId = null;
        Long toDate = null;
        TransactionsReportConstraints transactionsReportConstraints = null;
        String callbackUrl = null;
        Boolean includePending = null;
        TransactionsReportAck response = api.generateTransactionsReport(customerId, toDate, transactionsReportConstraints, callbackUrl, includePending);
        // TODO: test validations
    }

    /**
     * Get All Customer Transactions
     *
     * Get all transactions available for this customer within the given date range, across all accounts. This service supports paging and sorting by &#x60;transactionDate&#x60; (or &#x60;postedDate&#x60; if no transaction date is provided), with a maximum of 1000 transactions per request.  Standard consumer aggregation provides up to 180 days of transactions prior to the date each account was added to the Finicity system. To access older transactions, you must first call the service Load Historic Transactions for Account.  There is no limit for the size of the window between &#x60;fromDate&#x60; and &#x60;toDate&#x60;, however, the maximum number of transactions returned on one page is 1000.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllCustomerTransactionsTest() throws ApiException {
        String customerId = null;
        Long fromDate = null;
        Long toDate = null;
        Integer start = null;
        Integer limit = null;
        String sort = null;
        Boolean includePending = null;
        Transactions response = api.getAllCustomerTransactions(customerId, fromDate, toDate, start, limit, sort, includePending);
        // TODO: test validations
    }

    /**
     * Get Customer Account Transactions
     *
     * Get all transactions available for this customer account within the given date range. This service supports paging and sorting by &#x60;transactionDate&#x60; (or &#x60;postedDate&#x60; if no transaction date is provided), with a maximum of 1000 transactions per request.  Standard consumer aggregation provides up to 180 days of transactions prior to the date each account was added to the Finicity system. To access older transactions, you must first call the Cash Flow Verification service Load Historic Transactions for Account.  There is no limit for the size of the window between &#x60;fromDate&#x60; and &#x60;toDate&#x60;, however, the maximum number of transactions returned on one page is 1000.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomerAccountTransactionsTest() throws ApiException {
        String customerId = null;
        String accountId = null;
        Long fromDate = null;
        Long toDate = null;
        Integer start = null;
        Integer limit = null;
        String sort = null;
        Boolean includePending = null;
        Transactions response = api.getCustomerAccountTransactions(customerId, accountId, fromDate, toDate, start, limit, sort, includePending);
        // TODO: test validations
    }

    /**
     * Get Customer Transaction by ID
     *
     * Get details for the given transaction.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomerTransactionTest() throws ApiException {
        String customerId = null;
        Long transactionId = null;
        Transaction response = api.getCustomerTransaction(customerId, transactionId);
        // TODO: test validations
    }

    /**
     * Load Historic Transactions for Customer Account
     *
     * Connect to the account&#39;s financial institution and load up to 24 months of historic transactions for the account. Length of history varies by institution.  This is a premium service. The billable event is a call to this service specifying a customer ID that has not been seen before by this service. (If this service is called multiple times with the same customer ID, to load transactions from multiple accounts, only one billable event has occurred.)  The recommended timeout setting for this request is 180 seconds in order to receive a response. However, you can terminate the connection after making the call the operation will still complete. You will have to pull the account records to check for an updated aggregation attempt date to know when the refresh is complete.  The date range sent to the institution is calculated from the account&#39;s &#x60;createdDate&#x60;. This means that calling this service a second time for the same account normally will not add any new transactions for the account. For this reason, a second call to this service for a known account ID will usually return immediately.  In a few specific scenarios, it may be desirable to force a second connection to the institution for a known account ID. Some examples are:  * The institution&#39;s policy has changed, making more transactions available * Finicity has now added a longer transaction history support for the institution * The first call encountered an error, and the resulting Aggregation Ticket has now been fixed by the Finicity Support Team  In these cases, the POST request can contain the parameter &#x60;force&#x3D;true&#x60; in the request body to force the second connection.  _Supported regions_: ![🇺🇸](https://flagcdn.com/20x15/us.png)
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void loadHistoricTransactionsForCustomerAccountTest() throws ApiException {
        String customerId = null;
        String accountId = null;
        api.loadHistoricTransactionsForCustomerAccount(customerId, accountId);
        // TODO: test validations
    }

}
