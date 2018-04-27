package org.nevillejrbrown.connectfour

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestGame {

    @Test
    fun `Test Add Piece`() {
        val board = Game(0, 6, 7)
        board.addCounter(3, Mark.P1)
        board.addCounter(3, Mark.P1)

        assertTrue(board.getMarkAtPosition(Position(1, 3)) == Mark.P1)

    }


    @Test
    fun `Test room in column with room`() {
        val board = Game(0, 3, 3)
        board.addCounter(2, Mark.P1)
        board.addCounter(2, Mark.P1)
        assertTrue(board.isRoomInColumn(2))
    }

    @Test
    fun `Test room in column with NO room`() {
        val board = Game(0, 3, 3)
        board.addCounter(2, Mark.P1)
        board.addCounter(2, Mark.P1)
        board.addCounter(2, Mark.P1)
        assertFalse(board.isRoomInColumn(2))
    }

    @Test
    fun `Test adding move to full row throws exception`() {
        val board = Game(0, 3, 3)
        board.addCounter(2, Mark.P1)
        board.addCounter(2, Mark.P1)
        board.addCounter(2, Mark.P1)
        assertFailsWith(InvalidMoveException::class) {
            board.addCounter(2, Mark.P1)
        }
    }

    @Test
    fun `Test adding move to non existent row throws exception`() {
        val board = Game(0, 3, 3)
        assertFailsWith(InvalidMoveException::class) {
            board.addCounter(3, Mark.P1)
        }
    }

    @Test fun `Test getResult spots vertical four in a row`() {
        val board = Game(0, 6, 7)
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.WON, Mark.P1), board.addCounter(2, Mark.P1) )
    }

    @Test fun `Test getResult spots horizontal four in a row`() {
        val board = Game(0, 6, 7)
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.WON, Mark.P1), board.addCounter(3, Mark.P1) )
    }
    @Test fun `Test getResult spots horizontal four in a row when adding middle counter`() {
        val board = Game(0, 6, 7)
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(3, Mark.P1) )
        assertEquals(GameResult(GameState.WON, Mark.P1), board.addCounter(1, Mark.P1) )
    }

    @Test fun `Test getResult spots leading diagonal`() {
        val board = Game(0, 6, 7)
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(3, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(3, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(3, Mark.P2) )
        assertEquals(GameResult(GameState.WON, Mark.P1), board.addCounter(3, Mark.P1) )
    }

    @Test fun `Test getResult spots trailing diagonal`() {
        val board = Game(0, 6, 7)
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(3, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(2, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(1, Mark.P1) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P2) )
        assertEquals(GameResult(GameState.IN_PLAY, null), board.addCounter(0, Mark.P2) )
        assertEquals(GameResult(GameState.WON, Mark.P1), board.addCounter(0, Mark.P1) )
    }
}