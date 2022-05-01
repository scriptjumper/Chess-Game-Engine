package com.chess.tests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Board.Builder;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.Bishop;
import com.chess.engine.pieces.King;
import org.junit.Test;

import java.util.Collection;

public class TestBishop {
    @Test
    public void testMiddleBishopOnEmptyBoard() {
        final Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, false, false));
        // White Layout
        builder.setPiece(new Bishop(35, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, false, false));
        // Set the current player
        builder.setMoveMaker(Alliance.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.whitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.blackPlayer().getLegalMoves();
        assertEquals(whiteLegals.size(), 18);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("a7"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("b6"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("c5"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("e3"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("f2"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("d4"), BoardUtils.getCoordinateAtPosition("g1"))));
    }

    @Test
    public void testTopLeftBishopOnEmptyBoard() {
        Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, false, false));
        // White Layout
        builder.setPiece(new Bishop(0, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, false, false));
        // Set the current player
        builder.setMoveMaker(Alliance.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.whitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.blackPlayer().getLegalMoves();
        assertEquals(whiteLegals.size(), 12);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("b7"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("c6"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("d5"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("e4"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("f3"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("g2"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a8"), BoardUtils.getCoordinateAtPosition("h1"))));
    }

    @Test
    public void testTopRightBishopOnEmptyBoard() {
        Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, false, false));
        // White Layout
        builder.setPiece(new Bishop(7, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, false, false));
        // Set the current player
        builder.setMoveMaker(Alliance.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.whitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.blackPlayer().getLegalMoves();
        assertEquals(whiteLegals.size(), 12);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("g7"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("f6"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("e5"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("d4"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("c3"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("b2"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h8"), BoardUtils.getCoordinateAtPosition("a1"))));
    }

    @Test
    public void testBottomLeftBishopOnEmptyBoard() {
        Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, false, false));
        // White Layout
        builder.setPiece(new Bishop(56, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, false, false));
        // Set the current player
        builder.setMoveMaker(Alliance.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.whitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.blackPlayer().getLegalMoves();
        assertEquals(whiteLegals.size(), 12);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("b2"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("c3"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("d4"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("e5"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("f6"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("g7"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("a1"), BoardUtils.getCoordinateAtPosition("h8"))));
    }

    @Test
    public void testBottomRightBishopOnEmptyBoard() {
        Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, false, false));
        // White Layout
        builder.setPiece(new Bishop(63, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, false, false));
        // Set the current player
        builder.setMoveMaker(Alliance.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.whitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.blackPlayer().getLegalMoves();
        assertEquals(whiteLegals.size(), 12);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("g2"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("f3"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("e4"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("d5"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("c6"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("b7"))));
        assertTrue(whiteLegals.contains(Move.MoveFactory
                .createMove(board, BoardUtils.getCoordinateAtPosition("h1"), BoardUtils.getCoordinateAtPosition("a8"))));
    }
}