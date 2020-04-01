import coffee.Americano;
import coffee.Coffee;
import coffee.Latte;
import coffee.Mocha;
import pets.Cat;
import pets.Dog;
import pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }
    static void oldStyleMethod1(List probablyAmericano) {
        probablyAmericano.add(new Mocha());
    }
    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1);
        List<Dog> dog2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dog2);
        } catch(Exception e) {
            System.out.println(e);
        }
        List<Pet> pet = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pet.add(new Dog());
        pet.add(new Cat());

        List<Americano> cofee1 = new ArrayList<Americano>();
        oldStyleMethod1(cofee1);
        List<Americano> cofee2 = Collections.checkedList(new ArrayList<Americano>(), Americano.class);
        try {
            oldStyleMethod1(cofee2);
        } catch(Exception e) {
            System.out.println(e);
        }
        cofee2.add(new Americano());
        List<Coffee> coffees = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        coffees.add(new Americano());
        coffees.add(new Latte());
    }
}
