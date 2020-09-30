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


@Service
public class CoinGenerator {


    @Autowired
    CoinRepository coinRepository;


    public Coin generateCoin(String lastCoinHash, Transaction transaction) {
        Coin coin = new Coin();
        coin.setId(coinRepository.findFirstByOrderByIdDesc().getId() + 1);
        coin.setPreviousHash(lastCoinHash);
        Date date = new Date();
        coin.setTimestamp(date.getTime());
        if (transaction != null) {
            coin.setTransaction(transaction.getId());
            coin.setHash(hash(lastCoinHash, transaction));
        }else {
            coin.setHash(hash(lastCoinHash));
        }
        return coin;
    }

    @SneakyThrows
    private String hash(String lastCoinHash, Transaction transaction) {
        byte[] bytes = ArrayUtils.addAll(lastCoinHash.getBytes(),transaction.toString().getBytes());
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(bytes));

    }

    @SneakyThrows
    private String hash(String lastCoinHash) {
        MessageDigest m = MessageDigest.getInstance("MD5");
        return MD5Encoder.encode(m.digest(lastCoinHash.getBytes()));
    }

}
