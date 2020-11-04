package static1;
// Java program explaining lang.Math class methods
// abs(), acos(), toRadians()


public class TestMath
{
        public static void main(String[] args)
        {
                // Declaring the variables
                int Vali = -1;
                float Valf = .5f;

                // Printing the values
                System.out.println("Initial value of int : "+Vali);
                System.out.println("Initial value of int : "+Valf);


                // Use of .abs() method to get the absoluteValue
                int Absi = Math.abs(Vali);
                float Absf = Math.abs(Valf);

                System.out.println("Absolute value of int : "+Absi);
                System.out.println("Absolute value of int : "+Absf);
                System.out.println("");

                // Use of acos() method
                // Value greater than 1, so passing NaN
                double Acosi = Math.acos(60);
                System.out.println("acos value of Acosi : "+Acosi);
                double x = Math.PI;

                // Use of toRadian() method
                x = Math.toRadians(x);
                double Acosj = Math.acos(x);
                System.out.println("acos value of Acosj : "+Acosj);

        }
}
