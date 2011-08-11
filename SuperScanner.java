import java.util.Scanner;
import java.io.InputStream;

public class SuperScanner {
    private Scanner input;
    
    public SuperScanner(InputStream source) {
        input = new Scanner(source);
    }
    
    public int nextInt() {
        if (input.hasNextInt()) {
            int x = input.nextInt();
            input.nextLine();
            return x;
        }
        input.nextLine();
        System.out.println("Error: Invalid integer.");
        System.out.print("Try again: ");
        return nextInt();
    }
    
    public boolean confirm() {
        String ans = input.nextLine();
        if (ans.charAt(0)=='Y' || ans.charAt(0)=='y')
            return true;
        else if (ans.charAt(0)=='N' || ans.charAt(0)=='n')
            return false;
        System.out.println("Error: Invalid response.");
        System.out.print("Try again: ");
        return confirm();
    }
    
    public String nextLine() {
        return input.nextLine();
    }
    
    public static void main(String[] args) {
        SuperScanner input = new SuperScanner(System.in);
        System.out.print("Does this work? ");
        if (input.confirm())
            System.out.println("YES!");
        else
            System.out.println("NO!");
    }
}