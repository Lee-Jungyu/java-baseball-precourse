package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMaker {

    public ArrayList<Integer> getRandomNumberArray() {
        ArrayList<Integer> randomNumberArray = new ArrayList<>();

        while(randomNumberArray.size() != 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if(!randomNumberArray.contains(randomNumber)) {
                randomNumberArray.add(randomNumber);
            }
        }

        return randomNumberArray;
    }

    public ArrayList<Integer> getInputNumberArray(Scanner scanner) {
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = scanner.next();

        //입력 값이 정수형이 맞는지 체크
        for (char c : inputNumber.toCharArray()) {
            if(!Character.isDigit(c)) throw new IllegalArgumentException();
        }
        //세 자리 수가 맞는지 체크
        if(inputNumber.length() != 3) throw new IllegalArgumentException();
        //입력 값에 0이 있는지 체크
        if (inputNumber.contains("0")) throw new IllegalArgumentException();
        //자리에 있는 값이 모두 다른지 체크
        for(int i = 0; i < 2; i++) {
            if(inputNumber.substring(i + 1, 3).contains(inputNumber.substring(i, i + 1)))
                throw new IllegalArgumentException();
        }

        for(int i = 0; i < 3; i++) {
            inputNumberArray.add(Integer.valueOf(inputNumber.charAt(i)));
        }

        return inputNumberArray;
    }

    public int getStrike(ArrayList<Integer> randomNumberArray, ArrayList<Integer> inputNumberArray) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumberArray.get(i).equals(inputNumberArray.get(i))) strike++;
        }

        return strike;
    }

    public int getBall(ArrayList<Integer> randomNumberArray, ArrayList<Integer> inputNumberArray) {
        int ball = 0;

        for(int i = 0; i < 3; i++) {
            if(randomNumberArray.get(i) != inputNumberArray.get(i) && randomNumberArray.contains(inputNumberArray.get(i))) ball++;
        }

        return ball;
    }

    public void printHint(int ball, int strike) {
        if(ball == 0 && strike == 0) System.out.println("낫싱");
        else if(ball > 0 && strike == 0) System.out.println(ball + "볼");
        else if(ball == 0 && strike > 0) System.out.println(strike + "스트라이크");
        else System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
