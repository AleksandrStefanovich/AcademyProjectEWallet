package by.it.academy.repository;

import by.it.academy.model.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long> {
    Coin findFirstByOrderByIdDesc();
}
