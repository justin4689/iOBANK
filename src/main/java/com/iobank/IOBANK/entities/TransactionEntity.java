package com.iobank.IOBANK.entities;

import com.iobank.IOBANK.enums.Status;
import com.iobank.IOBANK.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private  Double amount;
    private Double txFee;
    private String sender ;
    private String receiver ;
    private LocalDateTime updateAt ;
    private LocalDateTime createdAt ;

    private Status status  ;
    private Type  type ;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity card ;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

}

