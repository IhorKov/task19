package com.task;

public class IntListImpl implements IntList{
    private int[] arr = new int[10];
    private int count = 0;

    @Override
    public void add(int i) {
        if (count >= this.arr.length) {
            increasingArray();
        }
        this.arr[this.count] = i;
        this.count++;
    }

    @Override
    public void insert(int index, int value) {
        this.count++;
        if (count >= this.arr.length) {
            increasingArray();
        }

        int[] arrBuff = new int[this.arr.length - index];

        for (int i = index, k = 0; i < this.arr.length; i++, k++){
            arrBuff[k] = this.arr[i];
        }

        this.arr[index] = value;

        for (int i = index, k = 0; i < arrBuff.length; i++, k++){
            this.arr[i + 1] = arrBuff[k];
        }

    }

    @Override
    public void set(int index, int value) {
        this.arr[index] = value;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public int capacity() {
        return this.arr.length;
    }

    @Override
    public int getByIndex(int index) {
        return this.arr[index];
    }

    @Override
    public Integer getIndexByValue(int value) {
        Integer result = null;

        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean contains(int value) {
        boolean isValue = false;

        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                isValue = true;
                break;
            }
        }
        return isValue;
    }

    @Override
    public void removeValue(int value) {

        int[] arr = new int[this.arr.length];

        for (int i = 0, k = 0; i < this.arr.length; i++){
            if (value == this.arr[i]){
                this.count--;
            }
            else {
                arr[k] = this.arr[i];
                k++;
            }
        }
        this.arr = arr;
    }

    @Override
    public void removeByIndex(int index) {
        int[] arr = new int[this.arr.length];

        for (int i = 0, k = 0; i < this.arr.length; i++){
            if (i == index){
                this.count--;
            }
            else {
                arr[k] = this.arr[i];
                k++;
            }
        }
        this.arr = arr;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new IntListImpl();

        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(getByIndex(i));
        }
        return list;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size()];

        for(int i = 0; i < size(); i++) {
            arr[i] = getByIndex(i);
        }

        return arr;
    }

    private void increasingArray() {
        int newSize = (int)(this.arr.length * 1.5) + 1;
        int[] arr = new int[newSize];

        for (int i = 0; i < this.arr.length; i++) {
            arr[i] = this.arr[i];
        }
        this.arr = arr;
    }
}
