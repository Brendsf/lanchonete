package com.prog2.lanchonete.controller;

import com.prog2.lanchonete.model.Cliente;
import com.prog2.lanchonete.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cliente/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes/consulta";
    }

    @GetMapping("/consulta")
    public String consulta(@RequestParam(required = false) String nome, Model model) {
        List<Cliente> clientes = (nome != null) ? clienteService.buscarPorNome(nome) : clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/consulta";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes/consulta";
    }
}