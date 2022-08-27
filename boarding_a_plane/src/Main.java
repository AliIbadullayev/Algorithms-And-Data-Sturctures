import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] seats = new int[4][6];
        int counter = 0;
        while (counter != n) {
            char[] row = scanner.next().toCharArray();
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '_')
                    continue;
                if (i > 3) {
                    if (row[i] == '.')
                        seats[counter][i - 1] = 0;
                    else
                        seats[counter][i - 1] = 1;
                } else {
                    if (row[i] == '.')
                        seats[counter][i] = 0;
                    else
                        seats[counter][i] = 1;
                }
            }
            counter++;
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {

            int num = scanner.nextInt();
            String side = scanner.next();
            String pos = scanner.next();

            takeSeats(n, seats, num, side, pos);
        }
    }

    public static void takeSeats(int n, int[][] seats, int num, String side, String pos) {
        int counter;
        int row = 0;
        boolean canSeat = true;
        if (side.equals("left")) {
            while (row != n) {
                int[] takenSeats = new int[6];
                if (pos.equals("window")) {
                    counter = 0;
                    while (counter != num) {
                        canSeat &= seats[row][counter] == 0;
                        takenSeats[counter] = 1;
                        counter++;
                    }
                } else {
                    counter = 2;
                    while (counter != 3 - num - 1) {
                        canSeat &= seats[row][counter] == 0;
                        takenSeats[counter] = 1;
                        counter--;
                    }
                }
                if (!canSeat) {
                    row++;
                    canSeat = true;
                } else {
                    printRes(seats, side, row, takenSeats);
                    return;
                }
            }
        } else {
            while (row != n) {
                int[] takenSeats = new int[6];
                if (pos.equals("window")) {
                    counter = 2;
                    while (counter != 3 - num - 1 ) {
                        canSeat &= seats[row][counter + 3] == 0;
                        takenSeats[counter + 3] = 1;
                        counter--;
                    }
                } else {
                    counter = 0;
                    while (counter != num) {
                        canSeat &= seats[row][counter + 3] == 0;
                        takenSeats[counter + 3] = 1;
                        counter++;
                    }
                }
                if (!canSeat) {
                    row++;
                    canSeat = true;
                } else {
                    printRes(seats, side, row, takenSeats);
                    return;
                }
            }
        }
        System.out.println("Cannot fulfill passengers requirements.");

    }


    private static void printRes(int[][] seats, String side, int row, int[] takenSeats) {
        System.out.print("Passengers can take seats:");

        for (int i = 0; i < takenSeats.length; i++) {
            if (side.equals("left")) {
                if (takenSeats[i] == 1) {
                    System.out.print(" ");
                    if (i == 0) System.out.print((row+1) + "A");
                    if (i == 1) System.out.print((row+1) + "B");
                    if (i == 2) System.out.print((row+1) + "C");
                }
            }
            if (side.equals("right")) {
                if (takenSeats[i] == 1) {
                    System.out.print(" ");
                    if (i == 3) System.out.print((row+1) + "D");
                    if (i == 4) System.out.print((row+1) + "E");
                    if (i == 5) System.out.print((row+1) + "F");

                }
            }
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[1].length; j++) {
                if (row == i) {
                    if (takenSeats[j] == 1) {
                        System.out.print("X");
                        seats[i][j] = 1;
                        if (j == 2) {
                            System.out.print("_");
                        }
                        continue;
                    }
                }
                if (seats[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
                if (j == 2) {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
