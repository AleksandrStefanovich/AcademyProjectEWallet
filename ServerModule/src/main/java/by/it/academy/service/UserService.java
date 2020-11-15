package by.it.academy.service;

import by.it.academy.model.Transaction;
import by.it.academy.model.User;
import by.it.academy.model.Wallet;
import by.it.academy.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
Service for
            -creation of new user
            -loading user info
            -loading user's transaction history
            -creating new transactions
 */
@Service
public class UserService {

    @Autowired
    Dao<User> userDao;

    @Autowired
    Dao<Wallet> walletDao;

    @Autowired
    Dao<Transaction> transactionDao;

    //creation of new user
    public boolean createNewUser(User user) {
        //check if user with this username already exists
        if(userDao.find(user.getUserId()) != null) return false;
        //add user to database
        userDao.create(user);
        //automaticly create wallet for new user
        Wallet wallet = new Wallet(user.getId(), 0L);
        walletDao.create(wallet);
        //check if creation was succesful
        if (userDao.read(User.class, user.getId()) != null &&
                walletDao.read(Wallet.class, user.getId()) != null){
            return true;
        } else {
            return false;
        }
    }
    //used for logging in
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

    //loading user info
    public User getUserByUserId(String userId) { return userDao.find(userId); }

    public Wallet getWalletByUserId(String userId) {
        return walletDao.read(Wallet.class, userDao.find(userId).getId());
    }

    //loading user transactions
    public List<Transaction> getTransactionsByUserId(String userId) {
        return transactionDao.readAll(userId);
    }

    //creating new transaction for user
    public boolean createNewTransaction(Transaction transaction) {
        //check if transaction amount not negative
        if (transaction.getAmount() < 0) return false;
        //get sender info
        User sender = userDao.find(transaction.getSenderId());
        Wallet senderWallet = walletDao.read(Wallet.class, sender.getId());
        //check if user has enough coins
        if (senderWallet.getBalance() < transaction.getAmount()) return false;
        //get receiver info
        User receiver = userDao.find(transaction.getReceiverId());
        if (receiver == null) return false;
        Wallet receiverWallet = walletDao.read(Wallet.class, receiver.getId());
        //proccessing coins transfer
        long senderBalance = senderWallet.getBalance();
        long receiverBalance = receiverWallet.getBalance();
        senderBalance -= transaction.getAmount();
        receiverBalance += transaction.getAmount();
        senderWallet.setBalance(senderBalance);
        receiverWallet.setBalance(receiverBalance);
        //saving result to database
        walletDao.update(senderWallet);
        walletDao.update(receiverWallet);
        transactionDao.create(transaction);
        return true;
    }
}
