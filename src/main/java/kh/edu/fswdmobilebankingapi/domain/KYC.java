package kh.edu.fswdmobilebankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KYC {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String UUID;

    @Column(unique=true, nullable=false, length=10)
    private String nationalCardId;

    @Column(nullable=false)
    private Boolean isVerified;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne
    private Customer customer;
}
