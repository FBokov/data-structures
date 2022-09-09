package com.fbokov.binarytree;

public enum TraversalStrategies {
    PRE_ORDER_ON_ARRAYS(new PreOrderTraversalOnArraysStrategy()),
    PRE_ORDER_ON_STACK(new PreOrderTraveralOnStackStrategy()),
    PRE_ORDER_RECURSIVE(new PreOrderTraversalRecursiveStrategy());;

    public final TraversalStrategy instance;
    private TraversalStrategies(TraversalStrategy instance) {
        this.instance = instance;
    }
}
