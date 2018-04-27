package org.nevillejrbrown.connectfour.repository

import org.nevillejrbrown.connectfour.Game
import org.springframework.stereotype.Repository

class NotFoundException(val msg: String) : Exception(msg)

@Repository
class GameRepositoryImpl : GameRepository {
    val games: MutableMap<Int, Game> = HashMap<Int, Game>()

    override fun getGame(gameId: Int): Game {
        return games.get(gameId) ?: throw NotFoundException("Can't find game with id $gameId")
    }

    override fun createGame(numRows: Int, numCols: Int): Int {
        println("Creating game")
        val maxGameKey: Int = games.keys.max() ?: 0
        games.put(maxGameKey + 1, Game(maxGameKey + 1, 6, 7))
        return maxGameKey
    }

    override fun getGames(): List<Game> {
        return ArrayList<Game>(games.values)
    }


    override fun removeGame(gameId: Int) {
        games.remove(gameId)
    }


    override fun saveGame(game: Game) {
        games.replace(game.id, game)
    }
}