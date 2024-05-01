package day1_nbCalculator;

public class CircleCalculator extends Calculator {
    private double radius;

    public CircleCalculator(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 연산 메서드
    @Override
    public double calculate() {
        double result = radius * radius * Math.PI;
        addArr(result);
        return result;

    }
}
