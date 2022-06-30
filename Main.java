/*
File Name: main.java
Name: Amar Panjwani
Description: This program simulates a seat-picking menu for a theatre by allowing the user to choose their seat either by price or specific row and column.
Date: 03/22/21
Email: panjwania@student.vvc.edu
*/

import java.util.Scanner;

class Main {
  /**
    Prints an array that shows all the available seats.
    @param seats - the array to display
    @return void
  */
  public static void printSeats(int[][] seats)
  {
    final int ROWS = 9;
    final int COLUMNS = 10;
    for (int i = 0; i < ROWS; i++) 
    {
      for (int j = 0; j < COLUMNS; j++)
      {
        System.out.printf("%8d", seats[i][j]);
      }
      System.out.println(); 
    }
    System.out.println();
  }
  /**
    Searches for the next seat at a specified price.
    @param seats - the array to search within
    @price - the value to find
  */
  public static void searchPrice(int[][] seats,int price)
  {
    Scanner in = new Scanner(System.in);
    int posRow = 0;
    int posColumn = 0;
    boolean found = false;
    while (posRow < seats.length && !found)
    {
      posColumn = 0;
      while (posColumn < seats[0].length && !found)
      {
        if(seats[posRow][posColumn] == price)
        {
          found = true;
          System.out.println("Your new seat is at: Row " + posRow + " Column: " + posColumn);
          seats[posRow][posColumn] = 0;
        }
        else
        {
          posColumn++;
        }
      }  
      posRow++; 
      }  
    if(!found)
    {
      System.out.println("Unfortunately, all seats at that price have already been booked.");
    }
  }
  /**
    Searches for the availability of a user-specified seat.
    @param seats - array to search within
    @rowNumber - the row number of the desired value
    @columnNumber - the column number of the desired value
  */
  public static void searchSeat(int[][] seats, int rowNumber, int columnNumber)
  {
    if (seats[rowNumber][columnNumber] == 0)
    {
      System.out.println("Seat already taken, please try again.");
    }
    else
    {
      System.out.println("Seat available - successfully booked Row: " + rowNumber + " Column: " + columnNumber );
      seats[rowNumber][columnNumber] = 0;
    }
  }

  public static void main(String[] args) 
  {
    int[][] seats =
    {
      {10,10,10,10,10,10,10,10,10,10},
      {10,10,10,10,10,10,10,10,10,10},
      {10,10,10,10,10,10,10,10,10,10},
      {10,10,20,20,20,20,20,20,10,10},
      {10,10,20,20,20,20,20,20,10,10},
      {10,10,20,20,20,20,20,20,10,10},
      {20,20,30,30,40,40,30,30,20,20},
      {20,30,30,40,50,50,40,30,30,20},
      {30,40,50,50,50,50,50,50,40,30}
    };
    
    int choice = 0;
    while (choice != -1)
    {
      System.out.println("");
      printSeats(seats);
      Scanner in = new Scanner(System.in);
      System.out.print("Enter 1 to pick a specific seat, 2 to pick the next available seat by price, or -1 if done: ");
      choice = in.nextInt();
      if (choice == 1)
      {
        System.out.print("Enter desired row number (0-8): ");
        int rowNumber = in.nextInt();
        System.out.print("Enter desired column number (0-9): ");
        int columnNumber = in.nextInt();
        searchSeat(seats, rowNumber, columnNumber);
      }
      else if (choice == 2)
      {
        System.out.print("Enter desired price (10,20,30,40, or 50 dollars): ");
        int price = in.nextInt();
        searchPrice(seats,price);
      }
      else if (choice == -1)
      {
        System.out.println("Enjoy the show!");
      }
      else
      {
        System.out.println("Invalid input, try again.");
      }
    }
  }
}