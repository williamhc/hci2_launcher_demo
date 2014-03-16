package experiment;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.example.hci2_demo.app.R;
import java.io.IOException;
import java.lang.reflect.Field;


public class AnimalController {
    private Context context;
    private Animal[] animalImages150;
	private Animal[] animalImages50;
	public AnimalController(Context context) {
        this.context = context;
		animalImages150 = new Animal[150];
		animalImages50 = new Animal[50];
        try {
            readImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void readImages() throws IOException {
        R.drawable drawableResources = new R.drawable();
        Class<R.drawable> c = R.drawable.class;
        Field[] fields = c.getDeclaredFields();
        Resources res = context.getResources();
        int resourceId;

        for (int i = 0, max = fields.length - 1; i < max; i++) {
            try {
                String animalName = fields[i].getName();
                resourceId = fields[i].getInt(drawableResources);
                Drawable drawable = res.getDrawable(resourceId);
                this.animalImages150[i] = new Animal(drawable, animalName);
            } catch (Exception e) {
                continue;
            }
        }

		shuffleArray(animalImages150, 0, 50);
		shuffleArray(animalImages150, 50, 100);
		shuffleArray(animalImages150, 100, 148);
		shuffleArray(animalImages150, 34, 90);
		shuffleArray(animalImages150, 80, 148);
		shuffleArray(animalImages150, 2, 124);
		shuffleArray(animalImages150, 0, 148);
		storeEveryXImageFrom150Images(3, animalImages50);
	}
	
	private void storeEveryXImageFrom150Images(int x, Animal animals[]) {
		for (int index = 0; index < animalImages150.length && (index / x) < animals.length; index+=3) {
			animals[index / x] = animalImages150[index];
		}
	}
	
	private void shuffleArray(Animal animals[], int start, int end) {
		while (start != end) {
			Animal temp = animals[start];
			animals[start] = animals[end];
			animals[end] = temp;
			start++;
			end--;
		}
	}
	
	public Animal[] getFrequentAnimals(int animalCount, int count) {
		Animal[] animals = animalCount == 50 ? animalImages50: animalImages150;
        Animal[] frequentAnimals = new Animal[count];

        for (int i = 0; i < count; i++) {
            int randNum = (int) Math.floor(animalCount * 0.3 * Math.random());
            frequentAnimals[i] = animals[randNum];
        }
        return frequentAnimals;
    }
	
	public Animal[] getInfrequentAnimals(int animalCount, int count) {
        Animal[] animals = animalCount == 50 ? animalImages50: animalImages150;
        Animal[] frequentAnimals = new Animal[count];

        for (int i = 0; i < count; i++) {
            int randNum = animalCount - (int) Math.ceil(animalCount * 0.3 * Math.random());
            frequentAnimals[i] = animals[randNum];
        }
        return frequentAnimals;
	}
	
	public Animal[] AnimalImages150() {
		return animalImages150;
	}
	
	public Animal[] AnimalImages50() {
		return animalImages50;
	}
}
