package mazeproyect;

import java.awt.Color;
import java.awt.Graphics;

/*
*@autor Diego
*Clase donde se crea el laberinto
*/


public class Labyrinth {
    
    public GrafoLA myGrafo;
    public int inicio;
    private int fila = 0;
    private int columna = 0;
    private final int numeroFilas;
    private final int numeroColumnas;
    private final int anchoBloque = 20;
    private final int altoBloque = 20;
    private Lista[] visited;
    private Lista list;
    
    /*
    *Constructor de la clase
    *@param grafo del laberinto, vertice donde se inicia el recorrido, numero de celdas nxn del laberinto
    */
    public Labyrinth(GrafoLA myGrafo, int inicio, int n) {
        this.numeroFilas = n;
        this.numeroColumnas = n;
        this.myGrafo = myGrafo;
        this.inicio = inicio;
        this.list = new Lista();
        this.visited = new Lista[myGrafo.numVertices];
        for (int i = 0; i < myGrafo.numVertices; i++) {
            visited[i] = list;
            visited[i].index = 99999;
        }
    }

    /*
*@param grafico de la libreria Graphics para pintar las celdas del laberinto
*@autor Diego
*/
    public void paint(Graphics grafico) {
//        Lista visited[] = new Lista[myGrafo.numVertices];
//        Lista list = new Lista();

        Lista recorrer[] = Prim2(inicio, 0);
        
        int valorDado = (int)Math.floor(Math.random()*recorrer.length);
        int valorDado2 = (int)Math.floor(Math.random()*recorrer.length);
        
        recorrer[valorDado].value = 2;
        recorrer[valorDado2].value = 3;
//
//        for (int i = 0; i < visited.length; i++) {
//            System.out.println(visited[i].value);
//        }
        
        for (fila = 0; fila < numeroFilas; fila++) {
            for (columna = 0; columna < numeroColumnas; columna++) {
                if (recorrer[fila*columna].value == 1) {
                    grafico.setColor(Color.black);
                    grafico.fillRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                }else if(recorrer[fila*columna].value == 2){
                    grafico.setColor(Color.green);
                    grafico.fillRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                    grafico.setColor(Color.green);
                    grafico.drawRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                }else if(recorrer[fila*columna].value == 3){
                    grafico.setColor(Color.red);
                    grafico.fillRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                    grafico.setColor(Color.red);
                    grafico.drawRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                }
                else if(recorrer[fila*columna].value == 0){
                    grafico.setColor(Color.white);
                    grafico.fillRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                    grafico.setColor(Color.white);
                    grafico.drawRect(columna * 20, fila * 20, anchoBloque, altoBloque);
                }
            }
        }

    }

    /*
*@param dato que se desea buscar en la lista
*@autor Diego
*@return true si lo encontro, false si no
*/
   public boolean buscar(int info){
       boolean encontro = false;
       for (int i = 0; i < visited.length; i++) {
           if (visited[i].index == info) {
               encontro = true;
           }
       }
       return encontro;
   }
    
    /*
*@param vertice de inicio del recorrido, contador
*@autor Diego
*@return Lista de recorrido para crear el laberinto
*/
    public Lista[] Prim2(int ref, int v) {
        
        visited[v] = myGrafo.listaAdy[ref];
      
        Nodo temp = myGrafo.listaAdy[ref].pFirst;
        for (int k = 0; k < myGrafo.listaAdy[ref].GiveSize(); k++) {
            if (buscar(temp.data) == false) {
                return Prim2(temp.data, v + 1);
            }else{
                temp = temp.getpNext();
            }
       
        }   
        return visited;
        
        
    }
    
    /*
*@autor Diego
*@deprecated Segunda version del algoritmo de Prim
*@return Lista de recorrido para crear el laberinto
*/
//      public Lista[] Prim() {
//      
//          Lista visited[] = new Lista[myGrafo.numVertices];
//          int ref = inicio;
//
//          for (int i = 0; i < myGrafo.numVertices; i++) {
//              visited[i] = null;
//          }
//          
//          visited[0] = myGrafo.listaAdy[ref];
//         
//          while (visited[ref] == null) {
//              Nodo aux = myGrafo.listaAdy[ref].pFirst;
//              for (int k = 0; k < myGrafo.listaAdy[ref].GiveSize(); k++) {
//                  for (int i = 0; i < visited.length; i++) {
//                      if (visited[i] != myGrafo.listaAdy[ref]) {
//                          visited[ref] = myGrafo.listaAdy[i];
//                          ref = myGrafo.listaAdy[i].index;
//
//                      }
//                  }
//                  
//              }
//
//        }
//        
//        for (int i = 0; i < visited.length; i++) {
//            System.out.println(visited[i].index + ": " + visited[i].value);
//        }
////        
//        return visited;
//        
//        
//    }
//      
      
    /*
*@autor Diego
*@deprecated Primera version del algoritmo de Prim
*@return Lista de recorrido para crear el laberinto
*/
//    public Lista obtenerLaberinto(){
//        
//        int numVertices = myGrafo.numVertices;
//        Lista visitados = new Lista();
//        int s = myGrafo.listaAdy[inicio].index;
//        visitados.InsertFinal(s);
//        
//        while(visitados.GiveSize() < numVertices){
//            Nodo aux = myGrafo.listaAdy[s].pFirst;
//            for (int i = 0; i < myGrafo.listaAdy[s].GiveSize(); i++) {
//                if (!visitados.buscar(aux.getData())) {
//                    s = aux.getData();
//                    visitados.InsertFinal(s);
//          
//                }else{
//                    aux = aux.getpNext();
//                }
//            }
//        }
//        
//        return visitados;
//
//    }
    
    
}    
    
    

