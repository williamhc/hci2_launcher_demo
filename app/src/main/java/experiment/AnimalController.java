package experiment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.hci2_demo.app.R;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Random;


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
                this.animalImages150[i] = new Animal(drawable, resourceId, animalName);
            } catch (Exception e) {
                continue;
            }
        }

        shuffleArray(animalImages150);

        storeEveryXImageFrom150Images(3, animalImages50);
	}

    static void shuffleArray(Animal[] ar)
    {
        Random rnd = new Random(1);
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Animal a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

	private void storeEveryXImageFrom150Images(int x, Animal animals[]) {
		for (int index = 0; index < animalImages150.length && (index / x) < animals.length; index+=3) {
			animals[index / x] = animalImages150[index];
		}
	}

	public Animal[] getFrequentAnimals(int animalCount, int count) {
        Animal[] animals = animalCount == 50 ? animalImages50: animalImages150;
        Animal[] frequentAnimals = new Animal[count];
        LinkedList<Animal> animalsChosen = new LinkedList<Animal>();
        int index = 0;

        while (index < count) {
            int randomNumber = (int) Math.floor(animalCount * 0.3 * Math.random());
            Animal chosenAnimal = animals[randomNumber];
            if (!animalsChosen.contains(chosenAnimal)) {
                frequentAnimals[index] = chosenAnimal;
                animalsChosen.add(chosenAnimal);
                index++;
            }
        }

        return frequentAnimals;
    }
	
	public Animal[] getInfrequentAnimals(int animalCount, int count) {
        Animal[] animals = animalCount == 50 ? animalImages50: animalImages150;
        Animal[] frequentAnimals = new Animal[count];
        LinkedList<Animal> animalsChosen = new LinkedList<Animal>();
        int index = 0;

        while (index < count) {
            int randomNumber = animalCount - (int) Math.ceil(animalCount * 0.3 * Math.random());
            Animal chosenAnimal = animals[randomNumber];
            if (!animalsChosen.contains(chosenAnimal)) {
                frequentAnimals[index] = chosenAnimal;
                animalsChosen.add(chosenAnimal);
                index++;
            }
        }

        return frequentAnimals;
	}
	
	public Animal[] Animals150() {
		return animalImages150;
	}
	
	public Animal[] Animals50() {
		return animalImages50;
	}
}
