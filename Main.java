//do we need to automatically reduce
import java.util.*;
public class Main {
    public static void main(String[] args) {



    }

    public static Fraction findPi() {
        Fraction pi = new Fraction(355, 113);
        Fraction MILU = new Fraction( 355, 113 );

        final double EPSILON = Math.abs( Math.PI - MILU.toDouble() );


        while((Math.abs(Math.PI - pi.toDouble()) >= EPSILON)) {

            if (pi.toDouble() > Math.PI) {
                pi.setDenom(pi.getDenom()+1);
            } else if (pi.toDouble() < Math.PI) {
                pi.setNum(pi.getNum()+1);
            }
        }


        pi.reduce();
        return pi;
    }

    public static void Quiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck! \n");
        int wins = 0;
        int losses = 0;
        int total = 0;

        while (true) {


            Fraction first = new Fraction((int) (Math.random()*9) + 1, (int) (Math.random()*9) + 1);
            Fraction second = new Fraction((int) (Math.random()*9) + 1, (int) (Math.random()*9) + 1);

            int operatorNum = (int) (Math.random()*4) + 1;
            String operator;
            Fraction answer;
            if (operatorNum == 1) {
                operator = "+";
                answer = Fraction.add(first, second);
                answer.reduce();
            } else if (operatorNum == 2) {
                operator = "-";
                answer = Fraction.subtract(first, second);
                answer.reduce();
            } else if (operatorNum == 3) {
                operator = "*";
                answer = Fraction.multiply(first, second);
                answer.reduce();
            } else {
                operator = "/";
                answer = Fraction.divide(first, second);
                answer.reduce();
            }

            System.out.println(first + " " + operator + " " + second + " = " );

            String input = scanner.nextLine();

            if(input.equals("quit")) {
                break;
            }

            Fraction answerInput = new Fraction(input);

            if (answer.getNum() == answerInput.getNum() && answer.getDenom() == answerInput.getDenom()) {
                System.out.println("Correct!");
                wins++;
                total++;
            } else {
                System.out.println("Wrong, the answer was " + answer);
                losses++;
                total++;
            }






        }

        Fraction ratio = new Fraction(wins, total);
        System.out.println("Your win/loss ratio was " + ratio + ", for a score of " +  ((int)(ratio.toDouble() * 100 + 0.5)) + " percent!");


    }
}