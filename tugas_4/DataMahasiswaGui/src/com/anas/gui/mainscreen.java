package com.anas.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class mainscreen extends JFrame{
    private JPanel panelMain;
    private JList jListMahasiswa;
    private JButton buttonFilter;
    private JTextField textFieldFilter;
    private JTextField textFieldNIM;
    private JTextField textFieldNama;
    private JTextField textFieldIPK;
    private JButton buttonSave;
    private JButton buttonDelete;
    private JButton buttonClear;
    private List<Mahasiswa> arrayListMahasiswa = new ArrayList<>();
    private DefaultListModel defaultListModel = new DefaultListModel();

    class Mahasiswa{
        private String NIM;
        private String Nama;
        private float IPK;

        public String getNIM() {
            return NIM;
        }

        public void setNIM(String NIM) {
            this.NIM = NIM;
        }

        public String getNama() {
            return Nama;
        }

        public void setNama(String nama) {
            Nama = nama;
        }

        public float getIPK() {
            return IPK;
        }

        public void setIPK(float IPK) {
            this.IPK = IPK;
        }
    }

    public mainscreen() {
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = textFieldNIM.getText();
                String nama = textFieldNama.getText();
                float ipk = Float.parseFloat(textFieldIPK.getText());

                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setIPK(ipk);
                mahasiswa.setNama(nama);
                mahasiswa.setNIM(nim);

                arrayListMahasiswa.add(mahasiswa);
                clearform();

                FromListMahasiswatoListModel();
            }
        });
        jListMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayListMahasiswa.size(); i++){
                    if (arrayListMahasiswa.get(i).getNama().equals(nama)){
                        Mahasiswa mahasiswa = arrayListMahasiswa.get(i);
                        textFieldIPK.setText (String.valueOf(mahasiswa.getIPK()));
                        textFieldNama.setText(mahasiswa.getNama());
                        textFieldNIM.setText(mahasiswa.getNIM());
                        break;
                    }
                }


            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearform();
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;
                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayListMahasiswa.size(); i++){
                    if(arrayListMahasiswa.get(i).getNama().equals(nama)){
                        arrayListMahasiswa.remove(i);
                        break;
                    }
                }

                FromListMahasiswatoListModel();
            }
        });
        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyWord = textFieldFilter.getText();

                List<String> filtered = new ArrayList<>();

                for (int i = 0; i < arrayListMahasiswa.size(); i++ ){
                    if (arrayListMahasiswa.get(i).getNama().contains(keyWord)){
                        filtered.add(arrayListMahasiswa.get(i).getNama());
                    }
                }

                refreshListModel(filtered);
            }
        });
    }
    private void FromListMahasiswatoListModel() {
        List<String> ListNamaMahasiswa = new ArrayList<>();
        for ( int i = 0; i < arrayListMahasiswa.size(); i++) {
            ListNamaMahasiswa.add(
                    arrayListMahasiswa.get(i).getNama()
            );
        }
        refreshListModel(ListNamaMahasiswa);
    }

    private void clearform(){
        textFieldNama.setText("");
        textFieldIPK.setText("");
        textFieldNIM.setText("");
    }
    private void refreshListModel(List<String> List) {
        defaultListModel.clear();
        defaultListModel.addAll(List);
        jListMahasiswa.setModel(defaultListModel);
    }

    public static void main(String[] args) {
        mainscreen mainscreen = new mainscreen();
        mainscreen.setVisible(true);
    }

}
