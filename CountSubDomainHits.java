package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**

 You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

 counts = [ "900,google.com",
 "60,mail.yahoo.com",
 "10,mobile.sports.yahoo.com",
 "40,sports.yahoo.com",
 "300,yahoo.com",
 "10,stackoverflow.com",
 "20,overflow.com",
 "5,com.com",
 "2,en.wikipedia.org",
 "1,m.wikipedia.org",
 "1,mobile.sports",
 "1,google.co.uk"]

 Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

 Sample output (in any order/format):

 calculateClicksByDomain(counts) =>
 com:                     1345
 google.com:              900
 stackoverflow.com:       10
 overflow.com:            20
 yahoo.com:               410
 mail.yahoo.com:          60
 mobile.sports.yahoo.com: 10
 sports.yahoo.com:        50
 com.com:                 5
 org:                     3
 wikipedia.org:           3
 en.wikipedia.org:        2
 m.wikipedia.org:         1
 mobile.sports:           1
 sports:                  1
 uk:                      1
 co.uk:                   1
 google.co.uk:            1


 [{stackoverflow.com=10, mail.yahoo.com=60, sports.yahoo.com=40, google.com=900, en.wikipedia.org=2, mobile.sports.yahoo.com=10, mobile.sports=1, yahoo.com=300, com.com=5, m.wikipedia.org=1, google.co.uk=1, overflow.com=20}]

 n: number of domains in the input
 (individual domains and subdomains have a constant upper length)
*/


public class CountSubDomainHits {
    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Map<String, Long> counter = getDomainHits(counts);

        System.out.println(counter.keySet().size());
        System.out.println(Arrays.asList(counter));
    }

    public static Map<String, Long> getDomainHits(String[] counts){

        Map<String, Long> counter = new HashMap<String, Long>();

        for(int i =0; i<counts.length; i++){
            System.out.println("reading counts array elements");
            String countString = counts[i];
            long countNum =  Long.parseLong(countString.split(",")[0]);
            String fullDomain = countString.split(",")[1];
            System.out.println("fullDomain:" + fullDomain);

            String[] subDomains = fullDomain.split("\\.");
            System.out.println("subDomains.length: " + subDomains.length);

            String suffix = "";
            String currentSubDomain = "";

            for(int j = subDomains.length - 1; j>=0; j--){
                System.out.println("adding subDomains for " + currentSubDomain);
                currentSubDomain = (suffix.isEmpty()) ? subDomains[j] :  subDomains[j] + suffix;
                System.out.println("currentSubDomain: "+ currentSubDomain);

                if(counter.get(currentSubDomain) == null){
                    System.out.println("key: "+ currentSubDomain +" is not there, adding counter fresh");
                    counter.put(currentSubDomain, countNum);
                } else{
                    long oldCount = counter.get(currentSubDomain);
                    System.out.println("key: "+ currentSubDomain + "is already there, adding counter to it");
                    counter.put(currentSubDomain, oldCount + countNum);
                }
               // suffix = (!suffix.isEmpty()) ? "\\." + currentSubDomain : currentSubDomain;
                suffix = "\\." + currentSubDomain;
                System.out.println(suffix);
            }


        }

        return counter;

    }



}
