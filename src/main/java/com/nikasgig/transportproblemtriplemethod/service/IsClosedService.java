/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

import com.nikasgig.transportproblemtriplemethod.form.MainJFrame;

/**
 *
 * @author NikAS GiG
 */
public class IsClosedService {
    public static boolean isClosed(int[] supply, int[] demand) {
        int totalSupply = 0;
        int totalDemand = 0;

        for (int i = 0; i < supply.length; i++) {
            totalSupply += supply[i];
        }

        for (int i = 0; i < demand.length; i++) {
            totalDemand += demand[i];
        }

        return totalSupply == totalDemand;
    }

    public static void task(MainJFrame frame, int[] supply, int[] demand) {

        if (isClosed(supply, demand)) {
            System.out.println("Транспортная задача закрыта");
            frame.label9.setText("Transport task is closed");
        } else {
            System.out.println("Транспортная задача открыта");
            frame.label9.setText("Transport task is open");
        }
    }
}
