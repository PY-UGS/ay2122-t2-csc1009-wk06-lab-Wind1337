import java.util.*;

public class Main {
    public static void main(String[] args){
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }

    public static void Question1(){
        System.out.println("\nQuestion 1: Add value '8' to Linked List");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(3);
        linkedList1.add(5);
        linkedList1.add(7);
        linkedList1.add(9);
        linkedList1.add(11);
        System.out.println("Contents of Linked List 1 before: " + linkedList1);
        addAndSort(linkedList1, 8);
        System.out.println("Contents of Linked List 1 after: " + linkedList1);
    }

    public static void Question2(){
        System.out.println("\nQuestion 2: Swap values of Linked List index 2 and 5");
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(1);
        linkedList2.add(3);
        linkedList2.add(5);
        linkedList2.add(7);
        linkedList2.add(9);
        linkedList2.add(11);
        System.out.println("Contents of Linked List 2 before: " + linkedList2);
        swapValues(linkedList2, 1, 5);
        System.out.println("Contents of Linked List 2 after: " + linkedList2);
    }

    public static void Question3(){
        System.out.println(("\nQuestion 3: Check if integer exists in Linked List"));
        LinkedList<Integer> linkedList3 = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 500; i++){
            linkedList3.add(random.nextInt(9999) + 1000);
        }
        int targetVal = random.nextInt(9999) + 1000;
        int result = findValue(linkedList3, targetVal);
        System.out.println("The result of the search is: " + result);
    }

    public static void Question4(){
        System.out.println("\nQuestion 4: Add value '8' to hash table");
        Hashtable<Integer, Integer> hashtable1 = new Hashtable<>();
        hashtable1.put(1, 1);
        hashtable1.put(3, 3);
        hashtable1.put(5, 5);
        hashtable1.put(7, 7);
        hashtable1.put(9, 9);
        hashtable1.put(11, 11);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(hashtable1);

        Set<Integer> keys = treeMap.keySet();
        Iterator<Integer> iterator = keys.iterator();

        System.out.print("Contents of hash table before: ");
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(treeMap.get(i) + " ");
        }

        hashInsertAndSort(hashtable1, 8);

        treeMap = new TreeMap<>(hashtable1);
        keys = treeMap.keySet();
        iterator = keys.iterator();

        System.out.print("\nContents of hash table after: ");
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(treeMap.get(i) + " ");
        }
    }

    public static void Question5(){
        System.out.println("\n\nQuestion 5: Swap values of Hash Map value 3 and 11");
        LinkedHashMap<Integer, Integer> linkedHashMap1 = new LinkedHashMap<>();

        int[] insertValues = {1,3,5,7,9,11};
        for(int i = 0; i < insertValues.length; i++){
            linkedHashMap1.put(insertValues[i], insertValues[i]);
        }

        Set<Integer> keys = linkedHashMap1.keySet();
        Iterator<Integer> iterator = keys.iterator();

        System.out.print("Contents of hash map before: ");
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(linkedHashMap1.get(i) + " ");
        }

        hashSwapValues(linkedHashMap1, 1, 5, insertValues);

        keys = linkedHashMap1.keySet();
        iterator = keys.iterator();

        System.out.print("\nContents of hash map after: ");
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(linkedHashMap1.get(i) + " ");
        }
    }

    public static void Question6(){
        System.out.println(("\n\nQuestion 6: Check if integer exists in Hash Table"));
        Hashtable<Integer, Integer> hashtable2 = new Hashtable<>();
        Random random = new Random();
        for (int i = 0; i < 500; i++){
            hashtable2.put(i, random.nextInt(9999) + 1000);
        }
        int targetVal = random.nextInt(9999) + 1000;
        int result = hashFindValue(hashtable2, targetVal);
        System.out.println("The result of the search is: " + result);
    }

    public static void addAndSort(LinkedList<Integer> list, int value){
        for (int i = 0; i < list.size(); i++){
            if (value <= list.get(i)){
                list.add(i, value);
                break;
            }
        }
    }

    public static void swapValues(LinkedList<Integer> list, int indexOne, int indexTwo){
        int temp = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, temp);
    }

    public static int findValue(LinkedList<Integer> list, int searchVal){
        for (int i = 0; i < list.size(); i++){
            if (searchVal == list.get(i)){
                return i;
            }
        }
        return -1;
    }

    public static void hashInsertAndSort(Hashtable<Integer, Integer> hashtable, int value){
        hashtable.put(value, value);
    }

    public static void hashSwapValues(LinkedHashMap<Integer, Integer> linkedHashMap, int indexOne, int indexTwo, int[] insertValues){
        int temp = insertValues[indexOne];
        insertValues[indexOne] = insertValues[indexTwo];
        insertValues[indexTwo] = temp;

        linkedHashMap.clear();

        for(int i = 0; i < insertValues.length; i++){
            linkedHashMap.put(insertValues[i], insertValues[i]);
        }
    }

    public static int hashFindValue(Hashtable<Integer, Integer> hashtable, Integer searchVal){
        if(hashtable.contains(searchVal)){
            for(Map.Entry entry: hashtable.entrySet()) {
                if (searchVal.equals(entry.getValue())) {
                    int key = (int) entry.getKey();
                    return key; //breaking because its one to one map
                }
            }
        }
        return -1;
    }
}
