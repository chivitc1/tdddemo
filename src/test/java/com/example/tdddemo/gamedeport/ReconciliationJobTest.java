package com.example.tdddemo.gamedeport;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReconciliationJobTest
{
    ReconciliationJob job;
    @Mock
    FinancialTransactionDAO financialTransactionDAO;

    @Mock
    MembershipDAO membershipDAO;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        job = new ReconciliationJob(financialTransactionDAO,
                membershipDAO);
        MembershipStatusDto basicMembership = new MembershipStatusDto();
        basicMembership.setDeductable(0.30);
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

    @Test
    public void when_transaction_exists_then_membership_detail_is_retrieved_for_the_developer() throws Exception
    {
        List<TransactionDto> singleTxList = new ArrayList<>();
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTargetId("DEV001");
        singleTxList.add(transactionDto);

        // Stubbing
        when(financialTransactionDAO.retrieveUnSettledTransactions())
                .thenReturn(singleTxList);

        //Verify
        assertEquals(1, job.reconcile());
        verify(membershipDAO).getStatusFor(anyString());
    }

    @Test
    public void when_transaction_exists_then_membership_detail_is_retrieved_for_each_developer() throws Exception
    {
        // Prepare transactions
        List<TransactionDto> singleTxList = new ArrayList<>();
        TransactionDto dev001Transaction = new TransactionDto();
        String dev001Id = "dev001";
        dev001Transaction.setTargetId(dev001Id);

        TransactionDto dev002Transaction = new TransactionDto();
        String dev002Id = "dev002";
        dev002Transaction.setTargetId(dev002Id);

        singleTxList.add(dev001Transaction);
        singleTxList.add(dev002Transaction);

        // Stubbing
        when(financialTransactionDAO.retrieveUnSettledTransactions())
                .thenReturn(singleTxList);

        // Execute
        int count = job.reconcile();

        //Verify
        assertEquals(2, count);

        // Verify arguments were passed correctly
        ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);

        verify(membershipDAO, new Times(2)).getStatusFor(argCaptor.capture());
        List<String> passedValues = argCaptor.getAllValues();

        assertEquals(dev001Id, passedValues.get(0));
        assertEquals(dev002Id, passedValues.get(1));
    }
}
