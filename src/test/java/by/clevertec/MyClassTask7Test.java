package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyClassTask7Test {

    List<Animal> animalsWithoutOceania = List.of(
            new Animal(1, "Dog", 20, "Hungarian", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Canada", "Female")
    );

    List<Animal> animalsWithOceania = List.of(
            new Animal(1, "Dog", 40, "Oceania", "Male"),
            new Animal(2, "Cat", 35, "Argentina", "Bipolar"),
            new Animal(3, "Bird", 50, "Brazil", "Male"),
            new Animal(4, "Dog", 45, "Oceania", "Bilingual"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Polymorphism"),
            new Animal(7, "Sheep", 40, "Canada", "Male")
    );




    @Test
    void givenAnimalsWithoutOceania_whenTask7_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isThereAnimalFromOceania = myClass.task7(animalsWithoutOceania);

        assertTrue(isThereAnimalFromOceania);
    }

    @Test
    void givenAnimalsWithOceania_whenTask7_thenReturnFalse() {
        MyClass myClass = new MyClass();

        boolean isThereAnimalFromOceania = myClass.task7(animalsWithOceania);

        assertFalse(isThereAnimalFromOceania);
    }






}