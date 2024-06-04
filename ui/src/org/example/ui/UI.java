package org.example.ui;

import org.example.numbers.NumberConverter;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.Objects;

public class UI {

    public static class MyInterface extends JFrame {
        private JTextField textField1, textField2, textField3;
        private JButton button1, button2, button3, button4,button5;
        private JRadioButton rb1,rb2;
        private static JLabel warningLabel;
        public static boolean locale = true;
        public NumberConverter numberConverter ;


        public MyInterface(NumberConverter converterService) {
            super();
            this.numberConverter = converterService;

            setLayout(null);
            setTitle("Kelime Hesap Makinesi");

            textField1 = new JTextField();
            textField1.setBounds(150, 20, 250, 30);
            add(textField1);


            textField2 = new JTextField();
            textField2.setBounds(150, 70, 250, 30);
            add(textField2);


            textField3 = new JTextField();
            textField3.setEditable(false);
            textField3.setBounds(150, 120, 250, 30);
            add(textField3);



            warningLabel = new JLabel("");
            warningLabel.setForeground(Color.RED);
            warningLabel.setBounds(50, 0, 400, 20);
            add(warningLabel);


            JLabel label1 = new JLabel("Birinci Sayı");


            JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
            BoundedRangeModel brm = textField1.getHorizontalVisibility();
            scrollBar.setModel(brm);
            scrollBar.setBounds(150, 50, 250, 12);
            add(scrollBar);


            JScrollBar scrollBar2 = new JScrollBar(JScrollBar.HORIZONTAL);
            BoundedRangeModel brm2 = textField2.getHorizontalVisibility();
            scrollBar2.setModel(brm2);
            scrollBar2.setBounds(150, 100, 250, 12);
            add(scrollBar2);


            JScrollBar scrollBar3 = new JScrollBar(JScrollBar.HORIZONTAL);
            BoundedRangeModel brm3 = textField3.getHorizontalVisibility();
            scrollBar3.setModel(brm3);
            scrollBar3.setBounds(150, 150, 250, 12);
            add(scrollBar3);


            label1.setBounds(50, 20, 100, 30);
            add(label1);


            JLabel label2 = new JLabel("İkinci Sayı:");
            label2.setBounds(50, 70, 100, 30);
            add(label2);


            JLabel label3 = new JLabel("Sonuç:");
            label3.setBounds(50, 120, 100, 30);
            add(label3);


            button1 = new JButton("Ekle");
            button1.setBounds(50, 170, 100, 30);
            button1.addActionListener(e -> {


                if (locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.turkishNumbers().get(token);
                        if (token.equals("eksi")|| token.equals(""))
                        {

                        }
                        else if (number == null  )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumber(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number1 = this.numberConverter.turkishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number1 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumber(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.add(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToTurkish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="sıfır";
                                textField3.setText("sıfır");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }


                if (!locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.englishNumbers().get(token);
                        if (token.equals("minus"))
                        {

                        }
                        else if (number == null )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number2 = this.numberConverter.englishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number2 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.add(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToEnglish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="zero";
                                textField3.setText("zero");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }});

            add(button1);


            button2 = new JButton("Çıkar");
            button2.setBounds(180, 170, 100, 30);
            button2.addActionListener(e ->
            {
                if (locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.turkishNumbers().get(token);
                        if (token.equals("eksi")|| token.equals(""))
                        {

                        }
                        else if (number == null  )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumber(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number1 = this.numberConverter.turkishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number1 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumber(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.subtract(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToTurkish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="sıfır";
                                textField3.setText("sıfır");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }


                if (!locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.englishNumbers().get(token);
                        if (token.equals("minus"))
                        {

                        }
                        else if (number == null )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number2 = this.numberConverter.englishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number2 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.subtract(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToEnglish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="zero";
                                textField3.setText("zero");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }});

            add(button2);


            button3 = new JButton("Çarp");
            button3.setBounds(310, 170, 100, 30);
            button3.addActionListener(e ->
            {
                if (locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.turkishNumbers().get(token);
                        if (token.equals("eksi")|| token.equals(""))
                        {

                        }
                        else if (number == null  )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumber(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number1 = this.numberConverter.turkishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number1 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumber(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.multiply(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToTurkish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="sıfır";
                                textField3.setText("sıfır");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }


                if (!locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.englishNumbers().get(token);
                        if (token.equals("minus"))
                        {

                        }
                        else if (number == null )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number2 = this.numberConverter.englishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number2 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.multiply(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToEnglish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="zero";
                                textField3.setText("zero");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }});

            add(button3);


            button4 = new JButton("Böl");
            button4.setBounds(440, 170, 100, 30);
            button4.addActionListener(e ->
            {
                if (locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.turkishNumbers().get(token);
                        if (token.equals("eksi")|| token.equals(""))
                        {

                        }
                        else if (number == null  )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumber(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number1 = this.numberConverter.turkishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number1 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumber(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.divide(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToTurkish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="sıfır";
                                textField3.setText("sıfır");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }


                if (!locale)
                {
                    textField3.setText("");
                    String text1input = textField1.getText();
                    String[] tokens = text1input.split("\\s+");

                    for (String token : tokens)
                    {

                        BigInteger number = this.numberConverter.englishNumbers().get(token);
                        if (token.equals("minus"))
                        {

                        }
                        else if (number == null )  {
                            showWarning();
                            return;
                        }
                    }

                    BigInteger ahmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text1input);
                    String text2input = textField2.getText();

                    String[] tokens2 = text2input.split("\\s+");
                    for (String token2 : tokens2) {

                        BigInteger number2 = this.numberConverter.englishNumbers().get(token2);
                        if (token2.equals("minus"))
                        {

                        }
                        else if (number2 == null) {
                            showWarning();
                            return;
                        }
                        else
                        {

                            BigInteger mehmet = (BigInteger) this.numberConverter.convertToNumberEnglish(text2input);
                            System.out.println(mehmet);
                            BigInteger serviceOutput = this.numberConverter.divide(ahmet,mehmet);
                            String convertOutput = this.numberConverter.convertToEnglish(serviceOutput);
                            if (Objects.equals(serviceOutput, BigInteger.ZERO))
                            {
                                convertOutput="zero";
                                textField3.setText("zero");
                                deleteWarning();
                            }

                            else
                            {
                                textField3.setText(String.valueOf(convertOutput));
                                deleteWarning();

                            }
                        }

                    }

                }});
            add(button4);

            button5 = new JButton("?");
            button5.setBounds(0, 0, 45, 45);
            button5.addActionListener(e ->
            {
                JOptionPane.showMessageDialog(null,"Uygulama Desilyon'a (10^33) kadar desteklemektedir.\n" +
                        "Eksi sayılar girdi olarak yazılabilir veya çıktı olarak okunabilir.\nYazılım yanlışı söz konusu olduğunda uygulama verilen girdileri kontrol edip yazım yanlışı konusunda sizi uyaracak ve kodun devamını çalıştırmayacaktır.");
            });

            add(button5);

            rb1 = new JRadioButton("Türkçe");
            rb1.setSelected(true);
            rb1.setBounds(420, 0, 80, 30);
            add(rb1);
            rb1.addActionListener(e ->
            {
                locale = true;
                System.out.println(locale);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                label1.setText("Birinci Sayı:");
                label2.setText("İkinci Sayı:");
                label3.setText("Sonuç:");
                button1.setText("Topla");
                button2.setText("Çıkar");
                button3.setText("Çarp");
                button4.setText("Böl");
                setTitle("Kelime Hesap Makinesi");
            });

            rb2 = new JRadioButton("English");
            rb2.setBounds(500, 0, 80, 30);
            add(rb2);
            rb2.addActionListener(e ->
            {
                locale = false;
                System.out.println(locale);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                label1.setText("First Number:");
                label2.setText("Second Number:");
                label3.setText("Result:");
                button1.setText("Sum");
                button2.setText("Subtract");
                button3.setText("Multiply");
                button4.setText("Divide");
                setTitle("Word Calculator");
            });

            ButtonGroup group = new ButtonGroup();
            group.add(rb1);
            group.add(rb2);



            setSize(600, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);


        }

        public static void showWarning() {
            if(locale){
                warningLabel.setText("Lütfen sayıları doğru giriniz.");
            }
            else{
                warningLabel.setText("Please enter the numbers correctly.");
            }
        }


        public static void deleteWarning(){
            warningLabel.setText("");

        }

        public static void divideToZero() {
            JOptionPane.showMessageDialog(null, "Bir sayı sıfıra bölünemez.\n");

        }
        public static void divideToZeroEng() {
            JOptionPane.showMessageDialog(null, "A number cannot be divided by zero.\n");

        }

    }
}