/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author martin
 */
public class TresEnRayaTest {
    
    private TresEnRaya tresEnRaya;
 
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void before(){
        tresEnRaya = new TresEnRaya();
    }
    
    @Test
    public void cuandoFueraXlanzarExcepcion() throws Exception{
        //Preparación de la prueba
        tresEnRaya = new TresEnRaya();
        
        //Lógica de la prueba
        
        //Verificación o Assert
        exception.expect(Exception.class);
        tresEnRaya.jugar(5,2);
        tresEnRaya.jugar(0,2);
    }
    
    @Test
    public void cuandoFueraYlanzarExcepcion() throws Exception{
        //Preparación de la prueba
        tresEnRaya = new TresEnRaya();
        
        //Lógica de la prueba
        
        //Verificación o Assert
        exception.expect(Exception.class);
        tresEnRaya.jugar(2,5);
        tresEnRaya.jugar(2,0);
    }
    
    @Test
    public void cuandoCasillaOcupadalanzarExcepcion() throws Exception{
        //Preparación de la prueba
        tresEnRaya = new TresEnRaya();
        
        //Lógica de la prueba
        
        //Verificación o Assert
        
        //tresEnRaya.jugar(2,1);//X
        tresEnRaya.jugar(2,1);//+
        exception.expect(Exception.class);
        tresEnRaya.jugar(2,1);//+
    }
    
    @Test
    public void siPrimerTurnoEntoncesJuegaX(){
        //Preparación de la prueba
        tresEnRaya = new TresEnRaya();
        
        //Lógica de la prueba
        
        //Verificación o Assert
        assertEquals('X', tresEnRaya.siguienteTurno());
    }
    
    @Test
    public void siPrimerTurnoXSiguienteCero() throws Exception{
        tresEnRaya.jugar(2, 1);
        assertEquals('0', tresEnRaya.siguienteTurno());
        
        tresEnRaya.jugar(2, 2);
        assertEquals('X', tresEnRaya.siguienteTurno());
    }
    
    @Test
    public void cuandoJuegaNoHayGanador() throws Exception{
        String resultado = tresEnRaya.jugar(2, 1);
        assertEquals("No hay ganador", resultado);
    }
    
    @Test
    public void siLlenaUnEjeVerticalEntoncesGana() throws Exception{
        tresEnRaya.jugar(1, 1);//X
        tresEnRaya.jugar(1, 2);//+
        tresEnRaya.jugar(2, 1);//X
        tresEnRaya.jugar(2, 2);//+
        String resultado = tresEnRaya.jugar(3, 1);
        assertEquals("X es el ganador", resultado);
    }
    
    @Test
    public void siLlenaUnEjeHorizontalEntoncesGana() throws Exception{
        tresEnRaya.jugar(2, 1);//X
        tresEnRaya.jugar(1, 1);//+
        tresEnRaya.jugar(3, 1);//X
        tresEnRaya.jugar(1, 2);//+
        tresEnRaya.jugar(2, 2);//+
        String resultado = tresEnRaya.jugar(1, 3);
        assertEquals("0 es el ganador", resultado);
    }
}
