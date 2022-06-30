package vehicles;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(11); // 초기 버스 넘버 고유 값

        // 버스 상태 변경
        bus.startRunning();
        System.out.println(bus.getState()); // 초기화 후 운행상태
        bus.setGasAmount(5);
        bus.setState(BusState.차고지행); // 주유량이 10 미만일 시 경고 출력

        // 승객 탑승
        bus.getOn(5000); // 상태가 운행중이 아님
        bus.setCurrentPassengers(30);
        bus.getOn(5000); // 정원 초과
        bus.setCurrentPassengers(10);

        // 속도 변경
        bus.changeSpeed(30); // 주유량이 10 미만 시 경고 출력
        bus.setGasAmount(30); // 주유하기
        bus.changeSpeed(60); // 속도 변경
        System.out.println(bus.getCurrentSpeed()); // 속도 변경됨

        System.out.println("--------------------------");

        Taxi taxi = new Taxi(1234);

        // 운행 시작
        taxi.startRunning();
        taxi.setGasAmount(5);
        taxi.startRunning(); // 주유량 부족 체크

        // 승객 탑승
        taxi.getOn(5000);
        taxi.getOn(5000); // "운행 중" 상태라 탑승 불가능

        // 속도 변경
        taxi.changeSpeed(60);
        System.out.println(taxi.getCurrentSpeed()); // 60으로 변경

        // 요금결제 - (거리당 요금 추가)
        System.out.println(taxi.getBasicDistance()); // 기본 요금
        System.out.println(taxi.payTheMoney()); // 거리당 추가 요금까지 결제

    }
}
