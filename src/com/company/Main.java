package com.company;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int items = 60;
        String newsType = "";
        double rev = 0;
        double costNp = items * 0.33;
        double lostProfit = 0;
        double scrapRev = 0;
        double dailyProfit = 0;
        double totalProfit = 0;
        int demand = 0;
        int days = 1;
        DecimalFormat df = new DecimalFormat("0.0");

        while (days <= 10) {
            int x = generate_NT();
            int y = generate_demand();
            if (News_Type(x) == "Fair") {
                newsType = "Fair";
                demand = Fair_RN(y);
            } else if (News_Type(x) == "Good") {
                newsType = "Good";
                demand = Good_RN(y);
            } else if (News_Type(x) == "Poor") {
                newsType = "Poor";
                demand = Poor_RN(y);
            }

            rev = demand * 0.5;
            if (demand > items)
                lostProfit = (demand - items) * 0.17;
            if (items > demand)
                scrapRev = (items - demand) * 0.05;

            dailyProfit = rev - costNp - lostProfit + scrapRev;
            totalProfit += dailyProfit;
            System.out.println("day: " + days + " | RN for NT: " + x + " | News Type: " + newsType + " | RN for Demand: " + y +
                    " | demand: " + demand + "| Revenue from Sales:  " + rev + " | Cost of NPs: " + costNp + " " +
                    "| Lost Profit: " + df.format(lostProfit) + " " + "| Scrap Revenue: " + scrapRev + " | Daily Profit: " + df.format(dailyProfit));
            lostProfit = 0;
            scrapRev = 0;
            days++;
        }
        System.out.println("Total Profit: " + df.format(totalProfit));
    }

    public static int generate_NT() {
        int NT = generate_random_number();
        return NT;
    }

    public static int generate_demand() {
        int demand = generate_random_number();
        return demand;
    }

    public static int generate_random_number() {
        Random random_number = new Random();
        return random_number.nextInt(100);

    }

    public static String News_Type(int x) {

        if (x >= 0 && x <= 35) {
            return "Good";
        } else if (x >= 36 && x <= 80) {

            return "Fair";
        } else

            return "Poor";

    }

    public static int Good_RN(int gn) {
        if (gn >= 1 && gn <= 3) {
            return 40;
        } else if (gn >= 4 && gn <= 8) {
            return 50;
        } else if (gn >= 9 && gn <= 23) {
            return 60;
        } else if (gn >= 24 && gn <= 43) {
            return 70;
        } else if (gn >= 44 && gn <= 78) {
            return 80;
        } else if (gn >= 79 && gn <= 93) {
            return 90;
        } else return 100;
    }

    public static int Fair_RN(int fn) {

        if (fn >= 1 && fn <= 10) {
            return 40;
        } else if (fn >= 11 && fn <= 28) {
            return 50;
        } else if (fn >= 29 && fn <= 68) {
            return 60;
        } else if (fn >= 69 && fn <= 88) {
            return 70;
        } else if (fn >= 89 && fn <= 96) {
            return 80;
        } else return 100;
    }

    public static int Poor_RN(int pn) {

        if (pn >= 1 && pn <= 44) {
            return 40;
        } else if (pn >= 45 && pn <= 66) {
            return 50;
        } else if (pn >= 67 && pn <= 82) {
            return 60;
        } else if (pn >= 83 && pn <= 94) {
            return 70;
        } else return 100;
    }

}
