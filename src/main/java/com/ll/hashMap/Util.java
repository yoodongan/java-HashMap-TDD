package com.ll.hashMap;

public class Util {
    public static class arr {
        public static void moveLeft(Object[] arr, int startIndex, int endIndex) {
            for (int i = startIndex; i <= endIndex; i++) { // startIndex -1  인덱스가 삭제할 위치임.
                arr[i - 1] = arr[i];
            }
        }
        public static Object[] sizeUp(Object[] arr) {
            Object[] newArr = new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            return arr;
        }


    }
}
