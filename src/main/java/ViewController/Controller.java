package ViewController;

import Model.ComplexNumber;
import Model.UseData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;

import javax.swing.*;

public class Controller extends JFrame {
    iGetModel model;
    iPublisher publisher;
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 14);
    final private Font resultFont = new Font("Segoe print", Font.BOLD, 20);
    JTextField realPart;
    JTextField imaginaryPart;
    JTextArea middlePart;
    JLabel resultPart;

    public void initialize(iGetModel model) {
        this.model = model;
        publisher = new UseData();

        JLabel realPartInPut = new JLabel("Input realPart: ");
        realPartInPut.setFont(mainFont);
        realPart = new JTextField();
        realPart.setFont(mainFont);
        realPart.setText("");

        JLabel imaginaryPartInPut = new JLabel("Input imaginaryPart: ");
        imaginaryPartInPut.setFont(mainFont);
        imaginaryPart = new JTextField();
        imaginaryPartInPut.setFont(mainFont);
        imaginaryPartInPut.setText("");

        middlePart = new JTextArea(10, 10);
        middlePart.setFont(mainFont);
        middlePart.setText("");
        middlePart.setBackground(new Color(0, 200, 255));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 5, 4));
        formPanel.add(realPartInPut);
        formPanel.add(resultPart);
        formPanel.add(imaginaryPartInPut);
        formPanel.add(imaginaryPart);

        JLabel lbWelcome = new JLabel();
        lbWelcome.setFont(resultFont);

        StringBuilder data = new StringBuilder();

        JButton bPlus = new JButton("+");
        bPlus.setFont(mainFont);
        bPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.delete(0, data.length());
                try {

                    double realPartNum = Double.parseDouble(realPart.getText());
                    double imaginaryPartNum = Double.parseDouble(imaginaryPart.getText());
                    ComplexNumber cn = new ComplexNumber(realPartNum, imaginaryPartNum);
                    data.append(cn.toString() + " + ");

                } catch (ConcurrentModificationException a) {

                } catch (NumberFormatException a) {
                    resultPart.setText("You entered data with error or didn't input one of element or all elements");
                }
                realPart.setText("");
                imaginaryPart.setText("");
            }

        });

        JButton bDevision = new JButton("/");
        bPlus.setFont(mainFont);
        bPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.delete(0, data.length());
                try {

                    double realPartNum = Double.parseDouble(realPart.getText());
                    double imaginaryPartNum = Double.parseDouble(imaginaryPart.getText());
                    ComplexNumber cn = new ComplexNumber(realPartNum, imaginaryPartNum);
                    data.append(cn.toString() + " / ");

                } catch (ConcurrentModificationException a) {

                } catch (NumberFormatException a) {
                    resultPart.setText("You entered data with error or didn't input one of element or all elements");
                }
                realPart.setText("");
                imaginaryPart.setText("");
            }

        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                realPart.setText("");
                imaginaryPart.setText("");
                middlePart.setText("");
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(bPlus);
        buttonPanel.add(bDevision);
        buttonPanel.add(bMulti);
        buttonPanel.add(bEqually);
        buttonPanel.add(btnClear);

//        JPanel custumerPanel = new JPanel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(0, 150, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        JPanel outputPanel = new JPanel();
        outputPanel.add(lbWelcome);
        outputPanel.setBackground(new Color(0, 100, 250));


        add(mainPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);


        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 4, 5));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);


        setTitle("VendingMachines");
        setSize(700, 800);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
