package com.example.demo.service;


import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {
    private final TrabalhoRepository repo;
    private final PessoaRepository pessoaRepo;

    public TrabalhoService(TrabalhoRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public List<TrabalhoDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TrabalhoDTO findById(Long id) {
        return repo.findById(id).map(this::toDTO).orElseThrow();
    }

    public TrabalhoDTO create(TrabalhoDTO dto) {
        Trabalho t = new Trabalho();
        t.setEndereco(dto.getEndereco());
        Pessoa p = pessoaRepo.findById(dto.getPessoaId()).orElseThrow();
        t.setPessoa(p);
        Trabalho salvo = repo.save(t);
        return toDTO(salvo);
    }

    public TrabalhoDTO update(Long id, TrabalhoDTO dto) {
        Trabalho t = repo.findById(id).orElseThrow();
        t.setEndereco(dto.getEndereco());
        Pessoa p = pessoaRepo.findById(dto.getPessoaId()).orElseThrow();
        t.setPessoa(p);
        return toDTO(repo.save(t));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private TrabalhoDTO toDTO(Trabalho t) {
        TrabalhoDTO dto = new TrabalhoDTO();
        dto.setId(t.getId());
        dto.setEndereco(t.getEndereco());
        dto.setPessoaId(t.getPessoa().getId());
        return dto;
    }
}