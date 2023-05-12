/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

import com.nikasgig.transportproblemtriplemethod.form.MainJFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author NikAS GiG
 */
public class InputService {
    
    private int[][] A;
    private int[] b;
    private int[] c;
    private final int row;
    private final int col;

    public InputService(int row, int col){
        A = new int[col][row];
        b = new int[row];
        c = new int[row];
        this.row = row;
        this.col = col;
    }
    
    public void doTask(MainJFrame frame) {
        //MainJFrame frame = new MainJFrame();
        
        try {
            TableModel model1 = frame.jTable1.getModel();
            
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                Object value = model1.getValueAt(i, j);
                if (value instanceof Number) {
                    A[i][j] = Integer.parseInt(value.toString());
                } else {
                    try {
                        A[i][j] = Integer.parseInt(value.toString());
                    } catch (NumberFormatException e) {
                        A[i][j] = 0;
                    }
                }
                System.out.println("i = " + i + ", j = " + j);
                System.out.println(A[i][j]);
            }
        
        // System.out.println("i = " + i + ", j = " + j);
        //  System.out.println(A[i][j]);
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error of get data of jTable1: " + e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Exception of get data of jTable1: " + e.getMessage());
            return;
        }
        try {    
            TableModel model2 = frame.jTable2.getModel();
            for (int i = 0; i < row; i++) {
                // Получаем значение ячейки таблицы
                Object value = model2.getValueAt(0, i);
                if (value instanceof Number) {
                    // Преобразуем значение в double и записываем в массив
                    b[i] = Integer.parseInt(value.toString());
                } else {
                    // Если значение не является числом, записываем 0
                    try {
                        b[i] = Integer.parseInt(value.toString());
                    } catch (NumberFormatException e) {
                        b[i] = 0;
                    }
                }
                System.out.println("i = " + i);
                System.out.println(b[i]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error of get data of jTable2: " + e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Exception of get data of jTable2: " + e.getMessage());
            return;
        }
        try {    
            TableModel model3 = frame.jTable3.getModel();
            for (int i = 0; i < row; i++) {
                // Получаем значение ячейки таблицы
                Object value = model3.getValueAt(0, i);
                if (value instanceof Number) {
                    // Преобразуем значение в double и записываем в массив
                    c[i] = Integer.parseInt(value.toString());
                } else {
                    // Если значение не является числом, записываем 0
                    try {
                        c[i] = Integer.parseInt(value.toString());
                    } catch (NumberFormatException e) {
                        c[i] = 0;
                    }
                }
                System.out.println("i = " + i);
                System.out.println(c[i]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error of get data of jTable3: " + e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Exception of get data of jTable3: " + e.getMessage());
            return;
        }
    }

    public int[][] getA() {
        return A;
    }

    public void setA(int[][] A) {
        this.A = A;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

    public int[] getC() {
        return c;
    }

    public void setC(int[] c) {
        this.c = c;
    } 
}
