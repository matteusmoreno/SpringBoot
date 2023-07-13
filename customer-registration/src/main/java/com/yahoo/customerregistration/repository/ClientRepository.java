package com.yahoo.customerregistration.repository;

import com.yahoo.customerregistration.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findAllByStatusTrue(Pageable page);
}
