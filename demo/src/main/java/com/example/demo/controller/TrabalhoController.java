package com.example.demo.controller;

import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.service.TrabalhoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eliel/trabalhos")
public class TrabalhoController {
    private final TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrabalhoDTO> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TrabalhoDTO buscar(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrabalhoDTO criar(@RequestBody TrabalhoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TrabalhoDTO atualizar(@PathVariable Long id, @RequestBody TrabalhoDTO dto) {
        return service.update(id, dto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.delete(id);
    }
}