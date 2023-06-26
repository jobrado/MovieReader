/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Jo
 */
public  class FormUtils {
  
       public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    public static boolean formValid(List<JTextComponent> fields, List<JLabel> labels) {
           boolean ok = true;
                for (int i = 0; i < fields.size(); i++) {
                ok &= !fields.get(i).getText().trim().isEmpty();
                labels.get(i).setText(fields.get(i).getText().trim().isEmpty() ? "X" : "");
            
                 if ("tfPubDate".equals(fields.get(i).getName())) {
                      try {
                            LocalDate.parse(fields.get(i).getText().trim(),DATE_FORMATTER).atStartOfDay();
                            labels.stream().filter((label) -> ("lblErrorPubDate".equals(label.getName()))).forEachOrdered((label) -> {
                                label.setText(" ");
                 });
             } 
             catch (Exception e) {
                  ok = false;
             labels.stream().filter((label) -> ("lblErrorPubDate".equals(label.getName()))).forEachOrdered((label) -> {
                     label.setText("X");
                 });             }
           }
        }
            return ok;
    }
}
