import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {
    /**
     * * 	метод1 - завести числа от 0 до 300 000 000 млн
     * * 	метод2 - выполнить сортировку по возрастанию
     * * 	метод3 - вывести только нечетные числа
     * * 	метод4 - удалить из списка/множества все числа, которые делятся на 5 без остатка(метод должен возвращать список/множество)
     * * 	метод5 - удалять последний элемент списка/множества, пока не останется 100 элементов(метод должен возвращать список/множество)
     * * 	метод6 - превратить полученный в м5 список/множество в мапу, где вторым значением(value) является результат конкантенации заданной строки и значения списка/множества
     * * 	+ придумать еще 3 метода для работы со списком/множеством, что еще можно с ними сделать.
     */
    public static void main(String[] args) {
        /**
         * завести числа от 0 до 300млн
         */
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 301; i++) {
            numbers.add(i);
        }
        printSort(numbers);
        onlyOddNumbers(numbers);
        System.out.println(divByFiveWithoutRemainder(numbers));
        System.out.println(deleteLastElementUntilOneHundredIsLeft(numbers));
        System.out.println(createWonderMap(numbers));
    }

    /**
     * Метод, выполняющий сортировку по возрастанию и вывод
     */
    public static void printSort(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println("После сортировки:");
        for (int counter : numbers) {
            System.out.println(counter);
        }
    }

    /**
     * Метод, выполняющий вывод только нечетных чисел
     */
    public static void onlyOddNumbers(ArrayList<Integer> numbers) {
        System.out.println("Нечетные числа:");
        System.out.println(numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList()));
    }

    /**
     * Метод, выполняющий удаление из списка/множества всех чисел, которые делятся на 5 без остатка
     *
     * @return
     */
    public static ArrayList<Integer> divByFiveWithoutRemainder(ArrayList<Integer> numbers) {
        System.out.println("Числа, которые делятся на 5 без остатка:");
        ArrayList<Integer> res = (ArrayList<Integer>) numbers.stream().filter(n -> n % 5 == 0 && (n != 0)).collect(Collectors.toList());
        return res;
    }

    /**
     * Метод, выполняющий удаление последнего элемента списка/множества, пока не останется 100 элементов
     */
    public static ArrayList<Integer> deleteLastElementUntilOneHundredIsLeft(ArrayList<Integer> numbers) {
        System.out.println("Первые 100 элементов:");
        return (ArrayList<Integer>) numbers.stream().limit(100).collect(Collectors.toList());
        /**int indexOfLastElement;
         while (numbers.size() > 100) {
         indexOfLastElement = numbers.size() - 1;
         numbers.remove(indexOfLastElement);
         }*/
    }

    /**
     * Метод, выполняющий превращение полученного в м5 список/множество в мапу, где вторым значением(value) является результат конкатенации заданной строки и значения списка/множества
     */
    public static Map<Integer, String> createWonderMap(ArrayList<Integer> numbers) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:  ");
        String inputString = String.valueOf(in.nextLine());

        Map<Integer, String> map = new HashMap<>();
        for (Integer number : numbers) {
            map.put(number, inputString + number);
        }
        in.close();
        return map;
    }


}
