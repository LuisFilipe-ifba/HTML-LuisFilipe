package com.br.ifba.salva_fome.Controller;

import com.br.ifba.salva_fome.DTO.UsuarioRequestDTO;
import com.br.ifba.salva_fome.DTO.UsuarioResponseDTO;
import com.br.ifba.salva_fome.Model.Usuario;
import com.br.ifba.salva_fome.Service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios") // Define a URL base para o endpoint de usuários
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite que o seu Frontend React faça requisições para cá sem erro de CORS
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 1. Salvar (POST) -> Retorna 201 Created
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvar(@RequestBody @Valid UsuarioRequestDTO dto) {

        Usuario usuario = usuarioService.salvar(objectMapper.convertValue(dto, Usuario.class));
        UsuarioResponseDTO resposta = objectMapper.convertValue(usuario, UsuarioResponseDTO.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta);
    }

    // 2. Listar Todos (GET) -> Retorna 200 OK
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {

        List<UsuarioResponseDTO> usuariosDTOs = usuarioService.listarTodos()
                .stream()
                .map(usuario -> objectMapper.convertValue(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTOs);
    }

    // 3. Pesquisar por Nome (GET) -> Ex: /api/usuarios/pesquisa?nome=Luis
    @GetMapping("/pesquisa")
    public ResponseEntity<List<UsuarioResponseDTO>> pesquisarPorNome(@RequestParam String nome) {

        List<UsuarioResponseDTO> usuariosDTOs = usuarioService.pesquisarPorNome(nome)
                .stream()
                .map(usuario -> objectMapper.convertValue(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTOs);
    }

    // 4. Editar (PUT) -> Retorna 200 OK
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> editar(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO dto) {

        Usuario usuarioAtualizado = objectMapper.convertValue(dto, Usuario.class);
        Usuario usuarioEditado = usuarioService.editar(id, usuarioAtualizado);
        UsuarioResponseDTO resposta = objectMapper.convertValue(usuarioEditado, UsuarioResponseDTO.class);

        return ResponseEntity.ok(resposta);
    }

    // 5. Deletar (DELETE) -> Retorna 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}