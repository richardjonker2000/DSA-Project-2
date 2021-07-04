/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *

 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    public boolean isInternal(Position<E> p){
        return numChildren(p) > 0;
    }
    
    @Override
    public boolean isExternal(Position<E> p){
        return numChildren(p) == 0;
    }
    
    @Override
    public boolean isRoot(Position<E> p){
        return p == root();
    }
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
    
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }
    
    private Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }
    
    @Override
    public Iterable<Position<E>> positions(){
        return preorder();
    }
    
    @Override
    public Iterator<E> iterator(){
        return new ElementIterator();
    }
    
    private class ElementIterator implements Iterator{
        Iterable<Position<E>> snapshot = positions();
        Iterator<Position<E>> posIterator = snapshot.iterator();
        @Override
        public boolean hasNext(){
            return posIterator.hasNext();
        }
        public E next(){
            return posIterator.next().getElement();
        }
        public void remove(){
            posIterator.remove();
        }
    }
}
