

public class Calculator {

    String list = "";
    float totalPrice = 0;

    RubleFormatter formatter = new RubleFormatter();

    void add(float price) {
        totalPrice += price;
    }

    void writeToTheList(String nameOfProduct, float priceOfProduct) {
        list += nameOfProduct.trim().toLowerCase();
        list += " ";
        list += priceOfProduct;
        list += "\n";
    }

    void showCheck(int numberOfUsers) {
        System.out.println("Добавленные товары:");
        System.out.println(list);
        String messageTemplateTotalPrice = "Итоговая сумма: %.2f %s.";
        String messageTemplateResult = "Каждый должен заплатить %.2f %s.";

        String formattedUnit = formatter.formatUnit(totalPrice);
        System.out.println(String.format(messageTemplateTotalPrice, totalPrice, formattedUnit));

        formattedUnit = formatter.formatUnit(totalPrice / numberOfUsers);
        System.out.println(String.format(messageTemplateResult, totalPrice / numberOfUsers, formattedUnit));
    }
}
