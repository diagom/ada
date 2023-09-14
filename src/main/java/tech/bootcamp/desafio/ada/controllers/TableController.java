package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.payloads.response.CreateTableResponse;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;
import tech.bootcamp.desafio.ada.services.PlayTableService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/table")
@Tag(name = "Mesa", description = "Criar usuario e mesa onde sera guardada a sessão")
public class TableController {
    private final PlayTableService playTableService;

    @PostMapping(path = "/", produces = "application/json" )
    @Operation(summary = "cria uma mesa para a sessao" )
    public CreateTableResponse createTable(@RequestBody CreateTableRequest createTableRequest){
        return playTableService.createTable(createTableRequest);
    }

    @GetMapping(path = "/", produces = "application/json" )
    @Operation(summary = "Mostra todas as mesas")
    public List<TableResponse> getAllTables(){
        return playTableService.getAllTables();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma mesa")
    @DeleteMapping(path = "/{tableId}", produces = "application/json" )
    public void deleteTable(@PathVariable("tableId") String tableId){
        playTableService.deleteTable(tableId);
    }

    @Operation(summary = "Rola os dados de Iniciativa")
    @PutMapping(path = "/{tableId}", produces = "application/json" )
    public TableResponse rollIniciative(@PathVariable("tableId") String tableId){
        return playTableService.rollIniciative(tableId);
    }
}
