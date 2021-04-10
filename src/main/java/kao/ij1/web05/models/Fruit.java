package kao.ij1.web05.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fruit_id;
    private String fruit_name;
    private String fruit_color;
    private String fruit_info;


    public Fruit(){}

    public Long getFruit_id() {
        System.out.println("===081===Web05Application.java===getFruit_id()===" );
        return fruit_id;
    }

    public void setFruit_id(Long fruit_id) {
        System.out.println("===081===Web05Application.java===setFruit_id()===" );
        this.fruit_id = fruit_id;
    }

    public String getFruit_name() {
        System.out.println("===081===Web05Application.java===getFruit_name()===" );
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        System.out.println("===081===Web05Application.java===setFruit_name()===" );
        this.fruit_name = fruit_name;
    }

    public String getFruit_color() {
        System.out.println("===081===Web05Application.java===getFruit_color()===" );
        return fruit_color;
    }

    public void setFruit_color(String fruit_color) {
        System.out.println("===081===Web05Application.java===setFruit_color()===" );
        this.fruit_color = fruit_color;
    }

    public String getFruit_info() {
        System.out.println("===081===Web05Application.java===getFruit_info()===" );
        return fruit_info;
    }

    public void setFruit_info(String fruit_info) {
        System.out.println("===081===Web05Application.java===setFruit_info()===" );
        this.fruit_info = fruit_info;
    }
}
