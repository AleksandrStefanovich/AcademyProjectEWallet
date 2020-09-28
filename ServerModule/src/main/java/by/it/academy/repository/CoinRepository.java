package by.it.academy.repository;

import by.it.academy.model.Coin;
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
public class CoinRepository  implements Dao<Coin>, ApplicationContextAware {
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Coin coin) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(coin);
    }

    @Override
    @Transactional(readOnly = true)
    public Coin read(Class clazz, Serializable id) {
        return (Coin) sessionFactory.getCurrentSession()
                .get(clazz, id);
    }

    @Override
    @Transactional
    public void update(Coin coin) {
        sessionFactory.getCurrentSession()
                .update(coin);
    }

    @Override
    public void delete(Coin coin) {

    }


    @Override
    @Transactional(readOnly = true)
    public List<Coin> readAll(String searchStr) {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery("from Coin c", Coin.class)
                    .list();
    }

    @Override
    public Coin find(String s) {
        return null;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
