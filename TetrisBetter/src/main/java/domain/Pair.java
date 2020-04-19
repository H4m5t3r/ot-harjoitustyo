/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author taleiko
 */
public class Pair<TOne, TTwo> {
    
    private final TOne left;
    private final TTwo right;

    public Pair(TOne left, TTwo right) {
        this.left = left;
        this.right = right;
    }
    
    public TOne getLeft() {
        return left;
    }
    
    public TTwo getRight() {
        return right;
    }
    
    public static <tOne, tTwo> Pair<tOne, tTwo> of(tOne left, tTwo right) {
        return new Pair(left, right);
    }
}
