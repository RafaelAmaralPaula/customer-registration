package com.rafaelamaral.customerregistration.services;

import com.rafaelamaral.customerregistration.dto.ClientDTO;
import com.rafaelamaral.customerregistration.entities.Client;
import com.rafaelamaral.customerregistration.repositories.ClientRepository;
import com.rafaelamaral.customerregistration.services.exceptions.DataBaseException;
import com.rafaelamaral.customerregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client entity = new Client();
        copyDtoToEntity(entity , clientDTO);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try{
            Client entity = clientRepository.getOne(id);
            copyDtoToEntity(entity , clientDTO);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException("Id not found : " + id);
        }
    }

    public void delete(Long id) {
        try{
            clientRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){
            throw new ResourceNotFoundException("Id not found : " + id);
        }
        catch (DataIntegrityViolationException ex){
            throw new DataBaseException("Integrity Violation");
        }
    }


    private void copyDtoToEntity(Client entity, ClientDTO clientDTO) {
        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setIncome(clientDTO.getIncome());
        entity.setBirthDate(clientDTO.getBirthDate());
        entity.setChildren(clientDTO.getChildren());
    }


}
