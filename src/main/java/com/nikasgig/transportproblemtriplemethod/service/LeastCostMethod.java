/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

/**
 *
 * @author NikAS GiG
 */
public class LeastCostMethod {

    private int[][] costs;
    private int[] supply;
    private int[] demand;

    // Constructor
    public LeastCostMethod(int[][] costs, int[] supply, int[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
    }

    public Object[] solve() {
        int totalCost = 0;
        int[][] distribution = new int[supply.length][demand.length];

        while (!isAllSupplyExhausted() && !isAllDemandSatisfied()) {
            int[] minCostCell = getCellWithMinCost();
            int i = minCostCell[0], j = minCostCell[1];

            int quantity = Math.min(supply[i], demand[j]);
            totalCost += quantity * costs[i][j];
            distribution[i][j] = quantity;

            // Update supply and demand
            supply[i] -= quantity;
            demand[j] -= quantity;

            // If supply exhausted, set its costs to infinity
            if (supply[i] == 0) {
                for (int k = 0; k < costs[i].length; k++) {
                    costs[i][k] = Integer.MAX_VALUE;
                }
            }

            // If demand satisfied, set its costs to infinity
            if (demand[j] == 0) {
                for (int k = 0; k < costs.length; k++) {
                    costs[k][j] = Integer.MAX_VALUE;
                }
            }
        }

        return new Object[]{totalCost, distribution};
    }

    private boolean isAllSupplyExhausted() {
        for (int quantity : supply) {
            if (quantity > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllDemandSatisfied() {
        for (int quantity : demand) {
            if (quantity > 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getCellWithMinCost() {
        int[] cell = new int[2];
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                if (costs[i][j] < minCost) {
                    minCost = costs[i][j];
                    cell[0] = i;
                    cell[1] = j;
                }
            }
        }

        return cell;
    }

    public static void test() {
        int[][] costs = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] supply = {30, 40, 50};
        int[] demand = {40, 30, 50};

        LeastCostMethod problem = new LeastCostMethod(costs, supply, demand);
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
