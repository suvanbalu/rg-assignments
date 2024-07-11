interface Vehicle {
    // Abstract method
    void cleanVehicle();

    // Default method
    default void startEngine() {
        System.out.println("Engine started.");
    }

    // Static method
    static void getVehicleType() {
        System.out.println("Unknown Vehicle Type");
    }
}

class Car implements Vehicle {
    @Override
    public void cleanVehicle() {
        System.out.println("Cleaning the car.");
    }

    // Optionally override the default method
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}

public class InterfaceEnhancements {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.cleanVehicle();  // Calls the overridden method in Car class
        myCar.startEngine();   // Calls the overridden startEngine method

        Vehicle.getVehicleType(); // Calls the static method in Vehicle interface
    }
}
