package by.it.academy.service;

import by.it.academy.model.Coin;
import by.it.academy.model.Transaction;
import by.it.academy.repository.CoinRepository;
import by.it.academy.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CoinGenerator {


    @Autowired
    CoinRepository coinRepository;

    public Coin generateCoin(String lastCoinHash, List<Transaction> transactions) {
        Coin coin = new Coin();
        coin.setId(coinRepository.findFirstByOrderByIdDesc().getId()+1);
        coin.setPreviousHash(lastCoinHash);
     //   coin.setTimestamp(timestamp.getTime());
        coin.setTransactions(hash(transactions));
        coin.setHash(hash(lastCoinHash, transactions));
        return coin;
    }
    private String hash(List<Transaction> transactions){
        return transactions.hashCode() + "";
    }
    private String hash(String lastCoinHash, List<Transaction> transactions) {

        return (lastCoinHash + hash(transactions)).hashCode()+"";

    }
}
