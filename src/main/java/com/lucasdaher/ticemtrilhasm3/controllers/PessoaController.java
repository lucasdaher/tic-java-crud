package com.lucasdaher.ticemtrilhasm3.controllers;

import com.lucasdaher.ticemtrilhasm3.models.PessoaModel;
import com.lucasdaher.ticemtrilhasm3.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
public class PessoaController {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas() {
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criaNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        novaPessoa.setId(null);
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> editaPessoa(@RequestBody PessoaModel novaPessoa) {
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Integer id) {
        pessoaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}