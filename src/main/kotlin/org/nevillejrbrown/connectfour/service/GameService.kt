package org.nevillejrbrown.connectfour.service

import org.nevillejrbrown.connectfour.Game
import org.nevillejrbrown.connectfour.GameResult
import org.nevillejrbrown.connectfour.Mark

interface GameService {
    fun createGame():Int

    fun listGames():List<Game>

    fun playMove(gameId:Int, colNum:Int, mark:Mark):GameResult

    fun removeGame(gameId:Int)

    fun getGame(gameId:Int):Game
}