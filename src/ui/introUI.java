package ui;

import main.Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class introUI extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon("image/back.png").getImage();

    //메뉴버튼
    private ImageIcon startButtonImage = new ImageIcon("image/button_start.png");
    private ImageIcon helpButtonImage = new ImageIcon("image/button_help.png");
    private ImageIcon exitButtonImage = new ImageIcon("image/button_exit.png");

    private ImageIcon startButtonImageOn = new ImageIcon("image/button_on_start.png");
    private ImageIcon helpButtonImageOn = new ImageIcon("image/button_on_help.png");
    private ImageIcon exitButtonImageOn = new ImageIcon("image/button_on_exit.png");

    private JButton startButton = new JButton(startButtonImage);
    private JButton helpButton = new JButton(helpButtonImage);
    private JButton exitButton = new JButton(exitButtonImage);

    public introUI() {
        //BGM재생부
        Music introMusic = new Music("music/background_music.wav", true); //화면시작할때 무한정 노래 재생
        Music buttonClick = new Music("music/click.wav", false); //버튼 누를 때 효과음 한번만 재생
        introMusic.run();

        setUndecorated(true); //바 없애기
        setTitle("warboy_bear");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //Main에 있음
        setResizable(false); //한번 만들어진 게임창은 줄일수 없음
        setLocationRelativeTo((null)); //실행했을 때 컴퓨터 정중앙에 오도록
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);



        //게임시작
        startButton.setRolloverIcon(startButtonImageOn);
        startButton.setBounds(500, 350, 297, 106);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                introMusic.close();
                buttonClick.run();

                dispose();  //현재창 종료
                Main.changer = 1;    //메인에서 새로운 UI띄움
            }
        });

        //게임설명
        helpButton.setRolloverIcon(helpButtonImageOn);
        helpButton.setBounds(500, 450, 297, 106);
        helpButton.setBorderPainted(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setFocusPainted(false);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonClick.run();
                Main.changer = 3;    //메인에서 새로운 UI띄움
            }
        });

        //게임종료
        exitButton.setRolloverIcon(exitButtonImageOn);
        exitButton.setBounds(500, 550, 297, 106);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonClick.run();
                System.exit(0);
            }
        });

        add(startButton);
        add(helpButton);
        add(exitButton);

        setVisible(true); //화면에 출력되도록 기본값이 false여서 반드시 해줘야함
    }

    public void paint(Graphics g) { //약속된 메소드, 스크린드로우 함수를 이용해서 그림그려줌
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //창크기만큼의 이미지르 만든다음 그것을 스크린 이미지에 넣어주겠다.
        screenGraphic = screenImage.getGraphics(); //그래픽 개체를 얻어온다.
        screenDraw(screenGraphic); //스크린 그래픽에 그림을 그려줌
        g.drawImage(screenImage, 0, 0, null); //0,0 위치에 그려준다.
    }

    private void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);

        //항상 있고, 고정적인 메뉴바나 버튼은 컴포넌트로 구현
        paintComponents(g); //JLabel, JButton 등을 JFrame위에 그려줌
        //this.repaint(); //paint 메소드 다시 부름
    }
}
