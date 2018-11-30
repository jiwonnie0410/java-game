package player;

import main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {
    private boolean playerMoveLeft;
    private boolean playerMoveRight;

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    // 키 눌렸을 때
    @Override
    public void keyPressed(KeyEvent e) {
        //keyCode에 특수키를 받아옴
        int keyCode = e.getKeyCode();
        Player player = new Player();
        /*
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                player.Move("right");
                break;
            case KeyEvent.VK_LEFT:
                player.Move("left");
                break;
            case KeyEvent.VK_UP:
                player.Move("up");
                break;
            case KeyEvent.VK_SPACE:
                player.Move("space");
                break;
        }
        */
    }



    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
