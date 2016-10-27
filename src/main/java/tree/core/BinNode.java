/**
 * Source code example for "A Practical Introduction to Data
 * Structures and Algorithm Analysis, 3rd Edition (Java)"
 * by Clifford A. Shaffer
 * Copyright 2008-2011 by Clifford A. Shaffer
 */

package tree.core;

/**
 * ADT for binary tree nodes
 */
public interface BinNode<E> {
    /**
     * Get and set the element value
     */
    E element();

    void setElement(E v);

    /**
     * @return The left child
     */
    BinNode<E> left();

    /**
     * @return The right child
     */
    BinNode<E> right();

    /**
     * @return True if a leaf node, false otherwise
     */
    boolean isLeaf();
}