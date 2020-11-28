package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

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
}
