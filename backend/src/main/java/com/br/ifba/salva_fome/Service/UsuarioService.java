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

    private final ObjectMapper objectMapper; //Para o mapeamento entre DTO e entidade

    // 1. Salvar
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        Usuario usuario = objectMapper.convertValue(dto, Usuario.class); //Converte o DTO para a entidade Usuario

        Usuario usuarioSalvo = usuarioRepository.save(usuario); //Salva a entidade no banco de dados

        return objectMapper.convertValue(usuarioSalvo, UsuarioResponseDTO.class);//Converte a entidade salva de volta para o DTO de resposta
    }


    // 2. Listar Todos
    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository.findAll().stream().map(usuario -> objectMapper.convertValue(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
        // Busca todos os usuários no banco de dados, converte cada entidade para o DTO de resposta e retorna a lista de DTOs
    }

    // 3. Pesquisar por Nome
    public List<UsuarioResponseDTO> pesquisarPorNome(String nome) {

        return usuarioRepository.findByNomeContainingIgnoreCase(nome).stream().map(usuario -> objectMapper.convertValue(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
        // Busca os usuários cujo nome contém a string fornecida (ignorando maiúsculas/minúsculas), converte cada entidade para o DTO de resposta e retorna a lista de DTOs
    }
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