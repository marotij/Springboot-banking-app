package com.codelab.Springbootbankingapp.repository;

import com.codelab.Springbootbankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
