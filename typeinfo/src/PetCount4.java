import pets.Pet;
import pets.Pets;
import util.TypeCounter;
import static util.Print.print;
import static util.Print.printnb;

public class PetCount4 {
    public static void main(String[] args) {
        // Определяем объект счетчик во главе с классом-иерархии Pet
        TypeCounter counter = new TypeCounter(Pet.class);
        for(Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}
