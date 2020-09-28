package by.it.academy.repository;

import by.it.academy.model.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class TransactionRepository implements Dao<Transaction>, ApplicationContextAware {

    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;


    @Override
    @Transactional
    public void create(Transaction transaction) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction read(Class clazz, Serializable id) {
        return (Transaction) sessionFactory.getCurrentSession()
                .get(clazz, id);
    }

    @Override
    @Transactional
    public void update(Transaction transaction) {
        sessionFactory.getCurrentSession()
                .update(transaction);
    }

    @Override
    public void delete(Transaction transaction) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> readAll(String searchStr) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Transaction t where t.senderId = :searchStr or t.receiverId = :searchStr", Transaction.class)
                .setParameter("searchStr", searchStr )
                .list();
    }

    @Override
    public Transaction find(String s) {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
