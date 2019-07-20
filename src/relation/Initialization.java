package relation;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/*
*******************************
************Relation***********
*******************************
*/

class RelationInit extends JPanel implements ActionListener {

    Relation R;
    ArrayList<Integer> x;
    ArrayList<Integer> y;

    JTextField tF_1, tF_2, tF_3, tF_4;
    JLabel l_1, l_2, l_3, l_4, l_5, l_6, msg, resultTxt1, resultTxt2, resultTxt3;
    JTextArea result1, result2, result3;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JComboBox box1, box2;
    JScrollPane bar1, bar2, bar3;

    public RelationInit() {

        setLayout(null);
        l_3 = new JLabel("Domain");
        l_3.setBounds(20, 60, 80, 20);
        add(l_3);
        tF_1 = new JTextField();
        tF_1.setBounds(120, 60, 50, 20);
        add(tF_1);
        l_4 = new JLabel("To");
        l_4.setBounds(190, 60, 20, 20);
        add(l_4);
        tF_2 = new JTextField();
        tF_2.setBounds(230, 60, 50, 20);
        add(tF_2);
        l_1 = new JLabel("codomain");
        l_1.setBounds(20, 90, 80, 20);
        add(l_1);
        tF_3 = new JTextField();
        tF_3.setBounds(120, 90, 50, 20);
        add(tF_3);
        l_5 = new JLabel("To");
        l_5.setBounds(190, 90, 20, 20);
        add(l_5);
        tF_4 = new JTextField();
        tF_4.setBounds(230, 90, 50, 20);
        add(tF_4);
        l_2 = new JLabel("Element");
        l_2.setBounds(20, 150, 80, 20);
        add(l_2);
        
        box1 = new JComboBox();
        box1.setBounds(120, 150, 50, 20);
        box1.setEnabled(false);
        add(box1);
        box2 = new JComboBox();
        box2.setBounds(230, 150, 50, 20);
        box2.setEnabled(false);
        add(box2);
        
        resultTxt1 = new JLabel("Result");
        resultTxt1.setBounds(500, 20, 250, 20);
        add(resultTxt1);
        
        result1 = new JTextArea();
        result1.setBounds(0, 0, 250, 350);
        result1.setEditable(false);
        result1.setLineWrap(true);
        bar1 = new JScrollPane(result1);
        bar1.setBounds(500, 50, 250, 350);
        add(bar1);
        
        resultTxt2 = new JLabel("Domain of Diffenetion");
        resultTxt2.setBounds(20, 220, 180, 20);
        add(resultTxt2);
        
        result2 = new JTextArea();
        result2.setBounds(0, 0, 250, 350);
        result2.setEditable(false);
        result2.setLineWrap(true);
        bar2 = new JScrollPane(result2);
        bar2.setBounds(20, 250, 180, 150);
        add(bar2);
        
        resultTxt3 = new JLabel("Range of Relation");
        resultTxt3.setBounds(245, 220, 180, 20);
        add(resultTxt3);
        
        result3 = new JTextArea();
        result3.setBounds(0, 0, 250, 350);
        result3.setEditable(false);
        result3.setLineWrap(true);
        bar3 = new JScrollPane(result3);
        bar3.setBounds(245, 250, 180, 150);
        add(bar3);
        
        b1 = new JButton("add domain");
        b1.setBounds(300, 60, 120, 20);
        b1.setEnabled(false);
        add(b1);
        b1.addActionListener(this);
        msg = new JLabel("");
        msg.setBounds(150, 20, 300, 30);
        add(msg);
        b2 = new JButton("add codomain");
        b2.setBounds(300, 90, 120, 20);
        b2.setEnabled(false);
        add(b2);
        b2.addActionListener(this);
        b3 = new JButton("add Item");
        b3.setBounds(300, 150, 120, 20);
        b3.setEnabled(false);
        add(b3);
        b3.addActionListener(this);
        b4 = new JButton("Calculate");
        b4.setBounds(245, 410, 180, 20);
        b4.setEnabled(false);
        add(b4);
        b4.addActionListener(this);
        b5 = new JButton("Calculate");
        b5.setBounds(20, 410, 180, 20);
        b5.setEnabled(false);
        add(b5);
        b5.addActionListener(this);
        b6 = new JButton("new Relation");
        b6.setBounds(20, 20, 120, 30);
        add(b6);
        b6.addActionListener(this);
        b7 = new JButton("Print Relation");
        b7.setBounds(500, 410, 120, 20);
        b7.setEnabled(false);
        add(b7);
        b7.addActionListener(this);
        b8 = new JButton("Clear");
        b8.setBounds(670, 410, 80, 20);
        add(b8);
        b8.addActionListener(this);

        setVisible(true);
        setSize(550, 410);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
         if (e.getSource() == b6) {
            R = new Relation(x, y);
            if(R != null){
            b1.setEnabled(true);
            b2.setEnabled(true);
            b6.setEnabled(false);
            msg.setText("A New Relation Has Been Created Successfully");
            }
        }
         try {
            
       
        if (e.getSource() == b1) {
            int a1 = Integer.parseInt(tF_1.getText());
            int a2 = Integer.parseInt(tF_2.getText());
            R.setDomain(a1, a2);
            if(a1 <= a2){
                for (int i = 0; i < R.getDomain().size(); i++) {
                    box1.addItem(R.getDomain().get(i)); 
                 }
                box1.setEnabled(true);
                if(R.getDomain().isEmpty() == false && R.getCodomain().isEmpty() == false){
                    b3.setEnabled(true);
                }
                result1.append("The domain is:" + R.getDomain()+"\n");
                msg.setText("Created Domain Done Successfully");
                b1.setEnabled(false);
            }
        }
        if (e.getSource() == b2) {
            int a1 = Integer.parseInt(tF_3.getText());
            int a2 = Integer.parseInt(tF_4.getText());
            R.setCodomain(a1, a2);
            if(a1 <= a2){
                for (int i = 0; i < R.getCodomain().size(); i++) {
                    box2.addItem(R.getCodomain().get(i)); 
                 }
                box2.setEnabled(true);
                if(R.getDomain().isEmpty() == false && R.getCodomain().isEmpty() == false){
                    b3.setEnabled(true);
                }
               result1.append("The Co-domain is:" + R.getCodomain()+"\n");
               msg.setText("Created Co-omain Done Successfully");
               b2.setEnabled(false);
            }
        }
        if (e.getSource() == b3) {
            int a1 = Integer.parseInt(box1.getSelectedItem().toString());
            int a2 = Integer.parseInt(box2.getSelectedItem().toString());
        if(R.addElement(a1, a2)){
            result1.append("the Element ("+a1+","+a2+")"+"is added"+"\n");
            b4.setEnabled(true);
            b5.setEnabled(true);
            b7.setEnabled(true);
        } 
        else  result1.append("the Element dosn't add"+"\n");
        }
        
        if (e.getSource() == b4) {
            result3.append("" + R.Range()+"\n");
        }
        if (e.getSource() == b5) {
            result2.append("" + R.domainOfDef()+"\n");
        }
       
        if (e.getSource() == b7) {
            result1.append("The Relation is { " + R.toString() + " " + "}"+"\n");
        }
         } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Please Make A New Relation");
        }
        if (e.getSource() == b8) {
            tF_1.setText("");
            tF_2.setText("");
            tF_3.setText("");
            tF_4.setText("");
            result1.setText("");
            result2.setText("");
            result3.setText("");
            msg.setText("");
        }
    }

}
/*
*******************************
************Function***********
*******************************
*/
class FunctionInit extends JPanel implements ActionListener {

    JTextField tF_5, tF_6, tF_7, tF_8, tF_9, tF_10, tF_11, tF_12, tF_13, tF_14;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, msgF, msgGoF, resultTxtF1, resultTxtF2, resultTxtF3;
    JTextArea resultF1, resultF2, resultF3;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22;
    JComboBox box1, box2, box3, box4, box5, box6, box7, box8;
    JScrollPane bar1, bar2, bar3;
    JCheckBox ch1, ch2, ch3, ch4, ch5;
    Relation R;
    Function F, G, GoF;
    ArrayList<Integer> x;
    ArrayList<Integer> y;

    public FunctionInit() {

        setLayout(null);
        l1 = new JLabel("Domain");
        l1.setBounds(20, 60, 80, 20);
        add(l1);
        tF_5 = new JTextField();
        tF_5.setBounds(120, 60, 50, 20);
        add(tF_5);
        l2 = new JLabel("To");
        l2.setBounds(190, 60, 20, 20);
        add(l2);
        tF_6 = new JTextField();
        tF_6.setBounds(230, 60, 50, 20);
        add(tF_6);
        l3 = new JLabel("coDomain");
        l3.setBounds(20, 90, 80, 20);
        add(l3);
        tF_7 = new JTextField();
        tF_7.setBounds(120, 90, 50, 20);
        add(tF_7);
        l4 = new JLabel("To");
        l4.setBounds(190, 90, 20, 20);
        add(l4);
        tF_8 = new JTextField();
        tF_8.setBounds(230, 90, 50, 20);
        add(tF_8);
        l5 = new JLabel("Element");
        l5.setBounds(20, 150, 80, 20);
        add(l5);

        l6 = new JLabel("&");
        l6.setBounds(190, 150, 20, 20);
        add(l6);

        l7 = new JLabel("Co-domain");
        l7.setBounds(450, 60, 120, 20);
        add(l7);
        tF_9 = new JTextField();
        tF_9.setBounds(540, 60, 50, 20);
        add(tF_9);
        l8 = new JLabel("To");
        l8.setBounds(600, 60, 20, 20);
        add(l8);
        tF_10 = new JTextField();
        tF_10.setBounds(630, 60, 50, 20);
        add(tF_10);
        btn18 = new JButton("add");
        btn18.setBounds(690, 60, 60, 20);
        btn18.setEnabled(false);
        btn18.addActionListener(this);
        add(btn18);
        
        l10 = new JLabel("Element");
        l10.setBounds(450, 90, 120, 20);
        add(l10);
        box5 = new JComboBox();
        box5.setBounds(540, 90, 50, 20);
        box5.setEnabled(false);
        add(box5);
        l11 = new JLabel("To");
        l11.setBounds(600, 90, 20, 20);
        add(l11);
        box6 = new JComboBox();
        box6.setBounds(630, 90, 50, 20);
        box6.setEnabled(false);
        add(box6);
        btn20 = new JButton("add");
        btn20.setBounds(690, 90, 60, 20);
        btn20.setEnabled(false);
        btn20.addActionListener(this);
        add(btn20);
        
        l9 = new JLabel("GoF");
        l9.setBounds(450, 120, 40, 20);
        add(l9);
        btn19 = new JButton("calculate");
        btn19.setBounds(490, 120, 100, 20);
        btn19.setEnabled(false);
        btn19.addActionListener(this);
        add(btn19);
        msgGoF = new JLabel("");
        msgGoF.setBounds(600, 120, 140, 30);
        add(msgGoF);
        
        box7 = new JComboBox();
        box7.setBounds(450, 170, 50, 20);
        box7.setEnabled(false);
        add(box7);
        box8 = new JComboBox();
        box8.setBounds(605, 170, 50, 20);
        box8.setEnabled(false);
        add(box8);
        
        btn21 = new JButton("Image");
        btn21.setBounds(505, 170, 75, 20);
        btn21.setEnabled(false);
        btn21.addActionListener(this);
        add(btn21);
        btn22 = new JButton("PreImage");
        btn22.setBounds(660, 170, 90, 20);
        btn22.setEnabled(false);
        btn22.addActionListener(this);
        add(btn22);

        msgF = new JLabel("");
        msgF.setBounds(150, 20, 300, 30);
        add(msgF);
        
        box1 = new JComboBox();
        box1.setBounds(120, 150, 50, 20);
        box1.setEnabled(false);
        add(box1);
        box2 = new JComboBox();
        box2.setBounds(230, 150, 50, 20);
        box2.setEnabled(false);
        add(box2);
        
        box3 = new JComboBox();
        box3.setBounds(20, 400, 50, 20);
        box3.setEnabled(false);
        add(box3);
        box4 = new JComboBox();
        box4.setBounds(245, 400, 50, 20);
        box4.setEnabled(false);
        add(box4);
        
        resultTxtF1 = new JLabel("Result");
        resultTxtF1.setBounds(500, 200, 250, 20);
        add(resultTxtF1);
        
        resultF1 = new JTextArea();
        resultF1.setBounds(0, 0, 250, 300);
        resultF1.setEditable(false);
        resultF1.setLineWrap(true);
        bar1 = new JScrollPane(resultF1);
        bar1.setBounds(500, 230, 250, 150);
        add(bar1);
        
        resultTxtF2 = new JLabel("Domain of Diffenetion");
        resultTxtF2.setBounds(20, 200, 180, 20);
        add(resultTxtF2);
        
        resultF2 = new JTextArea();
        resultF2.setBounds(0, 0, 230, 120);
        resultF2.setEditable(false);
        resultF2.setLineWrap(true);
        bar2 = new JScrollPane(resultF2);
        bar2.setBounds(20, 230, 180, 120);
        add(bar2);
        
        resultTxtF3 = new JLabel("Range of Relation");
        resultTxtF3.setBounds(245, 200, 180, 20);
        add(resultTxtF3);
        
        resultF3 = new JTextArea();
        resultF3.setBounds(0, 0, 230, 120);
        resultF3.setEditable(false);
        resultF3.setLineWrap(true);
        bar3 = new JScrollPane(resultF3);
        bar3.setBounds(245, 230, 180, 120);
        add(bar3);

        btn1 = new JButton("add");
        btn1.setBounds(300, 60, 60, 20);
        btn1.setEnabled(false);
        add(btn1);
        btn1.addActionListener(this);
        btn2 = new JButton("add");
        btn2.setBounds(300, 90, 60, 20);
        btn2.setEnabled(false);
        add(btn2);
        btn2.addActionListener(this);
        btn13 = new JButton("Calculate");
        btn13.setBounds(20, 360, 180, 20);
        btn13.setEnabled(false);
        add(btn13);
        btn13.addActionListener(this);
        btn3 = new JButton("new Function(F)");
        btn3.setBounds(20, 20, 125, 30);
        add(btn3);
        btn3.addActionListener(this);
        btn4 = new JButton("add");
        btn4.setBounds(300, 150, 60, 20);
        btn4.setEnabled(false);
        add(btn4);
        btn4.addActionListener(this);
        
        btn5 = new JButton("getPreImage");
        btn5.setBounds(305, 400, 120, 20);
        btn5.setEnabled(false);
        btn5.addActionListener(this);
        add(btn5);
        btn6 = new JButton("getImage");
        btn6.setBounds(80, 400, 120, 20);
        btn6.setEnabled(false);
        btn6.addActionListener(this);
        add(btn6);
  
        btn14 = new JButton("Clear");
        btn14.setBounds(670, 400, 80, 20);
        btn14.addActionListener(this);
        add(btn14);
        btn12 = new JButton("Range");
        btn12.setBounds(245, 360, 180, 20);
        btn12.setEnabled(false);
        btn12.addActionListener(this);
        add(btn12);
        btn15 = new JButton("Print Function");
        btn15.setBounds(500, 400, 120, 20);
        btn15.setEnabled(false);
        btn15.addActionListener(this);
        add(btn15);
        
        btn16 = new JButton("chech Function");
        btn16.setBounds(620, 430, 120, 20);
        btn16.setEnabled(false);
        btn16.addActionListener(this);
        add(btn16);
        
        btn17 = new JButton("new Function(G)");
        btn17.setBounds(450, 20, 125, 30);
        btn17.setEnabled(false);
        btn17.addActionListener(this);
        add(btn17);
        
        ch1 = new JCheckBox("Left Total");
        ch1.setBounds(20, 430, 100, 20);
        add(ch1);
        ch1.setSelected(true);
        ch2 = new JCheckBox("Right Total");
        ch2.setBounds(140, 430, 100, 20);
        add(ch2);
        ch2.setSelected(true);
        ch3 = new JCheckBox("Surjective");
        ch3.setBounds(260, 430, 100, 20);
        add(ch3);
        ch3.setSelected(true);
        ch4 = new JCheckBox("Injective");
        ch4.setBounds(380, 430, 100, 20);
        add(ch4);
        ch4.setSelected(true);
        ch5 = new JCheckBox("Bijective");
        ch5.setBounds(500, 430, 100, 20);
        add(ch5);
        ch5.setSelected(true);

        setVisible(true);
        setSize(550, 420);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>(); 
        if (e.getSource() == btn3) {
            R = new Relation(x, y);
            F = new Function(x, y);
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            msgF.setText("A New Function Has Been Created Successfully");
        }
        try{
         
        if (e.getSource() == btn1) {
            int a1 = Integer.parseInt(tF_5.getText());
            int a2 = Integer.parseInt(tF_6.getText());
            
            if(a1 <= a2){
                F.setDomain(a1, a2);
                for (int i = 0; i < F.getDomain().size(); i++) {
                    box1.addItem(F.getDomain().get(i)); 
                    box3.addItem(F.getDomain().get(i)); 
                 }
                box1.setEnabled(true);
                box3.setEnabled(true);
                if(F.getDomain().isEmpty() == false && F.getCodomain().isEmpty() == false){
                    btn4.setEnabled(true);
                    btn17.setEnabled(true);
                }
                msgF.setText("Created Domain Done Successfully");
                resultF1.append("The domain is:" + F.getDomain()+"\n");
                btn1.setEnabled(false);
            }
        }
        if (e.getSource() == btn2) {
            int a1 = Integer.parseInt(tF_7.getText());
            int a2 = Integer.parseInt(tF_8.getText());
           
           if(a1 <= a2){
               F.setCodomain(a1, a2);
            for (int i = 0; i < F.getCodomain().size(); i++) {
                 box2.addItem(F.getCodomain().get(i));
                 box4.addItem(F.getCodomain().get(i));
                 box5.addItem(F.getCodomain().get(i));
              }
             box2.setEnabled(true);
             box4.setEnabled(true);
             box5.setEnabled(true);
             if(F.getDomain().isEmpty() == false && F.getCodomain().isEmpty() == false){
                 btn4.setEnabled(true);
                 btn17.setEnabled(true);
             }
             msgF.setText("Created Co-Domain Done Successfully");
             resultF1.append("The codomain is:" + F.getCodomain()+"\n");
             btn2.setEnabled(false);
           }
        }
       
        if (e.getSource() == btn4) {
            int a1 = Integer.parseInt(box1.getSelectedItem().toString());
            int a2 = Integer.parseInt(box2.getSelectedItem().toString());
          if(F.addElement(a1, a2)){
            resultF1.append("the Element ("+a1+","+a2+")"+"is added"+"\n");
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn12.setEnabled(true);
            btn13.setEnabled(true);
            btn15.setEnabled(true);
            btn16.setEnabled(true);
          } 
        else  resultF1.append("the Element cann't add"+"\n");
        }
        
        if (e.getSource() == btn5) {
            int a5 = Integer.parseInt(box4.getSelectedItem().toString());
            resultF3.append("The preImage for " + a5 + " is " + F.getPreimage(a5)+"\n");
        }
        if (e.getSource() == btn13) {
            resultF2.append("" + F.domainOfDef()+"\n");
        }
        if (e.getSource() == btn6) {
            int a5 = Integer.parseInt(box3.getSelectedItem().toString());
            resultF2.append("The Image for " + a5 + " is " + F.getImage(a5)+"\n");
        }
       
        if (e.getSource() == btn12) {
           resultF3.append(""+ F.Range()+"\n");
        }
        
        if (e.getSource() == btn15) {
            resultF1.append("The Function is " + F.toString() +"\n");
        }
        if (e.getSource() == btn16) {
            
            if (F.isLeftTotal()) {
                ch1.setSelected(true);
                ch1.setForeground(Color.green);
            } else {
                ch1.setSelected(false);
                ch1.setForeground(Color.red);
            }
            if (F.isRightTotal()) {
                ch2.setSelected(true);
                ch2.setForeground(Color.green);
            } else {
                ch2.setSelected(false);
                ch2.setForeground(Color.red);
            }
            if (F.isSurjective()) {
                ch3.setSelected(true);
                ch3.setForeground(Color.green);
            } else {
                ch3.setSelected(false);
                ch3.setForeground(Color.red);
            }
            if (F.isInjective()) {
                ch4.setSelected(true);
                ch4.setForeground(Color.green);
            } else {
                ch4.setSelected(false);
                ch4.setForeground(Color.red);
            }
            if (F.isBijective()) {
                ch5.setSelected(true);
                ch5.setForeground(Color.green);
            } else {
                ch5.setSelected(false);
                ch5.setForeground(Color.red);
            }
        }
        
        if (e.getSource() == btn17) {
            G = new Function(x, y);
            G.setDomain(F.getCodomain());
            btn18.setEnabled(true);
            msgF.setText("A Function F Created Successfully");
        }
        if (e.getSource() == btn18) {
            int a1 = Integer.parseInt(tF_9.getText());
            int a2 = Integer.parseInt(tF_10.getText());
            if(a1 <= a2){
                G.setCodomain(a1, a2);
                for (int i = 0; i < G.getCodomain().size(); i++) {
                    box6.addItem(G.getCodomain().get(i));
                 }
                box6.setEnabled(true);
                
                btn19.setEnabled(true);
                btn20.setEnabled(true);
                msgF.setText("Created Co domain od G Done Successfully");
                btn18.setEnabled(false);
            }
        }
        if (e.getSource() == btn19) {
            GoF = F.composite(G);
            msgGoF.setText("GoF Done Successfully");
            for (int i = 0; i < G.getCodomain().size(); i++) {
                box8.addItem(G.getCodomain().get(i));
             }
            for (int i = 0; i < F.getCodomain().size(); i++) {
                 box7.addItem(F.getDomain().get(i));
              }
            box7.setEnabled(true);
            box8.setEnabled(true);
            btn21.setEnabled(true);
            btn22.setEnabled(true);
        }
        if (e.getSource() == btn20) {
            
            int a1 = Integer.parseInt(box5.getSelectedItem().toString());
            int a2 = Integer.parseInt(box6.getSelectedItem().toString());
          if(G.addElement(a1, a2)){
            resultF1.append("the Element ("+a1+","+a2+")"+"is added"+"\n");
            
          } 
        else  resultF1.append("the Element cann't add"+"\n");
        }
        if (e.getSource() == btn21) {
            int a = Integer.parseInt(box7.getSelectedItem().toString());
            resultF2.append("The Image for " + a + " is " + GoF.getImage(a)+"\n");
        }
        if (e.getSource() == btn22) {
            int a = Integer.parseInt(box8.getSelectedItem().toString());
            resultF3.append("The Pre Image for " + a + " is " + GoF.getPreimage(a)+"\n");
        }
        }catch(Exception e2){
        JOptionPane.showMessageDialog(null, "Please Make A New Function");
        }
        if (e.getSource() == btn14) {
            tF_5.setText("");
            tF_6.setText("");
            tF_7.setText("");
            tF_8.setText("");
            tF_9.setText("");
            tF_10.setText("");
            resultF1.setText("");
            resultF2.setText("");
            resultF3.setText("");
            msgF.setText("");
        }
       
    }

}
/*
*******************************
**********RST-Relation*********
*******************************
*/

class RST_RelationInit extends JPanel implements ActionListener {

    JTextField d5, d6;
    JLabel leb1, leb2, leb3, leb4, leb5, leb6, leb7, leb8, leb9, msgS, resultSTxt1, resultSTxt2, resultSTxt3;
    JTextArea resultS1, resultS2, resultS3;
    JButton btn_a1, btn_a2, btn_a3, btn_a4, btn_a8, btn_a9, btn_a11, btn_a12, btn_a13;
    JComboBox box1, box2;
    JScrollPane barS1, barS2, barS3;
    JCheckBox ch1, ch2, ch3, ch4;
    ArrayList<Integer> x;
    ArrayList<Integer> y;
    Relation R;
    RST_Relation RS;

    public RST_RelationInit() {

        setLayout(null);
        leb1 = new JLabel("Set");
        leb1.setBounds(20, 80, 80, 20);
        add(leb1);
        d5 = new JTextField();
        d5.setBounds(120, 80, 50, 20);
        add(d5);
        leb2 = new JLabel("To");
        leb2.setBounds(190, 80, 20, 20);
        add(leb2);
        d6 = new JTextField();
        d6.setBounds(230, 80, 50, 20);
        add(d6);

        leb4 = new JLabel("Element");
        leb4.setBounds(20, 120, 80, 20);
        add(leb4);

        leb5 = new JLabel("&");
        leb5.setBounds(190, 120, 20, 20);
        add(leb5);
        msgS = new JLabel("");
        msgS.setBounds(150, 20, 300, 30);
        add(msgS);

        btn_a1 = new JButton("add domain");
        btn_a1.setBounds(300, 80, 120, 20);
        add(btn_a1);
        btn_a1.setEnabled(false);
        btn_a1.addActionListener(this);
        btn_a2 = new JButton("add codomain");
        btn_a2.setBounds(300, 90, 120, 20);
//        add(btn_a2);
        btn_a2.setEnabled(false);
        btn_a2.addActionListener(this);
        btn_a3 = new JButton("DoOfDef");
        btn_a3.setBounds(20, 410, 180, 20);
        add(btn_a3);
        btn_a3.setEnabled(false);
        btn_a3.addActionListener(this);
        btn_a4 = new JButton("newRST_R");
        btn_a4.setBounds(20, 20, 120, 30);
        add(btn_a4);
        btn_a4.addActionListener(this);
        btn_a9= new JButton("add Item");
        btn_a9.setBounds(300, 120, 120, 20);
        add(btn_a9);
        btn_a9.setEnabled(false);
        btn_a9.addActionListener(this);
        
        box1 = new JComboBox();
        box1.setBounds(120, 120, 50, 20);
        box1.setEnabled(false);
        add(box1);
        box2 = new JComboBox();
        box2.setBounds(230, 120, 50, 20);
        box2.setEnabled(false);
        add(box2);
        
        resultSTxt1 = new JLabel("Result");
        resultSTxt1.setBounds(500, 20, 250, 20);
        add(resultSTxt1);
        
        resultS1 = new JTextArea();
        resultS1.setBounds(0, 0, 250, 350);
        resultS1.setEditable(false);
        resultS1.setLineWrap(true);
        barS1 = new JScrollPane(resultS1);
        barS1.setBounds(500, 50, 250, 350);
        add(barS1);
        
        resultSTxt2 = new JLabel("Domain of Diffenetion");
        resultSTxt2.setBounds(20, 220, 180, 20);
        add(resultSTxt2);
        
        resultS2 = new JTextArea();
        resultS2.setBounds(0, 0, 250, 350);
        resultS2.setEditable(false);
        resultS2.setLineWrap(true);
        barS2 = new JScrollPane(resultS2);
        barS2.setBounds(20, 250, 180, 150);
        add(barS2);
        
        resultSTxt3 = new JLabel("Range of Relation");
        resultSTxt3.setBounds(245, 220, 180, 20);
        add(resultSTxt3);
        
        resultS3 = new JTextArea();
        resultS3.setBounds(0, 0, 250, 350);
        resultS3.setEditable(false);
        resultS3.setLineWrap(true);
        barS3 = new JScrollPane(resultS3);
        barS3.setBounds(245, 250, 180, 150);
        add(barS3);

        btn_a8 = new JButton("Check");
        btn_a8.setBounds(550, 450, 100, 20);
        btn_a8.addActionListener(this);
        add(btn_a8);

        btn_a11 = new JButton("printEquR");
        btn_a11.setBounds(500, 410, 120, 20);
        btn_a11.addActionListener(this);
        add(btn_a11);
        btn_a11.setEnabled(false);
        btn_a13 = new JButton("Clear");
        btn_a13.setBounds(670, 410, 80, 20);
        btn_a13.addActionListener(this);
        add(btn_a13);
        btn_a12 = new JButton("Range");
        btn_a12.setBounds(245, 410, 180, 20);
        btn_a12.addActionListener(this);
        add(btn_a12);
        btn_a12.setEnabled(false);

        ch1 = new JCheckBox("Reflexive");
        ch1.setBounds(20, 450, 100, 20);
        add(ch1);
        ch1.setSelected(true);
        ch2 = new JCheckBox("Symmetric");
        ch2.setBounds(140, 450, 100, 20);
        add(ch2);
        ch2.setSelected(true);
        ch3 = new JCheckBox("Transitive");
        ch3.setBounds(260, 450, 100, 20);
        add(ch3);
        ch3.setSelected(true);
        ch4 = new JCheckBox("Equvelance Relation");
        ch4.setBounds(380, 450, 150, 20);
        add(ch4);
        ch4.setSelected(true);
        
        setVisible(true);
        setSize(550, 420);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = new ArrayList<Integer>();        
        y = new ArrayList<Integer>();
        if (e.getSource() == btn_a4) {
            R = new Relation(x, y);
            RS = new RST_Relation(x,y);
            btn_a1.setEnabled(true);
            btn_a2.setEnabled(true);
            msgS.setText("A New Relation Has Been Created Successfully");
        }
        try {
        if (e.getSource() == btn_a1) {
            int a1 = Integer.parseInt(d5.getText());
            int a2 = Integer.parseInt(d6.getText());
            
            if(a1 <= a2){
                RS.setDomain(a1, a2);
                RS.setCodomain(a1, a2);
                for (int i = 0; i < RS.getDomain().size(); i++) {
                    box1.addItem(RS.getDomain().get(i));
                    box2.addItem(RS.getDomain().get(i));
                 }
                box1.setEnabled(true);
                box2.setEnabled(true);
                if(RS.getDomain().isEmpty() == false && RS.getCodomain().isEmpty() == false){
                    btn_a9.setEnabled(true);
                }
                resultS1.append("The domain is:" + RS.getDomain()+"\n");
                msgS.setText("Created Domain Done Successfully");
            }
        }
        if (e.getSource() == btn_a2) {
            int a1 = Integer.parseInt(d5.getText());
            int a2 = Integer.parseInt(d6.getText());
            RS.setCodomain(a1, a2);
            if(a1 <= a2){
                for (int i = 0; i < RS.getCodomain().size(); i++) {
                    box2.addItem(RS.getCodomain().get(i)); 
                 }
                box2.setEnabled(true);
                if(RS.getDomain().isEmpty() == false && RS.getCodomain().isEmpty() == false){
                    btn_a9.setEnabled(true);
                }
               resultS1.append("The Co-domain is:" + RS.getCodomain()+"\n");
               msgS.setText("Created Co-omain Done Successfully");
            }
        }
        
        if (e.getSource() == btn_a9) {
            int a1 = Integer.parseInt(box1.getSelectedItem().toString());
            int a2 = Integer.parseInt(box2.getSelectedItem().toString());
            if(RS.addElement(a1, a2)){
                btn_a11.setEnabled(true);
                btn_a12.setEnabled(true);
                btn_a3.setEnabled(true);
            
                resultS1.append("the Element ("+a1+","+a2+")"+"is added"+"\n");
                } 
                else  resultS1.append("the Element dosn't add"+"\n");
                }
        
        
        
        if (e.getSource() == btn_a3) {
            resultS2.append("" + RS.domainOfDef()+"\n");
        }

        if (e.getSource() == btn_a8) {
            if (RS.isEquivalence()) {
                ch1.setSelected(true);
                ch1.setForeground(Color.green);
            } else {
                ch1.setSelected(false);
                ch1.setForeground(Color.red);
            }
            if (RS.isSymmetric()) {
                ch2.setSelected(true);
                ch2.setForeground(Color.green);
            } else {
                ch2.setSelected(false);
                ch2.setForeground(Color.red);
            }
            if (RS.isTransitive()) {
                ch3.setSelected(true);
                ch3.setForeground(Color.green);
            } else {
                ch3.setSelected(false);
                ch3.setForeground(Color.red);
            }
            if (RS.isEquivalence()) {
                ch4.setSelected(true);
                ch4.setForeground(Color.green);
            } else {
                ch4.setSelected(false);
                ch4.setForeground(Color.red);
            }
           
        }

        if (e.getSource() == btn_a12) {
             resultS3.append( ""+RS.Range()+"\n");
        }
       
        if (e.getSource() == btn_a11) {
            resultS1.append( ""+RS.printEqClasses()+"\n");
        }
         } catch (Exception e3) {
            JOptionPane.showMessageDialog(null, "Error Please Make A New RST_Relation or input correct");
        }
        if (e.getSource() == btn_a13) {
            d5.setText("");
            d6.setText("");
            resultS1.setText("");
            resultS2.setText("");
            resultS3.setText("");
            msgS.setText("");

        }
    }
}
