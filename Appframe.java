package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import Comdecom.compress;
import Comdecom.decompress;


public class Appframe extends JFrame implements ActionListener {
    JButton compressor;
    JButton Decompressor;
    Appframe(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        compressor=new JButton("select the file to compress");
        Decompressor=new JButton("select the file to decompressor");
        compressor.addActionListener(this);
        Decompressor.addActionListener(this);
        this.add(compressor);
        this.add(Decompressor);
        this.setSize(300,300);
        this.setLocation(500,200);
        this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressor){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    compress.method(file);

                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
        if(e.getSource()==Decompressor){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decompress.method(file);

                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }
}
