package by.it.academy.repository;

import by.it.academy.model.Coin;
import by.it.academy.model.Transaction;
import by.it.academy.model.Wallet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class Dao {
//
//
//    SessionFactory sessionFactory;
//
//    public Coin getLastCoin() {
//        return read(getMaxId());
//    }
//
//    public long getMaxId() {
//        return (long)sessionFactory.getCurrentSession()
//                .createQuery("max(id) from coin")
//                .list()
//                .stream()
//                .findFirst()
//                .orElse(0);
//
//
//    }
//    public Coin read(long id){
//        return sessionFactory.getCurrentSession()
//                .createQuery("from Coin c where c.id=:id", Coin.class)
//                .setParameter("id", id)
//                .list()
//                .stream()
//                .findFirst()
//                .orElse(null);
//    }
//
//    public boolean create(Coin coin) {
//        sessionFactory.getCurrentSession()
//                .saveOrUpdate(coin);
//        if(read(coin.getId()) == null){
//            return false;
//        } else{
//            return true;
//        }
//    }
//
//    public Wallet findWallet(String id) {
//        return sessionFactory.getCurrentSession()
//                .createQuery("from Wallet w where w.id=:id", Wallet.class)
//                .setParameter("id",id)
//                .list()
//                .stream()
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void updateWallet(Wallet wallet) {
//        sessionFactory.getCurrentSession()
//                .saveOrUpdate(wallet);
//    }
//
//    public List<Transaction> getTransactions() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("from Transaction t where t.status=:status")
//                .setParameter("status", "new")
//                .list();
//
//    }
}
