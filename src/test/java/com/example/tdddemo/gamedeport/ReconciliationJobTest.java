package com.example.tdddemo.gamedeport;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ReconciliationJobTest
{
    ReconciliationJob job;
    @Mock
    FinancialTransactionDAO financialTransactionDAO;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        job = new ReconciliationJob(financialTransactionDAO);
    }

    @Test
    public void when_no_transactions_to_process_job_returns_processing_count_zero() throws Exception
    {
        // Execute reconcile()
        int numberOfTx = job.reconcile();

        // Verify
        assertEquals(0, numberOfTx);
    }

    @Test
    public void when_a_transaction_takeplaces_then_returns_processing_count_one() throws Exception
    {
        //Prepare transaction list
        List<TransactionDto> singleTxList = new ArrayList<>();
        singleTxList.add(new TransactionDto());

        //Stubbing retrieve method
        when(financialTransactionDAO.retrieveUnSettledTransactions())
                .thenReturn(singleTxList);

        // Execute reconcile()
        int numberOfTx = job.reconcile();

        // Verify
        assertEquals(1, numberOfTx);
    }
}
