package static1;
// Java program explaining lang.Math class methods
// abs(), acos(), toRadians()


public class TestStatic
{
        public static void main(String[] args)
        {
                TestStatic ts = new TestStatic();
                System.out.println(ts.add (1, 2));

                System.out.println(TestStatic.add (1, 2));
        }

        public static int add (int a, int b) {
                return a + b;
        }
}
