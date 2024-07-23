package wayfair.lld;

public class ParkingLotLLD {
}

/*Start Typing here

- Signatures only
-

enums


enum ParkingSpot{
    small, medium, large
}

enum PaymentStatus{
    unpaid,
    paid,
    pending
}

enum ParkingSpotStatus{
    available,
    unavailable
}

abstract User{
    String id
    String name;
}

class ParkingAgent extends User{
    bookParkingSpot();
}

class Admin extends User{

    addParkingSpot();
}

class DisplayBoard{
    parkingSpot.getListOfEmptySlots
}

abstract class ParkingStrategy{

}

class NearToEntranceParkingStrategy{

}

class NearToExitParkingStrategy{

}

abstract class ParkingFeeCalculator{
    abstract calculateFee();
}

class HourlyParkingFeeCalculator{
    calculateFee(){

    }
}

class DailyParkingFeeCalculator{
    calculateFee(){

    }
}



abstract class Gate{
    int id;
    DisplayBoard board;
}


class EntryGate extends Gate{
    checkIfAvailable();

    generateTicket();
}

class ExitGate extends Gate{
    calculateParkingFee(ParkingFeeCalculator parkingFeeCalculator);
}

class AutomatedLift{
    allocateAndDispatch(Vehicle vehicle, ParkingStrategy parkingStrategy);
}

class Booking{
    int id;
    DateTime startTime;
    VehicleType vehicleType;
    ParkingSpot parkingSpot;
    PaymentStatus paymentStatus;
}

class AllocationService{
    Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;

    ParkingSpot = allocate(VehicleType vehicleType);
}

//AutomatedLift
class DispatchService{
    AllocationService allocationService;

    parkingSpot = allocationService.allocate(vehicleType);

    dispatch(Vehicle vehicle, ParkingSpot parkingSpot);
}*/




