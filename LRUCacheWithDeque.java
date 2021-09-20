package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheWithDeque {

    static Deque <Integer> deque = new LinkedList<>();
    static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main (String [] args){
        String[] hits = {
                "1,google.com",
                "2,mail.yahoo.com",
                "3,mobile.sports.yahoo.com",
                "4,sports.yahoo.com",
                "5,yahoo.com",
                "2,mail.yahoo.com",
                "2,mail.yahoo.com",
                "2,mail.yahoo.com",
                "4,sports.yahoo.com",
                "6,stackoverflow.com",
                "7,overflow.com",
                "8,com.com",
                "2,mail.yahoo.com",
                "4,sports.yahoo.com",
                "2,mail.yahoo.com",
                "9,en.wikipedia.org",
                "10,m.wikipedia.org",
                "11,mobile.sports",
                "12,google.co.uk",
                "2,mail.yahoo.com"
        };
        processLRU(hits, 5);
    }

    private static void processLRU(String[] hits, int maxCapacity) {

        for(int i = 0; i < hits.length; i++) {

            int id = Integer.parseInt(hits[i].split(",")[0]);
            String value = hits[i].split(",")[1];

            System.out.println("Processing: "+ id + " - " + value);

            if(map.get(id) == null) {
                System.out.println("Entry not found: "+ id + " - " + value);
                if (deque.size() < maxCapacity) {
                    map.put(id, value);
                } else {
                    int idToRemove = deque.removeLast();
                    System.out.println("removing: "+ idToRemove);
                    map.remove(idToRemove);
                    map.put(id, value);
                }
            } else {
                System.out.println("Entry found: "+ id + " - " + value);
                System.out.println("removing to add: "+ id);
                deque.remove(id);
            }
            System.out.println("Pushing: "+ id + " - " + value);
            deque.push(id);
        }


        System.out.println(Arrays.asList(map));

        Iterator<Integer> itr = deque.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
    }


}
