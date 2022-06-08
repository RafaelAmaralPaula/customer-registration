package com.rafaelamaral.customerregistration.services;

import com.rafaelamaral.customerregistration.dto.ClientDTO;
import com.rafaelamaral.customerregistration.entities.Client;
import com.rafaelamaral.customerregistration.repositories.ClientRepository;
import com.rafaelamaral.customerregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = clientRepository.findAll(pageRequest);
        return list.map(obj -> new ClientDTO(obj));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        return new ClientDTO(entity);
    }
}
