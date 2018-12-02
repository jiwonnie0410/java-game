package ui;

import main.Main;
import player.*;
import java.awt.*;
import javax.swing.*;

public class stage1UI extends JFrame {

    JPanel scorePanal = new JPanel();
    JPanel desertPanal;
    Player  player = new Player(this.getGraphics(), this);

    ImageIcon BG = new ImageIcon("image/6.png");

    public stage1UI() throws InterruptedException {

        //음악 시작
        Music gameMusic = new Music("music/game_music.wav", true); //화면 시작할 때 무한정 노래 재생
        gameMusic.run();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); //바 없애기
        setResizable(false);
        //setBounds(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
        //setUndecorated(true);

        //setBackground(new Color(1.0f,1.0f,1.0f,0f));
        Container c = getContentPane();
        player.setFocusable(true);
        c.addKeyListener(player);

        //배경이미지 삽입
        desertPanal = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(BG.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        c.add(desertPanal);

        c.setFocusable(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);


        //UI표시부 반복
        while (true) {
            //this.getGraphics().clearRect(0,0,getWidth(),getHeight());
            //this.getGraphics().drawImage(BG.getImage(), 0, 0, null);
            //userdraw.setIcon(player.paint(this.getGraphics()));    //유저표현
            //player.run();
            this.getGraphics().drawImage(BG.getImage(), 0, 0, null);
            player.paint(this.getGraphics());
            Thread.sleep(20);
        }
    }

    public void upateGraphics (){
        this.getGraphics().drawImage(BG.getImage(), 0, 0, null);
        player.paint(this.getGraphics());
    }

}
