package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 전진 기능
    public void moveForward() {
        if (pickNumberInRange(0,9) >= 4)
            position++;
    }

    public void printPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}