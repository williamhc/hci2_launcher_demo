package experiment;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class ImageController {
	private Bitmap animalImages150[];
	private Bitmap animalImages50[];
	private final File animalDirectory = new File("./assets/animals/");
	
	public ImageController() {
		animalImages150 = new Bitmap[150];
		animalImages50 = new Bitmap[50];
		readImages();
	}
	
	private void readImages() {
		File[] file = animalDirectory.listFiles();
		for (int index = 0; index < file.length; index++) {
			animalImages150[index] = BitmapFactory.decodeFile(file[index].getPath());
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
	
	private void storeEveryXImageFrom150Images(int x, Bitmap imageStorage[]) {
		for (int index = 0; index < animalImages150.length && (index / x) < imageStorage.length; index+=3) {
			imageStorage[index / x] = animalImages150[index];
		}
	}
	
	private void shuffleArray(Bitmap imageStorage[], int start, int end) {
		while (start != end) {
			Bitmap temp = imageStorage[start];
			imageStorage[start] = imageStorage[end];
			imageStorage[end] = temp;
			start++;
			end--;
		}
	}
	
	public Bitmap FrequentImage(int threshold) {
		int randNum = (int)(Math.random() * threshold) + 1;
		return animalImages50[randNum];
	}
	
	public Bitmap InfrequentImage(int threshold) {
		int randNum = 50 - ((int)(Math.random() * threshold) + 1);
		return animalImages50[randNum];
	}
	
	public Bitmap[] AnimalImages150() {
		return animalImages150;
	}
	
	public Bitmap[] AnimalImages50() {
		return animalImages50;
	}
}
