import java.util.*;


public class Main {

    /**
     * Мапы
     * 1. Кошки.
     * Имя, порода, возраст(лет):
     * Барсик, британец, 1
     * Бакс, чеширский, 4
     * Туз, сфинкс, 12
     * Юла, дворовая, 7
     * Мышка, дворовая, 3
     * метод1 - завести всех кошек в мапу
     * метод2 - вывести самую старшую кошку
     * метод3 - вывести имена всех кошек в алфавитном порядке
     * метод4 - возвращать имя и возраст в зависимости от введенной породы
     * метод5 - Превратить мапу во множество и вывести все элементы множества.
     */
    public static void main(String[] args) {

        Map<Integer, Cat> catMap = createMap();
        System.out.println("Наша мапа: " + catMap);

        /**
         * вывод имен всех кошек в алфавитном порядке
         */
        displayingCatsInAlphabeticalOrder(catMap);

        /**
         * вывод самой старшей кошки
         */
        displayingOldestCat(catMap);

        Set<Map.Entry<Integer, Cat>> mapSet = catMap.entrySet();
        System.out.println("Сэт из мапы: " + mapSet);

        displayingNameAndAge(catMap);
    }


    public static Map<Integer, Cat> createMap() {
        TreeMap<Integer, Cat> map = new TreeMap<Integer, Cat>();
        map.put(1, new Cat("Барсик", "британец", 1));
        map.put(2, new Cat("Бакс", "чеширский", 4));
        map.put(3, new Cat("Туз", "сфинкс", 12));
        map.put(4, new Cat("Юла", "дворовая", 7));
        map.put(5, new Cat("Мышка", "дворовая", 3));
        return (TreeMap<Integer, Cat>) map;
    }

    /**
     * Метод вывода самой старшей кошки.
     */
    private static void displayingOldestCat(Map<Integer, Cat> map) {

        Map.Entry<Integer, Cat> maxEntry = null;

        for (Map.Entry<Integer, Cat> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().getAge().compareTo(maxEntry.getValue().getAge()) > 0) {
                maxEntry = entry;
            }
        }
        assert maxEntry != null;
        String oldestCatName = maxEntry.getValue().getName();
        System.out.println("Cамая старшая кошка: " + oldestCatName);
    }


    /**
     * Метод вывода имен всех кошек в алфавитном порядке
     */
    private static void displayingCatsInAlphabeticalOrder(Map<Integer, Cat> map) {
        System.out.println("имена всех кошек в алфавитном порядке: ");
        List<String> catNames = new ArrayList<String>();
        for (Map.Entry<Integer, Cat> entry : map.entrySet()) {
            catNames.add(entry.getValue().getName());
            Collections.sort(catNames);
        }
        catNames.forEach(System.out::println);
    }

    /**
     * Метод, возвращающий имя и возраст в зависимости от введенной породы
     *
     * @return HashMap, хранящий имя и возраст кошек одной породы
     */
    private static HashMap<String, Integer> displayingNameAndAge(Map<Integer, Cat> map) {
        HashMap<String, Integer> nameAndAgeHashMap = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите породу кошки:  ");
        String inputBreed = in.next();
        for (Map.Entry<Integer, Cat> entry : map.entrySet()) {
            if (Objects.equals(inputBreed, entry.getValue().getBreed())) {
                nameAndAgeHashMap.put(entry.getValue().getName(), entry.getValue().getAge());
            }
        }
        in.close();
        System.out.println("Имя и возраст кошки породы " + inputBreed + ": " + nameAndAgeHashMap);
        return nameAndAgeHashMap;

    }

    /**
     * Класс Кошка
     */
    public static class Cat implements Comparable<Cat> {

        public String getName() {
            return name;
        }

        public String getBreed() {
            return breed;
        }

        public Integer getAge() {
            return age;
        }

        private final String name;
        private final String breed;
        private final Integer age;


        public Cat(String name, String breed, Integer age) {
            this.name = name;
            this.breed = breed;
            this.age = age;

        }

        @Override
        public String toString() {
            return "{" +
                    "имя:'" + name + '\'' +
                    ", порода='" + breed + '\'' +
                    ", возраст=" + age +
                    '}';
        }

        @Override
        public int compareTo(Cat o) {
            return 0;
        }
    }

}