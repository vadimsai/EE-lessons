package patterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// объект содержит сам себе и другой объект (древовидная структура)


public class Composite {
    public static void main(String[] args) {

    }
}

class File{}               //  листики дерева

class Folder               //   корень дерева
{
    String name;
    Date creatDate;
    List<Folder> fold=new ArrayList<>();     //  список папок(самого себя)
    List<File> file=new ArrayList<>();       //  список файлов(листиков)

    public Folder(String name) {
        this.name = name;
    }

    public List<Folder> getFold() {
        return fold;
    }

    public List<File> getFile() {
        return file;
    }

    void addFold(Folder f)
    {
        fold.add(f);
    }

    void remoovFold(Folder f)
    {
        fold.remove(f);
    }
    void addFile(File f)
    {
        file.add(f);
    }

    void remoovFile(File f)
    {
        file.remove(f);
    }
}