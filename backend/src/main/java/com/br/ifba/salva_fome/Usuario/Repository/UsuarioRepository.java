package com.br.ifba.salva_fome.Repository;

import com.br.ifba.salva_fome.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método customizado para buscar usuários pelo nome (Spring gera o SQL automaticamente)
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}