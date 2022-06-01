package assignmentone.taskseven;

import java.util.Random;

/**
 * Print ants steps.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Ants {
  static boolean chessBoard(int[][] chessBoard) {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (chessBoard[row][col] == 0) {
          return false;
        }
      }
    }
    return true;
  }
  /**
   * main method to get ants steps simulation.
   */

  public static void main(String[] args) {
    System.out.println("Ants");
    System.out.println("===========\n");
    double stepsAverage = 0;
    Random rnd = new Random();

    for (int simulation = 1; simulation <= 10; simulation++) {
      int[][] boardofChess = new int[8][8]; // make a chessBoard with row & col
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          boardofChess[row][col] = 0;
        }
      }

      int row = rnd.nextInt(8);
      int columon = rnd.nextInt(8);

      boardofChess[row][columon] = 1;
      int step = 0;

      while (!chessBoard(boardofChess)) {
        int move = rnd.nextInt(4);  // can step up, down, right and left
        if (move == 0) { 
          if (row > 0) { 
            row--; 
            step++;
          }
        } else if (move == 1) { 
          if (row < 7) {
            row++;
            step++;
          }
        } else if (move == 2) { 
          if (columon > 0) { 
            columon--;
            step++;
          }
        } else if (move == 3) { 
          if (columon < 7) {
            columon++; 
            step++;
          }
        }
        boardofChess[row][columon] = 1;
      }
      stepsAverage += step;
      System.out.println("Number of steps in simulation " + simulation + " : " + step);
    }
    System.out.println("Average amount of steps : " + stepsAverage / 10);
  }
}
// done
