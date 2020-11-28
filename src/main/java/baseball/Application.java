package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int game = 1;
        do {
            GameMaker gameMaker = new GameMaker();
            gameMaker.startGame(scanner);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = scanner.nextInt();
        } while(game == 1);
    }
}
