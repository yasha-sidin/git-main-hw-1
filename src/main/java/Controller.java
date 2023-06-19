import Domen.Product;
import VendingMachines.VendingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

import javax.swing.*;
import javax.swing.border.Border;

public class Controller extends JFrame {
    iGetView view;
    iGetModel model;
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 14);
    JTextField amountOfMoney;
    JTextField idName;
    JTextArea textArea;
    JLabel lbWelcome;
    JScrollPane scroll;
    public void initialize(iGetView view, iGetModel model) {
        this.model = model;
        this.view = view;

        JLabel lbIdName = new JLabel("Choose product(id): ");
        lbIdName.setFont(mainFont);
        idName = new JTextField();
        idName.setFont(mainFont);
        idName.setText("");

        JLabel lbMoney = new JLabel("Enter money to VM: ");
        lbMoney.setFont(mainFont);
        amountOfMoney = new JTextField();
        amountOfMoney.setFont(mainFont);
        amountOfMoney.setText("");

        textArea = new JTextArea(10, 10);
        textArea.setFont(mainFont);
        textArea.setText("All products:\n" + iMachine.getStringProducts());
        textArea.setBackground(new Color(0, 200, 255));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 5, 4));
        formPanel.add(lbIdName);
        formPanel.add(idName);
        formPanel.add(lbMoney);
        formPanel.add(amountOfMoney);

        JLabel lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        JButton btnOk = new JButton("Buy");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double yourMoney = Double.parseDouble(amountOfMoney.getText());
                    int idProduct = Integer.parseInt(idName.getText());
                    if (idProduct < 0) {
                        lbWelcome.setText("Id must be grater than zero");
                        return;
                    }
                    if (!iMachine.contains(idProduct)) {
                        lbWelcome.setText("Vending Machine don't have product with this Id");
                        idName.setText("");
                        amountOfMoney.setText("");
                        return;
                    }
                    for (Product item : iMachine.getProducts()) {
                        if (item.getProductId() == idProduct) {
                            String buyingResult = iMachine.buyProduct(item, yourMoney);
                            lbWelcome.setText(buyingResult);
                            textArea.setText("All products:\n" + iMachine.getStringProducts());
                        }
                    }
                    if (iMachine.getProducts().isEmpty()) {
                        lbWelcome.setText("Oh. Product's list is empty:(");
                        textArea.setText("Product's list is empty:(");
                    }

                } catch (ConcurrentModificationException a) {

                } catch (NumberFormatException a) {
                    lbWelcome.setText("You entered data with error or didn't input one of element or all elements");
                }
                idName.setText("");
                amountOfMoney.setText("");

            }



        });


        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                idName.setText("");
                lbWelcome.setText("");
                amountOfMoney.setText("");
            }

        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(btnOk);
        buttonPanel.add(btnClear);

//        JPanel custumerPanel = new JPanel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(0, 150, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane (
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



        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,4,5));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);


        setTitle("VendingMachines");
        setSize(700, 800);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
