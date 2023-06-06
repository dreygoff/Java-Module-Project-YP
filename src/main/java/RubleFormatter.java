public class RubleFormatter {


    String formatUnit(float price) {
        /*
        Здесь форматируем окончание валюты, в зависимости от цены.
        Если предпоследняя цифра "1", то возвращаем рублей
        Иначе если последняя 1 - рубль, 2,3,4 - рубля, 5,6,7,8,9,0 - рублей
        */

        int formattedPrice = (int) Math.floor(price);

        if (formattedPrice % 100 / 10 == 1) {
            return "рублей";
        }

        switch (formattedPrice % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
