package com.example.demo.service;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private final PessoaRepository repo;

    public PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }

    public List<PessoaDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) {
        return repo.findById(id).map(this::toDTO).orElseThrow();
    }

    public PessoaDTO create(PessoaDTO dto) {
        Pessoa p = new Pessoa();
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());
        Pessoa salvo = repo.save(p);
        return toDTO(salvo);
    }

    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa p = repo.findById(id).orElseThrow();
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());
        return toDTO(repo.save(p));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private PessoaDTO toDTO(Pessoa p) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setCpf(p.getCpf());
        return dto;
    }
}