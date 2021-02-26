package itdvn.serializ;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Externazibl implements Externalizable {
    private int id;
    private String name;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(id);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        id=in.readInt();
        name= (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Externazibl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Externazibl() {
    }

    public Externazibl(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
