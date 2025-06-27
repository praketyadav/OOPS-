import java.util.HashSet;

class SudokuBoard {
    private char[][] board;

    public SudokuBoard(char[][] board) {
        this.board = board;
    }

    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> boxSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Row check
                char rowVal = board[i][j];
                if (rowVal != '.' && !rowSet.add(rowVal)) return false;

                // Column check
                char colVal = board[j][i];
                if (colVal != '.' && !colSet.add(colVal)) return false;

                // Box check
                int boxRow = 3 * (i / 3) + j / 3;
                int boxCol = 3 * (i % 3) + j % 3;
                char boxVal = board[boxRow][boxCol];
                if (boxVal != '.' && !boxSet.add(boxVal)) return false;
            }
        }
        return true;
    }
}
