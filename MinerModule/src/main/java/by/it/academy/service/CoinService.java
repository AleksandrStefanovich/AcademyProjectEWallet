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
        String lastCoinHash = coinRepository.findFirstByOrderByIdDesc().getHash();
        Transaction transaction = transactionRepository.findFirstByStatus("new");
        Coin coin = coinGenerator.generateCoin(lastCoinHash, transaction);
        coinRepository.save(coin);
        boolean result = coinRepository.existsById(coin.getId());
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
