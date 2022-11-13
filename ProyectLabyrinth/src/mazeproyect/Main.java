package mazeproyect;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
*Clase main para ejecutar el prgrama
*@autor Diego
*/
public class Main extends JPanel{
    
    int valorDado;
    Inicializar myGrafo; 
    Labyrinth laberinto;

    /*Constructor de la clase
    *@param numero que representa la cantidad de celdas nxn del laberinto
    */
    public Main(int n){
        this.valorDado = (int)Math.floor(Math.random()*(n*n)+1);
        this.myGrafo = new Inicializar(n);
        this.laberinto = new Labyrinth(this.myGrafo.InicializarGrafo(), this.valorDado, n);
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
//                personaje.teclaPresionada(e);
            }   

            @Override
            public void keyReleased(KeyEvent e) {
            }   
        });
        setFocusable(true);
        
    }
    
    @Override
    public void paint(Graphics grafico){ 
        laberinto.paint(grafico);
 
    }
    
    /*
*@autor Diego
*@deprecated aqui se llamaba al programa antes de crear la interfaz
*/
    public static void main(String[] args) {
        
//        JFrame mywindow = new JFrame("MY LABYRINTH");
//        Main game = new Main();
//        mywindow.add(game);
//       
//        mywindow.setSize(610,635);
//        mywindow.setLocation(450,100);
//        mywindow.setVisible(true);
//        
//        mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}    
    