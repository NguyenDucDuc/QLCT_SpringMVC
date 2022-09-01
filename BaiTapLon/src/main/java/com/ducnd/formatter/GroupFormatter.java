/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.formatter;

/**
 *
 * @author DucND
 */
import com.ducnd.pojo.Gr;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;



/**
 *
 * @author DucND
 */
public class GroupFormatter implements Formatter<Gr>{

    @Override
    public String print(Gr t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Gr parse(String groupId, Locale locale) throws ParseException {
        Gr g = new Gr();
        g.setId(Integer.parseInt(groupId));
        return g;
    }

   
    
}
