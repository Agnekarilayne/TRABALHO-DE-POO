package Trabalho3;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    private  int LINHAS = 20;
    private  int COLUNAS = 20;
    private  int TOTAL = LINHAS * COLUNAS; //20x20	

    private MyPanel[] blocos = new MyPanel[TOTAL]; //vetor 400 posiçoes, cada um com mypanel individual -> um bloco

    private ImageIcon fundoIcon = new ImageIcon(getClass().getResource("/imagensdotrabalho/fundo.png")); //carrega e busca a imagem da pasta


    public JanelaPrincipal() {
        setTitle("Minecraft");
        setSize(640, 640); //tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha quando clica no x

        setLayout(new GridLayout(LINHAS, COLUNAS)); //grade regular 

        for (int i = 0; i < TOTAL; i++) {
            blocos[i] = new MyPanel(fundoIcon);
            add(blocos[i]);
        } //loop para criar e adicionar os 400 painel

        setVisible(true); //torna visivel a janela
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}
