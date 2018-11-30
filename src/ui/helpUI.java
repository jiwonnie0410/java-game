package ui;

import main.Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ui.Music;

public class helpUI extends JFrame{
    private Image screenImage;
    private Graphics screenGraphic;
    private Image helpBackground = new ImageIcon("image/bg_help.png").getImage();

    // 버튼
    private ImageIcon gobackButtonImage = new ImageIcon("image/button_goback.png");
    private ImageIcon gobackButtonOn = new ImageIcon("image/button_on_goback.png");
    private JButton gobackButton = new JButton(gobackButtonImage);

    public helpUI() {
        setUndecorated(true); //바 없애기
        setTitle("warboy_bear");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //Main에 있음
        setResizable(false); //한번 만들어진 게임창은 줄일수 없음
        setLocationRelativeTo((null)); //실행했을 때 컴퓨터 정중앙에 오도록
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);


        //게임설명
        gobackButton.setRolloverIcon(gobackButtonOn);
        gobackButton.setBounds(500, 580, 297, 106);
        gobackButton.setBorderPainted(false);
        gobackButton.setContentAreaFilled(false);
        gobackButton.setFocusPainted(false);
        gobackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Main.changer = 0;    //메인에서 새로운 UI띄움
            }
        });
        add(gobackButton);

        setVisible(true); //화면에 출력되도록 기본값이 false여서 반드시 해줘야함
    }

    public void paint(Graphics g) { //약속된 메소드, 스크린드로우 함수를 이용해서 그림그려줌
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //창크기만큼의 이미지르 만든다음 그것을 스크린 이미지에 넣어주겠다.
        screenGraphic = screenImage.getGraphics(); //그래픽 개체를 얻어온다.
        screenDraw(screenGraphic); //스크린 그래픽에 그림을 그려줌
        g.drawImage(screenImage, 0, 0, null); //0,0 위치에 그려준다.
    }

    private void screenDraw(Graphics g) {
        g.drawImage(helpBackground, 0, 0, null);

        //항상 있고, 고정적인 메뉴바나 버튼은 컴포넌트로 구현
        paintComponents(g); //JLabel, JButton 등을 JFrame위에 그려줌
        //this.repaint(); //paint 메소드 다시 부름
    }
}
