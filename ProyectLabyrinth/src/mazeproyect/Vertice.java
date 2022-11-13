package mazeproyect;


/*
*@author Diego
*@deprecated No fue necesario emplear esta clase
*/
public class Vertice {
    public int value;
    public Lista data;
    public int index;
    public boolean isVisited;
    
    public Vertice(int value, Lista data, int index) {
        this.value = value;
        this.data = data;
        this.index = index;
        this.isVisited = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Lista getData() {
        return data;
    }

    public void setData(Lista data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    
    
}
