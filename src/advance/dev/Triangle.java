package advance.dev;

// Lớp Triangle kế thừa từ lớp Shape
public class Triangle extends Shape {
    private double a, b, c; // Độ dài 3 cạnh của tam giác

    // Constructor của lớp Triangle
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Phương thức tính chu vi của tam giác
    @Override
    public double chuVi() {
        return a + b + c;
    }

    // Phương thức tính diện tích của tam giác
    @Override
    public double dienTich() {
        // Sử dụng công thức Heron để tính diện tích của tam giác
        double p = chuVi() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
