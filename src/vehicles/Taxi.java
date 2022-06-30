package vehicles;

public class Taxi implements Vehicle {

    private int TaxiNumber = 0;
    private int gasAmount = 0;
    private int currentSpeed = 0;
    private String destination = "";
    private int basicDistance = 3000;
    private int distanceToDestination = 0;
    private int basicPayment = 3200;
    private int payPerDistance = 300;
    private TaxiState state;

    public Taxi(int taxiNumber) {
        TaxiNumber = taxiNumber;
        gasAmount = 30;
        state = TaxiState.일반;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getBasicDistance() {
        return basicDistance;
    }

    public void setBasicDistance(int basicDistance) {
        this.basicDistance = basicDistance;
    }

    public int getDistanceToDestination() {
        return distanceToDestination;
    }

    public void setDistanceToDestination(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
    }

    public int getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(int basicPayment) {
        this.basicPayment = basicPayment;
    }

//    public int getPayPerDistance() {
//        return payPerDistance;
//    }
//
//    public void setPayPerDistance(int payPerDistance) {
//        this.payPerDistance = payPerDistance;
//    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void getOn(int distanceToDestination) {
        if (state != TaxiState.일반) System.out.println("운행 중인 택시라 탑승이 불가합니다.");
        else {
            this.distanceToDestination = distanceToDestination;
            state = TaxiState.운행중;
            System.out.println("택시에 탑승합니다.");
        }
    }

    @Override
    public void changeSpeed(int speed) {
        currentSpeed = speed;
    }

    @Override
    public void startRunning() {
        if (gasAmount < 10) System.out.println("주유량이 부족하여 운행이 불가합니다.");
        else {
            System.out.println("출발합니다.");
        }
    }

    public int payTheMoney() {
        return ((distanceToDestination - basicDistance) / 100 * payPerDistance) + basicPayment;
    }
}
