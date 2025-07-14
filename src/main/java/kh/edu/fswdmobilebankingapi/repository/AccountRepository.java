package kh.edu.fswdmobilebankingapi.repository;

import io.micrometer.observation.ObservationFilter;
import kh.edu.fswdmobilebankingapi.domain.Account;
import kh.edu.fswdmobilebankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository
        extends JpaRepository<Account, Integer> {

        Optional<Account> findByActNo(String actNo);
        List<Account> findByCustomer(Customer customer);



}
