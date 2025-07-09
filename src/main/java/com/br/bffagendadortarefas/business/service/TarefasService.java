package com.br.bffagendadortarefas.business.service;


import com.br.bffagendadortarefas.business.service.dto.TarefasDTO;
import com.br.bffagendadortarefas.infrastructure.client.TarefasClient;
import com.br.bffagendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;


    public TarefasDTO gravarTarefa(TarefasDTO tarefasDTO, String token) {
        return tarefasClient.gravaTarefa(tarefasDTO, token);
    }

    public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal,
                                                             String token) {
        return tarefasClient.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token);

    }

    public List<TarefasDTO> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public void deletarTarefaPorId(String id,
                                   String token) {
        tarefasClient.eletarTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatusTarefa(String id, StatusNotificacaoEnum statusNotificacaoEnum,
                                         String token) {
        return tarefasClient.alteraStatusNotificacao(statusNotificacaoEnum, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO tarefasDTO,
                                    String id,
                                    String token) {
        return tarefasClient.updateTarefa(tarefasDTO, id, token);
    }

}
