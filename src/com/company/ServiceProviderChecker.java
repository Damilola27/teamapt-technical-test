package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ServiceProviderChecker {
    private static final Map<String, Integer> serviceProvidersMap;

    static {
        serviceProvidersMap = new HashMap<>();
        serviceProvidersMap.put("MTN", 0);
        serviceProvidersMap.put("Globacom", 0);
        serviceProvidersMap.put("Airtel", 0);
        serviceProvidersMap.put("9MOBILE", 0);
        serviceProvidersMap.put("MTEL", 0);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/home/damilola/Documents/PhoneNumbers.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        Long strtTime = System.currentTimeMillis();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            checkNetwork(str);
        }
        Long endTime = System.currentTimeMillis();
        long timeSpent = endTime - strtTime;
        System.out.println("time spent is: " + timeSpent);

        System.out.println(serviceProvidersMap);


    }

    public static void checkNetwork(String number){

        if (isMTN(number)){
            int users = serviceProvidersMap.get("MTN");
            serviceProvidersMap.replace("MTN", ++users);
        }else {
            if (is9Mobile(number)){
                int users = serviceProvidersMap.get("9MOBILE");
                serviceProvidersMap.replace("9MOBILE", ++users);
            }else{
                if(isAirtel(number)){
                    int users = serviceProvidersMap.get("Airtel");
                    serviceProvidersMap.replace("Airtel", ++users);
                }else{
                    if(isGlobacom(number)){
                        int users = serviceProvidersMap.get("Globacom");
                        serviceProvidersMap.replace("Globacom", ++users);
                    }else{
                        if(isMtel(number)){
                            int users = serviceProvidersMap.get("MTEL");
                            serviceProvidersMap.replace("MTEL", ++users);
                        }
                    }
                }
            }
        }
    }

    public  static boolean isMTN(String number){
        return number.startsWith("0703") || number.startsWith("0706")
                || number.startsWith("0803") || number.startsWith("0806") ||
                number.startsWith("0810") || number.startsWith("0813") ||
                number.startsWith("0814") || number.startsWith("0816")
                || number.startsWith("0903") || number.startsWith("0906")
                || number.startsWith("0913") || number.startsWith("0916")
                || number.startsWith("07025") || number.startsWith("07026") ||
                number.startsWith("0704");
    }

    public static boolean isAirtel(String number){
        return number.startsWith("0701")|| number.startsWith("0708")|| number.startsWith("0802")||
        number.startsWith("0808")|| number.startsWith("0812")|| number.startsWith("0901")|| number.startsWith("0902")||
        number.startsWith("0904")|| number.startsWith("0907")|| number.startsWith("0912");

    }

    public static boolean isGlobacom(String number){
            return  number.startsWith("0705")|| number.startsWith("0805")
                    ||number.startsWith("0807")|| number.startsWith("0811")
                    ||number.startsWith("0815") || number.startsWith("0905")
                    ||number.startsWith("0915");
    }

    public static boolean is9Mobile(String number){
        return number.startsWith("0809") || number.startsWith("0817")||
                number.startsWith("0818") ||number.startsWith("0909")||
                number.startsWith("0908");

    }

    public static boolean isMtel(String number){
        return number.startsWith("0804");

    }



}
