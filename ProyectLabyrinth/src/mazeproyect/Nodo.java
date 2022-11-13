
package mazeproyect;


/*
*@autor Diego
*Clase nodo para el laberinto
*/
public class Nodo {
    public Nodo pNext;
    public int data;

    public Nodo( int data) {
        this.pNext = null;
        this.data = data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
}
    
    
