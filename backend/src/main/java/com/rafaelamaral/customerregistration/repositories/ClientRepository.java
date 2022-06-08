package com.rafaelamaral.customerregistration.repositories;

import com.rafaelamaral.customerregistration.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client , Long> {
}
