package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;



public class Game {

    private static List<Car> carList = new ArrayList<>();
    public int tryInput;
    private final static int MaxNameLength = 5;

    public Game() {
        // 생성자 명시적으로 써주기
    }

    public void init() {

        // 차 입력받기
        setting();

        // 시도 횟수 입력받기
        String input;
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            input = readLine();
            if (checkTryInput(input))
                break;
        }
        tryInput = Integer.parseInt(input);
    }

    private boolean checkTryInput(String input) {
        try {
            if (!input.matches("\\d+"))
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void progress() {
        System.out.println("\n실행 결과");
        for (int i = 0; i<tryInput; i++) {
            for (Car car : carList) {
                car.moveForward();
            }
            resultView();
        }
        printWinner();
    }

    private void printWinner() {
        System.out.print("최종 우승자 : ");
        List<String> winner = getWinner();
        for (String s : winner) {
            System.out.print(s);
        }
    }

    private List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int max = -1;
        for (Car car : carList) {
            if (car.getPosition() > max) {
                winner.clear();
                winner.add(car.getName());
                max = car.getPosition();
            } else if (car.getPosition() == max)
                winner.add(car.getName());
        }
        return winner;
    }

    // 게임 결과 출력
    public void resultView() {
        for (Car car : carList) {
            car.printPosition();
        }
        System.out.println();
    }

    // Car 세팅
    private static void setting() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");


        // ','를 기준으로 입력받는 함수
        while (true) {
            String[] userInput = readLine().split(",");

            // 각각 5자 이하인지 체크
            for (String s : userInput) {
                if (!checkCount(s))
                    continue;
            }
            // Car 배열에 이름 넣기
            for (int i = 0; i < userInput.length; i++) {
                carList.add(new Car(userInput[i]));
            }
            break;
        }
    }

    private static boolean checkCount(String s) {
        try {
            if (s.length() > MaxNameLength)
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}