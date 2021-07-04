/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *

 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position parent(Position<E> p);
    Iterable<Position<E>> children(Position<E> p);
    
    // ===============
    // see this later to implement
    // int depth(Position<E> p);   // return the depth of the position node p
    // int height();   // returns the height of a tree
    // int height(Position<E> p);  // returns the height of a subtree
    // =================
    
    int numChildren(Position<E> p);
    boolean isInternal(Position<E> p);
    boolean isExternal(Position<E> p);
    boolean isRoot(Position<E> p);
    int size();
    boolean isEmpty();
    Iterable<Position<E>> positions();
}
