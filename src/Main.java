import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        //Задача 1
        oddNumbers();

        //Задача 2
        evenNumbers();

        //Задача 3
        stringSet();

        //Задача 4
        wordsNumbers();

        reader.close();
    }

    public static void oddNumbers() throws IOException {
        String s;
        int a = 0;
        int n = 0;

        List<Integer> myList = new ArrayList<>();
        System.out.println("Задача 1");

        System.out.println("Сколько чисел Вы хотите ввести?");
        s = reader.readLine();
        n=Integer.parseInt(s);

        for (int i = 0; i < n; i++){
            System.out.println("Введите целое число:");
            s=reader.readLine();
            a=Integer.parseInt(s);
                    if (a % 2 != 0) {
                        myList.add(a);
                    }
        }
        System.out.println("Среди введенных чисел нечетными являются:");
        System.out.println(myList);


    }


    public static void evenNumbers() throws IOException{
      String s;
      int a = 0;
      int n = 0;

      HashSet<Integer> mySet = new HashSet<Integer>();
      System.out.println("Задача 2");

      System.out.println("Сколько чисел Вы хотите ввести?");
      s = reader.readLine();
      n=Integer.parseInt(s);

      for (int i = 0; i < n; i++){
          System.out.println("Введите целое число:");
          s=reader.readLine();
          a=Integer.parseInt(s);
          if (a % 2 == 0) {
              mySet.add(a);
          }
      }
      List<Integer> myList = new ArrayList<>(mySet);
      Collections.sort(myList);
      System.out.println("Среди введенных чисел четными являются:");
      System.out.println(myList);
    }

    public static void stringSet() throws IOException {
        int n = 0;
        String s="";
        HashSet<String> mySet = new HashSet<String>();
        System.out.println("Задача 3");
        System.out.println("Сколько слов вы хотите ввести?");
        s=reader.readLine();
        n=Integer.parseInt(s);

        for (int i = 0; i < n; i++){
            System.out.println("Введите слово "+i+":");
            s=reader.readLine();
            mySet.add(s);
        }
        System.out.println("Список уникальных слов:");
        System.out.println(mySet);
    }

    public static void wordsNumbers() throws IOException{
        int n = 0;
        String s="";
        String p="";
        int k=0;
        int i=0;
        List<String> myList = new ArrayList<>();

        System.out.println("Задача 4");
        System.out.println("Сколько слов вы хотите ввести?");
        s=reader.readLine();
        n=Integer.parseInt(s);

        for (i = 0; i < n; i++){
            System.out.println("Введите слово "+i+":");
            s=reader.readLine();
            myList.add(s);
        }
        Collections.sort(myList);
        HashMap<String,Integer>wordStat=new HashMap<>();
        i=0;
        n=1;

        while (i < myList.size()) {
            s=myList.get(i);
            if (i + 1 < myList.size()) {
                p= myList.get(i+1);
            }else{
                p="";
            }

            if (p.equals(s)) {
                n++;
                if (i + 1 == myList.size()) {
                    wordStat.put(s,n);
                }
            }else{
                wordStat.put(s,n);
                n=1;
            }
            i++;
        }
        System.out.println("Отсортированный исходный список слов:");
        System.out.println(myList);
        System.out.println("Статистика вхождений по словам:");
        for (Map.Entry<String, Integer> pair : wordStat.entrySet())
        {
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + ":" + value);
        }
    }

}