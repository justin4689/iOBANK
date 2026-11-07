package com.iobank.IOBANK.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    private String firstName;
    private  String lasName ;

    @Column(nullable = false , unique = true)
    private String userName ;


    private Date dob ;
    private long tel ;
    private String tag;
    private String password ;
    private String gender  ;


    @CreationTimestamp
    private LocalDateTime createAt ;

    @UpdateTimestamp
    private LocalDateTime updatedAt ;


    @OneToOne(cascade = CascadeType.ALL , mappedBy = "owner")
    private CardEntity card;


    @OneToMany(mappedBy = "owner" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions ;


    @OneToMany(mappedBy = "owner" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<AccountEntity> accounts ;


}
