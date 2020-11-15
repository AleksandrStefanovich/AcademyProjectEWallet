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

/*
service used for checking if coin is valid
 */

@Service
public class ValidationService {
    @Autowired
    Dao<Coin> coinDao;

    @Autowired
    Dao<Transaction> transactionDao;

    //check if coin is valid
    public boolean validate(Coin coin) {
        Transaction transaction;
        //load transaction if exists in coin
        if(coin.getTransaction() != null) {
            transaction = transactionDao.read(Transaction.class, coin.getTransaction());
        } else {transaction = null;}
        //load previous coin's hash
        Coin previousCoin = coinDao.read(Coin.class, coin.getId() - 1);
        String previousHash = previousCoin.getHash();
        //generating hash for coin and check if it is correct
        if (transaction != null) {
            transaction.setStatus("new");
            return hash(previousHash, transaction).equals(coin.getHash());
        } else {
            return hash(previousHash).equals(coin.getHash());
        }
    }

    //hash generator for coin with transaction inside
    @SneakyThrows
    private String hash(String lastCoinHash, Transaction transaction) {
        byte[] bytes = ArrayUtils.addAll(lastCoinHash.getBytes(), transaction.toString().getBytes());
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(bytes));

    }

    //hash generator for coin without transaction
    @SneakyThrows
    private String hash(String lastCoinHash) {
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(lastCoinHash.getBytes()));
    }
}
