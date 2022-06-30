package vehicles;

import javax.print.attribute.standard.Destination;

public class Bus implements Vehicle {
    private int currentPassengers = 0;
    private int maxPassengers = 0;
    private final int PAYMENT = 30;
    private int busNumber = 0;
    private int gasAmount = 0;
    private int currentSpeed = 0;
    private BusState state;
    private int destination = 10000;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
        this.state = BusState.운행중;
        this.gasAmount = 30;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }


    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void setCurrentPassengers(int currentPassengers) {
        this.currentPassengers = currentPassengers;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }


    public String getState() {
        return String.valueOf(state);
    }

    public void setState(BusState state) {
        if (gasAmount == 0) this.state = BusState.차고지행;
        else if (gasAmount < 10) System.out.println("주유량이 10 미만입니다. 주유가 필요합니다.");
        else this.state = state;
    }

    @Override
    public void changeSpeed(int speed) {
        if (gasAmount < 10) System.out.println("주유량을 확인해주세요.");
        else this.currentSpeed = speed;
    }

    @Override
    public void startRunning() {
        System.out.println("버스 운행을 시작합니다.");
        gasAmount -= 1;
    }

    @Override
    public void getOn(int distanceToDestination) {
        if (state == BusState.운행중 && currentPassengers < maxPassengers) {
            destination -= distanceToDestination;
            System.out.println("버스에 탑승");
            currentPassengers++;
        } else System.out.println("운행중인 상태가 아니거나 정원을 초과했습니다.");
    }

}
