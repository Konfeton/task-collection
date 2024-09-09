package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyClassTask4Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 40, "Australia", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 50, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Male"),
            new Animal(7, "Sheep", 40, "Canada", "Female")
    );

    List<Animal> allMale = List.of(
            new Animal(1, "Dog", 40, "Australia", "Male"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 50, "Brazil", "Male"),
            new Animal(4, "Dog", 45, "Argentina", "Male"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Male"),
            new Animal(7, "Sheep", 40, "Canada", "Male")
    );




    @Test
    void givenNormalList_whenTask4_thenNumberOfFemale() {
        MyClass myClass = new MyClass();

        long numberOfFemale = myClass.task4(normalAnimals);

        assertEquals(4, numberOfFemale);
    }

    @Test
    void givenAllMale_whenTask4_thenReturnZero() {
        MyClass myClass = new MyClass();

        long numberOfFemale = myClass.task4(allMale);

        assertEquals(0, numberOfFemale);
    }

    @Test
    void givenEmptyList_whenTask4_thenReturnZero() {
        MyClass myClass = new MyClass();

        long numberOfFemale = myClass.task4(Collections.emptyList());

        assertEquals(0, numberOfFemale);
    }




}