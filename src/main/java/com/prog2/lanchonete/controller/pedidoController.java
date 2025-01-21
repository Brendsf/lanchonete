package com.prog2.lanchonete.controller;

import com.prog2.lanchonete.model.Pedido;
import com.prog2.lanchonete.service.ClienteService;
import com.prog2.lanchonete.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "pedido/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Pedido pedido) {
        pedidoService.salvar(pedido);
        return "redirect:/pedidos/consulta";
    }

    @GetMapping("/consulta")
    public String consulta(Model model) {
        List<Pedido> pedidos = pedidoService.listarTodos();
        model.addAttribute("pedidos", pedidos);
        return "pedido/consulta";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return "redirect:/pedidos/consulta";
    }
}