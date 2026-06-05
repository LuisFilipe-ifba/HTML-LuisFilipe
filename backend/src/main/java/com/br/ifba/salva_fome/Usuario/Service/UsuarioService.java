package com.br.ifba.salva_fome.Usuario.Service;

import com.br.ifba.salva_fome.Usuario.Repository.UsuarioRepository;
import com.br.ifba.salva_fome.Usuario.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Lombok: Cria o construtor para injetar o repository automaticamente
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // 1. Salvar
    @Transactional
    // Garante que a operação de salvar seja atômica, ou seja, ou tudo é salvo ou nada é salvo em caso de erro
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 2. Listar Todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // 3. Pesquisar por Nome
    public List<Usuario> pesquisarPorNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    // 4. Editar
    @Transactional
    // Garante que a operação de edição seja atômica, ou seja, ou tudo é editado ou nada é editado em caso de erro
    public Usuario editar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    // 5. Deletar
    public void deletar(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }

        usuarioRepository.deleteById(id);
    }

    //6. findAll
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
}