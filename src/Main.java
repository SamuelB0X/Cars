import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, What's your name?");
        String customerName = input.nextLine();

        System.out.println("Nice to meet you " + customerName);

        String path = "./welcome.txt";
        try {
            FileReader reader = new FileReader(path);
            while (reader.ready()){
                System.out.print((char) reader.read());
            }
            reader.close();
        } catch (IOException e){
            System.out.println(e);
        }

        System.out.println("\nPlease, provide a review: ");
        String review = input.nextLine();
        String customerReview = customerName + ": " + review;
        String reviewPath =  "./customerReview.txt";
        try {
            FileWriter output = new FileWriter(reviewPath);
            output.write(customerReview);
            output.close();
        } catch (IOException e) {
            System.out.println(e);
        }


        Car toyota = new Car("Toyota",2021, "ABC");
        Car honda = new Car("Honda",2021, "XYZ");

        try {
            FileOutputStream FileOutputStream = new FileOutputStream("./cars.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(FileOutputStream);

            objectOutputStream.writeObject(toyota);
            objectOutputStream.writeObject(honda);
        }catch (IOException e){
            System.out.println(e);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("./cars.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Car toyotaCopy = (Car) objectInputStream.readObject();
            Car hondaCopy = (Car) objectInputStream.readObject();

            System.out.println("Avariable cars: ");
            System.out.println(toyotaCopy);
            System.out.println(hondaCopy);

        } catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
}