package mazeproyect;

/*
*@autor Diego
*Clase para inicializar el grafo especifico del laberinto
*/
public class Inicializar {
    
    int number;
    
    public Inicializar(int number){
        this.number = number;
    }
    
    /*
*@autor Diego
*@return Grafo especifico del laberinto
*/
        
    public GrafoLA InicializarGrafo(){
        
        
        int n = number;
        GrafoLA myGrafo = new GrafoLA(n*n, false);
        
        
        myGrafo.insertaVertice(n*n);
        
        //Aristas de las cuatros esquinas del laberinto//
        myGrafo.insertaArista(0, 1);
        myGrafo.insertaArista(0, n);
        myGrafo.insertaArista(n-1, n-2);
        myGrafo.insertaArista(n-1, (2*n)-1);
        myGrafo.insertaArista((n*n)-n, (n*n)-(2*n));
        myGrafo.insertaArista((n*n)-n, (n*n)-n+1);
        myGrafo.insertaArista((n*n)-1, (n*n)-n-1);
        myGrafo.insertaArista((n*n)-1, (n*n)-2);
        
        //Aristas del borde superior del laberinto//
        for (int i = 1; i < (n - 1); i++) {
            if (!myGrafo.listaAdy[i].buscar(i-1)) {
                myGrafo.insertaArista(i, i - 1);
            }    
            if (!myGrafo.listaAdy[i].buscar(i+1)){
                myGrafo.insertaArista(i, i + 1);
            }
            if (!myGrafo.listaAdy[i].buscar(n+i)){
                myGrafo.insertaArista(i, n + i);
            }
        }
        
        //Aristas del borde inferior del laberinto//
        for (int i = (n * n) - n + 1; i < (n * n)-1; i++) {

            if (!myGrafo.listaAdy[i].buscar(i - 1)) {
                myGrafo.insertaArista(i, i - 1);
            }
            if (!myGrafo.listaAdy[i].buscar(i + 1)) {
                myGrafo.insertaArista(i, i + 1);
            }
            if (!myGrafo.listaAdy[i].buscar((n * n) - (2 * n) + (i - ((n * n) - n )))) {
                myGrafo.insertaArista(i, (n * n) - (2 * n) + (i - ((n * n) - n )));
            }

        }
        
        //Aristas del borde izquierdo del laberinto//
        for (int i = n; i < (n*n)-n; i=i+n) {
            if (!myGrafo.listaAdy[i].buscar(i-n)) {
                myGrafo.insertaArista(i, i - n);
            }    
            if (!myGrafo.listaAdy[i].buscar(i+n)){
                myGrafo.insertaArista(i, i + n);
            }
            if (!myGrafo.listaAdy[i].buscar(i+1)){
                myGrafo.insertaArista(i, i+1);
            }
        }
        
        //Aristas del borde derecho del laberinto//
        for (int i = (2*n)-1; i < (n*n)-1; i=i+n) {
            if (!myGrafo.listaAdy[i].buscar(i-n)) {
                myGrafo.insertaArista(i, i - n);
            }    
            if (!myGrafo.listaAdy[i].buscar(i+n)){
                myGrafo.insertaArista(i, i + n);
            }
            if (!myGrafo.listaAdy[i].buscar(i-1)){
                myGrafo.insertaArista(i, i-1);
            }
        }
        
        //Aristas del resto del laberinto//
        for (int i = (n+1); i < (n*n)-n+1; i=i+n) {
            for (int j = i; j < (i+n-2); j++) {
                if (!myGrafo.listaAdy[j].buscar(j-n)) {
                    myGrafo.insertaArista(j, j - n);
                }    
                if (!myGrafo.listaAdy[j].buscar(j+n)){
                    myGrafo.insertaArista(j, j + n);
                }
                if (!myGrafo.listaAdy[j].buscar(j-1)){
                    myGrafo.insertaArista(j, j-1);
                }
                if (!myGrafo.listaAdy[j].buscar(j+1)){
                    myGrafo.insertaArista(j, j+1);
                }
            }
        }   
        return myGrafo;
        
        
        
    }
    
}
