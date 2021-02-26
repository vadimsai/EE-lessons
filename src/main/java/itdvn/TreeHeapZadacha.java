package zadachi;

import java.util.Arrays;
import java.util.Scanner;

public class TreeHeapZadacha {

    public static void main(String[] args) {

        int arr[] = {2, 4, 15, 3, 6, 26, 8, 9, 13, 11};
      //  int g = 6;




      //  f(arr);

        buildHeap(arr);// две 2, исправить и получить высоту
      //  System.out.println(Arrays.toString(arr));

       // extractMax(arr,4);
       // System.out.println(Arrays.toString(arr));
       // particalSorting(arr,3);

       
    }

    public static void buildHeap(int[] arr) // Создаем кучу из массива
    {
        int n = arr.length / 2;
        for (int i = n; i >= 0; i--) {
            shutDown(arr, i);

        }
        System.out.println(Arrays.toString(arr));

    }

    public static void shutDown(int arr[], int i) {
        int maxindex = i;
        int l = i * 2;
        int r = i * 2 + 1;
        int size = arr.length - 1;
        if (l <= size && arr[l] > arr[maxindex]) {
            maxindex = l;
            System.out.println("левый лист: "+maxindex);

        }
        if (r <= size && arr[r] > arr[maxindex]) {
            maxindex = r;
            System.out.println("правый лист: "+maxindex);
        }
        if (i != maxindex) {  // значит i меньше maxindex и меняем местами
            int temp = arr[i];
            arr[i] = arr[maxindex];
            arr[maxindex] = temp;

            shutDown(arr, maxindex);
        }
    }

    public static int[] extractMax(int[] arr, int col) // извлечение корневого элемента
    {
        buildHeap(arr); // превращаем массив в кучу
        int result = arr[0]; // получаем корневой элемент
        arr[0] = arr[arr.length-1]; // последний в начало

        col--; // колличество корневых элементов для извлечения

        int arr2[] = new int[arr.length - 1];
        for (int i = 0; i <= arr.length-2; i++) {
            arr2[i] = arr[i]; // присваеваем в новый массив размером -1
        }
        System.out.println("MAX element: "+result+", arr size: "+ arr2.length);
        if(col!=0) { return extractMax(arr2,col);}// рекурсивный вызов, чтобы передать измененный массив
        else{ return arr2; } // возвращаем измененный массив

    }





    public static void heightH1(int arr[]) {
        {

            for (int i = 0; i <= arr.length - 2; i++) {
                int l = i * 2;
                int r = i * 2 + 1;
                if (i == l) {
                    heightH1(arr);
                    System.out.println(l);
                }

            }
        }
    }

/*
    public  static void f(int arr[])
    {
        int arr2[] = new int[arr.length - 1];
        for (int i = 0; i <= arr.length - 2; i++) {
            arr2[i] = arr[i];
            System.out.println(Arrays.toString(arr2));
        }
    }
*/
}
