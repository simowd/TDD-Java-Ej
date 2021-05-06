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
public class TresEnRaya {
    
    private Character[][] board = {{'0','0','0'},{'0','0','0'},{'0','0','0'}};
    
    private final int LIMITE = 3;
    
    private char ultimoJugador = '0';
    
    private void asignarPosicion(int x, int y, char ultimoJugador) throws Exception{
        if(board[x-1][y-1] != '0'){
            throw new Exception("Posición ocupada");
        }
        else{
            board[x-1][y-1] = ultimoJugador;
            System.out.println("Asignando posición: " + x + ", " + y);
        }
    }
    
    public String jugar(int x, int y) throws Exception{
        
        
        verificarEje(x);
        verificarEje(y);
        
        ultimoJugador = siguienteTurno();
        
        asignarPosicion(x, y, ultimoJugador);
        
        if(esVictoria()){
            return ultimoJugador + " es el ganador";
        }
        return "No hay ganador";
    }
    
    private void verificarEje(int eje) throws Exception{
        if(eje < 1 || eje > LIMITE){
            throw new Exception(eje + " esta fuera del tablero");
        }
    }
    
    public char siguienteTurno(){
        if(ultimoJugador == 'X'){
            return '0';
        }
        else{
                return 'X';
        }
    }
    
    private boolean esVictoria(){
        int total = ultimoJugador * LIMITE;
        for(int i = 0; i < LIMITE; i++){
            if(board[0][i] + board[1][i] + board[2][i] == total){
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] == total){
                return true;
            }
        }
        return false;
    }
}
