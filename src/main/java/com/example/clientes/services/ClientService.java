package com.example.clientes.services;

import com.example.clientes.dto.ClientDTO;
import com.example.clientes.repositories.ClientRepository;
import com.example.clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return new ClientDTO(clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));
    }
}
