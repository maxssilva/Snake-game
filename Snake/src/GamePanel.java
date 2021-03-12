
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 500;
    static final int UNIT_SIZE = 25; // dimensão da unidade de jogo
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE; //quantidade de quadros
    static final int DELAY = 55; //velocidade inicial do game
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6; //tamanho inicial da cobrinha
    int applesEaten; //quantidade de maçãs comidas
    int appleX;
    int appleY;
    char direction =  '6';//direção de início de movimento da cobra
    boolean running =  false;
    Timer timer;
    Random random;    
    
    GamePanel(){
        random =  new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    
    }
    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        
    }
    public void draw(Graphics g){
        
        if(running){
            /*
                //linhas de grade
              for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
               g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); //colore a bordas da coluna da tabela
               g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE); //colore as bordas da linha da tabela
            }           */
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i<bodyParts;i++){
                if(i == 0){
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else{
                    //cor do corpo da serpente em cinza(cyan)
                    //g.setColor(Color.cyan);
                    //cores aleatórias no corpo da serpente
                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.CENTER_BASELINE,40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Pontuação: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Pontuação: " + applesEaten))/2, g.getFont().getSize());  
        
        }
        else{
           gameOver(g); 
        }
    }
    public void newApple(){
        //metodo que randomiza o aparecimento da maçã
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        
        
        
    }   
    public void move(){
        for (int i =  bodyParts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        //controles de direção da snake
        switch(direction){
            case '8':
                y[0] = y[0]-UNIT_SIZE;
                break;
            case '2':
                y[0] = y[0]+UNIT_SIZE;
                break;
            case '4':
                x[0] = x[0]-UNIT_SIZE;
                break;
            case '6':
                x[0] = x[0]+UNIT_SIZE;
                break;
        
        }
    
    }
    public void checkApple(){
    //checando se a cobrinha encontra a maca e incrementa um ponto no score
        if((x[0]== appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
     
    }
    public void checkCollisions() {
    //checando se a cabeça colide com alguma parte do corpo
        for (int i = bodyParts;i>0;i--){
             if((x[0] == x[i])&&(y[0]==y[i])){
                running =  false;
        }
     
     //checando se a cabeça toca a borda esquerda
        if(x[0]<0){
            running = false;
        }
        
        //checando se a cabeça toca a borda direita
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        
        
        //checando se a cabeça toca a borda superior
        if(y[0] < 0){
            running = false;
        }
        
        //checando se a cabeça toca a borda inferior
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        
        if(!running){
        timer.stop();
        }
        
        }
    }
    public void  gameOver(Graphics g){
        //mensagem score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.CENTER_BASELINE,40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Pontuação: " + applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Pontuação: " + applesEaten))/2, g.getFont().getSize());  
        

        //mensagem Game OVer        
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.CENTER_BASELINE,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(running){
            move();
            checkApple();
            checkCollisions();        
        }
        repaint();
        
    }
    
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                
                case KeyEvent.VK_LEFT:
                    if(direction!='6'){
                        direction = '4';
                    }
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    if(direction!='4'){
                        direction = '6';
                    }
                    break;  
                    
                case KeyEvent.VK_UP:
                    if(direction!='2'){
                        direction = '8';
                    }
                    break;
                
                case KeyEvent.VK_DOWN:
                    if(direction!='8'){
                        direction = '2';
                    }
                    break;
            }
        }
        
        
        
    }
}
