package kh.edu.fswdmobilebankingapi.repository;

import kh.edu.fswdmobilebankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Integer> {


}
