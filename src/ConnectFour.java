import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //declaring and initializing variables
        int height;
        int length;
        int playerOneCol;
        int playerTwoCol;
        int rowOfChip;
        char xChip = 'x';
        char oChip = 'o';
        boolean playerOneWin = false;
        boolean playerTwoWin = false;
        boolean tieGame = false;

        //stores the height and length that the user wants the board to be
        System.out.print("What would you like the height of the board to be? ");
        height = scanner.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        length = scanner.nextInt();

        //creates the board based on the inputted length and height
        char [][] board = new char[height][length];

        //sends board array to be initialized to dashes
        initializeBoard(board);
        //sends board array to be printed
        printBoard(board);
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        //loops the the game until there is a tie game
        while (!tieGame) {
            int filledBoard = 0;
            System.out.println();

            //asks player 1 to pick column they want to place token
            System.out.print("Player 1: Which column would you like to choose? ");
            playerOneCol = scanner.nextInt();
            rowOfChip = insertChip(board, playerOneCol, xChip);
            playerOneWin = checkIfWinner(board, playerOneCol, rowOfChip, xChip);

            printBoard(board);
            System.out.println();
            if (playerOneWin) {
                break;
            }

            System.out.print("Player 2: Which column would you like to choose? ");
            playerTwoCol = scanner.nextInt();
            rowOfChip = insertChip(board, playerTwoCol, oChip);
            playerTwoWin = checkIfWinner(board, playerTwoCol, rowOfChip, oChip);

            printBoard(board);
            System.out.println();

            if (playerTwoWin) {
                break;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != '-') {
                        filledBoard++;
                    }
                    if (filledBoard == (height * length)) {
                        tieGame = true;
                    }
                }
            }
        }

        if (playerOneWin)  {
            System.out.println("Player 1 won the game!");
        }
        else if (playerTwoWin) {
            System.out.println("Player 2 won the game!");
        }
        else if (tieGame) {
            System.out.println("Draw. Nobody wins.");
        }


    }

    public static void printBoard(char[][] array) {
        int i;
        int j;
        for (i = array.length - 1; i >= 0; i--) {
            for (j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array) {
        int i;
        int j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                array[i][j] = '-';
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType) {
        int row;

        for (row = 0; row < array.length; row++) {

            if (array[row][col] == '-') {
                array[row][col] = chipType;
                break;
            }
        }
        return row;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        int rowWin = 0;
        int colWin = 0;
        boolean winner = false;
        int i;
        for (i = 0; i < array[0].length; i++) {
            if (array[row][i] == chipType) {
                rowWin++;
            }
            if (rowWin == 4) {
                break;
            }
            if (array[row][i] != chipType) {
                rowWin = 0;
            }
        }
        for (i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                colWin++;
            }
            if (colWin == 4){
                break;
            }
            if (array[i][col] != chipType) {
                colWin = 0;
            }
        }

        if (colWin == 4 || rowWin == 4) {
            winner = true;
        }
        return winner;

    }



}
