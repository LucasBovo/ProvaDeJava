package com.provaPratica.demo.controller;

import com.provaPratica.demo.dto.PessoaDTO;
import com.provaPratica.demo.dto.TrabalhoDTO;
import com.provaPratica.demo.service.PessoaService;
import com.provaPratica.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping("/pessoas")
    public List<PessoaDTO> getPessoas() {
        return pessoaService.getAllPessoas();
    }

    @PostMapping("/pessoas")
    public PessoaDTO createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.createPessoa(pessoaDTO);
    }

    @PutMapping("/pessoas/{id}")
    public PessoaDTO updatePessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.updatePessoa(id, pessoaDTO);
    }

    @DeleteMapping("/pessoas/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }

    @GetMapping("/trabalhos")
    public List<TrabalhoDTO> getTrabalhos() {
        return trabalhoService.getAllTrabalhos();
    }

    @PostMapping("/trabalhos")
    public TrabalhoDTO createTrabalho(@RequestBody TrabalhoDTO trabalhoDTO) {
        return trabalhoService.createTrabalho(trabalhoDTO);
    }

    @PutMapping("/trabalhos/{id}")
    public TrabalhoDTO updateTrabalho(@PathVariable Long id, @RequestBody TrabalhoDTO trabalhoDTO) {
        return trabalhoService.updateTrabalho(id, trabalhoDTO);
    }

    @DeleteMapping("/trabalhos/{id}")
    public void deleteTrabalho(@PathVariable Long id) {
        trabalhoService.deleteTrabalho(id);
    }
}
