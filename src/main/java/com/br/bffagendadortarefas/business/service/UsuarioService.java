package com.br.bffagendadortarefas.business.service;

import com.br.bffagendadortarefas.business.service.dto.EnderecoDTO;
import com.br.bffagendadortarefas.business.service.dto.TelefoneDTO;
import com.br.bffagendadortarefas.business.service.dto.UsuarioDTO;
import com.br.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        return usuarioClient.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscarPorEmail(email, token);
    }

    public void deletarPorEmail(String email, String token) {
        usuarioClient.deletarUsuario(email, token);
    }

    public UsuarioDTO atualizarDadosUsuario(String token, UsuarioDTO usuarioDTO) {
        return usuarioClient.atualizarDados(usuarioDTO, token);
    }

    public EnderecoDTO atualizarEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token) {
        return usuarioClient.atualizarEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizarTelefone(Long idTelefone, TelefoneDTO telefoneDTO, String token) {
        return usuarioClient.atualizarTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTO cadastrarEndereco(String token, EnderecoDTO enderecoDTO) {
        return usuarioClient.cadastrarEndereco(enderecoDTO, token);
    }

    public TelefoneDTO cadastrarTelefone(String token, TelefoneDTO telefoneDTO) {
        return usuarioClient.cadastrarTelefone(telefoneDTO, token);
    }

}


