/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

/**
 *
 * @author NikAS GiG
 */
public class VogelsApproximationMethod {

    private int[][] costs;
    private int[] supply;
    private int[] demand;

    public VogelsApproximationMethod(int[][] costs, int[] supply, int[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
    }

    public Object[] solve() {
        int totalCost = 0;
        int[][] distribution = new int[supply.length][demand.length];

        while (!isAllSupplyExhausted() && !isAllDemandSatisfied()) {
            int[] maxPenaltyCell = getCellWithMaxPenalty();
            int i = maxPenaltyCell[0], j = maxPenaltyCell[1];

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

    private int[] getCellWithMaxPenalty() {
        int[] cell = new int[2];
        int maxPenalty = Integer.MIN_VALUE;

        for (int i = 0; i < costs.length; i++) {
            if (supply[i] == 0) {
                continue;
            }
            int[] minTwo = getMinTwo(costs[i]);
            int penalty = minTwo[1] - minTwo[0];

            if (penalty > maxPenalty) {
                maxPenalty = penalty;
                cell[0] = i;
                cell[1] = getMinIndex(costs[i]);
            }
        }

        for (int j = 0; j < demand.length; j++) {
            if (demand[j] == 0) {
                continue;
            }
            int[] column = new int[costs.length];
            for (int i = 0; i < costs.length; i++) {
                column[i] = costs[i][j];
            }

            int[] minTwo = getMinTwo(column);
            int penalty = minTwo[1] - minTwo[0];

            if (penalty > maxPenalty) {
                maxPenalty = penalty;
                cell[0] = getMinIndex(column);
                cell[1] = j;
            }
        }

        return cell;
    }

    private int[] getMinTwo(int[] array) {
        int[] minTwo = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int value : array) {
            if (value <= minTwo[0]) {
                minTwo[1] = minTwo[0];
                minTwo[0] = value;
            } else if (value < minTwo[1]) {
                minTwo[1] = value;
            }
        }

        return minTwo;
    }

    private int getMinIndex(int[] array) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void test() {
        int[][] costs = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] supply = {30, 40, 50};
        int[] demand = {40, 30, 50};

        VogelsApproximationMethod problem = new VogelsApproximationMethod(costs, supply, demand);
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
