package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carta {
    private ImageIcon imagem;
    private ImageIcon sombra;
    private boolean virada;
    private JButton botao;

    public Carta(ImageIcon imagem, ImageIcon sombra, int largura, int altura) {
        this.imagem = redimensionarImagem(imagem, largura, altura);
        this.sombra = redimensionarImagem(sombra, largura, altura);
        this.virada = false;
        this.botao = new JButton(sombra);
        this.botao.setPreferredSize(new Dimension(largura, altura)); // Define o tamanho da carta
        this.botao.setFocusable(false); // Remove o foco do botão
        this.botao.addActionListener(e -> virar());
    }

    private ImageIcon redimensionarImagem(ImageIcon img, int largura, int altura) {
        Image scaledImage = img.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    public void virar() {
        virada = true;
        botao.setIcon(imagem);

        // Desvirar automaticamente após 1 segundo (1000 milissegundos)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desvirar();
            }
        });
        timer.setRepeats(false); // Executa apenas uma vez
        timer.start();
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void esconder() {
        virada = false;
        botao.setIcon(sombra);
    }
    public void desvirar() {
        virada = false;
        botao.setIcon(sombra);
    }


    public boolean estaVirada() {
        return virada;
    }

    public JButton getBotao() {
        return botao;
    }
}
