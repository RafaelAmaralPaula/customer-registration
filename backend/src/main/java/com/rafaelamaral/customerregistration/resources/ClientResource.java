package com.rafaelamaral.customerregistration.resources;

import com.rafaelamaral.customerregistration.dto.ClientDTO;
import com.rafaelamaral.customerregistration.services.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>>findAllPaged(
            @RequestParam(value = "page" , defaultValue = "0")Integer page,
            @RequestParam(value = "linesPerPage" , defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy" , defaultValue = "name") String orderBy,
            @RequestParam(value = "direction" , defaultValue = "ASC") String direction
    ){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction) , orderBy);
        Page<ClientDTO> list = clientService.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
