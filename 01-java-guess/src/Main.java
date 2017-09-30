import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj zakres liczb do wylosowania. ");
        System.out.print("PIerwsza liczba: ");
        int boundFrom = Integer.parseInt(scanner.next());

        System.out.print("Druga liczba: ");
        int boundTo = Integer.parseInt(scanner.next());


        Random random = new Random();
        int number = random.nextInt(boundTo-boundFrom) + boundFrom;
        int answer;
        int i=0;
        System.out.print("Zgadnij jaka to liczba masz 3 próby: ");

        do {

            answer = Integer.parseInt(scanner.next());
            if(number==answer) {
                System.out.println("Brawo zgadłeś, poprawna liczba to "+number);
                break;
            }
            else if(i<2) {
                System.out.println("Niestety nie zgadłes, spróbuj jeszcze raz: ");
            }
            i++;
        } while(i<3);
        if(number!=answer)
            System.out.println("Niestety nie zgadłes, poprawna liczba to: "+number);


    }

}