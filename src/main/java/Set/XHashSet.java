package Set;

import java.util.Iterator;

public class XHashSet<T> implements XSet<T> {
    class HashMap<T, Object> {

        T data;
        Object equalCheck;

        public HashMap(T data) {
            this.data = data;
        }
    }
    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public XSet<T> union(XSet<T> other) {
        return null;
    }

    @Override
    public XSet<T> intersection(XSet<T> other) {
        return null;
    }

    @Override
    public XSet<T> difference(XSet<T> other) {
        return null;
    }

    @Override
    public XSet<T> symmetricDifference(XSet<T> other) {
        return null;
    }

    @Override
    public boolean isSubsetOf(XSet<T> other) {
        return false;
    }

    @Override
    public boolean isSupersetOf(XSet<T> other) {
        return false;
    }

    @Override
    public XSet<T> copy() {
        return null;
    }
}
