package kh.edu.fswdmobilebankingapi.repository;

import kh.edu.fswdmobilebankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

//    List<Customer> findAllByIsDeletedFalse();
//
//
//    @Modifying
//    @Query(value = """
//UPDATE Customer c
//SET c.isDeteled= TRUE
//WHERE c.phoneNumber =?1
//
//""")
//
//    void disableByPhoneNumber(String phoneNumber);
}
