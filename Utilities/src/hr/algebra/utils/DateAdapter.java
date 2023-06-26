/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utils;


import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
/**
 *
 * @author Jo
 */
public class DateAdapter extends XmlAdapter<String, LocalDate>{

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DATE_FORMATTER);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DATE_FORMATTER);
    }
    
}
