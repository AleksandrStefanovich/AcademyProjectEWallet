package by.it.academy.repository;

import by.it.academy.model.Wallet;
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
public class WalletRepository implements Dao<Wallet>, ApplicationContextAware {
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Wallet wallet) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(wallet);
    }

    @Override
    @Transactional(readOnly = true)
    public Wallet read(Class clazz, Serializable id) {
        return (Wallet) sessionFactory.getCurrentSession()
                .get(clazz, id);
    }

    @Override
    @Transactional
    public void update(Wallet wallet) {
        sessionFactory.getCurrentSession()
                .update(wallet);
    }

    @Override
    public void delete(Wallet wallet) {

    }

    @Override
    public List<Wallet> readAll(String searchStr) {
        return null;
    }

    @Override
    public Wallet find(String s) {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
