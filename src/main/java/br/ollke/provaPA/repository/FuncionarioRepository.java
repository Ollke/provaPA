package br.ollke.provaPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ollke.provaPA.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findAllByNomeContainingIgnoreCase(String nome);
}
