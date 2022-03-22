package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    This is a Work in Progress, the main functionality is there, however there's still no validation for wrong 
    Seat formats, and there's no JUnit implementation, will keep working on it
*/

public class ListChallenge {
    
    static List<Seat> listOfSeats = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            char row = 'A';
            switch (i) {
                case 0:
                    row = 'A';
                    break;
                case 1:
                    row = 'B';
                    break;
                case 2:
                    row = 'C';
                    break;
                case 3:
                    row = 'D';
                    break;
                case 4:
                    row = 'E';
                    break;
                case 5:
                    row = 'F';
                    break;
                case 6:
                    row = 'G';
                    break;
                case 7:
                    row = 'H';
                    break;
            }
            for (int j = 0; j < 8; j++) {
                listOfSeats.add(new Seat(row, j, 50, false));
            }
        }
        Theatre theatre = new Theatre("Java Cinema", listOfSeats, 8, 64);
        reserve("A3");
        reserve("A4");
        reserve("A7");
        reserve("D3");
        reserve("D4");
        reserve("D5");
        reserve("C7");
        reserve("B4");
        reserve("H7");
        cancel("A4");
        printSeats(listOfSeats);
        System.out.println("Total Available: " + 64);
        System.out.println("Total Sold: " + theatre.getReservedSeats());
        System.out.println("Total Income: " + theatre.getTotalIncome());
        
    }
    
    private static void reserve(String seat){
        char row = seat.charAt(0);
        int line = Character.getNumericValue(seat.charAt(1));
        int index = -1;
        for (Seat item : listOfSeats) {
            if (item.getLine()== line && item.getRow() == row) {
                index = listOfSeats.indexOf(item);
            }
        }
        listOfSeats.get(index).setIsReserved(true);
    }
    
    private static void cancel(String seat){
        char row = seat.charAt(0);
        int line = Character.getNumericValue(seat.charAt(1));
        int index = -1;
        for (Seat item : listOfSeats) {
            if (item.getLine()== line && item.getRow() == row) {
                index = listOfSeats.indexOf(item);
            }
        }
        listOfSeats.get(index).setIsReserved(false);
    }

    private static void printSeats(List<Seat> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (list.get(i).getLine() == 7) {
                System.out.print("\n");
            }
        }
    }
}

class Seat {

    char row;
    int line;
    int price;
    boolean isReserved;

    public Seat(char row, int line , int price, boolean isReserved) {
        this.line = line;
        this.row = row;
        this.price = price;
        this.isReserved = isReserved;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    @Override
    public String toString() {
        if (isReserved)
            return "["+ row + line +"]";
        else
            return ".";
    }

}

class Theatre {

    String name;
    List<Seat> seats;
    int rows;
    int numberOfSeats;

    public Theatre(String name, List<Seat> seats, int rows, int numberOfSeats) {
        this.name = name;
        this.seats = seats;
        this.rows = rows;
        this.numberOfSeats = numberOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }
    
    public int getReservedSeats(){
        int reservedSeats = 0;
        for(Seat seat : seats){
            if (seat.isReserved()) {
                reservedSeats++;
            }
        }
        return reservedSeats;
    }
    
    public int getTotalIncome() {
        int income = 0;
        for(Seat seat : seats){
            if (seat.isReserved()) {
                income+= seat.getPrice();
            }
        }
        return income;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "name=" + name + "\n rows=" + rows + ", numberOfSeats=" + numberOfSeats;
    }
}
