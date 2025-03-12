package List;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class XArrayList <T> implements XList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private int size;
    Object[] array;

    public XArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    private void resize() {
        int oldCapacity = array.length;

        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if(size == oldCapacity) {
            int newCapacity = oldCapacity * 2;

            array = Arrays.copyOf(array, newCapacity);
            return;
        }
    }

    @Override
    public void add(T element) {
        if(element == null) {
            throw new NullPointerException();
        }
        if(size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        if(index == size) {
            add(element);
        }
        else {
            if(size == array.length) {
                resize();
            }

            for(int i=size; i>index; i--) {
                array[i] = array[i-1];
            }
            array[index] = element;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = (T) array[index];
        for(int i=index; i<size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return result;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if(index == -1) {
            throw new NullPointerException();
        }
        remove(index);
        return true;
    }

    @Override
    public boolean contains(T element) {
        int index = indexOf(element);
        return index != -1;
    }

    @Override
    public int indexOf(T element) {
        for(int i=0; i<size; i++) {
            if(element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public void set(int index, T element) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        array[index] = element;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size <= 1) return; // 요소가 1개 이하라면 정렬할 필요 없음

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(get(j), get(j+1)) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // 더 이상 바뀌는 요소가 없으면 종료
        }
    }
    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        XList<T> result = new XArrayList<T>();
        for(int i=fromIndex; i<toIndex; i++) {
            result.add(get(i));
        }
        return result;
    }

    @Override
    public void addAll(List<T> otherList) {
        for(T element : otherList) {
            add(element);
        }
    }

    @Override
    public void forEach() {
        for(int i=0; i<size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public XList<T> copy() {
        XList<T> result = new XArrayList<T>();
        for(int i=0; i<size; i++) {
            result.add(get(i));
        }
        return result;
    }
}
