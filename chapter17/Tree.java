package chapter17;

public class Tree<E> {

    protected int size = 0;
    protected Node<E> root = null;

    //default constructor
    public Tree(E rootdata){
        root = new Node<>(null, rootdata);
        size = 1;
    }

    @Override
    public String toString() {
        return String.format("%s [size=%d, height=%d]", root.toString(), size(), height());
    }

    private Object size() {
        return size;
    }

    private Object height() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }
}