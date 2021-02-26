package itdvn.xmlparsing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class SAmopisParsxml {

    private String xml;


    // конструктор, в нем считываем xml файл
    public SAmopisParsxml(String pathPagexml) throws UnsupportedEncodingException {
        byte[] buf=null;
        RandomAccessFile file=null;

        try {
            file=new RandomAccessFile(pathPagexml,"r"); // путь и r- считывает
            buf=new byte[(int) file.length()]; // записываем в массив байт
            file.read(buf); // считываем массив


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xml=new String(buf,"US-ASCII");
    }



    public String getPage(String tags)
    {
        String[] tag=tags.split("/"); // разбиваем на части по "/"
        String s_xml=xml; // записываем содержимое из конструктора

        for (String e : tag) {
            String inTag="<"+e+">";
            int start=s_xml.indexOf(inTag); // определяем где начинается тэг
            if (start<0)
            { return null; }
            else
            {
                start+=inTag.length();  // находим конец тэга
            }

            int end=s_xml.lastIndexOf("</"+e+">"); // находим закрывающий тэг
            if(end<0)
            { return  null;}

            s_xml=s_xml.substring(start,end); // вырезаем найденную строку
        }

        return s_xml;

    }

}
