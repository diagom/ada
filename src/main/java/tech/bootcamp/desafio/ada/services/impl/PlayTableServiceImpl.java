package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.PlayTable;
import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.exception.NotFoundExecption;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.payloads.response.CreateTableResponse;
import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;
import tech.bootcamp.desafio.ada.repositories.PlayTableRepository;
import tech.bootcamp.desafio.ada.services.PlayTableService;
import tech.bootcamp.desafio.ada.services.PlayerService;
import tech.bootcamp.desafio.ada.utils.TextUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayTableServiceImpl implements PlayTableService {
    private final PlayTableRepository playTableRepository;
    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    @Override
    public CreateTableResponse createTable(CreateTableRequest createTableRequest) {
        PlayTable playTable = new PlayTable();

        boolean isAPlainer = TextUtil.isStringUsable(createTableRequest.getPlayerTwoName())
                && TextUtil.isStringUsable(createTableRequest.getPlayerTwoCharacterId());

        List<Player> player = playerService.createPlayers(createTableRequest, isAPlainer);

        playTable.setPlayers(player);
        playTable.setAgainstMachine(!isAPlainer);

        PlayTable savedPlayTable = playTableRepository.save(playTable);
        CreateTableResponse createTableResponse =  modelMapper.map(savedPlayTable, CreateTableResponse.class);

        return createTableResponse;
    }

    @Override
    public List<TableResponse> getAllTables() {
        List<PlayTable> playTables = playTableRepository.findAll();
        List<TableResponse> tablesResponse = modelMapper.map(playTables, new TypeToken<List<TableResponse>>() {}.getType());
        return tablesResponse;
    }

    @Override
    public PlayTableRoundResponse getTableById(String id) {
        PlayTable playTable = playTableRepository.findById(id).orElseThrow(() -> new NotFoundExecption(id));
        return modelMapper.map(playTable ,PlayTableRoundResponse.class);
    }

    @Override
    public TableResponse rollIniciative(String id) {
        PlayTable playTable = playTableRepository.findById(id).orElseThrow(() -> new NotFoundExecption(id));
        List<Player> players = playerService.setPlayersIniciative(playTable.getPlayers());

        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);

        if(playerOne.getPlayerIniciative() > playerTwo.getPlayerIniciative()){
            playTable.setWhoIsAttacking(playerOne.getPlayerName());
        }else {
            playTable.setWhoIsAttacking(playerTwo.getPlayerName());
        }

        PlayTable UpdatedTable = playTableRepository.save(playTable);

        return modelMapper.map(UpdatedTable, TableResponse.class);
    }

    @Override
    public PlayTableRoundResponse updateTable(PlayTable table) {
        PlayTable savedTable = playTableRepository.save(table);

        return modelMapper.map(savedTable, PlayTableRoundResponse.class);
    }

    @Override
    public void deleteTable(String id) {
        PlayTable tablePlay = playTableRepository.findById(id).orElseThrow(() -> new NotFoundExecption(id));
        playTableRepository.delete(tablePlay);
    }
}
