package stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        // 1. Map (Function)
        Function<Integer, Integer> timesTwo = (x) -> x * 2;
        List<Integer> doubled = listOfIntegers
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());
        System.out.println(doubled);


        // 2. Filter (Predicate)
        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = listOfIntegers
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evens);

        String[] wordsArr = { "hello", "functional", "programming", "is", "cool" };
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan3 = createLengthTest.apply(3);
        Predicate<String> isLongerThan10 = createLengthTest.apply(10);

        List<String> longWords = words
                .stream()
                .filter(isLongerThan10)
                .collect(Collectors.toList());

        System.out.println(longWords);



        // 3. Reduce:
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };
        Integer sum = listOfIntegers
                .stream()
                .reduce(0, getSum);
        System.out.println(sum);



        // 4. Collect:
        String[] wordsArray = {"hello", "apple", "functional", "programming", "is", "cool"};
        List<String> words2 = new ArrayList<>(Arrays.asList(wordsArray));


        Set<String> wordsSet = words2
                .stream()
                .filter((w) -> w.length() > 5)
                .collect(Collectors.toSet());
        System.out.println(wordsSet);


        String longWords2 = words2
                .stream()
                .filter((w) -> w.length() > 5)
                .collect(Collectors.joining(", "));
        System.out.println(longWords2);



        Long howManyWords = words2
                .stream()
                .filter((w) -> w.length() > 5)
                .collect(Collectors.counting());
        System.out.println(howManyWords);



        // multiple
        Map<Integer, List<String>> wordLengthMap = words2
                .stream()
                .filter((w) -> w.length() > 5)
                .collect(Collectors.groupingBy(
                        (w) -> w.length()
                ));
        System.out.println(wordLengthMap);




        // Partition to 2 (Predicate: true, false)
        Map<Boolean, List<String>> wordLengthMap2 = words2
                .stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 5
                ));
        System.out.println(wordLengthMap2);





        // 5. Combine List Functions
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
        Float totalDeveloperSalaries = employees
                .stream()
                .filter((employee) -> employee.jobTitle == "developer")
                .map((developer) -> developer.salary)
                .reduce(0f, (acc, x) -> acc + x);

        Long numberOfDevelopers = employees
                .stream()
                .filter((employee) -> employee.jobTitle == "developer")
                .collect(Collectors.counting());

        Float averageDeveloperSalary = totalDeveloperSalaries / numberOfDevelopers;
        System.out.println(averageDeveloperSalary);





        // 6. Parallel Streams:
        List<String> processedWords = words
                .parallelStream()
                .map((word) -> {
                    System.out.println("Uppercasing " + word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.println("Adding exclamation point to " + word);
                    return word + "!";
                })
                .collect(Collectors.toList());
        System.out.println(processedWords);

    }




    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }
}



