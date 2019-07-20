package relation;

import javax.swing.*;
import java.awt.*;
	
public class Main extends JFrame {
 
    	JTabbedPane pane;
    	Container c;
    	
    	public Main(){
    		super("Relations Project");
    		setDefaultCloseOperation(EXIT_ON_CLOSE);
    		c=getContentPane();
    		c.setBackground(Color.white);
    		
    		pane=new JTabbedPane();
                pane.setBackground(Color.white);
    		pane.addTab("Relation",new RelationInit());
    		pane.addTab("RST_Relation",new RST_RelationInit());
                pane.addTab("Function",new FunctionInit());
    		c.add(pane);
    		setSize(800,560);
    		setVisible(true);
                setLocationRelativeTo(null);
    	}
    public static void main(String[] args) {
        new Main();
    }
}
