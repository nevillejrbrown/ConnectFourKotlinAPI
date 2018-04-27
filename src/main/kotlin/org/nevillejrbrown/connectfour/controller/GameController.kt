package org.nevillejrbrown.connectfour.controller


import org.nevillejrbrown.connectfour.Game
import org.nevillejrbrown.connectfour.GameResult
import org.nevillejrbrown.connectfour.Mark
import org.nevillejrbrown.connectfour.service.GameService
import org.springframework.web.bind.annotation.*

data class MoveRequest(var colNum: Int?, var mark: String?) {
    constructor() : this(null, null) {}
}


@RestController
@RequestMapping("api/games")
class GameController(val gameService: GameService) {


    @RequestMapping(value = "/", method = [RequestMethod.GET])
    fun listGames(): List<Game> {
        return gameService.listGames();
    }

    @RequestMapping("/{id}")
    fun getGameContents(@PathVariable id: Int): Game {
        return gameService.getGame(id)
    }


    @RequestMapping(value = "/", method = [RequestMethod.POST])
    fun createGame(): Int {
        return gameService.createGame()
    }

    @RequestMapping(value = "{id}", method = [RequestMethod.DELETE])
    fun deleteGame(@PathVariable id: Int) {
        gameService.removeGame(id)
    }

    @RequestMapping(value = "/{id}/move", method = [RequestMethod.PATCH])
    fun makeMove(@PathVariable id: Int, @RequestBody moveRequest: MoveRequest): GameResult {
        println("id=$id colnum=$moveRequest.colNum mark=$moveRequest.mark")

        return gameService.playMove(id, moveRequest.colNum ?: -1, Mark.decode(moveRequest.mark ?: " "))
    }


}