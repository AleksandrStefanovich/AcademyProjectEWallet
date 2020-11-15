package by.it.academy.service;

import by.it.academy.model.Coin;
import by.it.academy.model.Transaction;
import by.it.academy.repository.CoinRepository;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Date;
/*
Class is used to generate new coin(block)
 */

@Service
public class CoinGenerator {


    @Autowired
    CoinRepository coinRepository;


    public Coin generateCoin(String lastCoinHash, Transaction transaction) {
        Coin coin = new Coin();
        //setting of id for new coin
        coin.setId(coinRepository.findFirstByOrderByIdDesc().getId() + 1);
        //add previous coin hash to new coin
        coin.setPreviousHash(lastCoinHash);
        Date date = new Date();
        //new coin creation time
        coin.setTimestamp(date.getTime());
        //add transaction to coin if exists and generating coin's hash
        if (transaction != null) {
            coin.setTransaction(transaction.getId());
            coin.setHash(hash(lastCoinHash, transaction));
        }else {
            coin.setHash(hash(lastCoinHash));
        }
        return coin;
    }

    //generating hash for coin with transaction inside
    @SneakyThrows
    private String hash(String lastCoinHash, Transaction transaction) {
        byte[] bytes = ArrayUtils.addAll(lastCoinHash.getBytes(),transaction.toString().getBytes());
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(bytes));

    }

    //generating hash for coin without transaction
    @SneakyThrows
    private String hash(String lastCoinHash) {
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(lastCoinHash.getBytes()));
    }

}
