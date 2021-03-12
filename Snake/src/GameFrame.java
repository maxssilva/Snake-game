
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    GameFrame(){
        
       // GamePanel panel = new GamePanel();
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //*002*
        this.setResizable(false);
        this.pack(); /*001*/
        this.setVisible(true); //003**
        this.setLocationRelativeTo(null);//004**
        
    }
    
}
