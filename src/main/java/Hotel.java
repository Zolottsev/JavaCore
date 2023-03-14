import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Hotel {
    /**
     * Отель. Реализовать логику бронирования номеров.
     * Завести 100 номеров: номер - тип номера(стандарт, люкс, супер-люкс)
     * Импользовать мапу
     * метод1 - бронирование номера
     * метод2 - Выполнить поиск и вывод всех забронированных номеров
     * метод3 - получить булево значение, свободен номер или занят
     */
    public static void main(String[] args) {
        Map<Integer, Room> roomMap = new HashMap<>();
        for (int i = 1; i < 101; i++)
            roomMap.put(i, new Room(i, getRandomType(), TRUE));

        getBookingStatus(roomMap);
        bookingRoom(roomMap);
        getBookingStatus(roomMap);

    }


    public static class Room {


        public Integer getNumberOfRoom() {
            return numberOfRoom;
        }

        private final Integer numberOfRoom;

        public Boolean getStatus() {
            return isFree;
        }

        Boolean isFree;
        Type roomType;

        public Room(Integer numberOfRoom, Type type, Boolean isFree) {
            this.numberOfRoom = numberOfRoom;
            this.isFree = isFree;
        }

    }

    /**
     * Метод бронирования номера
     */
    private static void bookingRoom(Map<Integer, Room> roomMap) {


        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер комнаты для подтверждения бронирования или 0 для выхода:  ");

        while (true) {

            try {
                Integer inputRoomNumber = Integer.valueOf(in.next());
                Room room = roomMap.get(inputRoomNumber);
                if (inputRoomNumber == 0)
                    break;
                else if (inputRoomNumber > roomMap.size())
                    System.out.println("Комнаты с номером " + inputRoomNumber + " не существует. Введите другой номер или нажмите 0 для выхода");
                else if (room.isFree == FALSE)
                    System.out.println("К сожалению номер " + inputRoomNumber + " уже занят. Введите другой номер или нажмите 0 для выхода");
                else {
                    Boolean isThisRoomFree = room.getStatus();
                    if (isThisRoomFree == TRUE) {
                        roomMap.replace(inputRoomNumber, new Room(inputRoomNumber, room.roomType, FALSE));
                        System.out.println("Номер " + inputRoomNumber + " успешно забронирован");
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        in.close();

    }

    /**
     * Метод, выполняющий поиск и вывод всех забронированных номеров
     */
    private static void getBookingStatus(Map<Integer, Room> roomMap) {
        List<Integer> bookedRooms = new ArrayList<Integer>();
        for (Map.Entry<Integer, Hotel.Room> entry : roomMap.entrySet()) {
            if (entry.getValue().getStatus() == FALSE) {
                bookedRooms.add(entry.getValue().getNumberOfRoom());
            }
        }
        if (bookedRooms.size() > 0) System.out.println("Список всех забронированных номеров:  " + bookedRooms);
        else System.out.println("Все номера свободны");
    }


    enum Type {STANDARD, DELUXE, SUPER_DELUXE}

    private static Type getRandomType() {
        List<Type> enumTypes = Arrays.asList(Type.values());
        Random rand = new Random();
        return enumTypes.get(rand.nextInt(enumTypes.size()));
    }

}
