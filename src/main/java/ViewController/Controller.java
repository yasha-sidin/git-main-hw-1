package ViewController;

import Model.ComplexNumber;
import Model.UseData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;

import javax.swing.*;

public class Controller extends JFrame {
    iPublisher publisher;
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 14);
    final private Font resultFont = new Font("Segoe print", Font.BOLD, 20);
    JTextField realPartFn;
    JTextField imaginaryPartFn;
    JTextField realPartSn;
    JTextField imaginaryPartSn;
    JLabel resultPart;

    public void initialize(iPublisher publisher) {
        this.publisher = publisher

        JLabel realPartInPutFn = new JLabel("First num's realPart: ");
        realPartInPutFn.setFont(mainFont);
        realPartFn = new JTextField();
        realPartFn.setFont(mainFont);
        realPartFn.setText("");

        JLabel imaginaryPartInPutFn = new JLabel("First num's imaginaryPart: ");
        imaginaryPartInPutFn.setFont(mainFont);
        imaginaryPartFn = new JTextField();
        imaginaryPartFn.setFont(mainFont);
        imaginaryPartFn.setText("");

        JPanel formPanelFn = new JPanel();
        formPanelFn.setLayout(new GridLayout(10, 1, 5, 4));
        formPanelFn.add(realPartInPutFn);
        formPanelFn.add(realPartFn);
        formPanelFn.add(imaginaryPartInPutFn);
        formPanelFn.add(imaginaryPartFn);

        JLabel realPartInPutSn = new JLabel("Second num's realPart: ");
        realPartInPutSn.setFont(mainFont);
        realPartSn = new JTextField();
        realPartSn.setFont(mainFont);
        realPartSn.setText("");

        JLabel imaginaryPartInPutSn = new JLabel("Second num's imaginaryPart: ");
        imaginaryPartInPutSn.setFont(mainFont);
        imaginaryPartSn = new JTextField();
        imaginaryPartSn.setFont(mainFont);
        imaginaryPartSn.setText("");

        JPanel formPanelSn = new JPanel();
        formPanelSn.setLayout(new GridLayout(10, 1, 5, 4));
        formPanelSn.add(realPartInPutSn);
        formPanelSn.add(realPartSn);
        formPanelSn.add(imaginaryPartInPutSn);
        formPanelSn.add(imaginaryPartSn);

        JPanel formPanel = new JPanel();
        formPanel.add(formPanelFn, BorderLayout.NORTH);
        formPanel.add(formPanelSn, BorderLayout.SOUTH);

        resultPart = new JLabel();
        resultPart.setFont(resultFont);

        Data data = new CalcResultData();
        CalculateComplexNumbers calculator = new CalculateComplexNumbers();

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

                    double realPartNumFn = Double.parseDouble(realPartFn.getText());
                    double imaginaryPartNumFn = Double.parseDouble(imaginaryPartFn.getText());
                    double realPartNumSn = Double.parseDouble(realPartSn.getText());
                    double imaginaryPartNumSn = Double.parseDouble(imaginaryPartSn.getText());

                    ComplexNumber cn1 = new ComplexNumber(realPartNumFn, imaginaryPartNumFn);
                    calculator.setFirstNum(cn1);

                    ComplexNumber cn2 = new ComplexNumber(realPartNumSn, imaginaryPartNumSn);
                    calculator.setSecondNum(cn2);
                    
                    ComplexNumber result = calculator.division(cn1, cn2);
                    data.setData(cn1, cn2, result, "/");
                    
                    resultPart.setText(data.getCalcResultData());
                    publisher.onNewData(data);

                } catch (ConcurrentModificationException a) {

                } catch (NumberFormatException a) {
                    resultPart.setText("You entered data with error or didn't input one of element or all elements");
                }
                realPartFn.setText("");
                imaginaryPartFn.setText("");
                realPartSn.setText("");
                imaginaryPartSn.setText("");
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
        buttonPanel.add(bEqually);hh
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
