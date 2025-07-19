package com.br.bffagendadortarefas.controller;

import com.br.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.br.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.br.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.br.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.br.bffagendadortarefas.business.service.UsuarioService;
import com.br.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar usuários", description = "Cadastra um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvar(@RequestBody UsuarioDTORequest usuarioDTO) {
        return ResponseEntity.ok().body(usuarioService.salvar(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Realiza Login")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credencias inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginDTORequest loginDTORequest) {
        return usuarioService.loginUsuario(loginDTORequest);
    }

    @GetMapping
    @Operation(summary = "Buscar usuários por email", description = "Buscar todos os usuários cadastrados")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                                    @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar usuários por ID", description = "Deleta um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String email,
                                               @RequestHeader(name = "Authorization", required = false) String token) {
        usuarioService.deletarPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar usuários por ID", description = "Atualiza um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarDados(@RequestBody UsuarioDTORequest usuarioDTO,
                                                             @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.atualizarDadosUsuario(token, usuarioDTO));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço do usuário por ID", description = "Atualiza o endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizadoa com sucesso")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.atualizarEndereco(id, enderecoDTO, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone do usuário por ID", description = "Atualiza o telefone do usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Telefone não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.atualizarTelefone(id, telefoneDTO, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva endereço do usuário", description = "Salvar endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Endereço não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> cadastrarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.cadastrarEndereco(token, enderecoDTO));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Atualizar telefone do usuário por ID", description = "Atualiza o telefone do usuário")
    @ApiResponse(responseCode = "200", description = "Telefone cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Telefone não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok().body(usuarioService.cadastrarTelefone(token, telefoneDTORequest));
    }
}
