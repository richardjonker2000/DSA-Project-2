/*
 * Interface a ser usada no segundo trabalho prático de AED.
 */
package set;

/**
 * Interface for sorted collections with the typical behavior of sets.
 * Requires that the elements to be collected be comparable.
 * This is an adapted version of the interface
 * <a href="http://docs.oracle.com/javase/7/docs/api/java/util/SortedSet.html">SortedSet</a>
 * do package java.util do Java Standard Ed.7.
 * @author Paulo Gouveia
 * @param <E> type of elements to collect.
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/">Java™ Platform, Standard Edition 7 API Specification</a>
 * @since 07/06/2020
 */
public interface SortedSet<E extends Comparable<E>> extends Iterable<E>{ 
    
    /**
     * Returns a subset of this set with the elements contained in the range [fromElement, toElement[.
     * In other words, returns all elements that are greater than or equal to fromElement
     * and strictly inferior to toElement. 
     * @param fromElement lower (inclusive) limit of the values contained in the subset to be returned.
     * @param toElement upper (exclusive) limit of the values contained in the subset to be returned.
     * @return set with the elements of this set higher than or equal to fromElement and lower than toElement.
     */
    SortedSet<E> subSet(E fromElement, E toElement);
    
    /**
     * Returns a subset of this set with all elements that are strictly less than toElement.
     * @param toElement upper (exclusive) limit of the values contained in the subset to be returned.
     * @return set with the elements of this set less than toElement.
     */
    SortedSet<E> headSet(E toElement);

    /**
     * Returns a subset of this set with all elements that are greater than or equal to fromElement.
     * @param fromElement lower (inclusive) limit of the values contained in the subset to be returned.
     * @return set with the elements of this set greater than or equal to fromElement.
     */
    SortedSet<E> tailSet(E fromElement);
    
    /**
     * Returns, without removing, the smallest of the elements.
     * @return the smallest element of this set.
     */  
    E min();
    
    /**
     * Returns, without removing, the higher of the elements.
     * @return the higher element of this set.
     */  
    E max();
    
    /**
     * Returns the amount of elements contained in this set.
     * @return number of elements in this set.
     */
    int size();
    
    /**
     * Checks that this set contains no elements.
     * @return true if this set is empty.
     */
    boolean isEmpty();
    
    /**
     * Checks whether this set contains the specific element.
     * @param e element whose presence in the set is checked.
     * @return true if the specific element is present in this set.
     */
    boolean contains(E e);
    
    /**
     * Adds the specific element to this set if it is not already present.
     * @param e element to add to this set.
     * @return true if this set does not yet contain the specific element.
     */
    boolean add(E e);
    
    /**
     * Removes the specific element from this set, if present.
     * @param e element to be removed from this set.
     * @return true if the element has been removed.
     */
    boolean remove(E e);
    
    /**
     * Checks whether this set contains all elements of the specific set.
     * @param s set to check if it is contained in this set.
     * @return true if this set contains all elements of the specific set.
     */
    boolean containsAll(SortedSet<E> s);
    
    /**
     * Adds in this set all the elements contained in the specific set, without cloning the copied objects.
     * @param s set with the elements to be added to this set.
     */
    void addAll(SortedSet<E> s);
    
    /**
     * Removes from this set all elements that are contained in the specific set.
     * @param s set with the elements to be removed from this set.
     */
    void removeAll(SortedSet<E> s);
    
    /**
     * Removes from this set all elements that are not contained in the specific set.
     * @param s set with the elements to be retained in this set.
     */
    void retainAll(SortedSet<E> s);
    
    /**
     * Removes all elements from this set, leaving it empty.
     */
    void clear();
    
    /**
     * Returns a string with a representation of all collected elements.
     * @return a string with a representation of the collected elements.
     */ 
    String toString();
    
    /**
     * Checks whether the specific object is considered equal to this set.
     * @param obj object to be compared with the current set.
     * @return true if the sets are considered equal.
     */ 
    boolean equals(Object obj);
    
    /**
     * Returns a copy of this collection without cloning the collected objects.
     * @return a set with the same elements as this set.
     */ 
    SortedSet<E> clone();
}
 