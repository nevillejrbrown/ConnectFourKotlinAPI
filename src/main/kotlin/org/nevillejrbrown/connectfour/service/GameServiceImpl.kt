package org.nevillejrbrown.connectfour.service

import org.nevillejrbrown.connectfour.Game
import org.nevillejrbrown.connectfour.GameResult
import org.nevillejrbrown.connectfour.Mark
import org.nevillejrbrown.connectfour.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameServiceImpl(val gameRepository:GameRepository ):GameService {
    override fun listGames(): List<Game> {
        return gameRepository.getGames()
    }

    override fun playMove(gameId: Int, colNum: Int, mark:Mark): GameResult {
        val game:Game = gameRepository.getGame(gameId)
        val result:GameResult = game.addCounter(colNum, mark)
        gameRepository.saveGame(game)
        return result
    }

    override fun removeGame(gameId: Int) {
        gameRepository.removeGame(gameId)
    }

    override fun getGame(gameId: Int):Game {
        return gameRepository.getGame(gameId)
    }

    override fun createGame(): Int {
        return gameRepository.createGame(6,7)
    }
}