package by.it.academy.repository;

import by.it.academy.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findAllByStatus(String aNew);

    Transaction findFirstByStatus(String aNew);
}
