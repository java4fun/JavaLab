package lambda.methodreferencesexample;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Square s = new Square(4);

        /*
        Shapes shapes = (Square square) -> {
            return square.calculateArea();
        }
        */

        // rewrite the above into method reference
        Shapes shapes = Square::calculateArea;

        System.out.println("Area: " + shapes.getArea(s));

    }

}
