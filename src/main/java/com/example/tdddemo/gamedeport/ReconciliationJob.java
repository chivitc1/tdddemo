package com.example.tdddemo.gamedeport;

import java.util.List;

public class ReconciliationJob {
     private FinancialTransactionDAO financialTransactionDAO;

    public ReconciliationJob(FinancialTransactionDAO _financialTransactionDAO) {
        this.financialTransactionDAO = _financialTransactionDAO;
    }

    public int reconcile() {
        List<TransactionDto> unsettledTransactions = financialTransactionDAO.retrieveUnSettledTransactions();
        return unsettledTransactions.size();
    }
}
