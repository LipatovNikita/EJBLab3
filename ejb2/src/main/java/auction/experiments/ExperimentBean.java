package auction.experiments;

import auction.entity.Item;
import auction.facade.ItemFacade;
import bankaccount.entity.Account;
import bankaccount.facade.AccountFacade;

import javax.annotation.Resource;
import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ExperimentBean {

    @EJB
    ItemFacade itemOperation;
    @EJB
    AccountFacade accountOperation;
    @Resource
    SessionContext context;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String firstExperiment() {
        Item item = itemOperation.findById(1);
        debit(item.getPrice());
        item.setClosed(true);
        itemOperation.edit(item);
        if (!context.getRollbackOnly()) {
            return String.valueOf(accountOperation.findById(1).getCashAccount());
        }
        else {
            return "Неудача";
        }
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debit(int cash) {
        Account account = accountOperation.findById(1);
        account.setCashAccount(account.getCashAccount() - cash);
        accountOperation.edit(account);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String secondExperiment() {
        Item item = itemOperation.findById(2);
        item.setClosed(true);
        itemOperation.edit(item);
        blockAccount(item.getPrice());
        if (context.getRollbackOnly()) {
            return "Rollback состоялся";
        }
        else {
            return "Rollback не было";
        }
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void blockAccount(int cash) {
        Account account = accountOperation.findById(1);
        account.setCashAccount(account.getCashAccount() - cash);
        if (account.getCashAccount() > 0) {
            accountOperation.deleteWithRollback(account);
        }
        else {
            accountOperation.delete(account);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String thirdExperiment() {
        try {
            Item item = itemOperation.findById(3);
            int count = item.getCount();
            for (int i = 0; i < count; i++) {
                debit(item.getPrice());
                item.setCount(item.getCount() - 1);
            }
            itemOperation.deleteWithException(item);
        }
        catch (EJBException exception) {
            return "Транзакция закончена откатом";
        }
        return "EJBException не выкинут, почему-то";
    }


    public void fourthExperiment() {

    }

    public void fifthExperiment() {

    }
}
