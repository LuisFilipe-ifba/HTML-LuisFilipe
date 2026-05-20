package com.br.ifba.salva_fome.Service;

import com.br.ifba.salva_fome.Repository.UsuarioRepository;
import com.br.ifba.salva_fome.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok: Cria o construtor para injetar o repository automaticamente
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // 1. Salvar
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 2. Listar Todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // 3. Pesquisar por Nome
    public List<String> pesquisarPorNome(String nome) {
        // Retorna uma lista se encontrar trechos do nome informado
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    // 4. Editar
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
}