package func;

import java.util.function.Function;
import java.util.function.BiFunction;

public class Func {

    public static void main(String[] args) {
        // 1. The functional interface
        Function<Integer, Integer> myTriple = MyMath::triple;
        Integer result = myTriple.apply(5);
        System.out.println(result);



        // 2. The functional interface
        Function<Integer, Integer> absoluteValue = (x) -> {
            if (x < 0) {
                return -x;
            } else {
                return x;
            }
        };
        // SHORT:   (x) -> x < 0 ? -x : x;
        System.out.println(absoluteValue.apply(-100));

        // 3. BiFunction (Built-in),  TriFunction (Self defined below), NoArgFunction (Self defined below)
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
            System.out.println(add.apply(32, 32));

        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
            System.out.println(addThree.apply(54, 3, 4));

        NoArgFunction<String> sayHello = () -> "Hello!";
            System.out.println(sayHello.apply());



        // 4. Functions as Data
        final Boolean IS_DEVELOPMENT = false;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        //System.out.println(dataLoader.loadPerson.apply());




        // 5. Passing Function as Arguments
        System.out.println(MeMath.combine2And3(MeMath::add));
        System.out.println(MeMath.combine2And3(MeMath::subtract));
        System.out.println(MeMath.combine2And3((x, y) -> 2 * x + 2 * y));




        // 6. Returning function
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello functional!";
        //NoArgFunction<String> greeter = createGreeter.apply();
        //System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
        Function<Integer, Integer> timesFour = MyMath.createMultiplier(4);
        System.out.println(timesTwo.apply(6));
        System.out.println(timesThree.apply(6));
        System.out.println(timesFour.apply(6));


        // 7. closure: can access local vars included in the function
        NoArgFunction<NoArgFunction<String>> createAGreeter = () -> {
            String name = "Shaun";
            return () -> "Hello, " + name;
        };
        //NoArgFunction<String> greeter = createAGreeter.apply();
        //System.out.println(greeter.apply());



        // 8. Higher Order Function
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsntZeroCheck =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: second argument is zero!");
                        return 0f;
                    }
                    return func.apply(x, y);
                };
        BiFunction<Float, Float, Float> divideSafe = secondArgIsntZeroCheck.apply(divide);
        System.out.println(divideSafe.apply(10f, 2f));

    }
}








// define NO arg functional interface
interface NoArgFunction<R> {
    R apply();
}

// define Tri Arg functional interface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}


// 4. used by DataLoader
class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}


// 4. used by DataLoader
class DataLoader {
    public final NoArgFunction<Person> loadPerson;

    public DataLoader(Boolean isDevelopment) {
        loadPerson = isDevelopment
                ? this::loadPersonFake
                : this::loadPersonReal;
    }

    private Person loadPersonReal() {
        System.out.println("Loading person...");
        return new Person("Real Person", 30);
    }

    private Person loadPersonFake() {
        System.out.println("Returning fake person object...");
        return new Person("Fake Person", 100);
    }
}

// 5. Passing Function as Arguments
class MeMath {
    public static Integer add(Integer x, Integer y) {
        return x + y;
    }

    public static Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    public static Integer combine2And3(BiFunction<Integer, Integer, Integer> combineFunc) {
        return combineFunc.apply(2, 3);
    }
}


class MyMath {
    // 1. functional
    public static Integer triple(Integer x) {
        return x * 3;
    }

    // 6. Returning function
    public static Integer timesTwo(Integer x) {
        return x * 2;
    }

    public static Integer timesThree(Integer x) {
        return x * 3;
    }

    public static Integer timesFour(Integer x) {
        return x * 4;
    }

    public static Function<Integer, Integer> createMultiplier(Integer y) {
        return (Integer x) -> x * y;
    }
}