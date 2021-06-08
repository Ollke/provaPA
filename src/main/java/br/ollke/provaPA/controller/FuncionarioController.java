package br.ollke.provaPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ollke.provaPA.entity.Funcionario;
import br.ollke.provaPA.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {
    
    FuncionarioRepository fr;

    @Autowired
    FuncionarioController(FuncionarioRepository fr){
        this.fr = fr;
    }

    @PostMapping("/v1/funcionario/cadastro")
    public ResponseEntity<Object> create(@RequestBody Funcionario f){
        try {
            return ResponseEntity.status(201).body(fr.save(f));
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.badRequest().body("erro");
        }
    }

    @GetMapping("/v1/funcionarios")
    public ResponseEntity<List<Funcionario>> obterTodos(){
        List<Funcionario> funcionarios = fr.findAll();
        if(funcionarios != null) return ResponseEntity.ok(funcionarios);
        return null;
    }

    @GetMapping("/v1/funcionarios/nome/{nome}")
    public ResponseEntity<List<Funcionario>> obterNome(@PathVariable("nome") String nome){
        List<Funcionario> funcionarios = fr.findAllByNomeContainingIgnoreCase(nome);
        if(funcionarios != null) return ResponseEntity.ok(funcionarios);
        return null;
    }

    @PatchMapping("/v1/funcionario/remover/{matricula}")
    public ResponseEntity<Object> delete(@PathVariable("matricula") long matricula){
        try {
            fr.deleteById(matricula);
            return ResponseEntity.ok().body("deletado");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.badRequest().body("erro");
        }
    }

    @PatchMapping("/v1/funcionario/atualizar/{matricula}")
    public ResponseEntity<Object> update(@PathVariable("matricula") long matricula,@RequestBody Funcionario f){
        try {
            Optional<Funcionario> OptionalFuncionario = fr.findById(matricula);
            OptionalFuncionario.get().setDataDeCadatro(f.getDataDeCadatro());
            OptionalFuncionario.get().setEmail(f.getEmail());
            OptionalFuncionario.get().setNome(f.getNome());
            Funcionario savedFuncionario = fr.save(OptionalFuncionario.get());

            return ResponseEntity.ok().body(savedFuncionario);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.badRequest().body("erro");
        }
    }
    

}
