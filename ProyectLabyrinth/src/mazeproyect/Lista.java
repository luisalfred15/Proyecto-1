package mazeproyect;

public class Lista{
    public boolean visited;
    public int index;
    public int value;
    public Nodo pFirst;
    public int size;

    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }
    
    public Lista(int value, int index) {
        this.pFirst = null;
        this.size = 0;
        this.value = value;
        this.index = index;
        this.visited = false;
        
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
    public boolean IsEmpty(){
        return pFirst == null;
    }
    
    public void InsertStart(int data){
        Nodo nuevo = new Nodo(data);
        if (IsEmpty()) {
            pFirst = nuevo;
            
        }else{
            nuevo.setpNext(pFirst);
            pFirst = nuevo;
        }
        size++;
        
    }
     public void InsertFinal(int data){
         Nodo  nuevo = new Nodo(data);
        if (IsEmpty()) {
            pFirst = nuevo;
            
        }else{
            Nodo aux = pFirst;
            while(aux.getpNext() != null){
                aux = aux.getpNext();
            }
            aux.setpNext(nuevo);
        }
        size++;
    }
    
    public void InsertIndex(int data, int index){
        Nodo nuevo = new Nodo(data);
        if (IsEmpty()) {
            pFirst = nuevo;
        } else {
            Nodo  aux = pFirst;
            int cont = 0;
            while (cont < index-2 && aux.getpNext() != null) {
                aux = aux.getpNext();
                cont++;
            }
            nuevo.setpNext(aux.getpNext());
            aux.setpNext(nuevo);
        }
        size++;
    }
     
    public void EliminateStart(){
        if (!IsEmpty()){
            Nodo  aux = pFirst;
            pFirst = aux.getpNext();
            aux.setpNext(null);
            size--;
        }
    } 
     
    public void EliminateFinal(){
        if(!IsEmpty()){
            Nodo aux = pFirst;
            while (aux.getpNext().getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            size--;
        }
    }
    
    
    public void EliminateIndex(int index){
        if(!IsEmpty()){
            Nodo aux = pFirst;
            int cont = 0;
            while (cont < (index - 2) && aux.getpNext() != null) {
                aux = aux.getpNext();
                cont++;
            }
            Nodo temp = aux.getpNext();
            aux.setpNext(temp.getpNext());
            temp.setpNext(null);
            size--;
        }
    }
    
    public Object getNodo(int index){
        if (IsEmpty()) {
            return null;
        } else {
            Nodo  aux = pFirst;
            int cont = 0;
            while (cont < index-2 && aux.getpNext() != null) {
                aux = aux.getpNext();
                cont++;
            }
            if (cont == index) {
                return aux.getData();
            } else {
                return null;
            }
        }
    }
    
    public  void Print(){
        if(!IsEmpty()){
           Nodo aux = pFirst;
            while(aux != null){
                System.out.println(aux.getData());
                aux = aux.getpNext();
            }
        }else{
            System.out.println("La lista esta vacia");
        }
     
    }
    
     public int GiveSize(){
        Nodo aux = pFirst;
        size = 0;
        while(aux != null){
            aux = aux.getpNext();
            size++;  
        }
        return size;
    }
    
    public boolean buscar(Object x){
        boolean encontro = false;
        Nodo aux = pFirst;
        for (int i = 0; i < GiveSize(); i++) {
            if(encontro != true){
                if(x.equals(aux.getData())){
                    encontro = true;  
                }else{
                    aux = aux.getpNext();
                }   
            }
            
        }      
        return encontro;
    }
    
}
