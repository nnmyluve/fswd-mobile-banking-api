package kh.edu.fswdmobilebankingapi.repository;

import kh.edu.fswdmobilebankingapi.domain.KYC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KYCRepository
        extends JpaRepository<KYC, String> {
}
