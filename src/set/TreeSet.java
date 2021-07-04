/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import java.util.Iterator;
import trees.*;

/**
 *
 *
 * @param <E>
 */
public class TreeSet<E extends Comparable<E>> extends SearchBinaryTree<E> implements SortedSet<E> {

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {

        SortedSet<E> elem = new TreeSet<>();
        //iterate thrught the tree and add all elements that fit the condition
        for (E curr : this) {
            if (fromElement.compareTo(curr) <= 0 && toElement.compareTo(curr) > 0) {
                elem.add(curr);
            }
        }

        return elem;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        //returns a call to the subset element wiht min() as the fromElement
        return this.subSet(this.min(), toElement);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        //returns a call to the subset element wiht max() as the toElement
        return this.subSet(fromElement, this.max());
    }

    @Override
    public E min() {
        //gets the root of the tree, and call the getLetf function until there is no more elements on the left
        Node<E> element = super.root;
        if (element ==null) return null;
        while (element.getLeft() != null) {
            
            element = element.getLeft();
        }
        return element.getElement();
    }

    @Override
    public E max() {
        //gets the root of the tree, and call the getRight function until there is no more elements on the right
        Node<E> element = super.root;
        if (element ==null) return null;
        while (element.getRight() != null) {
            
            element = element.getRight();
        }
        return element.getElement();
    }

    @Override
    public int size() {
        //calls the super size funciton
        return super.size();
    }


    @Override
    public boolean isEmpty() {
        //checks if the size is 0
        return super.size() == 0;
    }

    @Override
    public boolean contains(E e) {
        //if we can find the element, then the tree contains the element
        return super.find(e) != null;
    }

    @Override
    public boolean add(E e) {
        //calls the put function            
        return super.put(e) == null;
    }

    @Override
    public boolean remove(E e) {
        //calls the renamed super remove function. We needed to rename the function as 
        //the return signature were different
        return super.removeT(e) != null;
    }

    @Override
    public boolean containsAll(SortedSet<E> s) {
        //iterate through the provided set and check if this tree contains the element. if it doesent return false
        if(s==null) return false;
        Iterator it = s.iterator();
        while (it.hasNext()) {
            if (!contains((E) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addAll(SortedSet<E> s) {
        //iterate through the provided set and add each element to this tree
        Iterator it = s.iterator();
        while (it.hasNext()) {
            this.add((E) it.next());
        }
    }

    @Override
    public void removeAll(SortedSet<E> s) {
        //iterate through the provided set and remove each element from this tree
        Iterator it = s.iterator();
        while (it.hasNext()) {
            this.remove((E) it.next());
        }
    }

    @Override
    public void retainAll(SortedSet<E> s) {
        //make a temporary treeset and iterate through *this* treeset
        Iterator it = this.iterator();
        SortedSet<E> removing = new TreeSet<>();
        while (it.hasNext()) {
            E thiselem = (E) it.next();
            //if the provided set doesent contain the element then add it to the temporary set
            if (!s.contains(thiselem)) {
                removing.add(thiselem);
            }
        }
        //remove all elements in *this* that we added to the temporary set
        this.removeAll(removing);
    }

    @Override
    public void clear() {
        //remove all elements taht are in this set
        this.removeAll(this.clone());
    }

    //this
    @Override
    public String toString() {
        //if the size is 0, say the set is empty
        String out = "";
        if (this.size() == 0) {
            return "This Set is empty!";
        }
        //make a clone copy of this tree set, printing the min elements of the tree, before removing that element, until no elements remain
        SortedSet<E> temp = new TreeSet<>();
        temp = this.clone();
        while (!temp.isEmpty()) {
            E min = temp.min();
            out += "[" + min + "] ";
            temp.remove(min);
        }
        return out;
    }

    @Override
    public boolean equals(Object obj) {

        //cast the obj to a treeset, and iterate through *this*, checking it it temp contains every element
        //if an element is missing return false
        
        SortedSet<E> temp = (TreeSet) obj;
        if(this.min() == null && temp.min() != null) return false;
        for (E it : this) {
            if (!temp.contains(it)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public SortedSet<E> clone() {
        //using a foreach, add every element to a new set and return that set
        SortedSet<E> ret = new TreeSet<>();
        for (E it : this) {
            ret.add(it);
        }
        return (ret);
    }

}
