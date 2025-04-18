package com.provaPratica.demo.service;

import com.provaPratica.demo.dto.TrabalhoDTO;
import com.provaPratica.demo.model.Trabalho;
import com.provaPratica.demo.repository.TrabalhoRepository;
import com.provaPratica.demo.model.Pessoa;
import com.provaPratica.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<TrabalhoDTO> getAllTrabalhos() {
        List<Trabalho> trabalhos = trabalhoRepository.findAll();
        return trabalhos.stream().map(trabalho -> {
            TrabalhoDTO dto = new TrabalhoDTO();
            dto.setId(trabalho.getId());
            dto.setEndereco(trabalho.getEndereco());
            return dto;
        }).collect(Collectors.toList());
    }

    public TrabalhoDTO createTrabalho(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = new Trabalho();
        trabalho.setEndereco(trabalhoDTO.getEndereco());

        if (trabalhoDTO.getId() != null) {
            Pessoa pessoa = pessoaRepository.findById(trabalhoDTO.getId()).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
            trabalho.setPessoa(pessoa);
        }

        trabalho = trabalhoRepository.save(trabalho);
        trabalhoDTO.setId(trabalho.getId());
        return trabalhoDTO;
    }

    public TrabalhoDTO updateTrabalho(Long id, TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = trabalhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
        trabalho.setEndereco(trabalhoDTO.getEndereco());

        if (trabalhoDTO.getId() != null) {
            Pessoa pessoa = pessoaRepository.findById(trabalhoDTO.getId()).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
            trabalho.setPessoa(pessoa);
        }

        trabalho = trabalhoRepository.save(trabalho);
        trabalhoDTO.setId(trabalho.getId());
        return trabalhoDTO;
    }

    public void deleteTrabalho(Long id) {
        trabalhoRepository.deleteById(id);
    }
}
