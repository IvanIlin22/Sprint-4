package ru.sber.generics

import java.util.*

// 1.
fun <A, B> compare(p1: Pair<A, B>, p2: Pair<A, B>): Boolean {
    return p1.equals(p2)
}

// 2.
fun <T : Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    var count: Int = 0

    for (value in anArray) {
        if (value > elem) {
            count++
        }
    }

    return count
}

// 3.
class Sorter<T : Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort();
    }
}

// 4.
class Stack<T> {
    private val stack: Deque<T> = ArrayDeque<T>()

    fun push(value: T) {
        stack.push(value)
    }

    fun pop(): T {
        return stack.pop()
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }
}