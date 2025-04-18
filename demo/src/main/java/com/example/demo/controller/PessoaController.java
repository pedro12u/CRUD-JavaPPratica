package com.example.demo.controller;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eliel/pessoas")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PessoaDTO> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO buscar(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO criar(@RequestBody PessoaDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public PessoaDTO atualizar(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.delete(id);
    }
}