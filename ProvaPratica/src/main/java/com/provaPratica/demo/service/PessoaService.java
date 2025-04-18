package com.provaPratica.demo.service;

import com.provaPratica.demo.dto.PessoaDTO;
import com.provaPratica.demo.model.Pessoa;
import com.provaPratica.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> getAllPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(pessoa -> {
            PessoaDTO dto = new PessoaDTO();
            dto.setId(pessoa.getId());
            dto.setNome(pessoa.getNome());
            dto.setCpf(pessoa.getCpf());
            return dto;
        }).collect(Collectors.toList());
    }

    public PessoaDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa = pessoaRepository.save(pessoa);
        pessoaDTO.setId(pessoa.getId());
        return pessoaDTO;
    }

    public PessoaDTO updatePessoa(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa = pessoaRepository.save(pessoa);
        pessoaDTO.setId(pessoa.getId());
        return pessoaDTO;
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
