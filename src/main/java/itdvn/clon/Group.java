package itdvn.clon;

import java.io.Serializable;

public class Group implements Serializable {
    public int id;

    public Group() {
    }

    public Group(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                '}';
    }
}
