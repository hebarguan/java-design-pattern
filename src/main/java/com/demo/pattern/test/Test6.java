package com.demo.pattern.test;


/**
 * @author huaihai.guan
 * @since 2021/7/14 17:45
 */
public class Test6 {

    public static void main(String[] args) {
        ILinked<String> a = new ILinked<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.remove(4);
        for (int i = 0; i < a.size; i++) {
            System.out.println(a.get(i));
        }
    }

    interface BaseLinked<E> {
        void add(E e);
        void remove(int Idx);
        E get(int idx);
    }

    static class ILinked<E> implements BaseLinked<E> {

        private INode<E> first;
        private INode<E>last;
        private int size;

        @Override
        public void add(E o) {
            INode<E> n;
            INode<E> l = last;
            INode<E> f = first;
            if (f == null && l == null) {
                n = new INode<>(null, o, null);
                first = n;
                last = n;
            } else {
                n = new INode<>(l, o, null);
                l.next = n;
                last = n;
            }
            size++;
        }

        @Override
        public void remove(int idx) {
            if (idx >= size) throw new ArrayIndexOutOfBoundsException("outOfBoundsException");
            if (idx == 0 || size == 1) {
                if (first.next == null) {
                    first = null;
                    last = null;
                } else {
                    INode<E> next = first.next;
                    next.prev = null;
                    first = next;
                }
            } else {
                INode<E> curr;
                if (idx <= size >> 1) {
                    curr = first;
                    for (int i = 0; i < idx; i++) {
                        curr = curr.next;
                    }
                    removeINode(curr.prev, curr.next);
                } else {
                    curr = last;
                    for (int i = size - 1; i > idx; i--) {
                        curr = curr.prev;
                    }
                    removeINode(curr.prev, curr.next);
                }
            }
            size--;

        }

        private void removeINode(INode<E> prev, INode<E> next) {
            prev.next = next;
            if (null != next) {
                next.prev = prev;
            }
        }

        @Override
        public E get(int idx) {
            if (idx >= size) throw new ArrayIndexOutOfBoundsException("outOfBoundsException");
            if (idx == 0 ) return first.item;
            if (idx == size - 1) return last.item;
            INode<E> curr;
            if (idx <= size >> 1) {
                curr = first;
                for (int i = 0; i < idx; i++) {
                    curr = curr.next;
                }
                return curr.item;
            } else {
                curr = last;
                for (int i = size - 1; i > idx; i--) {
                    curr = curr.prev;
                }
                return curr.item;
            }
        }
    }

    static class INode<E> {
        private E item;
        private INode<E> prev;
        private INode<E> next;

        INode(INode<E> prev, E item, INode<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
