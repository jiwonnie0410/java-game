package ui;

import main.Main;
import player.*;

import java.awt.*;
import javax.swing.*;


public class stage1UI extends JFrame {

    JPanel scorePanal = new JPanel();
    JPanel seaPanal;
    Player  player = new Player();

    ImageIcon BG = new ImageIcon("image/6.png");

    public stage1UI() throws InterruptedException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); //바 없애기
        setResizable(false);

        Container c = getContentPane();
        player.setFocusable(true);
        c.addKeyListener(player);
        //c.addKeyListener(new Player());

        //배경이미지 삽입
        seaPanal = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(BG.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        //sea패널 설정
        seaPanal.setLayout(null);
        JLabel userdraw = new JLabel();    //user이미지
        userdraw.setBounds(50, 450, 200, 200);

        seaPanal.add(userdraw);
        c.add(seaPanal);

        c.setFocusable(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);


        //음악 시작
        Music introMusic = new Music("music/bgm.wav", true); //화면 시작할 때 무한정 노래 재생
        introMusic.run();

        //UI표시부 반복
        while (true) {

            this.getGraphics().clearRect(0,0,getWidth(),getHeight());
            this.getGraphics().drawImage(BG.getImage(), 0, 0, null);
            //userdraw.setIcon(Player.getUserImg());    //유저표현
            //player.paint(this.getGraphics());
            Thread.sleep(20);
        }
    }
}
