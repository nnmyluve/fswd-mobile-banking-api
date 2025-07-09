package kh.edu.fswdmobilebankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

//change name table
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(unique = true, length = 100)
    private String email;

    @Column(unique = true, length = 10)
    private String phoneNumber;

    @Column(nullable = false, length = 2)
    private String gender;

    @Column(nullable = false)
    private String isDeleted;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    //Relationship (HAS-A)
    @OneToMany(mappedBy = "customer")
    private List<Account> account;

    @OneToOne(mappedBy = "customer")
    private KYC kyc;

}
