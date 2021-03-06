package com.chess.tests;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.King;
import com.chess.engine.pieces.Pawn;
import com.chess.engine.player.MoveTransition;
import com.chess.engine.player.ai.MiniMax;
import com.chess.engine.player.ai.MoveStrategy;
import com.google.common.collect.Iterables;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class BoardTest {
    @Test
    public void initialBoard() {
        final Board board = Board.createStandardBoard();
        assertEquals(board.currentPlayer().getLegalMoves().size(), 20);
        assertEquals(board.currentPlayer().getOpponent().getLegalMoves().size(), 20);
        assertFalse(board.currentPlayer().isInCheck());
        assertFalse(board.currentPlayer().isInCheckMate());
        assertFalse(board.currentPlayer().isCastled());

        assertEquals(board.currentPlayer(), board.whitePlayer());
        assertEquals(board.currentPlayer().getOpponent(), board.blackPlayer());
        assertFalse(board.currentPlayer().getOpponent().isInCheck());
        assertFalse(board.currentPlayer().getOpponent().isInCheckMate());
        assertFalse(board.currentPlayer().getOpponent().isCastled());

        assertTrue(board.whitePlayer().toString().contains("White"));
        assertTrue(board.blackPlayer().toString().contains("Black"));

        final Iterable<Move> allMoves = Iterables.concat(board.whitePlayer().getLegalMoves(), board.blackPlayer().getLegalMoves());
        for(final Move move : allMoves) {
            assertFalse(move.isAttack());
            assertFalse(move.isCastlingMove());
        }

        assertEquals(Iterables.size(allMoves), 40);
    }

    @Test
    public void testPlainKingMove() {
        final Board.Builder builder = new Board.Builder();

        // Black Layout
        builder.setPiece(new King(4, Alliance.BLACK, true, true));
        builder.setPiece(new Pawn( 12, Alliance.BLACK));

        // White Layout
        builder.setPiece(new Pawn(52, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE, true, true));
        builder.setMoveMaker(Alliance.WHITE);

        // Set the current player
        final Board board = builder.build();

        assertEquals(board.whitePlayer().getLegalMoves().size(), 6);
        assertEquals(board.blackPlayer().getLegalMoves().size(), 6);
        assertFalse(board.currentPlayer().isInCheck());
        assertFalse(board.currentPlayer().isInCheckMate());
        assertFalse(board.currentPlayer().getOpponent().isInCheck());
        assertFalse(board.currentPlayer().getOpponent().isInCheckMate());
        assertEquals(board.currentPlayer(), board.whitePlayer());
        assertEquals(board.currentPlayer().getOpponent(), board.blackPlayer());
    }

    @Test
    public void testBoardConsistency() {
        final Board board = Board.createStandardBoard();
        assertEquals(board.currentPlayer(), board.whitePlayer());
    }

    @Test
    public void mem() {
        final Runtime runtime = Runtime.getRuntime();
        long start, end;
        runtime.gc();
        start = runtime.freeMemory();
        Board board = Board.createStandardBoard();
        end =  runtime.freeMemory();
        System.out.println("That took " + (start-end) + " bytes.");
    }

    @Test
    public void testAI() {
        final Board board = Board.createStandardBoard();
        final MoveStrategy moveStrategy = new MiniMax(4);
        final Move move = moveStrategy.execute(board);
        System.out.println(move);
    }

    @Test
    public void testFoolsMate() {
        final Board board = Board.createStandardBoard();
        final MoveTransition t1 = board.currentPlayer().makeMove(
                Move.MoveFactory.createMove(board,
                        BoardUtils.getCoordinateAtPosition("f2"),
                        BoardUtils.getCoordinateAtPosition("f3"))
        );

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(
                        Move.MoveFactory.createMove(t1.getTransitionBoard(),
                                BoardUtils.getCoordinateAtPosition("e7"),
                                BoardUtils.getCoordinateAtPosition("e5"))
                );

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(
                        Move.MoveFactory.createMove(t2.getTransitionBoard(),
                                BoardUtils.getCoordinateAtPosition("g2"),
                                BoardUtils.getCoordinateAtPosition("g4"))
                );

        assertTrue(t3.getMoveStatus().isDone());

        final MoveStrategy strategy = new MiniMax(4);
        final Move aiMove = strategy.execute(t3.getTransitionBoard());
        final Move bestMove = Move.MoveFactory.createMove(
                t3.getTransitionBoard(),
                BoardUtils.getCoordinateAtPosition("d8"),
                BoardUtils.getCoordinateAtPosition("h4")
        );
        assertEquals(aiMove, bestMove);
    }
}