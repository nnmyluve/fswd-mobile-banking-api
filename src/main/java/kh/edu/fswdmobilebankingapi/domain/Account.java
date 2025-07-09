package kh.edu.fswdmobilebankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String actNo;
    private double balance;
    private BigDecimal overLimit;
    private boolean isDeleted;

    //mappedBy ចងគ្នាទៅវិញទៅមក
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "id")
    private Customer customer;
}
