package com.lucasdaher.ticemtrilhasm3.controllers;

import com.lucasdaher.ticemtrilhasm3.models.PessoaModel;
import com.lucasdaher.ticemtrilhasm3.repositories.PessoaRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
@AllArgsConstructor
public class PessoaController {
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas() {
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criarNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        novaPessoa.setId(null);
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> editarPessoa(@RequestBody PessoaModel novaPessoa) {
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Integer id) {
        pessoaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
