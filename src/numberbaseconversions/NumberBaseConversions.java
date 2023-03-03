package numberbaseconversions;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NumberBaseConversions extends JFrame {

    static JButton convert;
    static JTextField textfield;
    static JComboBox box;
    static JPanel p1, p2, p3;
    static JLabel l1, l2, l3, l4;
    static ImageIcon icon;
    static JFrame frame;
    String[] name = {"Null", "Decimal to Hexadecimal", "Decimal to Octal", "Decimal to Binary", "Hexadecimal to Decimal",
        "Hexadecimal to Binary", "Hexadecimal to Octal", "Binary to Decimal", "Binary to Octal", "Binary to Hexadecimal",
        "Octal to Decimal", "Octal to Binary", "Octal to Hexadecimal"};
    static int selected = 0;//tell as which index is selected from combobox

    NumberBaseConversions() {
        icon = new ImageIcon(getClass().getResource("logo.png"));

        l3 = new JLabel("Number Base Conversions");
        l3.setFont(new Font("Serif", 1, 20));
        l3.setForeground(Color.WHITE);

        p2 = new JPanel();
        p2.setBackground(new Color(0, 51, 51));
        p2.add(l3);

        p1 = new JPanel(new GridLayout(3, 2, 15, 15));
        p1.setBackground(new Color(0, 51, 51));

        l1 = new JLabel("Number to be Converted");
        l1.setForeground(Color.WHITE);

        textfield = new JTextField();

        p1.add(l1);
        p1.add(textfield);

        l2 = new JLabel("Convert to");
        l2.setForeground(Color.WHITE);

        box = new JComboBox(name);

        p1.add(l2);
        p1.add(box);

        l4 = new JLabel("");
        l4.setForeground(Color.RED);

        convert = new JButton("Convert");
        convert.setCursor(new Cursor(Cursor.HAND_CURSOR));

        p1.add(l4);
        p1.add(convert);

        p3 = new JPanel(new BorderLayout());
        p3.setBorder(new LineBorder(new Color(0, 80, 80), 30));

        p3.add(p2, BorderLayout.NORTH);
        p3.add(p1, BorderLayout.CENTER);

        add(p3);

        box.addItemListener((ItemEvent e) -> {
            switch (box.getSelectedIndex()) {
                case 1:
                    selected = 1;
                    break;
                case 2:
                    selected = 2;
                    break;
                case 3:
                    selected = 3;
                    break;
                case 4:
                    selected = 4;
                    break;
                case 5:
                    selected = 5;
                    break;
                case 6:
                    selected = 6;
                    break;
                case 7:
                    selected = 7;
                    break;
                case 8:
                    selected = 8;
                    break;
                case 9:
                    selected = 9;
                    break;
                case 10:
                    selected = 10;
                    break;
                case 11:
                    selected = 11;
                    break;
                case 12:
                    selected = 12;
                    break;
                default:
                    selected = 0;
                    break;
            }
        });

        convert.addActionListener((ActionEvent e) -> {
            try {
                switch (selected) {
                    case 1: {
                        int decimal = Integer.parseInt(textfield.getText());
                        decimalToHexadecimal(decimal);
                        break;
                    }
                    case 2: {
                        int decimal = Integer.parseInt(textfield.getText());
                        decimalToOctal(decimal);
                        break;
                    }
                    case 3: {
                        int decimal = Integer.parseInt(textfield.getText());
                        decimalToBinary(decimal);
                        break;
                    }
                    case 4:
                        if (textfield.getText().length() == 0) {
                            l4.setText("the field is empty !");
                            textfield.requestFocusInWindow();
                        } else {
                            hexadecimalToDecimal(textfield.getText());
                        }
                        break;
                    case 5:
                        if (textfield.getText().length() == 0) {
                            l4.setText("the field is empty !");
                            textfield.requestFocusInWindow();
                        } else {
                            hexadecimalToBinary(textfield.getText());
                        }
                        break;
                    case 6:
                        if (textfield.getText().length() == 0) {
                            l4.setText("the field is empty !");
                            textfield.requestFocusInWindow();
                        } else {
                            hexadecimalToOctal(textfield.getText());
                        }
                        break;
                    case 7: {
                        int decimal = Integer.parseInt(textfield.getText());
                        binaryToDecimal(decimal);
                        break;
                    }
                    case 8: {
                        int decimal = Integer.parseInt(textfield.getText());
                        binaryToOctal(decimal);
                        break;
                    }
                    case 9: {
                        int decimal = Integer.parseInt(textfield.getText());
                        binaryToHexadecimal(decimal);
                        break;
                    }
                    case 10: {
                        int decimal = Integer.parseInt(textfield.getText());
                        octalToDecimal(decimal);
                        break;
                    }
                    case 11: {
                        int decimal = Integer.parseInt(textfield.getText());
                        octalToBinary(decimal);
                        break;
                    }
                    case 12: {
                        int decimal = Integer.parseInt(textfield.getText());
                        octalToHexadecimal(decimal);
                        break;
                    }
                    default:
                        l4.setText("please select to convert!");
                        break;
                }
            } catch (NumberFormatException ex) {

                if (textfield.getText().equals("")) {
                    l4.setText("the field is empty !");
                    textfield.requestFocusInWindow();
                } else {
                    l4.setText("invalid input !");
                }
            }
        });

    }

    public static void main(String[] args) {

        frame = new NumberBaseConversions();

        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    public static void decimalToHexadecimal(int decimal) {

        int rem = 0;
        int hexadecimal = 0;
        String s = "";

        boolean tv = true, tv1 = false;
        while (decimal > 0) {
            rem = decimal % 16;
            if (rem == 0) {
                //used for concatinating zero before a number like 045...
                hexadecimal = hexadecimal * 10 + rem;
                s = s + hexadecimal;
            } else if (rem <= 15 && rem >= 10) {
                char ch = (char) (55 + rem);
                if ((hexadecimal) != 0) {
                    s = s + hexadecimal;
                    hexadecimal = 0;//privent duplicate
                    s += ch;
                    tv1 = false;
                } else {
                    s += ch;
                }
                tv = false;
            } else {
                hexadecimal = hexadecimal * 10 + rem;
                //used for detecting more after A to F division
                if ((s.length() > 0) && (s.charAt(s.length() - 1) >= 'A' && s.charAt(s.length() - 1) <= 'F')) {
                    tv1 = true;
                }
            }
            decimal /= 16;
        }

        if (tv1) {
            s = s + hexadecimal;
        }

        //if remainder less than ten for all division it assign default  part to s
        if (tv) {
            s = s + hexadecimal;
        }
        //reversing hexadecimal number 
        StringBuilder builder = new StringBuilder();

        builder.append(s);
        builder.reverse();

        s = builder.toString();
        JOptionPane.showMessageDialog(null, s);

        clearForm();
    }

    public static void decimalToBinary(int decimal) {
        int binary, remainder, base;
        base = 1;
        binary = 0;

        while (decimal > 0) {
            remainder = decimal % 2;
            binary = binary + remainder * base;
            decimal = decimal / 2;
            base = base * 10;
        }
        JOptionPane.showMessageDialog(null, binary);
        clearForm();

    }

    public static void decimalToOctal(int decimal) {

        int octal, remainder, base;
        base = 1;
        octal = 0;

        while (decimal > 0) {
            remainder = decimal % 8;
            String s = String.valueOf(remainder);
            char ch = s.charAt(0);
            s = String.valueOf(ch);
            remainder = Integer.parseInt(s);

            octal = octal + remainder * base;
            decimal = decimal / 8;
            base = base * 10;
        }
        JOptionPane.showMessageDialog(null, octal);
        clearForm();
    }

    public static void hexadecimalToDecimal(String hex) {

        char charhex[] = hex.toCharArray();

        //check for invalid input
        for (int i = 0; i < charhex.length; i++) {
            if (!((Character.toUpperCase(charhex[i]) >= 'A' && Character.toUpperCase(charhex[i]) <= 'F') || (charhex[i] <= '9' && charhex[i] >= '0'))) {
                l4.setText("invalid format");
                textfield.requestFocusInWindow();
                return;
            }
        }

        int longvalue = charhex.length;
        int decimal = 0;
        int counter = charhex.length - 1;

        while (longvalue > 0) {
            longvalue--;
            if (Character.toUpperCase(charhex[longvalue]) >= 'A' && Character.toUpperCase(charhex[longvalue]) <= 'F') {
                int value = Character.toUpperCase(charhex[longvalue]) - 'A' + 10;
                decimal = decimal + (value * (int) Math.pow(16, counter - longvalue));
            } else {
                String s = "" + charhex[longvalue];
                int value = Integer.parseInt(s);
                decimal = decimal + (value * (int) Math.pow(16, counter - longvalue));
            }
        }
        JOptionPane.showMessageDialog(null, decimal);
        clearForm();
    }

    public static void hexadecimalToBinary(String hex) {

        char charhex[] = hex.toCharArray();

        //check for invalid input
        for (int i = 0; i < charhex.length; i++) {
            if (!((Character.toUpperCase(charhex[i]) >= 'A' && Character.toUpperCase(charhex[i]) <= 'F') || (charhex[i] <= '9' && charhex[i] >= '0'))) {
                l4.setText("invalid format");
                textfield.requestFocusInWindow();
                return;
            }
        }

        int index = 0;
        String binary = "";

        while (charhex.length > index) {

            if (Character.toUpperCase(charhex[index]) >= 'A' && Character.toUpperCase(charhex[index]) <= 'F') {
                int value = Character.toUpperCase(charhex[index]) - 'A' + 10;
                binary += toBinary(value);
            } else {
                String s = "" + charhex[index];
                int value = Integer.parseInt(s);
                binary += toBinary(value);
            }
            index++;
        }
        JOptionPane.showMessageDialog(null, binary);
        clearForm();
    }

    public static void hexadecimalToOctal(String hex) {
        char charhex[] = hex.toCharArray();

        //check for invalid input
        for (int i = 0; i < charhex.length; i++) {
            if (!((Character.toUpperCase(charhex[i]) >= 'A' && Character.toUpperCase(charhex[i]) <= 'F') || (charhex[i] <= '9' && charhex[i] >= '0'))) {
                l4.setText("invalid format");
                textfield.requestFocusInWindow();
                return;
            }
        }

        int index = 0;
        String binary = "";

        while (charhex.length > index) {

            if (Character.toUpperCase(charhex[index]) >= 'A' && Character.toUpperCase(charhex[index]) <= 'F') {
                int value = Character.toUpperCase(charhex[index]) - 'A' + 10;
                binary += toBinary(value);
            } else {
                String s = "" + charhex[index];
                int value = Integer.parseInt(s);
                binary += toBinary(value);
            }
            index++;
        }
        //JOptionPane.showMessageDialog(null, binary);
        String stringbinary = String.valueOf(binary);

        if (stringbinary.length() % 3 == 1) {
            String s = stringbinary;
            stringbinary = "00";
            stringbinary += s;
        } else if (stringbinary.length() % 3 == 2) {
            String s = stringbinary;
            stringbinary = "0";
            stringbinary += s;
        }

        String octal = "", pass = "";
        char[] charhx = stringbinary.toCharArray();
        System.out.println("&&&" + stringbinary);
        for (int i = 0; i < charhx.length; i++) {
            pass += charhx[i];
            if ((i + 1) % 3 == 0) {
                octal += toDecimal(Integer.parseInt(pass));
                //System.out.println(octal);
                pass = "";
            }
        }
        JOptionPane.showMessageDialog(null, octal);
        clearForm();
    }

    public static void binaryToHexadecimal(int binary) {
        char[] chdecimal = String.valueOf(binary).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (!(chdecimal[i] == '0' || chdecimal[i] == '1')) {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");
                return;
            }

        }

        String stringbinary = String.valueOf(binary);

        switch (stringbinary.length() % 4) {
            case 1: {
                String s = stringbinary;
                stringbinary = "000";
                stringbinary += s;
                break;
            }
            case 2: {
                String s = stringbinary;
                stringbinary = "00";
                stringbinary += s;
                break;
            }
            case 3: {
                String s = stringbinary;
                stringbinary = "0";
                stringbinary += s;
                break;
            }
            default:
                break;
        }

        String hexa = "", pass = "";
        char[] charhx = stringbinary.toCharArray();

        for (int i = 0; i < charhx.length; i++) {
            pass += charhx[i];
            if ((i + 1) % 4 == 0) {
                switch (pass) {
                    case "1111":
                        hexa += "F";
                        break;
                    case "1110":
                        hexa += "E";
                        break;
                    case "1101":
                        hexa += "D";
                        break;
                    case "1100":
                        hexa += "C";
                        break;
                    case "1011":
                        hexa += "B";
                        break;
                    case "1010":
                        hexa += "A";
                        break;
                    default:
                        hexa += toDecimal(Integer.parseInt(pass));
                        break;
                }
                pass = "";

            }
        }
        JOptionPane.showMessageDialog(null, hexa);
        clearForm();

    }

    public static void binaryToOctal(int binary) {
        char[] chdecimal = String.valueOf(binary).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (!(chdecimal[i] == '0' || chdecimal[i] == '1')) {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");
                return;
            }

        }

        String stringbinary = String.valueOf(binary);

        if (stringbinary.length() % 3 == 1) {
            String s = stringbinary;
            stringbinary = "00";
            stringbinary += s;
        } else if (stringbinary.length() % 3 == 2) {
            String s = stringbinary;
            stringbinary = "0";
            stringbinary += s;
        }

        String octal = "", pass = "";
        char[] charhx = stringbinary.toCharArray();
        System.out.println("&&&" + stringbinary);
        for (int i = 0; i < charhx.length; i++) {
            pass += charhx[i];
            if ((i + 1) % 3 == 0) {
                octal += toDecimal(Integer.parseInt(pass));
                pass = "";
            }
        }
        JOptionPane.showMessageDialog(null, octal);
        clearForm();
    }

    public static void binaryToDecimal(int binary) {
        char[] chdecimal = String.valueOf(binary).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (!(chdecimal[i] == '0' || chdecimal[i] == '1')) {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");
                return;
            }

        }

        JOptionPane.showMessageDialog(null, toDecimal(binary));
        clearForm();
    }

    public static void octalToBinary(int octal) {
        char[] chdecimal = String.valueOf(octal).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (chdecimal[i] == '9' || chdecimal[i] == '8') {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");

                return;
            }
        }

        int rem = 0, counter = 0;
        String s = "", binary = "";

        StringBuilder builder = new StringBuilder();

        builder.append(octal);
        builder.reverse();
        binary = builder.toString();

        octal = Integer.parseInt(binary);
        binary = "";

        while (octal > 0) {
            rem = octal % 10;
            s = toBinaryo(rem);
            if (counter == 0 && String.valueOf(octal).length() != 1) {
                binary += s;
                counter++;
                octal /= 10;

                continue;
            }
            switch (s.length()) {
                case 1:
                    binary += "00" + s;
                    break;
                case 2:
                    binary += "0" + s;
                    break;
                default:
                    binary += s;
                    break;
            }
            octal /= 10;
        }

        String stringbinary = String.valueOf(binary);

        switch (stringbinary.length() % 4) {
            case 1:
                s = stringbinary;
                stringbinary = "000";
                stringbinary += s;
                break;
            case 2:
                s = stringbinary;
                stringbinary = "00";
                stringbinary += s;
                break;
            case 3:
                s = stringbinary;
                stringbinary = "0";
                stringbinary += s;
                break;
            default:
                break;
        }

        String hexa = "", pass = "";
        char[] charhx = stringbinary.toCharArray();
        System.out.println("&&&" + stringbinary);
        for (int i = 0; i < charhx.length; i++) {
            pass += charhx[i];
            if ((i + 1) % 4 == 0) {
                switch (pass) {
                    case "1111":
                        hexa += "F";
                        break;
                    case "1110":
                        hexa += "E";
                        break;
                    case "1101":
                        hexa += "D";
                        break;
                    case "1100":
                        hexa += "C";
                        break;
                    case "1011":
                        hexa += "B";
                        break;
                    case "1010":
                        hexa += "A";
                        break;
                    default:
                        hexa += toDecimal(Integer.parseInt(pass));
                        break;
                }
                pass = "";

            }
        }
        JOptionPane.showMessageDialog(null, binary);
        clearForm();

    }

    public static void octalToDecimal(int octal) {
        char[] chdecimal = String.valueOf(octal).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (chdecimal[i] == '9' || chdecimal[i] == '8') {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");

                return;
            }
        }

        JOptionPane.showMessageDialog(null, toOctal(octal));
        clearForm();
    }

    public static void octalToHexadecimal(int octal) {
        char[] chdecimal = String.valueOf(octal).toCharArray();

        for (int i = 0; i < chdecimal.length; i++) {
            if (chdecimal[i] == '9' || chdecimal[i] == '8') {
                textfield.requestFocusInWindow();
                l4.setText("invalid number format");

                return;
            }
        }

        int rem = 0, counter = 0;
        String s = "", binary = "";

        StringBuilder builder = new StringBuilder();

        builder.append(octal);
        builder.reverse();
        binary = builder.toString();

        octal = Integer.parseInt(binary);
        binary = "";

        while (octal > 0) {
            rem = octal % 10;
            s = toBinaryo(rem);
            if (counter == 0 && String.valueOf(octal).length() != 1) {
                binary += s;
                counter++;
                octal /= 10;

                continue;
            }
            switch (s.length()) {
                case 1:
                    binary += "00" + s;
                    break;
                case 2:
                    binary += "0" + s;
                    break;
                default:
                    binary += s;
                    break;
            }
            octal /= 10;
        }

        String stringbinary = String.valueOf(binary);

        switch (stringbinary.length() % 4) {
            case 1:
                s = stringbinary;
                stringbinary = "000";
                stringbinary += s;
                break;
            case 2:
                s = stringbinary;
                stringbinary = "00";
                stringbinary += s;
                break;
            case 3:
                s = stringbinary;
                stringbinary = "0";
                stringbinary += s;
                break;
            default:
                break;
        }

        String hexa = "", pass = "";
        char[] charhx = stringbinary.toCharArray();

        for (int i = 0; i < charhx.length; i++) {
            pass += charhx[i];
            if ((i + 1) % 4 == 0) {
                switch (pass) {
                    case "1111":
                        hexa += "F";
                        break;
                    case "1110":
                        hexa += "E";
                        break;
                    case "1101":
                        hexa += "D";
                        break;
                    case "1100":
                        hexa += "C";
                        break;
                    case "1011":
                        hexa += "B";
                        break;
                    case "1010":
                        hexa += "A";
                        break;
                    default:
                        hexa += toDecimal(Integer.parseInt(pass));
                        break;
                }
                pass = "";

            }
        }
        JOptionPane.showMessageDialog(null, hexa);
        clearForm();
    }

    public static String toBinary(int decimal) {
        int binary, remainder, base;
        base = 1;
        binary = 0;

        while (decimal > 0) {
            remainder = decimal % 2;
            binary = binary + remainder * base;
            decimal = decimal / 2;
            base = base * 10;
        }
        String stringvalue = String.valueOf(binary);

        switch (stringvalue.length()) {
            case 1:
                stringvalue = "000";
                stringvalue += binary;
                break;
            case 2:
                stringvalue = "00";
                stringvalue += binary;
                break;
            case 3:
                stringvalue = "0";
                stringvalue += binary;
                break;
            default:
                break;
        }

        return stringvalue;

    }

    public static String toBinaryo(int decimal) {
        int binary, remainder, base;
        base = 1;
        binary = 0;

        while (decimal > 0) {
            remainder = decimal % 2;
            binary = binary + remainder * base;
            decimal = decimal / 2;
            base = base * 10;
        }

        return String.valueOf(binary);

    }

    public static String toDecimal(int binary) {

        int rem, sum = 0, counter = 0, base = 10;
        while (binary > 0) {
            rem = (int) binary % base;
            if (rem > 0) {
                sum += factor(counter);
            }
            counter++;
            binary /= base;
        }

        return String.valueOf(sum);
    }

    public static String toOctal(int binary) {

        int rem, sum = 0, counter = 0, base = 10;
        while (binary > 0) {
            rem = (int) binary % base;
            if (counter == 0) {
                sum = rem;
            } else {
                sum += rem * factor1(counter);
            }
            counter++;
            binary /= base;
        }

        return String.valueOf(sum);
    }

    public static int factor(int c) {
        int fact = 1;
        for (int i = 1; i <= c; i++) {
            fact *= 2;
        }
        return fact;
    }

    public static int factor1(int c) {
        int fact = 1;
        for (int i = 1; i <= c; i++) {
            fact *= 8;
        }
        return fact;
    }

    public static void clearForm() {
        box.setSelectedIndex(0);
        textfield.setText("");
        selected = 0;
        l4.setText("");
    }

}
