package Trabalho3;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class MyPanel extends JPanel {
    private ImageIcon icon; //declara atributo

    public MyPanel(ImageIcon icon) {
        this.icon = icon;
    } //construtor da classe

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        repaint(); //atualizar o painel caso a imagem mude
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //metodo do JPanel que garante que a tela fique limpa antes de desenhar algo novo


        if (icon != null) {
            g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null); //desenho da imagem,coordenadas onde começa, altura e largura(...)
        }
    }
}
