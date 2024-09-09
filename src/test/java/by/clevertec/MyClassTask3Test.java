package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTask3Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 40, "Australia", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 50, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 45, "Australia", "Male"),
            new Animal(7, "Sheep", 40, "Canada", "Female")
    );

    List<Animal> animalsWithAgeLessThan30 = List.of(
            new Animal(1, "Dog", 20, "Australia", "Female"),
            new Animal(2, "Cat", 22, "Argentina", "Male"),
            new Animal(3, "Bird", 23, "Brazil", "Female"),
            new Animal(4, "Dog", 25, "Argentina", "Female"),
            new Animal(5, "Horse", 20, "Albania", "Male"),
            new Animal(6, "Cow", 20, "Australia", "Male"),
            new Animal(7, "Sheep", 20, "Canada", "Female")
    );

    List<Animal> animalsWithOriginStartsWithB = List.of(
            new Animal(1, "Dog", 20, "Bahrain", "Female"),
            new Animal(2, "Cat", 22, "Belarus", "Male"),
            new Animal(3, "Bird", 23, "Brazil", "Female"),
            new Animal(4, "Dog", 25, "Belgia", "Female")
    );


    @Test
    void givenNormalList_whenTask3_thenReturnCities() {
        MyClass myClass = new MyClass();

        List<String> result = myClass.task3(normalAnimals);
        List<String> expected = List.of("Australia", "Argentina", "Albania");
        assertEquals(expected, result);
    }

    @Test
    void givenListWithAgeLessThan30_WhenTask3_thenReturnZero() {
        MyClass myClass = new MyClass();


        List<String> result = myClass.task3(animalsWithAgeLessThan30);
        List<String> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    void givenEmptyList_WhenTask3_thenReturnZero() {
        MyClass myClass = new MyClass();


        List<String> result = myClass.task3(Collections.emptyList());
        List<String> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    void givenListWithCitiesStartsWithB_WhenTask3_thenReturnZero() {
        MyClass myClass = new MyClass();


        List<String> result = myClass.task3(animalsWithOriginStartsWithB);
        List<String> expected = Collections.emptyList();
        assertEquals(expected, result);
    }


}