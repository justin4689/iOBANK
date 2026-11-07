package com.iobank.IOBANK.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_account")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    private String currency ;
    private String symbol ;
    private String code ;

    private String accountName ;

    @Column(nullable = false , unique = true)
    private String accountNumber ;

    private String balance ;

    private String label ;


    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updatedAt ;

    @OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions ;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner ;

}
