package by.it.academy.service;

import by.it.academy.model.Coin;
import by.it.academy.model.Transaction;
import by.it.academy.model.User;
import by.it.academy.model.Wallet;
import by.it.academy.repository.CoinRepository;
import by.it.academy.repository.TransactionRepository;
import by.it.academy.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
logic of creating new coin(block)
 */

@Service
public class CoinService {

    @Autowired
    CoinRepository coinRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    CoinGenerator coinGenerator;

    public boolean createCoin(User user) {
        //first it finds last coin hash
        String lastCoinHash = coinRepository.findFirstByOrderByIdDesc().getHash();
        //second it finds not approved(new) transactions
        Transaction transaction = transactionRepository.findFirstByStatus("new");
        //then it generates new coin
        Coin coin = coinGenerator.generateCoin(lastCoinHash, transaction);
        //and saves coin
        coinRepository.save(coin);
        //check to find out if coin is saved
        boolean result = coinRepository.existsById(coin.getId());
        //then we give user who mined coin a reward of 1 coin to user's wallet
        //and set transaction status to "approved" if we have a transaction in coin
        if (result) {
            Wallet wallet = walletRepository.findById(user.getId()).orElse(null);
            long balance = wallet.getBalance();
            balance += 1;
            wallet.setBalance(balance);
            walletRepository.save(wallet);
            if(transaction != null) {
                transaction.setStatus("approved");
                transactionRepository.save(transaction);
            }
            return true;
        } else {return false;}
    }
}
