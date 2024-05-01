package day1_calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator(br);
        calculator.run();
    }
}
