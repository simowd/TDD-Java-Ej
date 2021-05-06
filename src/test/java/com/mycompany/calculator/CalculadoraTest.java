package com.mycompany.calculator;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author martin
 */
public class CalculadoraTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void enCadenaVaciaRetornarCero() throws Exception{
        //Preparación de la prueba
        Calculadora c = new Calculadora();
        
        //logica de la prueba
        String resultado = c.suma("");
        
        //Verficacion o Assert
        Assert.assertEquals("0",resultado);
    }
    
    @Test
    public void para2numerosComasRetornarSuma() throws Exception{
        //Preparación de la prueba
        Calculadora c = new Calculadora();
        
        //logica de la prueba
        //Verficacion o Assert
        Assert.assertEquals("5",c.suma("2,3"));
        Assert.assertEquals("500",c.suma("200,300"));
        Assert.assertEquals("20",c.suma("20,0"));
        Assert.assertEquals("0",c.suma("0,0"));
        Assert.assertEquals("23",c.suma("20,3"));
    }
    
    @Test
    public void para3numerosComasRetornarSuma() throws Exception{
        //Preparación de la prueba
        Calculadora c = new Calculadora();
        
        //logica de la prueba
        //Verficacion o Assert
        Assert.assertEquals("10",c.suma("2,3,5"));
        Assert.assertEquals("100",c.suma("20,30,50"));
        Assert.assertEquals("5",c.suma("0,0,5"));
        Assert.assertEquals("25",c.suma("12,8,5"));
        Assert.assertEquals("110",c.suma("22,33,55"));
    }
    
    @Test
    public void numerosMayores1000sonIgnorados() throws Exception{
        //Preparación de la prueba
        Calculadora c = new Calculadora();
        
        //logica de la prueba
        //Verficacion o Assert
        Assert.assertEquals("5",c.suma("2,3,1001"));
    }
    
    @Test
    public void numerosNegativosLanzanExcepcion() throws Exception{
        //Preparación de la prueba
        Calculadora c = new Calculadora();
        
        //logica de la prueba
        //Verficacion o Assert
        exception.expect(Exception.class);
        Assert.assertEquals("5",c.suma("2,3,-1"));
    }
}
