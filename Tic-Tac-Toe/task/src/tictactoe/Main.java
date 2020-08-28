package tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static String createTicTacRow(int row, char[][] ticTacArray) {
        // Rows start at zero
        String lineResult = "";

        // Note space at the end of string returned
        for (int i = 0; i < 3; i++) {
            char temp = ticTacArray[row][i];
            lineResult += temp + " ";
        }

        return lineResult;
    }

    public static void printTicTacToeOutput (char[][] ticTacArray) {
        String firstLine = createTicTacRow(0, ticTacArray);
        String secondLine = createTicTacRow(1, ticTacArray);
        String thirdLine = createTicTacRow(2, ticTacArray);

        System.out.println("---------");
        System.out.println("| " + firstLine + "|");
        System.out.println("| " + secondLine + "|");
        System.out.println("| " + thirdLine + "|");
        System.out.println("---------");
    }

    public static char[][] createTicTacArray(String userInput) {
        char[][] ticTacArray = new char[3][3];

        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                ticTacArray[column][row] = userInput.charAt(column * 3 + row);
            }
        }

        return ticTacArray;
    }

    public static boolean checkRowWinCondition(char letter, char[][] ticTacArray) {
        boolean rowWinStatus = false;

        // Checking for row wins
        for (int row = 0; row < 3; row++) {
            if (ticTacArray[row][0] == letter &&
                    ticTacArray[row][1] == letter &&
                    ticTacArray[row][2] == letter) {
                rowWinStatus = true;
                break;
            }
        }

        return rowWinStatus;
    }

    public static boolean checkColWinCondition(char letter, char[][] ticTacArray) {
        boolean colWinStatus = false;

        // checking for column wins
        for (int col = 0; col < 3; col++) {
            if (ticTacArray[0][col] == letter &&
                    ticTacArray[1][col] == letter &&
                    ticTacArray[2][col] == letter) {
                colWinStatus = true;
                break;
            }
        }

        return colWinStatus;
    }

    public static boolean checkForEmptyCells(char characterForEmptyCells, char[][] ticTacArray) {
        boolean hasEmptyCells = false;

        // Going through each element to check for character that represents empty cell
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (ticTacArray[row][col] == characterForEmptyCells) {
                    hasEmptyCells = true;
                    break;
                }
            }
        }

        return hasEmptyCells;
    }

    public static boolean checkDiagonalWinCondition(char letter, char[][] ticTacArray) {
        boolean diagonalWinStatus = false;

        // Once confirmed center matches letter, checking if either diagonal line is also letter
        if (ticTacArray[1][1] == letter) {
            diagonalWinStatus = ticTacArray[0][0] == letter && ticTacArray[2][2] == letter ||
                    ticTacArray[0][2] == letter && ticTacArray[2][0] == letter;
        }

        return diagonalWinStatus;
    }

    public static boolean checkWinCondition(char letter, char[][] ticTacArray) {
        return checkRowWinCondition(letter, ticTacArray) ||
                checkColWinCondition(letter,ticTacArray) ||
                checkDiagonalWinCondition(letter,ticTacArray);
    }

    public static boolean checkForUnevenCount(char[][] ticTacArray) {
        int xCounter = 0;
        int oCounter = 0;

        // Going through each element to count X's and O's
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (ticTacArray[row][col] == 'X') {
                    xCounter++;
                } else if (ticTacArray[row][col] == 'O') {
                    oCounter++;
                }
            }
        }

        // checking if difference is 2 or greater, meaning count is uneven
        int difference = Math.abs(xCounter - oCounter);
        return difference >= 2 ;
    }

    public static void printGameStatus(boolean xHasWin, boolean oHasWin,
                                       boolean hasEmptyCells, boolean hasUnevenCount) {
        // printing game status
        if (xHasWin && oHasWin || hasUnevenCount) {
            System.out.println("Impossible");
        } else if (xHasWin) {
            System.out.println("X wins");
        } else if (oHasWin) {
            System.out.println("O wins");
        } else if (!xHasWin && !oHasWin && !hasEmptyCells) {
            System.out.println("Draw");
        } else if (!xHasWin && !oHasWin && hasEmptyCells) {
            System.out.println("Game not finished");
        }
    }

    public static void updateTicTacToe(int xCoordinate, int yCoordinate, char[][] ticTacArray, char newValue) {
        /*
        (x, y) representation       positional representation
        of coordinates              of array within array loop
        (1, 3) (2, 3) (3, 3)        [0, 0] [0, 1] [0, 2]
        (1, 2) (2, 2) (3, 2)    >   [1, 0] [1, 1] [1, 2]
        (1, 1) (2, 1) (3, 1)        [2, 0] [2, 1] [2, 2]
         */

        ticTacArray[3 - yCoordinate][xCoordinate - 1] = newValue;
        // (2, 1) > [2, 1]
        // (3, 3) > [0, 2]
    }

    public static boolean checkIfSeatsTaken(int xCoordinate, int yCoordinate, char[][] ticTacArray) {
        char charAtPositionXY = ticTacArray[3 - yCoordinate][xCoordinate - 1];

        return charAtPositionXY == 'X' || charAtPositionXY == 'O';
    }

    public static boolean checkIfStringIsInt(String stringToTest) {
        boolean isInt = true;

        // making sure X value is an int
        try {
            int intTest = Integer.parseInt(stringToTest);
        }catch (NumberFormatException e) {
            isInt = false;
        }

        return isInt;
    }

    public static int[] getXYCoordinates(char[][] ticTacArray) {
        // Get the coordinates of the players next move (player playing as 'X')
        int xCoordinate, yCoordinate;

        while (true) {
            System.out.print("Enter the coordinates: ");

            // Grabbing full line input for coordinates and splitting them off
            String coordinates = scanner.nextLine();
            String[] coordinateArray = coordinates.split(" ");
            String xString = "";
            String yString = "";
            xString = coordinateArray[0];
            // Accounting for possibility no second value may be entered
            if (coordinateArray.length > 1) {
                yString = coordinateArray[1];
            }

            // making sure X value is an int
            if (!checkIfStringIsInt(xString) || !checkIfStringIsInt(yString)) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Now that we know strings are ints, parsing them
            xCoordinate = Integer.parseInt(xString);
            yCoordinate = Integer.parseInt(yString);

            // making sure x and y are within proper range
            if (xCoordinate < 1 || xCoordinate > 3 || yCoordinate < 1 || yCoordinate > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // checking if valid move (location does not already contain a letter)
            boolean seatsTaken = checkIfSeatsTaken(xCoordinate, yCoordinate, ticTacArray);
            if (seatsTaken) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                break;
            }
        }

        return new int[]{xCoordinate, yCoordinate};
    }

    public static void main(String[] args) {
        // Start game with initial state and display it
        String initialState = "_________";
        char[][] ticTacArr = createTicTacArray(initialState);
        printTicTacToeOutput(ticTacArr);

        // Setting initial conditions to determine if game is completed
        boolean xHasWin = false;
        boolean oHasWin = false;
        boolean hasEmptyCells = true;
        char currentCharacter = 'X';

        //  Game play (while no winner)
        while (!oHasWin && !xHasWin & hasEmptyCells) {

            // Get validated user coordinates
            int[] XYCoordinates = getXYCoordinates(ticTacArr);
            int xCoordinate = XYCoordinates[0];
            int yCoordinate = XYCoordinates[1];

            //Update tic tac board and display
            updateTicTacToe(xCoordinate, yCoordinate, ticTacArr, currentCharacter);
            printTicTacToeOutput(ticTacArr);

            // Switching to next players character
            currentCharacter = currentCharacter == 'X' ? 'O' : 'X';

            // Updating game conditions
            xHasWin = checkWinCondition('X',ticTacArr);
            oHasWin = checkWinCondition('O',ticTacArr);
            hasEmptyCells = checkForEmptyCells('_', ticTacArr);
        }

        // Declare game status
        boolean hasUnevenCount = checkForUnevenCount(ticTacArr);
        printGameStatus(xHasWin, oHasWin, hasEmptyCells, hasUnevenCount);

//        // print state prior to player move
//        printTicTacToeOutput(ticTacArr);

        /*
        // Work through games status and print result
        boolean xHasWin = checkWinCondition('X',ticTacArr);
        boolean oHasWin = checkWinCondition('O',ticTacArr);
        boolean hasEmptyCells = checkForEmptyCells('_', ticTacArr);
        boolean hasUnevenCount = checkForUnevenCount(ticTacArr);
        printGameStatus(xHasWin, oHasWin, hasEmptyCells, hasUnevenCount);
        */
    }
}
