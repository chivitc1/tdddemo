package com.example.tdddemo.gamedeport;

import java.util.List;

public interface FinancialTransactionDAO {
    List<TransactionDto> retrieveUnSettledTransactions();
}
