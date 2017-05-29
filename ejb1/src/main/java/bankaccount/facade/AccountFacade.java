package bankaccount.facade;

import bankaccount.entity.Account;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    @Resource
    SessionContext context;

    @PersistenceContext(unitName = "sberbank")
    private EntityManager entityManager;

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void deleteWithRollback(Account account) {
        getEntityManager().remove(getEntityManager().merge(account));
        context.setRollbackOnly();
    }
}
