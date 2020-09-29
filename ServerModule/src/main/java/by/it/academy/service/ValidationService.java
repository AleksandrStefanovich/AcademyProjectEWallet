package by.it.academy.service;

import by.it.academy.model.Coin;
import by.it.academy.model.Transaction;
import by.it.academy.repository.Dao;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class ValidationService {
    @Autowired
    Dao<Coin> coinDao;

    @Autowired
    Dao<Transaction> transactionDao;

    public boolean validate(Coin coin) {
        Transaction transaction;
        if(coin.getTransaction() != null) {
            transaction = transactionDao.read(Transaction.class, coin.getTransaction());
        } else {transaction = null;}
        Coin previousCoin = coinDao.read(Coin.class, coin.getId() - 1);
        String previousHash = previousCoin.getHash();
        if (transaction != null) {
            transaction.setStatus("new");
            return hash(previousHash, transaction).equals(coin.getHash());
        } else {
            return hash(previousHash).equals(coin.getHash());
        }
    }

    @SneakyThrows
    private String hash(String lastCoinHash, Transaction transaction) {
        byte[] bytes = ArrayUtils.addAll(lastCoinHash.getBytes(), transaction.toString().getBytes());
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(bytes));

    }

    @SneakyThrows
    private String hash(String lastCoinHash) {
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(lastCoinHash.getBytes()));
    }
}
