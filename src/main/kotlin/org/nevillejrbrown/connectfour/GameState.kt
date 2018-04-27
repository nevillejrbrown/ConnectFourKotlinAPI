package org.nevillejrbrown.connectfour

data class GameResult(val state:GameState, val winner:Mark?)

enum class GameState(stateLabel:String ) {
    IN_PLAY("Still playing"),
    WON("Won"),
    DRAWN("Drawn")
}