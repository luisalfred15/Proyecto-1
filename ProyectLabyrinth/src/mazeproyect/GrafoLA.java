package mazeproyect;


/*
*@autor Diego
*Clase para crear un grafo general
*/
public class GrafoLA implements Grafo {

    boolean dirigido; // Indica si es dirigido o no.
    int maxNodos; // Tamaño máximo de la tabla.
    int numVertices; // Número de vértices del grafo.
    Lista listaAdy[]; // Vector de listas de adyacencias del grafo.
    
    public GrafoLA(boolean d) {
        maxNodos = numVertices = 0;
        dirigido = d;
    }

    public GrafoLA(int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        listaAdy = new Lista[n];
    }

    
    
    public void insertaArista(int i, int j) {
        if (i >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].InsertFinal(j);
            if (!dirigido) {
                listaAdy[j].InsertFinal(i);
            }
        }
    }

    public void eliminaArista(int i, int j) {
        if (j >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].EliminateIndex(j);
            if (!dirigido) {
                listaAdy[j].EliminateIndex(i);
            }
        }
    }

    public void insertaVertice(int n) {
        if (n > maxNodos - numVertices) {
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        } else {
            for (int i = numVertices; i < numVertices + n; i++) {
                int valorDado = (int)Math.floor(Math.random()*2);
                
                Lista myList = new Lista(valorDado, i);
                listaAdy[i]= myList;
            }
        }
        numVertices += n;
    }

    /*
*@deprecated No fue necesario de emplear
*/
    public int gradoIn(int v) {
        int gIn = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i != v) {
                if (listaAdy[i].buscar(v)) {
                    gIn++;
                }
            }
        }
        return gIn;
    }

    /*
*@deprecated No fue necesario de emplear
*/
    public int gradoOut(int i) { //contar los elementos de la lista
        int gOut = 0;
        Nodo aux = listaAdy[i].pFirst;
        while (aux != null) {
            gOut++;
            aux = aux.getpNext();
        }
        return gOut;
    }

    /*
*@deprecated No fue necesario de emplear
*/
    public int incidencia(int i) {
        if (!dirigido) {
            return gradoIn(i);
        } else {
            return gradoIn(i) + gradoOut(i);
        }
    }

    
   /*
*@deprecated No fue necesario de emplear
*/
    public int tamanno() {
        int tm = 0;
        for (int i = 0; i < numVertices; i++) {
            tm += numElementos(listaAdy[i]);
        }
        if (!dirigido) {
            tm = tm / 2;
        }
        return tm;
    }

   /*
*@deprecated No fue necesario de emplear
*/
    static int numElementos(Lista lista) {
        Nodo aux = lista.getpFirst();
        int resul = 0;
        while (aux != null) {
            resul += 1;
            aux = aux.getpNext();
        }
        return resul;
    }

    public boolean esNoDirigido() {
        boolean dir = true;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (listaAdy[i].buscar(j) != listaAdy[j].buscar(i)) {
                    dir = false;
                }
            }
        }
        return dir;
    }

    /*
*@deprecated No fue necesario de emplear
*/
    public void imprimirGrafo() {
        System.out.println("Tamaño máximo del grafo: " + maxNodos + "\n");
        System.out.println("El grafo contiene " + numVertices + " vértices: \n");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("vértice " + i + ": ");
            escribir(listaAdy[i]);
        }
    }

  /*
*@deprecated No fue necesario de emplear
*/
    static void escribir(Lista lista) {
        Nodo aux;
        aux = lista.pFirst;
        while (aux != null) {
            System.out.print(aux.data + ", ");
            aux = aux.pNext;
        }
        System.out.println("FIN");
    }
    
    
    

    @Override
    public void eliminarVertice(int v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarArista(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esVacio(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeArista(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int tamano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esDirigido(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ponerMaxNodos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ponerDirigido(boolean d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

