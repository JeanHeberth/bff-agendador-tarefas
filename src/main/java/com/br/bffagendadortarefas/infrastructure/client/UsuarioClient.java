package com.br.bffagendadortarefas.infrastructure.client;

import com.br.bffagendadortarefas.business.service.dto.EnderecoDTO;
import com.br.bffagendadortarefas.business.service.dto.TelefoneDTO;
import com.br.bffagendadortarefas.business.service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscarPorEmail(@RequestParam("email") String email,
                              @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTO salvarUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletarUsuario(@PathVariable String email, @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO atualizarDados(@RequestBody UsuarioDTO usuarioDTO, @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTO atualizarTelefone(@RequestBody TelefoneDTO telefoneDTO, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO, @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneDTO cadastrarTelefone(@RequestBody TelefoneDTO telefoneDTO, @RequestHeader("Authorization") String token);

}
