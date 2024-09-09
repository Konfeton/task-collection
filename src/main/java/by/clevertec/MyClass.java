package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MyClass {

    public List<String> task3(List<Animal> animals) {

        List<String> list = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();

        return list;
    }

    public long task4(List<Animal> animals) {

        long numberOfFemale = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        return numberOfFemale;
    }

    public boolean task5(List<Animal> animals) {

        long hungarians = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .filter(animal -> animal.getOrigin().equals("Hungarian"))
                .count();

        return hungarians > 0;
    }

    public boolean task6(List<Animal> animals) {

        long numberOfMultiGenderAnimals = animals.stream()
                .filter(animal -> !Objects.equals(animal.getGender(), "Male") && !animal.getGender().equals("Female"))
                .count();

        return numberOfMultiGenderAnimals == 0;
    }

    public boolean task7(List<Animal> animals) {

        long numberOfAnimalsFromOceania = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Oceania"))
                .count();

        return numberOfAnimalsFromOceania == 0;
    }

    public Integer task8(List<Animal> animals) {

        Integer ageOfTheOldest = animals.stream()
                .sorted((Comparator.comparing(Animal::getBread)))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .getAsInt();

        return ageOfTheOldest;
    }

    public Integer task9(List<Animal> animals) {

        Integer minLengthOfBread = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(chars -> chars.length)
                .min()
                .getAsInt();

        return minLengthOfBread;
    }

    public int task10(List<Animal> animals) {

        int ageSum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        return ageSum;
    }

    public double task11(List<Animal> animals) {

        double averageAgeOfIndonesianAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .getAsDouble();

        return averageAgeOfIndonesianAnimals;
    }

    public List<Student> task16(List<Student> students) {

        List<Student> list = students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .toList();

        return list;
    }

    public List<String> task17(List<Student> students) {
        List<String> list = students.stream()
                .map(Student::getGroup)
                .distinct()
                .toList();

        return list;
    }

}
