package com.br.bffagendadortarefas.infrastructure.client;

import com.br.bffagendadortarefas.business.service.dto.in.EnderecoDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.LoginDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.TelefoneDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.UsuarioDTORequest;
import com.br.bffagendadortarefas.business.service.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscarPorEmail(@RequestParam("email") String email,
                                     @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest loginDTORequest);

    @DeleteMapping("/{email}")
    void deletarUsuario(@PathVariable String email, @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizarDados(@RequestBody UsuarioDTORequest usuarioDTO, @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    UsuarioDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTO, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    UsuarioDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTO, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    UsuarioDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest enderecoDTO, @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    UsuarioDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTO, @RequestHeader("Authorization") String token);

}
