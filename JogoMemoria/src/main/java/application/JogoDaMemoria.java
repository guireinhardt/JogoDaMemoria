package application;

import entities.Tabuleiro;
import entities.Carta;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogoDaMemoria {
    private List<Carta> cartas;
    private Carta primeiraCarta = null;

    public JogoDaMemoria() {
        inicializarCartas();
        embaralhar();
        criarGUI();
    }

    private void inicializarCartas() {
        cartas = new ArrayList<>();
        // Adicione cartas com suas imagens e sombras
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8902111.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        cartas.add(new Carta(new ImageIcon("src/main/imgs/8895005.jpg"), new ImageIcon("src/main/imgs/images.png"), 150, 150));
        // Adicione mais cartas conforme necessário
    }

    private void embaralhar() {
        Collections.shuffle(cartas);
    }

    private void criarGUI() {
        JFrame frame = new JFrame("Jogo da Memória com Sombras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Tabuleiro tabuleiro = new Tabuleiro(cartas);
        tabuleiro.desenhar();

        frame.add(tabuleiro.getPainel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void cartaSelecionada(Carta carta) {
        if (primeiraCarta == null) {
            primeiraCarta = carta;
            carta.virar(); // Vira a primeira carta
        } else {
            carta.virar(); // Vira a segunda carta
            verificarPareamento(carta);
        }
    }

    private void verificarPareamento(Carta segundaCarta) {
        if (primeiraCarta.getImagem().equals(segundaCarta.getImagem())) {
            // Se as imagens forem iguais, mantenha as cartas viradas
            primeiraCarta = null; // Reseta a primeira carta
        } else {
            // Se não forem iguais, desvira as cartas após um tempo
            Timer timer = new Timer(1000, e -> {
                primeiraCarta.desvirar();
                segundaCarta.desvirar();
                primeiraCarta = null; // Reseta a primeira carta
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JogoDaMemoria());
    }
}
