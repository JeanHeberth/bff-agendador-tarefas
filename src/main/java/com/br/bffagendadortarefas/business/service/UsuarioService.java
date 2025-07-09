package com.br.bffagendadortarefas.business.service;

import com.br.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.EnderecoDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.LoginDTORequest;
import com.br.bffagendadortarefas.business.service.dto.in.TelefoneDTORequest;
import com.br.bffagendadortarefas.business.service.dto.out.UsuarioDTOResponse;
import com.br.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvar(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest loginDTORequest) {
        return usuarioClient.login(loginDTORequest);
    }


    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscarPorEmail(email, token);
    }

    public void deletarPorEmail(String email, String token) {
        usuarioClient.deletarUsuario(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest usuarioDTO) {
        return usuarioClient.atualizarDados(usuarioDTO, token);
    }

    public UsuarioDTOResponse atualizarEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return usuarioClient.atualizarEndereco(enderecoDTO, idEndereco, token);
    }

    public UsuarioDTOResponse atualizarTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token) {
        return usuarioClient.atualizarTelefone(telefoneDTO, idTelefone, token);
    }

    public UsuarioDTOResponse cadastrarEndereco(String token, EnderecoDTORequest enderecoDTO) {
        return usuarioClient.cadastrarEndereco(enderecoDTO, token);
    }

    public UsuarioDTOResponse cadastrarTelefone(String token, TelefoneDTORequest telefoneDTO) {
        return usuarioClient.cadastrarTelefone(telefoneDTO, token);
    }

}


