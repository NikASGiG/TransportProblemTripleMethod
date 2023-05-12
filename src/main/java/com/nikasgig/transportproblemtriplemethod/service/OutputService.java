/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nikasgig.transportproblemtriplemethod.service;

import com.nikasgig.transportproblemtriplemethod.form.MainJFrame;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NikAS GiG
 */
public class OutputService {

    public static double[] toTable(StringBuilder result) {
        double[] table = new double[6];
        String input = result.toString();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String arrayString = matcher.group(1);
            String[] arrayValues = arrayString.split(", ");
            //double[] table = new double[arrayValues.length];
            for (int i = 0; i < arrayValues.length; i++) {
                table[i] = Double.parseDouble(arrayValues[i]);
            }
            return table;
        }
        return table;
    }
    
    public static void showResult(MainJFrame frame, Object[] result, int rowCount, int columnCount){
        int[][] tableResult = (int[][]) result[1];
        DefaultTableModel model = new DefaultTableModel(rowCount, columnCount);
        // Заполнение модели данными из массива
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                model.setValueAt(tableResult[i][j], i, j);
            }
        }
        frame.jTable4.setModel(model);
        System.out.println("=====");
        frame.jTextField3.setText(Integer.toString((Integer) result[0]));
    }
}
