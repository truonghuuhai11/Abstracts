package advance.dev;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10]; // Khai báo mảng 10 phần tử Shape

        input(shapes); // Nhập giá trị cho mảng shapes gồm 3 hình tròn, 3 hình chữ nhật, 4 tam giác
        print(shapes); // In ra các hình đã nhập
        findMaxAreaShape(shapes); // Tìm hình có diện tích lớn nhất
        findMaxAreaForEachType(shapes); // Tìm diện tích lớn nhất của mỗi loại hình
    }

    // Phương thức nhập giá trị cho mảng shapes
    public static void input(Shape[] shapes) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            if (i < 3) {
                System.out.println("Nhập thông tin cho hình tròn thứ " + (i + 1) + ":");
                System.out.print("Nhập bán kính: ");
                double r = scanner.nextDouble();
                scanner.nextLine();
                shapes[i] = new Circle(r);
            } else if (i < 6) {
                System.out.println("Nhập thông tin cho hình chữ nhật thứ " + (i - 2) + ":");
                System.out.print("Nhập độ dài cạnh a: ");
                double a = scanner.nextDouble();
                System.out.print("Nhập độ dài cạnh b: ");
                double b = scanner.nextDouble();
                scanner.nextLine();
                shapes[i] = new Rectangle(a, b);
            } else {
                System.out.println("Nhập thông tin cho tam giác thứ " + (i - 5) + ":");
                System.out.print("Nhập độ dài cạnh a: ");
                double a = scanner.nextDouble();
                System.out.print("Nhập độ dài cạnh b: ");
                double b = scanner.nextDouble();
                System.out.print("Nhập độ dài cạnh c: ");
                double c = scanner.nextDouble();
                scanner.nextLine();
                shapes[i] = new Triangle(a, b, c);
            }
        }
    }

    // Phương thức in ra các hình đã nhập
    public static void print(Shape[] shapes) {
        System.out.println("Các hình đã nhập:");
        for (Shape shape : shapes) {
            System.out.println("Diện tích: " + shape.dienTich());
            System.out.println("Chu vi: " + shape.chuVi());
            System.out.println("------------------------");
        }
    }

    // Phương thức tìm hình có diện tích lớn nhất
    public static void findMaxAreaShape(Shape[] shapes) {
        double maxArea = 0;
        Shape maxAreaShape = null;

        for (Shape shape : shapes) {
            if (shape.dienTich() > maxArea) {
                maxArea = shape.dienTich();
                maxAreaShape = shape;
            }
        }

        System.out.println("Hình có diện tích lớn nhất:");
        System.out.println("Diện tích: " + maxAreaShape.dienTich());
        System.out.println("Chu vi: " + maxAreaShape.chuVi());
        System.out.println("------------------------");
    }

    // Phương thức tìm diện tích lớn nhất của mỗi loại hình
    public static void findMaxAreaForEachType(Shape[] shapes) {
        double maxCircleArea = 0;
        double maxRectangleArea = 0;
        double maxTriangleArea = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                if (shape.dienTich() > maxCircleArea) {
                    maxCircleArea = shape.dienTich();
                }
            } else if (shape instanceof Rectangle) {
                if (shape.dienTich() > maxRectangleArea) {
                    maxRectangleArea = shape.dienTich();
                }
            } else if (shape instanceof Triangle) {
                if (shape.dienTich() > maxTriangleArea) {
                    maxTriangleArea = shape.dienTich();
                }
            }
        }

        System.out.println("Diện tích lớn nhất của mỗi loại hình:");
        System.out.println("Diện tích lớn nhất của hình tròn: " + maxCircleArea);
        System.out.println("Diện tích lớn nhất của hình chữ nhật: " + maxRectangleArea);
        System.out.println("Diện tích lớn nhất của tam giác: " + maxTriangleArea);
    }
}
