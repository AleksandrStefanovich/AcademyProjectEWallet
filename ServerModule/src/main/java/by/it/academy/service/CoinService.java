package by.it.academy.service;

import by.it.academy.model.Coin;
import by.it.academy.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  CoinService {

    @Autowired
    Dao<Coin> dao;

    public List<Coin> getAll() {
        return dao.readAll("");
    }

}
