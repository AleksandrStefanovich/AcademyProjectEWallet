package by.it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coin implements Serializable {
    @Id
    private long id;
    @Column(name = "previous_hash")
    private String previousHash;
    private String hash;
    private String transaction;
    private long timestamp;
}
