package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyClassTask6Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 20, "Hungarian", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Canada", "Female")
    );

    List<Animal> differentGenders = List.of(
            new Animal(1, "Dog", 40, "Hungarian", "Male"),
            new Animal(2, "Cat", 35, "Argentina", "Bipolar"),
            new Animal(3, "Bird", 50, "Brazil", "Male"),
            new Animal(4, "Dog", 45, "Argentina", "Bilingual"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Polymorphism"),
            new Animal(7, "Sheep", 40, "Canada", "Male")
    );

    List<Animal> allMale = List.of(
            new Animal(1, "Dog", 40, "Hungarian", "Male"),
            new Animal(2, "Cat", 20, "Hungarian", "Male"),
            new Animal(3, "Bird", 27, "Hungarian", "Male"),
            new Animal(4, "Dog", 18, "Hungarian", "Male"),
            new Animal(5, "Horse", 6, "Hungarian", "Male"),
            new Animal(6, "Cow", 32, "Hungarian", "Male"),
            new Animal(7, "Sheep", 22, "Hungarian", "Male")
    );

    List<Animal> allFemale = List.of(
            new Animal(1, "Dog", 40, "Hungarian", "Female"),
            new Animal(2, "Cat", 20, "Hungarian", "Female"),
            new Animal(3, "Bird", 27, "Hungarian", "Female"),
            new Animal(4, "Dog", 18, "Hungarian", "Female"),
            new Animal(5, "Horse", 6, "Hungarian", "Female"),
            new Animal(6, "Cow", 32, "Hungarian", "Female"),
            new Animal(7, "Sheep", 22, "Hungarian", "Female")
    );


    @Test
    void givenNormalList_whenTask6_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isAllMaleOrFemale = myClass.task6(normalAnimals);

        assertTrue(isAllMaleOrFemale);
    }

    @Test
    void givenDifferentGenders_whenTask6_thenReturnFalse() {
        MyClass myClass = new MyClass();

        boolean isAllMaleOrFemale = myClass.task6(differentGenders);

        assertFalse(isAllMaleOrFemale);
    }

    @Test
    void givenAllMale_whenTask6_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isAllMaleOrFemale = myClass.task6(allMale);

        assertTrue(isAllMaleOrFemale);
    }

    @Test
    void givenAllFemaleMale_whenTask6_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isAllMaleOrFemale = myClass.task6(allFemale);

        assertTrue(isAllMaleOrFemale);
    }




}