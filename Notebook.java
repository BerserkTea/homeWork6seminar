package Seminar6th.homeWork;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import java.security.Key;
import java.sql.Array;
import java.util.*;


/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
*/
public class Notebook {
    private int ram;
    private int ssd;
    private String os;
    private String color;

    public Notebook(int ram, int ssd, String os, String color) {
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return ("ram " + ram + " ssd " + ssd + " os " + os + " color " + color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && ssd == notebook.ssd && Objects.equals(os, notebook.os) && Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return 21 * ram + 18 * ssd + 9 * os.hashCode() + 11 * color.hashCode();
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public String getInfo(){
        return String.format("ram %d ssd %d os %s color %s", ram, ssd, os, color);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static Map menu(){
        Map<String,String> customerChoise = new HashMap<String,String>();
        boolean checker = true;
        while (checker){
        System.out.println("Введите какой критерий хотите изменить");
        System.out.println("1 - RAM");
        System.out.println("2 - Объем SSD");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("0 - Выход");
        Scanner scanner = new Scanner(System.in);
        int item = scanner.nextInt();
            switch (item){
                case 1:
                    System.out.println("Доступны следующие параметры RAM");
                    System.out.println("1 - 4");
                    System.out.println("2 - 8");
                    System.out.println("3 - 16");
                    System.out.println("4 - 32");
                    customerChoise.put("ram", choiseLine());
                    break;
                case 2:
                    System.out.println("Доступны следующие параметры Объем SSD");
                    System.out.println("128");
                    System.out.println("256");
                    System.out.println("512");
                    System.out.println("1024");
                    customerChoise.put("ssd", choiseLine());
                    break;
                case 3:
                    System.out.println("Доступны следующие параметры Операционная система");
                    System.out.println("1 - Windows");
                    System.out.println("2 - Linux");
                    System.out.println("3 - MacOS");
                    customerChoise.put("os", choiseLine());
                    break;
                case 4:
                    System.out.println("Доступны следующие параметры Цвет");
                    System.out.println("1 - Red");
                    System.out.println("2 - Orange");
                    System.out.println("3 - White");
                    System.out.println("4 - Black");
                    System.out.println("5 - Blue");
                    System.out.println("6 - Purple");
                    System.out.println("7 - Silver");
                    System.out.println("8 - Grey");
                    customerChoise.put("color", choiseLine());
                    break;
                default:
                    checker=false;
                    break;
            }
        }
        return customerChoise;
    }

    public static void sort(Map<String, String> customerSelect, Set<Notebook> setNout){
        List<String> keysList = new ArrayList<>(customerSelect.keySet());
        List<String> valueList = new ArrayList<>(customerSelect.values());
        for (Notebook nout: setNout
             ) {
            String[] words = nout.toString().toLowerCase().split(" ");
            int counterSovpadeniy = 0;
            for (int i = 0; i < keysList.size(); i++) {
//                if (Arrays.asList(words).contains(keysList.get(i))) { //todo это может пригодиться
                if (valueList.size()!=0) {
                    int index = Arrays.asList(words).indexOf(keysList.get(i));
//                    верни номер элемента в массиве, и проверим следующий
                    if (isNumeric(valueList.get(i))){
                        if (Integer.parseInt(valueList.get(i))<= Integer.parseInt(words[index+1])){
                            counterSovpadeniy++;
                        }
                    }else {
                        if (valueList.get(i).equals(words[index+1])){
                            counterSovpadeniy++;
                        }
                    }
                }
            }
            if (counterSovpadeniy == keysList.size()) {
                System.out.println("Вот ноутбук подходящий вашм критериям " + nout);
            }
        }
//        System.out.println(keysList);

//        for (Map.Entry entry:
//                customerSelect.entrySet()) {
//            System.out.println(entry);
//        }
//        System.out.println(setNout);//TODO Это мы для проверки вписали, что бы посмотреть чего там выходит), ах какие мы молодцы
    }

//    public static void filterNout(Set<Notebook> laptops) {
//
//        //создал МАР с критериями фильтрации
//
//        Map<String, String> criteria = new HashMap<>();
//        criteria.put("1", "ram");
//        criteria.put("2", "ssd");
//        criteria.put("3", "os");
//        criteria.put("4", "color");
//
//        // запрос критерия у пользователя
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please select criteria");
//        System.out.println("1-ram");
//        System.out.println("2-ssd");
//        System.out.println("3-os");
//        System.out.println("4-color");
//        String userInput = scanner.nextLine();
//
//        //проверяем на существование критерия
//        if (criteria.containsKey(userInput)) {
//            String selectedCriteria = criteria.get(userInput);
//            System.out.println("Insert minimum size of selected criteria");
//            String minValue = scanner.nextLine();
//            //Фильтруем теперь, но ....
//            Set<Notebook> filteredNoutebooks = new HashSet<>();
//
//            switch (selectedCriteria) {
//                case "ram":
//                    int minRam = Integer.parseInt(minValue);
//                    for (Notebook laptop : laptops) {
//                        if (laptop.getRam() >= minRam) {
//                            filteredNoutebooks.add(laptop);
//                        }
//                    }
//                    break;
//                case "ssd":
//                    int minSsdSize = Integer.parseInt(minValue);
//                    for (Notebook laptop : laptops) {
//                        if (laptop.getSsd() >= minSsdSize) {
//                            filteredNoutebooks.add(laptop);
//                        }
//                    }
//                    break;
//                case "os":
//                    for (Notebook laptop : laptops) {
//                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
//                            filteredNoutebooks.add(laptop);
//                        }
//                    }
//                    break;
//                case "color":
//                    for (Notebook laptop : laptops) {
//                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
//                            filteredNoutebooks.add(laptop);
//                        }
//                    }
//                    break;
//                default:
//                    System.out.println("некорректный ввод критерия");
//                    return;
//            }
//            //я валенок, но мы выводим список отфильтрованного
//            if (filteredNoutebooks.isEmpty()) {
//                System.out.println("No laptops mark as criteria");
//            } else {
//                for (Notebook laptop : filteredNoutebooks) {
//                    System.out.println(laptop);
//                }
//            }
//        } else {
//            System.out.println("Incorrect criteria");
//        }
//    }

    private static String choiseLine() {
        Scanner scanner = new Scanner(System.in);
        String choiseLine = scanner.nextLine().toLowerCase();
        return choiseLine;

}
}