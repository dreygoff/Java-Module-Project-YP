
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfUsers = -1;

        Scanner scanner = new Scanner(System.in); // Создаем экземпляр класса Scanner.
        Calculator calculator = new Calculator();

        numberOfUsers = getNumberOfPeople(scanner);
        getProductsInfo(scanner, calculator);
        calculator.showCheck(numberOfUsers);

        scanner.close(); // Закрываем Scanner по завершении работы.
    }


    public static int getNumberOfPeople(Scanner scan) {
        int numb = -1;
        while (true) {
            System.out.println("Введите, на скольких человек необходимо разделить счёт");

            numb = getInt(scan);
            if (numb > 1) {
                break;
            } else {
                System.err.println("Некорректное число");
            }
        }
        return numb;
    }


    public static void getProductsInfo(Scanner scan, Calculator calculator) {
        while (true) {
            String nameOfProduct = "";
            float priceOfProduct = 0;

            System.out.println("Введите название товара");
            nameOfProduct = scan.next();


            while (priceOfProduct <= 0) {

                System.out.println("Введите цену товара");

                priceOfProduct = getFloat(scan);

                if (priceOfProduct > 0) {
                    calculator.add(priceOfProduct);
                    calculator.writeToTheList(nameOfProduct, priceOfProduct);
                    System.out.println("Товар успешно добавлен");
                } else {
                    System.err.println("Некорректная цена!");
                }

            }

            System.out.println("Продолжить ввод товаров? Введите \"Завершить\"," +
                    " если хотите окончить ввод товаров, или любой символ, если хотите продолжить ввод");
            String command = scan.next();

            if (command.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }



    public static float getFloat(Scanner scan) {
        try {
            float number = scan.nextFloat();
            return number;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return 0;
        }
    }

    public static int getInt(Scanner scan) {
        try {
            int number = scan.nextInt();
            return number;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return 0;
        }
    }


}




