package org.nevillejrbrown.connectfour.repository

import org.nevillejrbrown.connectfour.Game

interface GameRepository {
    fun createGame(numRows:Int, numCols:Int):Int

    fun getGames():List<Game>

    fun removeGame(gameId:Int)

    fun saveGame(game: Game)

    fun getGame(gameId:Int):Game
}