package chapter17;
import java.util.ArrayList;

public class Node<E> {
 
    protected E data;
    protected Node<E> parent;
    protected ArrayList<Node<E>> children;

    public Node(Node<E> parent, E data){
        this.data = data;
        this.parent = parent;
    }
    
    public Node(Node<E> parent, ArrayList<Node<E>> children, E data){
        this.parent = parent;
        this.children = children;
        this.data = data;
    }

}
