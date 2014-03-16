package experiment;

import android.graphics.drawable.Drawable;

/**
 * RAWR
 */
public class Animal {
    public Drawable img;
    public String name;
    public int img_id;

    public Animal(Drawable img, int img_id, String name) {
        this.img = img;
        this.name = name;
        this.img_id = img_id;
    }
}
