
package io.scannerexample;

import java.util.Scanner;

public class PersonCreator {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name, age and phone number: ");
        String name = scanner.next();
        int age = scanner.nextInt();
        Long phoneNumber = scanner.nextLong();
        Person person = new Person(name, age, phoneNumber);

        
    }
    
}
