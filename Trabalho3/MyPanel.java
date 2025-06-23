import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Dimension;

public class MyPanel extends JPanel {
    private ImageIcon icon; //declara atributo

    public MyPanel(ImageIcon icon) {
        this.icon = icon;
        setPreferredSize(new Dimension(32, 32)); // define tamanho fixo para cada bloco
        setMaximumSize(new Dimension(32, 32));   // tamanho máximo
        setMinimumSize(new Dimension(32, 32));   // tamanho mínimo
        setOpaque(false); // remove o fundo branco do JPanel
        setBorder(null);  // sem borda
        setLayout(null);  // remove layout padrão
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
