import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //Store
        Person[] employees = new Person[100];
        int num;
        //Input
        System.out.println("How many employees?");
        num = scanner.nextInt();
       
        for(int i=0;i<num;i++){
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter name: ");
            String name = scanner.next();
            
        }
        //Output
        for(int i=0;i<num;i++){
            System.out.println(employees[i]);
        }



        
        
        
    }
}
