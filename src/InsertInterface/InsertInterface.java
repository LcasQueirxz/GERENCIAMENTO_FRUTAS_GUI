package InsertInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertInterface {
    private ArrayList<String> frutas; // utilizando os arrays para tirar e colocar o que eu quero
    private DefaultListModel<String> listModel; // aplicando e estruturando a minha interface
    private JList<String> list; // aplicando e estruturando a minha interface

    public InsertInterface() {
        frutas = new ArrayList<>(); // utilizando os arrays para tirar e colocar o que eu quero
        listModel = new DefaultListModel<>(); // aplicando e estruturando a minha interface

        JFrame frame = new JFrame("Gerenciador de Frutas"); // aplicando e estruturando a minha interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(); // aplicando e estruturando a minha interface
        panel.setLayout(new FlowLayout());

        JTextField frutaField = new JTextField(15); // aplicando e estruturando a minha interface
        panel.add(frutaField);

        JButton addButton = new JButton("Adicionar"); // aplicando e estruturando a minha interface
        panel.add(addButton);

        JButton modifyButton = new JButton("Modificar"); // aplicando e estruturando a minha interface
        modifyButton.setEnabled(false);
        panel.add(modifyButton);

        JButton removeButton = new JButton("Remover"); // aplicando e estruturando a minha interface
        removeButton.setEnabled(false);
        panel.add(removeButton);

        frame.add(panel, BorderLayout.NORTH);

        list = new JList<>(listModel); // aplicando e estruturando a minha interface
        JScrollPane scrollPane = new JScrollPane(list); // aplicando e estruturando a minha interface
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton listButton = new JButton("Listar Frutas"); // aplicando e estruturando a minha interface
        frame.add(listButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaFruta = frutaField.getText();
                if (!novaFruta.isEmpty()) {
                    frutas.add(novaFruta); // utilizando os arrays para tirar e colocar o que eu quero
                    listModel.addElement(novaFruta); // aplicando dados que eu quero que sejam exibidos
                    frutaField.setText("");
                    JOptionPane.showMessageDialog(frame, novaFruta + " foi adicionada.");
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String frutaSelecionada = listModel.getElementAt(selectedIndex);
                    String novaFruta = JOptionPane.showInputDialog(frame, "Modificar " + frutaSelecionada + " para:", frutaSelecionada);
                    if (novaFruta != null && !novaFruta.isEmpty()) {
                        frutas.set(selectedIndex, novaFruta); // utilizando os arrays para tirar e colocar o que eu quero
                        listModel.set(selectedIndex, novaFruta); // aplicando dados que eu quero que sejam exibidos
                        JOptionPane.showMessageDialog(frame, "Fruta " + frutaSelecionada + " foi modificada para " + novaFruta);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione uma fruta para modificar.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String frutaRemovida = frutas.remove(selectedIndex); // utilizando os arrays para tirar e colocar o que eu quero
                    listModel.remove(selectedIndex); // aplicando dados que eu quero que sejam exibidos
                    JOptionPane.showMessageDialog(frame, frutaRemovida + " foi removida.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione uma fruta para remover.");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frutas.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhuma fruta na lista.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Frutas: " + frutas); // mostrando como eu quero estruturar o chamado para a lista
                }
            }
        });

        list.addListSelectionListener(e -> {
            boolean selectionExists = !list.isSelectionEmpty();
            removeButton.setEnabled(selectionExists);
            modifyButton.setEnabled(selectionExists);
        });

        frame.setVisible(true); // aplicando e estruturando a minha interface
    }

    public static void main(String[] args) {
        new InsertInterface(); // aplicando e estruturando a minha interface
    }
}
