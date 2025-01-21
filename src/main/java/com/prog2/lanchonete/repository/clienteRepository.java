package com.prog2.lanchonete.repository;

import com.prog2.lanchonete.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContaining(String nome);
    List<Cliente> findByCpf(String cpf);
}