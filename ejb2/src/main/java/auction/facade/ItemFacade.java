package auction.facade;

import auction.entity.Item;
import bankaccount.facade.AbstractFacade;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemFacade extends AbstractFacade<Item> {

    @Resource
    SessionContext context;

    @PersistenceContext(unitName = "auction")
    private EntityManager entityManager;

    public ItemFacade() {
        super(Item.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void deleteWithException(Item item) {
        getEntityManager().remove(getEntityManager().merge(item));
        if (!context.getRollbackOnly()) {
            throw new EJBException();
        }
    }
}
