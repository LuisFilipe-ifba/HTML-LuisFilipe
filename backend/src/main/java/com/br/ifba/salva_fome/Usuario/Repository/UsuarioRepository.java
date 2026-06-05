package com.br.ifba.salva_fome.Usuario.Repository;

import com.br.ifba.salva_fome.Usuario.Model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método customizado para buscar usuários pelo nome (Spring gera o SQL automaticamente)
    List<Usuario> findByNomeContainingIgnoreCase(String nome);

    public abstract Page<Usuario> findAll(Pageable pageable);
}