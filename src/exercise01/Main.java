package exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = Double.parseDouble(sc.nextLine());
        double n2 = Double.parseDouble(sc.nextLine());
        double n3 = Double.parseDouble(sc.nextLine());
        Box box = new Box(n1, n2, n3);
        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume – %.2f%n", box.calculateVolume());
    }
}
