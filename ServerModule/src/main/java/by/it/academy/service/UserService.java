package by.it.academy.service;

import by.it.academy.model.Transaction;
import by.it.academy.model.User;
import by.it.academy.model.Wallet;
import by.it.academy.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    Dao<User> userDao;

    @Autowired
    Dao<Wallet> walletDao;

    @Autowired
    Dao<Transaction> transactionDao;

    public boolean createNewUser(User user) {
        if(userDao.find(user.getUserId()) != null) return false;
        userDao.create(user);
        Wallet wallet = new Wallet(user.getId(), 0L);
        walletDao.create(wallet);
        if (userDao.read(User.class, user.getId()) != null &&
                walletDao.read(Wallet.class, user.getId()) != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean findUserByUserId(User user) {
        String userId = user.getUserId();
        String password = user.getPassword();
        User savedUser = userDao.find(userId);
        if (savedUser != null && savedUser.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }

    }

    public User getUserByUserId(String userId) { return userDao.find(userId); }

    public Wallet getWalletByUserId(String userId) {
        return walletDao.read(Wallet.class, userDao.find(userId).getId());
    }

    public List<Transaction> getTransactionsByUserId(String userId) {
        return transactionDao.readAll(userId);
    }

    public boolean createNewTransaction(Transaction transaction) {
        if (transaction.getAmount() < 0) return false;
        User sender = userDao.find(transaction.getSenderId());
        Wallet senderWallet = walletDao.read(Wallet.class, sender.getId());
        if (senderWallet.getBalance() < transaction.getAmount()) return false;
        User receiver = userDao.find(transaction.getReceiverId());
        Wallet receiverWallet = walletDao.read(Wallet.class, receiver.getId());
        long senderBalance = senderWallet.getBalance();
        long receiverBalance = receiverWallet.getBalance();
        senderBalance -= transaction.getAmount();
        receiverBalance += transaction.getAmount();
        senderWallet.setBalance(senderBalance);
        receiverWallet.setBalance(receiverBalance);
        walletDao.update(senderWallet);
        walletDao.update(receiverWallet);
        transactionDao.create(transaction);
        return true;
    }
}
