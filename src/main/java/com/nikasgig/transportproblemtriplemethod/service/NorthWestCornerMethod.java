/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

/**
 *
 * @author NikAS GiG
 */
public class NorthWestCornerMethod {

    private int[][] costs;
    private int[] supply;
    private int[] demand;

    // Constructor
    public NorthWestCornerMethod(int[][] costs, int[] supply, int[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
    }

    public Object[] solve() {
        int i = 0, j = 0;
        int totalCost = 0;
        int[][] distribution = new int[supply.length][demand.length];

        while (i < supply.length && j < demand.length) {
            int quantity = Math.min(supply[i], demand[j]);
            totalCost += quantity * costs[i][j];
            distribution[i][j] = quantity;

            // Update supply and demand
            supply[i] -= quantity;
            demand[j] -= quantity;

            // Move to next supply/demand
            if (supply[i] == 0) {
                i++;
            }
            if (demand[j] == 0) {
                j++;
            }
        }

        return new Object[]{totalCost, distribution};
    }

    public static void test() {
        int[][] costs = {
            {2, 3, 4},
            {3, 4, 2},
            {4, 2, 3}
        };
        int[] supply = {30, 40, 50};
        int[] demand = {40, 30, 50};

        NorthWestCornerMethod problem = new NorthWestCornerMethod(costs, supply, demand);
        Object[] result = problem.solve();

        // Output the total cost
        System.out.println("Total cost: " + result[0]);

        // Output the distribution table
        int[][] distribution = (int[][]) result[1];
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                System.out.printf("%d ", distribution[i][j]);
            }
            System.out.println();
        }
    }
}
