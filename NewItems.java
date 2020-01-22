import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Abena Okyere
 * this class defines an item class with
 * the name of the item, the quantity and the price as parameters
 * it also defines a method that writes the parameters passed to a file
 */

public class NewItems {
    public String shelf_Item;
    public int quantity;
    public float price;


    public NewItems(){}

    public NewItems(String shelf_Item, int quantity, float price) {
        this.shelf_Item = shelf_Item;
        this.quantity = quantity;
        this.price = price;
    }

    public void setItemName(String name) {
        this.shelf_Item = name;
    }

    public void setItemQuantity(int quant) {
        this.quantity = quant;
    }

    public void setItemPrice(float pricetag) {
        this.price = pricetag;
    }

    public String getShelf_Items() {
        return shelf_Item;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void capture(){ // this is a method to capture the data from the keyboard
        for (int i=0;i<10;i++){
            Scanner myscanner=new Scanner(System.in);
            String prodname= myscanner.next();
            int prodquant=myscanner.nextInt();
            float prodprice=myscanner.nextFloat();
            NewItems items= new NewItems(prodname,prodquant,prodprice);
            write(prodname);
            write(" ");
            String myquantity= prodquant + "  ";
            write(myquantity);
            write("");
            String myprice= "GHS "+ prodprice + "  ";
            write(myprice);
            write("\n");

        }
        System.out.println("STOCK FULL");
    }
    public void  write(String prod){ // this method writes the data to the essentials main file and the backup file as well
        try {
            FileWriter fileWriter=new FileWriter("essentials_stock.txt",true);
            fileWriter.write(prod);
            fileWriter.close();
            FileWriter fileWriter1=new FileWriter("backup_essentials_stock.txt",true);
            fileWriter1.write(prod);
            fileWriter1.close();
        }
        catch (IOException e){
            System.out.println("file does not exist");
        }
    }
}