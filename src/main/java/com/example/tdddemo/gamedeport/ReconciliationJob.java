package com.example.tdddemo.gamedeport;

import java.util.List;

public class ReconciliationJob {
     private FinancialTransactionDAO financialTransactionDAO;
     private MembershipDAO membershipDAO;

    public ReconciliationJob(FinancialTransactionDAO _financialTransactionDAO, MembershipDAO _membershipDAO) {
        this.financialTransactionDAO = _financialTransactionDAO;
        this.membershipDAO = _membershipDAO;
    }

    public int reconcile() {
        List<TransactionDto> unsettledTransactions =
                financialTransactionDAO.retrieveUnSettledTransactions();

        for (TransactionDto txDto : unsettledTransactions)
        {
            MembershipStatusDto membership =
                    membershipDAO.getStatusFor(txDto.getTargetId());
        }

        return unsettledTransactions.size();
    }
}
