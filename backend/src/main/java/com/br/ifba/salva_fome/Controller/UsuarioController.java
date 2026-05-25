package com.br.ifba.salva_fome.Controller;

import com.br.ifba.salva_fome.Model.Usuario;
import com.br.ifba.salva_fome.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // Define a URL base para o endpoint de usuários
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite que o seu Frontend React faça requisições para cá sem erro de CORS
public class UsuarioController {

    private final UsuarioService usuarioService;

    // 1. Salvar (POST) -> Retorna 201 Created
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvar(
            @RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuario = usuarioService.salvar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }

    // 2. Listar Todos (GET) -> Retorna 200 OK
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {

        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    // 3. Pesquisar por Nome (GET) -> Ex: /api/usuarios/pesquisa?nome=Luis
    @GetMapping("/pesquisa")
    public ResponseEntity<List<UsuarioResponseDTO>> pesquisarPorNome(
            @RequestParam String nome) {

        return ResponseEntity.ok(usuarioService.pesquisarPorNome(nome));
    }
}

    // 4. Editar (PUT) -> Retorna 200 OK
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioEditado = usuarioService.editar(id, usuario);
        return ResponseEntity.ok(usuarioEditado);
    }

    // 5. Deletar (DELETE) -> Retorna 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}