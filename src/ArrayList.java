import javax.print.DocFlavor;
import java.util.Random;

public class ArrayList {
    int[] mainArray;
    int size = 0;

    public ArrayList() {
        mainArray = new int[16];
    }

    public void addAtIndex(int index) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size == mainArray.length) {
            expand();
        }
        Random rand = new Random();
        mainArray[index] = rand.nextInt(201) - 100;
    }

    private void expand() {
        int[] tempArray = new int[mainArray.length * 2];
        for (int i = 0; i < mainArray.length; i++) {
            tempArray[i] = mainArray[i];
        }
        mainArray = tempArray;
    }

    public void removeAtIndex(int index) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        while (index < size) {
            mainArray[index] = mainArray[index + 1];
            index++;
        }
        size--;
    }


    public String toString() {
        String builder = "";
        for (int i = 0; i < mainArray.length; i++) {
            builder += "[" + mainArray[i] + "]";
        }
        return builder;
    }

}
