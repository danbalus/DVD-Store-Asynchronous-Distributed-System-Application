package entity;

public class DigitalVideoDisc {
  // The producer sends a DVD to the queue
  // The Consumer sends an email with each new DVD added
  // Add another message consumer that creates a text file with for each message and
  //prints the content of the message in the text file

    private String title;
    private int year;
    private double price;

    public DigitalVideoDisc(){}

    public DigitalVideoDisc(String title, int year, double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
