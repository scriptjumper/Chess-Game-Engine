package com.chess.engine;

import com.chess.engine.board.Board;

public class JChess {
    public static void main(String arg[]) {
        Board board = Board.createStandardBoard();

        System.out.println(board);
    }
}
