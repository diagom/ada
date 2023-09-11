package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.payloads.response.CreateTableResponse;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/table")
@Tag(name = "Mesa", description = "Criar usuario e masa onde sera gardada a sessão")
public class TableController {

    @PostMapping(path = "/", produces = "application/json" )
    public CreateTableResponse createTable(@RequestBody CreateTableRequest createTableRequest){
        return new CreateTableResponse();
    }

    @GetMapping(path = "/{tableId}", produces = "application/json" )
    public TableResponse getTable(){
        return new TableResponse();
    }

    @DeleteMapping(path = "/{tableId}", produces = "application/json" )
    public TableResponse deleteTable(){
        return new TableResponse();
    }

    @PutMapping(path = "/{tableId}", produces = "application/json" )
    public TableResponse rollIniciative(){
        return new TableResponse();
    }
}
