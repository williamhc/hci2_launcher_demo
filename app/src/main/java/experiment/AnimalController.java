package experiment;

import android.graphics.BitmapFactory;

import java.io.File;


public class AnimalController {
	private Animal[] animalImages150;
	private Animal[] animalImages50;
	private final File animalDirectory = new File("./assets/animals/");
	
	public AnimalController() {
		animalImages150 = new Animal[150];
		animalImages50 = new Animal[50];
		readImages();
	}
	
	private void readImages() {
		File[] file = animalDirectory.listFiles();
		for (int index = 0; index < file.length; index++) {
            String fname = file[index].getPath();
            Animal animal = new Animal(BitmapFactory.decodeFile(fname), fname.substring(0, fname.length() - 4));
			animalImages150[index] = animal;
		}
		
		shuffleArray(animalImages150, 0, 50);
		shuffleArray(animalImages150, 50, 100);
		shuffleArray(animalImages150, 100, 150);
		shuffleArray(animalImages150, 34, 90);
		shuffleArray(animalImages150, 80, 150);
		shuffleArray(animalImages150, 2, 124);
		shuffleArray(animalImages150, 0, 150);
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
