import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScientificCalculator extends JFrame implements ActionListener {

    JTextField valueField;
    JPanel mainPanel;
    JButton cl, rem, div, mul, inv, nine, eight, seven, minus, fac, six,
            five, four, three, two, one, zero, dot, plusMinusm, plus, pow,
            pi, equal, mod;

    JButton sin, cos, tan, sinin, cosin, tanin, twoX, xCube,  tenX, natln, logri, expX;
    JComboBox unitComboBox1, unitComboBox2, numComboBox1,numComboBox2;
    JLabel jLabel1 = new JLabel("To");
    JLabel jLabel2 = new JLabel("To");
    JLabel numSysLabel,unitLabel;

    double temp, temp1, result, a;
    static double m1, m2;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;

    void InputField(){
        valueField = new JTextField(115);
        valueField.setHorizontalAlignment(SwingConstants.RIGHT);
        valueField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                super.keyTyped(keyEvent);
                char c = keyEvent.getKeyChar();
                if (c >= '0' && c <= '9' ) {
                }
                else {
                    keyEvent.consume();
                }
            }
        });
        valueField.setBounds(320,10,265,30);
    }

    void BasicPanel(){

        cl = new JButton("C");
        cl.setBounds(10,60,50,50);
        cl.addActionListener(this);

        rem = new JButton("%");
        rem.setBounds(70,60,50,50);
        rem.addActionListener(this);

        div = new JButton("/");
        div.setBounds(130,60,50,50);
        div.addActionListener(this);

        mul = new JButton("*");
        mul.setBounds(190,60,50,50);
        mul.addActionListener(this);

        inv = new JButton("1/x");
        inv.setBounds(250,60,50,50);
        inv.addActionListener(this);

        nine = new JButton("9");
        nine.setBounds(10,120,50,50);
        nine.addActionListener(this);

        eight = new JButton("8");
        eight.setBounds(70,120,50,50);
        eight.addActionListener(this);

        seven = new JButton("7");
        seven.setBounds(130,120,50,50);
        seven.addActionListener(this);

        minus = new JButton("-");
        minus.setBounds(190,120,50,50);
        minus.addActionListener(this);

        fac = new JButton("x!");
        fac.setBounds(250,120,50,50);
        fac.addActionListener(this);

        six = new JButton("6");
        six.setBounds(10,180,50,50);
        six.addActionListener(this);

        five = new JButton("5");
        five.setBounds(70,180,50,50);
        five.addActionListener(this);

        four = new JButton("4");
        four.setBounds(130,180,50,50);
        four.addActionListener(this);

        plus = new JButton("+");
        plus.setBounds(190,180,50,50);
        plus.addActionListener(this);

        pow = new JButton("^");
        pow.setBounds(250,180,50,50);
        pow.addActionListener(this);

        three = new JButton("3");
        three.setBounds(10,240,50,50);
        three.addActionListener(this);

        two = new JButton("2");
        two.setBounds(70,240,50,50);
        two.addActionListener(this);

        one = new JButton("1");
        one.setBounds(130,240,50,50);
        one.addActionListener(this);

        pi = new JButton("π");
        pi.setBounds(190,240,50,50);
        pi.addActionListener(this);

        equal = new JButton("=");
        equal.setBounds(250,240,50,110);
        equal.addActionListener(this);

        zero = new JButton("0");
        zero.setBounds(10,300,50,50);
        zero.addActionListener(this);

        plusMinusm = new JButton("+/-");
        plusMinusm.setBounds(70,300,50,50);
        plusMinusm.addActionListener(this);

        dot = new JButton(".");
        dot.setBounds(130,300,50,50);
        dot.addActionListener(this);

        mod = new JButton("|x|");
        mod.setBounds(190,300,50,50);
        mod.addActionListener(this);
    }

    void UnitConversion(){

        unitLabel = new JLabel("Unit Conversion");
        unitLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        unitLabel.setBounds(320,60,120,30);
        String[] unit = {"Millimetre(mm)","Centimetres(cm)","Metres(m)","Kilometres(km)","Inhes(in)","Feet(ft)"};
        unitComboBox1 = new JComboBox(unit);
        unitComboBox1.setBounds(320,110,100,30);
        jLabel1.setBounds(440,110,30,30);
        unitComboBox2 = new JComboBox(unit);
        unitComboBox2.setBounds(490,110,100,30);

    }

    void NumBaseConver(){
        numSysLabel = new JLabel("Base System Conversion");
        numSysLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        numSysLabel.setBounds(320,210,200,30);
        String[] baseUnit = {"Binary","Hex","Decimal","Octa"};
        numComboBox1 = new JComboBox(baseUnit);
        numComboBox1.setBounds(320,260,100,30);
        jLabel2.setBounds(440,260,30,30);
        numComboBox2 = new JComboBox(baseUnit);
        numComboBox2.setBounds(490,260,100,30);
    }

    void TrigoPanel(){
        sin = new JButton("sin");
        sin.setBounds(610,60,70,70);
        sin.addActionListener(this);

        cos = new JButton("cos");
        cos.setBounds(690,60,70,70);
        cos.addActionListener(this);

        tan = new JButton("tan");
        tan.setBounds(770,60,70,70);
        tan.addActionListener(this);

        sinin = new JButton("sin-1");
        sinin.setBounds(610,140,70,70);
        sinin.addActionListener(this);

        cosin = new JButton("cos-1");
        cosin.setBounds(690,140,70,70);
        cosin.addActionListener(this);

        tanin = new JButton("tan-1");
        tanin.setBounds(770,140,70,70);
        tanin.addActionListener(this);

        natln = new JButton("ln");
        natln.setBounds(610,220,70,70);
        natln.addActionListener(this);

        logri = new JButton("log");
        logri.setBounds(690,220,70,70);
        natln.addActionListener(this);

        expX = new JButton("e^x");
        expX.setBounds(770,220,70,70);
        expX.addActionListener(this);

        twoX = new JButton("2^x");
        twoX.setBounds(610,300,70,70);
        twoX.addActionListener(this);

        xCube = new JButton("x^3");
        xCube.setBounds(690,300,70,70);
        xCube.addActionListener(this);

        tenX = new JButton("10^x");
        tenX.setBounds(770,300,70,70);
        tenX.addActionListener(this);
    }

    ScientificCalculator(){
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        InputField();

        BasicPanel();

        UnitConversion();

        NumBaseConver();

        TrigoPanel();

        mainPanel.add(valueField);

        mainPanel.add(cl);
        mainPanel.add(rem);
        mainPanel.add(div);
        mainPanel.add(mul);
        mainPanel.add(inv);
        mainPanel.add(nine);
        mainPanel.add(eight);
        mainPanel.add(seven);
        mainPanel.add(minus);
        mainPanel.add(fac);
        mainPanel.add(six);
        mainPanel.add(five);
        mainPanel.add(four);
        mainPanel.add(plus);
        mainPanel.add(pow);
        mainPanel.add(three);
        mainPanel.add(two);
        mainPanel.add(one);
        mainPanel.add(pi);
        mainPanel.add(equal);
        mainPanel.add(zero);
        mainPanel.add(plusMinusm);
        mainPanel.add(dot);
        mainPanel.add(mod);

        mainPanel.add(jLabel1);
        mainPanel.add(unitComboBox1);
        mainPanel.add(unitComboBox2);
        mainPanel.add(unitLabel);

        mainPanel.add(jLabel2);
        mainPanel.add(numComboBox1);
        mainPanel.add(numComboBox2);
        mainPanel.add(numSysLabel);

        mainPanel.add(sin);
        mainPanel.add(cos);
        mainPanel.add(tan);
        mainPanel.add(sinin);
        mainPanel.add(cosin);
        mainPanel.add(tanin);
        mainPanel.add(tenX);
        mainPanel.add(twoX);
        mainPanel.add(xCube);
        mainPanel.add(natln);
        mainPanel.add(logri);
        mainPanel.add(expX);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    double fact(double x) {
        int er = 0;
        if (x < 0) {
            er = 20;
            return 0;
        }
        double i, s = 1;
        for (i = 2; i <= x; i += 1.0)
            s *= i;
        return s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("1")){
            if (z == 0) {
                valueField.setText(valueField.getText() + "1");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "1");
                z = 0;
            }
        }
        if (s.equals("2")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "2");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "2");
                z = 0;
            }
        }
        if (s.equals("3")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "3");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "3");
                z = 0;
            }
        }
        if (s.equals("4")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "4");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "4");
                z = 0;
            }
        }
        if (s.equals("5")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "5");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "5");
                z = 0;
            }
        }
        if (s.equals("6")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "6");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "6");
                z = 0;
            }
        }
        if (s.equals("7")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "7");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "7");
                z = 0;
            }
        }
        if (s.equals("8")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "8");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "8");
                z = 0;
            }
        }
        if (s.equals("9")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "9");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "9");
                z = 0;
            }
        }
        if (s.equals("0")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + "0");
            } else {
                valueField.setText("");
                valueField.setText(valueField.getText() + "0");
                z = 0;
            }
        }
        if (s.equals(".")) {
            if (z == 0) {
                valueField.setText(valueField.getText() + ".");
                y=1;
            } else {
                valueField.setText(valueField.getText());
            }
        }
        if (s.equals("+/-")) {
            if (x == 0) {
                valueField.setText("-" + valueField.getText());
                x = 1;
            } else {
                valueField.setText(valueField.getText());
            }
        }
        if (s.equals("C")) {
            valueField.setText("");
            x = 0;
            y = 0;
            z = 0;
        }
        if (s.equals("1/x")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = 1 / Double.parseDouble(valueField.getText());
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("*")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 1;
                ch = '*';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(valueField.getText());
                ch = '*';
                valueField.setText("");
            }
            valueField.requestFocus();
        }
        if (s.equals("/")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 1;
                ch = '/';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(valueField.getText());
                ch = '/';
                valueField.setText("");
            }
            valueField.requestFocus();
        }
        if (s.equals("-")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 0;
                ch = '-';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(valueField.getText());
                valueField.setText("");
                ch = '-';
            }
            valueField.requestFocus();
        }
        if (s.equals("+")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 0;
                ch = '+';
            } else {
                temp = Double.parseDouble(valueField.getText());
                valueField.setText("");
                ch = '+';
                y = 0;
                x = 0;
            }
            valueField.requestFocus();
        }
        if (s.equals("%")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 0;
                ch = '%';
            } else {
                temp = Double.parseDouble(valueField.getText());
                valueField.setText("");
                ch = '%';
                y = 0;
                x = 0;
            }
            valueField.requestFocus();
        }
        if (s.equals("^")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
                temp = 0;
                ch = '^';
            } else {
                temp = Double.parseDouble(valueField.getText());
                valueField.setText("");
                ch = '^';
                y = 0;
                x = 0;
            }
            valueField.requestFocus();
        }
        if (s.equals("x!")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = fact(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("π")) {
            if (valueField.getText().equals("")) {
                valueField.setText(Double.toString(3.14));
            }
        }
        if (s.equals("=")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                temp1 = Double.parseDouble(valueField.getText());
                switch (ch) {
                    case '+':
                        result = temp + temp1;
                        break;
                    case '-':
                        result = temp - temp1;
                        break;
                    case '/':
                        result = temp / temp1;
                        break;
                    case '*':
                        result = temp * temp1;
                        break;
                    case '%':
                        result = temp % temp1;
                        break;
                    case '^':
                        result = Math.pow(temp,temp1);
                        break;

                }
                valueField.setText("");
                valueField.setText(valueField.getText() + result);
                z = 1;
            }
        }
        if (s.equals("sin")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.sin(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("cos")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.cos(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("tan")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.tan(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("sin-1")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.asin(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("cos-1")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.acos(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("tan-1")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.atan(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("ln")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.log(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        if (s.equals("log")) {
            if (valueField.getText().equals("")) {
                valueField.setText("");
            } else {
                a = Math.log10(Double.parseDouble(valueField.getText()));
                valueField.setText("");
                valueField.setText(valueField.getText() + a);
            }
        }
        valueField.requestFocus();
    }

    public static void main(String[] args){
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ScientificCalculator scientificCalculator = new ScientificCalculator();
        scientificCalculator.setTitle("Scientific Calculator");
        scientificCalculator.setSize(870,415);
        scientificCalculator.setVisible(true);
    }

}
