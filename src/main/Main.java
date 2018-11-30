package main;
import ui.*;

public class Main {
    public static final int SCREEN_WIDTH = 1288; //게임 창 크기 여기 메인에서 정함
    public static final int SCREEN_HEIGHT = 723;
    public static int changer = 0;  //UI 바꾸는 변수

    public static void main(String[] args) throws InterruptedException {
        //UI출력부
        while (true) {
            //UI체인저를 통해 UI전환
            switch (changer) {
                case 0:
                    new introUI();
                    changer = -1;
                    break;
                case 1:
                    new stage1UI();
                    changer = -1;
                    break;
                    /*
                case 2:
                    new shopUI();
                    changer = -1;
                    break;
                    */
                case 3:
                    new helpUI();
                    changer = -1;
                    break;
            }
            Thread.sleep(100);
        }
    }
}
