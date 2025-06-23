import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    private  int LINHAS = 20;
    private  int COLUNAS = 20;
    private  int TOTAL = LINHAS * COLUNAS; //20x20

    private MyPanel[] blocos = new MyPanel[TOTAL]; //vetor 400 posiçoes, cada um com mypanel individual -> um bloco

    private ImageIcon fundoIcon = new ImageIcon(getClass().getResource("/imagens/fundo.png")); //carrega e busca a imagem da pasta

    private int posAv = 0;
    private int[] tiposBlocos = new int[TOTAL]; // guarda tipo de cada bloco
    private ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/imagens/avatar.png"));
    private ImageIcon[] imagensBlocos = {
            new ImageIcon(getClass().getResource("/imagens/terra.png")), // 0
            new ImageIcon(getClass().getResource("/imagens/grama.png")), // 1
            new ImageIcon(getClass().getResource("/imagens/tijolo.png")), // 2
            new ImageIcon(getClass().getResource("/imagens/flor.png")), // 3
            new ImageIcon(getClass().getResource("/imagens/fundo.png"))  // 4
    };
    private void desenharAvatar() {
        for (int i = 0; i < TOTAL; i++) {
            blocos[i].setIcon(imagensBlocos[tiposBlocos[i]]);
        }
        blocos[posAv].setIcon(avatarIcon); // desenha avatar na posição atual
    }
    private void moverOuConstruir(java.awt.event.KeyEvent e) { //metodo para mover e colocar peça
        int key = e.getKeyCode();
        switch (key) {
            case java.awt.event.KeyEvent.VK_LEFT:
                if (posAv % COLUNAS != 0) posAv--;
                break;
            case java.awt.event.KeyEvent.VK_RIGHT:
                if (posAv % COLUNAS != COLUNAS - 1) posAv++;
                break;
            case java.awt.event.KeyEvent.VK_UP:
                if (posAv >= COLUNAS) posAv -= COLUNAS;
                break;
            case java.awt.event.KeyEvent.VK_DOWN:
                if (posAv < TOTAL - COLUNAS) posAv += COLUNAS;
                break;
            case java.awt.event.KeyEvent.VK_1:
                tiposBlocos[posAv] = BlocoTipo.Bloco1;
                break;
            case java.awt.event.KeyEvent.VK_2:
                tiposBlocos[posAv] = BlocoTipo.Bloco2;
                break;
            case java.awt.event.KeyEvent.VK_3:
                tiposBlocos[posAv] = BlocoTipo.Bloco3;
                break;
            case java.awt.event.KeyEvent.VK_4:
                tiposBlocos[posAv] = BlocoTipo.Bloco4;
                break;
            case java.awt.event.KeyEvent.VK_SPACE:
                tiposBlocos[posAv] = BlocoTipo.Fundo;
                break;
        }
        desenharAvatar();
    }

    public JanelaPrincipal() {
        setTitle("Minecraft");
        setSize(640, 640); //tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha quando clica no x

        setLayout(new GridLayout(LINHAS, COLUNAS, 0, 0)); //grade regular SEM espaçamento entre os blocos

        for (int i = 0; i < TOTAL; i++) {
            tiposBlocos[i] = BlocoTipo.Fundo;
            blocos[i] = new MyPanel(fundoIcon);
            add(blocos[i]);
        } //loop para criar e adicionar os 400 painel

        desenharAvatar();//chamando a função desenhar avatar

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                moverOuConstruir(e);
            }
        });

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setVisible(true); //torna visivel a janela
        setResizable(false); // Impede que a janela mude de tamanho e distorça o grid
    }

    private ImageIcon redimensionarImagem(String caminho) {
        Image img = new ImageIcon(getClass().getResource(caminho)).getImage();
        return new ImageIcon(img.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {

        new JanelaPrincipal();
    }
}
