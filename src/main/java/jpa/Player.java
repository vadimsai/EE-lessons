package jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@DiscriminatorValue("Pl")
@Entity
public class Player extends Person {

    @Id
    @GeneratedValue
    int id;

    String play;
    int sum;

    public Player() {
    }

    public Player(String play, int sum) {
        this.play = play;
        this.sum = sum;
    }
}
