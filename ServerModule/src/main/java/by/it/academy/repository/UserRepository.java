package by.it.academy.repository;

import by.it.academy.model.Role;
import by.it.academy.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserRepository implements Dao<User>, ApplicationContextAware {

    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void create(User user) {
        Role role = new Role();
        role.setRoleName("USER");
        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        sessionFactory.getCurrentSession()
                .saveOrUpdate(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User read(Class clazz, Serializable id) {
        return (User) sessionFactory.getCurrentSession()
                .get(clazz, id);
    }

    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession()
                .update(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    @Transactional(readOnly = true)
    public User find(String userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User u where u.userId=:userId", User.class)
                .setParameter("userId", userId)
                .list()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> readAll(String searchStr) {
        return null;
    }
}
