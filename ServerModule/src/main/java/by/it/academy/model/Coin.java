package by.it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Coin implements Serializable {
    @Id
    private long id;
    @Column(name = "previous_hash")
    private String previousHash;
    private String hash;
    @Column(name = "transactions")
    private String transactions;
    private long timestamp;
}
