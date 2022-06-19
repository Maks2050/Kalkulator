import java.io.IOException;
import java.net.SocketOption;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) throws iskluchenie1 {
        try {
            int chislo1=0;
            int chislo2=0;
            int romeNumb=0;
            Scanner a = new Scanner(System.in);
            System.out.println("Введите что вам надо посчитать, через пробел: ");
            String str1 = a.nextLine();
            String [] strings = str1.split(" ");
            if (strings.length>3){
                throw new IOException();
            }
            String [] arab ={"1","2","3","4","5","6","7","8","9","10"};
            String [] rime ={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
            try {
                chislo1 = Integer.valueOf(strings[0]);
                chislo2 = Integer.valueOf(strings[2]);
            }
            catch (Exception e){

                for (int i=0;i< rime.length;i++){
                    if (strings[0].equals(rime[i])){
                        chislo1 = Integer.valueOf(arab[i]);
                        romeNumb+=1;
                    }
                    if (strings[2].equals(rime[i])){
                        chislo2 = Integer.valueOf(arab[i]);
                        romeNumb+=1;
                    }
                }
            }
            if (romeNumb==1)
                throw new iskluchenie1("Введите либо два арабских, либо два римских числа");
            if (chislo1>10 || chislo1<1 || chislo2>10 || chislo2<1){
                throw new iskluchenie1("Введите числа от 1 до 10");
            }
            String plus = "+";
            String minus = "-";
            String umnojit = "*";
            String razdelit = "/";
            String[] operacii = {plus,minus,umnojit,razdelit};
            int vern = 0;
            for (int i=0;i< operacii.length;i++)
            {
                if(strings[1].equals(operacii[i])){
                    vern = 1;
                }
            }
            if (vern == 0) {
                throw new iskluchenie1("Введите одну из следующих операций: +; -; *; /");
            }
            if (!(romeNumb==2)){
                if (plus.equals(strings[1])){
                    System.out.println(chislo1 + chislo2);
                } else if (minus.equals(strings[1])){
                    System.out.println(chislo1 - chislo2);
                } else if (umnojit.equals(strings[1])){
                    System.out.println(chislo1 * chislo2);
                } else if (razdelit.equals(strings[1])){
                    System.out.println(chislo1 / chislo2);
                }
            }
           if (romeNumb==2){
               if (plus.equals(strings[1])){
                 romeNumb = chislo1 + chislo2;
               } else if (minus.equals(strings[1])){
                   romeNumb = chislo1 - chislo2;
               } else if (umnojit.equals(strings[1])){
                   romeNumb = chislo1 * chislo2;
               } else if (razdelit.equals(strings[1])){
                   romeNumb = chislo1 / chislo2;
               }
               if (romeNumb<=0){
                   throw new iskluchenie1("Римские числа могут быть только положительные");
               }
               if (romeNumb>1)
               {
                   String s = "";
                   while (romeNumb >= 100) {
                       s += "C";
                       romeNumb -= 100;
                   }
                   while (romeNumb >= 90) {
                       s += "XC";
                       romeNumb -= 90;
                   }
                   while (romeNumb >= 50) {
                       s += "L";
                       romeNumb -= 50;
                   }
                   while (romeNumb >= 40) {
                       s += "XL";
                       romeNumb -= 40;
                   }
                   while (romeNumb >= 10) {
                       s += "X";
                       romeNumb -= 10;
                   }
                   while (romeNumb >= 9) {
                       s += "IX";
                       romeNumb -= 9;
                   }
                   while (romeNumb >= 5) {
                       s += "V";
                       romeNumb -= 5;
                   }
                   while (romeNumb >= 4) {
                       s += "IV";
                       romeNumb -= 4;
                   }
                   while (romeNumb >= 1) {
                       s += "I";
                       romeNumb -= 1;
                   }
                   System.out.println(s);
               }
           }
            a.close();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Введите пример в одну строку");
        }
        catch (NumberFormatException e){
            System.out.println("Введите целые числа");
        }
        catch (IOException e) {
            System.out.println("Введите не больше двух чисел в примере");
        }
    }
}
