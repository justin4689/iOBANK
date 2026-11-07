package com.iobank.IOBANK.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId ;

    @Column(nullable = false , unique = true)
    private String cardNumber;
    private  String cardHolder ;
    private String balance ;

    private String billingAdress ;
    private Integer pin ;
    private  Integer cvv ;

    private LocalDateTime issueAt ;

    @CreationTimestamp
    private LocalDateTime createAt ;

    @UpdateTimestamp
    private LocalDateTime updateAt ;

    @OneToOne
    @JoinColumn(name = "owner_id" , unique = true)
    private UserEntity owner ;


    @OneToMany(mappedBy = "card" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions ;




}
