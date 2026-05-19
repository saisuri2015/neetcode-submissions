interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

interface VehicleFactory {
    public Vehicle createVehicle();
}

class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}

class TruckFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Truck();
    }
}
