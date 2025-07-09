package com.br.bffagendadortarefas.infrastructure.client;

import com.br.bffagendadortarefas.business.service.dto.TarefasDTO;
import com.br.bffagendadortarefas.business.service.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTO gravaTarefa(@RequestBody TarefasDTO tarefasDTO,
                           @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping()
    List<TarefasDTO> buscarTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void eletarTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                       @RequestParam("id") String id,
                                       @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTO updateTarefa(@RequestBody TarefasDTO tarefasDTO,
                            @RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);
}
