import java.io.IOException;
import java.net.SocketOption;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) throws iskluchenie1 {
        String [] rime ={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
            System.out.println("Введите что вам надо посчитать, через пробел: ");
            Scanner a = new Scanner(System.in);
            String str1 = a.nextLine();
            String otvet = Main.calc(str1);
            System.out.println(otvet);
    }
}
