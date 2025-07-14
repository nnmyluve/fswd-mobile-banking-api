package kh.edu.fswdmobilebankingapi.domain;

import jakarta.persistence.*;
//import kh.edu.fswdmobilebankingapi.controller.AccountType;
//import kh.edu.fswdmobilebankingapi.enums.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accNum;
    private Boolean isDeleted;
    private BigDecimal overLimit;
    private String actNo;

    @ManyToOne
    private Customer customer;


    @ManyToOne
//    @JoinColumn(name = "account_type_id")
    private AccountType accountType;


}
