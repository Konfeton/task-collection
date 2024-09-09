package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTask5Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 20, "Hungarian", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Canada", "Female")
    );

    List<Animal> notInAgeRange = List.of(
            new Animal(1, "Dog", 40, "Hungarian", "Male"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 50, "Brazil", "Male"),
            new Animal(4, "Dog", 45, "Argentina", "Male"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Male"),
            new Animal(7, "Sheep", 40, "Canada", "Male")
    );

    List<Animal> allHungarianSomeInAgeRange = List.of(
            new Animal(1, "Dog", 40, "Hungarian", "Male"),
            new Animal(2, "Cat", 20, "Hungarian", "Male"),
            new Animal(3, "Bird", 27, "Hungarian", "Male"),
            new Animal(4, "Dog", 18, "Hungarian", "Male"),
            new Animal(5, "Horse", 6, "Hungarian", "Male"),
            new Animal(6, "Cow", 32, "Hungarian", "Male"),
            new Animal(7, "Sheep", 22, "Hungarian", "Male")
    );


    @Test
    void givenNormalList_whenTask5_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isThereHungarian = myClass.task5(normalAnimals);

        assertTrue(isThereHungarian);
    }

    @Test
    void givenNotInAgeRangeWithHungarian_whenTask5_thenReturnFalse() {
        MyClass myClass = new MyClass();

        boolean isThereHungarian = myClass.task5(notInAgeRange);

        assertFalse(isThereHungarian);
    }

    @Test
    void givenAllHungarianSomeInAgeRange_whenTask5_thenReturnTrue() {
        MyClass myClass = new MyClass();

        boolean isThereHungarian = myClass.task5(allHungarianSomeInAgeRange);

        assertTrue(isThereHungarian);
    }




}