package zadachi;

import sun.security.util.math.intpoly.IntegerPolynomialP256;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) throws IOException {
     /*   byte[]b={3,5,5,3,78,88};
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(b); // выводим в байтах, но можем и в символах(char)

        int t;
        while ((t=byteArrayInputStream.read())!=-1) // когда нет возвращает -1
        {
            System.out.println(t);
        }

        String s= "Hello SAI";
        byte[] b1=s.getBytes();
        ByteArrayInputStream byteArrayInputStream1=new ByteArrayInputStream(b1,5,10);// c 5 символа по 10

        int t1;
        while ((t1=byteArrayInputStream1.read())!=-1)
        {
            System.out.println((char) t1); // в смиволах
        }*/


                            // Ввод с консоли

     /*   BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        //int i=bufferedReader.read();  // в байтах
        int i1= Integer.parseInt(bufferedReader.readLine());
       // System.out.println(i);
        System.out.println(i1);


        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        int n=inputStreamReader.read();
       // System.out.println(n); в байтах
        System.out.println((char) n); // символы
*/

                         // Запись в файл и чтение из файла
/*
        DataOutputStream data= new DataOutputStream(new BufferedOutputStream(new FileOutputStream("dataout.txt")));
        data.writeUTF("SAI RAM"); // записываем в файл, файл создается автоматом в src
        data.flush(); // насыщает
        data.close();

        DataInputStream datain= new DataInputStream(new BufferedInputStream(new FileInputStream("dataout.txt")));
        System.out.println(datain.readUTF()); // читаем из файла
        datain.close(); // надо закрывать или try with resourses автоматически закроет


        PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(System.out,"UTF-8"),true);// autoflesh- очищаем буфер или нет
        File file=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\ItdvnZadachi.java"); // файл- клласс ItdvnZadachi
        printWriter.println(file.getName());
        printWriter.println(file.canRead());
        printWriter.println(file.canWrite());
        printWriter.println(file.length());


        File file1=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src"); // файл в директории
        String[] d=file1.list(); // записываем в массив содержимое файла
        for (int i = 0; i < d.length; i++) {
            printWriter.println(d[i]); // читаем из массива
        }
        printWriter.close();



        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("G:\\ф\\hr.sql"))); // записываем из файла в буфер
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("buferOut.txt"),"UTF-8")); // создаем файл и пишем туда

        int b;
        while ((b=bufferedReader.read())!=-1) // из буфера в переменную
        {
            bufferedWriter.write((char)b); // записываем в файл
        }

        bufferedReader.close();
        bufferedWriter.close();


        OutputStream outputStream=new FileOutputStream("dataout.txt");
        byte[] bw={34,6,7,8,9,65,89,32};

        for (int i = 0; i < bw.length; i++) {
            outputStream.write(bw[i]); // записываем в файл
        }

        FileInputStream inputStreamReader= new FileInputStream("dataout.txt");

        int s=inputStreamReader.available(); // есть ли значения
        for (int i = 0; i < s; i++) {
            System.out.println(inputStreamReader.read()+" "); // читаем из файла
        }

        outputStream.close();
        inputStreamReader.close();



        File file2=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\dataout.txt");
        BufferedReader bufferedReader1=new BufferedReader(new FileReader(file2));

        String t;
        while ((t=bufferedReader1.readLine())!=null) // записываем в переменную
        {
            System.out.println(t); // не показывает
        }
        bufferedReader1.close();

        PrintWriter printWriter1=new PrintWriter(new FileWriter(file2, true));

        printWriter1.println("SAI RAM AUM"); // записываем в файл file2
        printWriter1.close();
*/

                  // произвольная запись и чтение в файл
/*
        RandomAccessFile randomAccessFile=new RandomAccessFile("C:\\Users\\it\\IdeaProjects\\HrProject\\raAces.txt","rw");
        randomAccessFile.write(new byte[]{3,5,66,8,9,9,0});
        randomAccessFile.seek(0);
        byte[] arr=new byte[10];
        int n=randomAccessFile.read(arr,5,0);
        System.out.println(Arrays.toString(arr));
*/


                // копирование из файла в файли перемещение

/*
        File fromfile=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\dataout.txt"); // из файла
        File tofile=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\tofile.txt");  // сам создает файл по адрессу при копировании(файл не должен существовать на момент копирования)

        Files.copy(fromfile.toPath(),tofile.toPath()); // копируем
*/

                       // URL и APIключ
/*
        String city;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        city=bufferedReader.readLine();

        URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q="+ URLEncoder.encode(city,"UTF-8")+"&units=metric&mode=html&appid=771a8c89dd0cdc9681c31d38cb745900");

        bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));



        while ((city=bufferedReader.readLine())!=null)
        {
            System.out.println(city);
        }

        bufferedReader.close();

 */



    }
}
