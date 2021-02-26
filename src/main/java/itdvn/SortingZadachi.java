package zadachi;

import java.util.Arrays;

public class SortingZadachi {

    public static void main(String[] args) {


        int a[] = {9, 3, 2, 4, 7};
        int b[] = {6, 1, 8};

        min(a);

        makeSet(a,b);
    }


    public static int min(int a[])  // получаем минимальный элемент массива
    {
        int min=a[0];
        for (int i=0;i<=a.length-1;i++)
        {
            if(min>a[i])
            {
                min=a[i];
            }

        }
        System.out.println(min);

        return min;
    }


    public static void makeSet(int a[],int b[])  // Объединение 2 массивов в один
    {
        int[] c=new int[a.length+b.length];
        for(int i=0;i<a.length;i++)
        {
            c[i]=a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            c[a.length+i]=b[i];
        }

        System.out.println(Arrays.toString(c));


        boolean sort= false;
        while (!sort)        // сортировка пузырьком, 2 элемента меняются местами
        {
            sort=true;

            for(int i=0;i<c.length-1;i++)
            {
                if(c[i]>c[i+1])
                {
                   int t=c[i];
                    c[i]=c[i+1];
                    c[i+1]=t;
                    sort=false;   // если хоть одно изменение, цикл продолжится, пока все не отсортирует
                }

            }

        }

        System.out.println(Arrays.toString(c));

     /*   for(int i=0;i<c.length;i++)
        {
            for(int k=0;k<a.length;k++) {
                if ( i == a[k]) {
                    c[i] = min(a);
                }
            }

        }
        System.out.println(Arrays.toString(c));*/



    }
}
