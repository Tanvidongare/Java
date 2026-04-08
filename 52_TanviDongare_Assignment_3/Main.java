class Shapes {
    String shapeType;
    double r, l, b, h;

    // Constructor overloading
    Shapes(double radius) {
        shapeType = "circle";
        r = radius;
    }

    Shapes(double length, double breadth) {
        shapeType = "rectangle";
        l = length;
        b = breadth;
    }

    Shapes(double base, double height, String type) {
        shapeType = type;
        b = base;
        h = height;
    }

    // Method overloading
    double area(double radius) {
        return 3.14 * radius * radius; // circle
    }

    double area(double length, double breadth) {
        return length * breadth; // rectangle
    }

    double area(double base, double height, boolean triangle) {
        return 0.5 * base * height; // triangle
    }

    // Common method based on object type
    double area() {
        if (shapeType.equals("circle")) {
            return area(r);
        } else if (shapeType.equals("rectangle")) {
            return area(l, b);
        } else if (shapeType.equals("triangle")) {
            return area(b, h, true);
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Shapes s1 = new Shapes(5); // circle
        Shapes s2 = new Shapes(4, 6); // rectangle
        Shapes s3 = new Shapes(8, 5, "triangle"); // triangle

        System.out.println("Area of Circle = " + s1.area());
        System.out.println("Area of Rectangle = " + s2.area());
        System.out.println("Area of Triangle = " + s3.area());
    }
}
