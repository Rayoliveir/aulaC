package com.example.aulaC.repository;

import com.example.aulaC.model.Endereco;
import com.example.aulaC.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
