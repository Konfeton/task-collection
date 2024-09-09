package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    private static final int ANIMALS_IN_ZOO = 7;

    public static void task1() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(2 * ANIMALS_IN_ZOO)
                .limit(ANIMALS_IN_ZOO)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equals("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                })
                .forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();

        long numberOfFemale = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        System.out.println(numberOfFemale);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();

        long hungarians = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .filter(animal -> animal.getOrigin().equals("Hungarian"))
                .count();

        System.out.println(hungarians > 0);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();

        long numberOfMultiGenderAnimals = animals.stream()
                .filter(animal -> !Objects.equals(animal.getGender(), "Male") && !animal.getGender().equals("Female"))
                .count();

        System.out.println(numberOfMultiGenderAnimals == 0);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();

        long numberOfAnimalsFromOceania = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Oceania"))
                .count();

        System.out.println(numberOfAnimalsFromOceania == 0);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();

        Integer ageOfTheOldest = animals.stream()
                .sorted((Comparator.comparing(Animal::getBread)))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .getAsInt();

        System.out.println(ageOfTheOldest);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();

        Integer minLengthOfBread = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(chars -> chars.length)
                .min()
                .getAsInt();

        System.out.println(minLengthOfBread);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();

        int ageSum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        System.out.println(ageSum);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();

        double averageAgeOfIndonesianAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .getAsDouble();

        System.out.println(averageAgeOfIndonesianAnimals);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();

        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> getAge(person.getDateOfBirth()) >= 18 && getAge(person.getDateOfBirth()) <= 27)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static int getAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public static void task13() {
        List<House> houses = Util.getHouses();

        Stream<Person> fromHospital = houses.stream()
                .filter(house -> house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream());

        Stream<Person> childrenAndElders = houses.stream()
                .filter(house -> !house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .filter(person -> getAge(person.getDateOfBirth()) < 18 || getAge(person.getDateOfBirth()) >= 64);

        Stream<Person> others = houses.stream()
                .filter(house -> !house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .filter(person -> getAge(person.getDateOfBirth()) >= 18 || getAge(person.getDateOfBirth()) < 64);


        Stream.concat(Stream.concat(fromHospital, childrenAndElders), others)
                .limit(500)
                .forEach(System.out::println);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();

        List<Car> firstCountry = cars.stream()
                .filter(car -> car.getCarModel().equals("Jaguar") || car.getColor().equals("White"))
                .toList();

        String[] carsToSecondCountry = {"BMW", "Lexus", "Chrysler", "Toyota"};

        List<Car> secondCountry = cars.stream()
                .filter(car -> !firstCountry.contains(car))
                .filter(car -> car.getMass() < 1500 && Arrays.asList(carsToSecondCountry).contains(car.getCarMake()))
                .toList();

        String[] carsToThirdCountry = {"GMC", "Dodge"};

        List<Car> thirdCountry = cars.stream()
                .filter(car -> !secondCountry.contains(car))
                .filter(car -> (car.getColor().equals("Black") && car.getMass() > 4000) || Arrays.asList(carsToThirdCountry).contains(car.getCarMake()))
                .toList();


        String[] carsToFourthCountry = {"Civic", "Cherokee"};

        List<Car> fourthCountry = cars.stream()
                .filter(car -> !thirdCountry.contains(car))
                .filter(car -> car.getReleaseYear() < 1982 || Arrays.asList(carsToFourthCountry).contains(car.getCarMake()))
                .toList();


        String[] forbiddenColors = {"Yellow", "Red", "Green", "Blue"};

        // 'Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон'
        // i made that nor of the cars with color YELLOW, RED, GREEN, BLUE goes to the selection
        // and in the requirements there is not with color or price > 40000 it leads to ~800 cars in the selection (833 to be exact)
        // with condition (.filter(car -> !Arrays.asList(forbiddenColors).contains(car.getColor()) || car.getPrice() > 40000))

        List<Car> fifthCountry = cars.stream()
                .filter(car -> !fourthCountry.contains(car))
                .filter(car -> !Arrays.asList(forbiddenColors).contains(car.getColor()))
                .filter(car -> car.getPrice() > 40000)
                .toList();


        List<Car> sixthCountry = cars.stream()
                .filter(car -> !fifthCountry.contains(car))
                .filter(car -> car.getVin().contains("59"))
                .toList();

        List<List<Car>> filteredCars = List.of(firstCountry, secondCountry, thirdCountry, fourthCountry, fifthCountry, sixthCountry);

        filteredCars.stream()
                .map(echelon -> echelon.stream()
                        .mapToInt(Car::getMass)
                        .sum()
                )
                .forEach(el -> System.out.println("expenses: " + el * 7.14));

        int revenue = filteredCars.stream()
                .mapToInt(echelon -> echelon.stream()
                        .mapToInt(Car::getPrice)
                        .sum())
                .sum();
        System.out.println("revenue = " + revenue);


    }

    private static final int DAYS_IN_YEAR = 365;
    private static final int YEARS = 5;
    private static final double WATER_PRICE_PER_CUBIC_METER = 1.39;
    private static final double LITERS_IN_CUBIC_METER = 1000;

    //I assumed that waterConsumption was in liters
    public static void task15() {
        List<Flower> flowers = Util.getFlowers();

        Set<String> vases = Set.of("Glass", "Aluminum", "Steel");

        double sum = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed())
                .sorted(Comparator.comparingDouble(Flower::getPrice))
                .sorted(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().startsWith("S") || flower.getCommonName().startsWith("C"))
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream().anyMatch(vases::contains))
                .peek(System.out::println)
                .mapToDouble(flower -> {
                    int price = flower.getPrice();
                    double liters = flower.getWaterConsumptionPerDay() * DAYS_IN_YEAR * YEARS;
                    double waterAmountInCubicMeters = liters / LITERS_IN_CUBIC_METER;
                    double waterPrice = waterAmountInCubicMeters * WATER_PRICE_PER_CUBIC_METER;
                    double result = price + waterPrice;
                    return result;
                })
                .sum();
        System.out.println("Total expenses for flowers: " + sum);

    }

    public static void task16() {
        List<Student> students = Util.getStudents();

        // there are no records in students.json with age < 18, so I made age<=18
        students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(System.out::println);
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet().stream()
                    .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.println("Faculty: " + e.getKey() + ", Average Age: " + e.getValue()));

    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Set<Integer> studentsId = examinations.stream()
                .filter(examination -> examination.getExam3() > 4)
                .map(Examination::getStudentId)
                .collect(Collectors.toSet());

        students.stream()
                .filter(student -> studentsId.contains(student.getId()))
                .forEach(System.out::println);
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();


        String faculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty))
                .entrySet().stream()
                .map(entry -> {

                    String facultyName = entry.getKey();

                    double averageScorePerFacultyForFirstExam = getAverageScorePerFacultyForFirstExam(entry, examinations);

                    return Map.entry(facultyName, averageScorePerFacultyForFirstExam);
                })
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .findFirst()
                .get()
                .getKey();

        System.out.println(faculty);
    }

    private static double getAverageScorePerFacultyForFirstExam(Map.Entry<String, List<Student>> entry, List<Examination> examinations) {
        List<Student> studentsByFaculty = entry.getValue();
        List<Integer> studentsId = studentsByFaculty.stream()
                .map(Student::getId)
                .toList();

        double averageScorePerFacultyForFirstExam = examinations.stream()
                .filter(ex -> studentsId.contains(ex.getStudentId()))
                .mapToInt(Examination::getExam1)
                .average()
                .getAsDouble();

        return averageScorePerFacultyForFirstExam;
    }

    public static void task21() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup))
                .forEach((key, value) -> System.out.println(key + ":" + value.size()));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty))
                .entrySet().stream()
                    .map(entry -> {
                        String facultyName = entry.getKey();
                        int minAge = entry.getValue().stream()
                                .mapToInt(Student::getAge)
                                .min()
                                .getAsInt();
                        return Map.entry(facultyName, minAge);
                    })
                    .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }
}
