class Hillstations {
    void famousfood() {
        System.out.println("Hillstation famous food");
    }

    void famousfor() {
        System.out.println("Hillstation is famous for");
    }
}

class Mahabaleshwar extends Hillstations {
    void famousfood() {
        System.out.println("Mahabaleshwar famous food: Strawberry with cream");
    }

    void famousfor() {
        System.out.println("Mahabaleshwar is famous for: Points, valleys and strawberries");
    }
}

class Manali extends Hillstations {
    void famousfood() {
        System.out.println("Manali famous food: Siddu");
    }

    void famousfor() {
        System.out.println("Manali is famous for: Snow, adventure sports and mountains");
    }
}

class Ooty extends Hillstations {
    void famousfood() {
        System.out.println("Ooty famous food: Homemade chocolates");
    }

    void famousfor() {
        System.out.println("Ooty is famous for: Tea gardens and cool climate");
    }
}

public class Hillstation {
    public static void main(String[] args) {
        Hillstations h;

        h = new Mahabaleshwar();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Manali();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Ooty();
        h.famousfood();
        h.famousfor();
    }
}