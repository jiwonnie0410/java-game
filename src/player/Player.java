package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Player extends JFrame implements KeyListener {
    int x = 100, y = 100, sel = 1;
    Image image;
    private static ImageIcon playerImage = new ImageIcon("image/bear.png");


    //유저이미지 리턴
    public static ImageIcon getUserImg() {
        return playerImage;
    }

    public Player() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/bear.png"));
        image = Toolkit.getDefaultToolkit().getImage("image/bear.png");

        setLayout(null);
        setBackground(Color.PINK);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("heya");
        int key = e.getKeyCode();
        if(key == e.VK_RIGHT ||
                key == e.VK_NUMPAD6 || //숫자키 NUMPAD
                key == e.VK_KP_RIGHT) {
            sel = (sel == 1)?2:1;  //삼항연산자
            x = (x < getWidth())?x + 10 : -image.getWidth(this);
        }
        else{int key1 = e.getKeyCode();
            if(key1 == e.VK_LEFT ||
                    key1 == e.VK_NUMPAD4 || //숫자키 NUMPAD
                    key1 == e.VK_KP_LEFT) {
                sel = (sel == 1)?3:1;  //삼항연산자
                x = (x > 0)?x - 10 :getWidth() + image.getWidth(this);
            }
            int key2 = e.getKeyCode();
            if(key2 == e.VK_UP ||
                    key2 == e.VK_NUMPAD8 || //숫자키 NUMPAD
                    key2 == e.VK_KP_UP) {
                sel = (sel == 1)?4:1;  //삼항연산자
                y = (y > 0)?y - 10 : getHeight() + image.getHeight(this);

            }
            int key3 = e.getKeyCode();
            if(key3 == e.VK_DOWN ||
                    key3 == e.VK_NUMPAD2 || //숫자키 NUMPAD
                    key3 == e.VK_KP_DOWN) {
                sel = (sel == 1)?4:1;  //삼항연산자
                y = (y < getHeight())?y + 10 : image.getWidth(this);
            }
        }
        System.out.println("ici");
        repaint(); //한번 실행하면 다시 원래 이미지로 복귀
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("coucou");
        switch (sel) {
            case 1:
                image = Toolkit.getDefaultToolkit().getImage("image/bear.png");
                break;
            case 2:
                image = Toolkit.getDefaultToolkit().getImage("image/bear.png");
                break;

            case 3:
                image = Toolkit.getDefaultToolkit().getImage("image/bear.png");
                break;

            case 4:
                image = Toolkit.getDefaultToolkit().getImage("image/bear.png");
                break;
        }

        //g.clearRect(0, 0, getWidth(), getHeight());  //화면의 잔상 클리어
        g.drawImage(image,
                x - image.getWidth(this) / 2,
                y - image.getHeight(this) / 2, this);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
