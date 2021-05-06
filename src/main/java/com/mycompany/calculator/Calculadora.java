/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

/**
 *
 * @author martin
 */
public class Calculadora {
    
    private static final int MAX = 1000;
    public String suma(String sumandos) throws Exception{
        if(sumandos != null && sumandos.equals("")){
            return "0";
        }
        
        Integer res = 0;
        
        String[] sums = sumandos.split(",");
        for(int i = 0;  i < sums.length; i++){
            int s = Integer.parseInt(sums[i]);
            if(s < MAX){
                res = res + s;
            }
            if(s < 0){
                throw new Exception("El sumando es negativo");
            }
        }
        
        return res.toString();
    }
}
