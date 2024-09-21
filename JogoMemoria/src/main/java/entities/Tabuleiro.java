package entities;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Tabuleiro {
    private List<Carta> cartas;
    private JPanel painel;

    public Tabuleiro(List<Carta> cartas) {
        this.cartas = cartas;
        painel = new JPanel(new GridLayout(4, 4)); // Ajuste conforme necessário
    }

    public void desenhar() {
        for (Carta carta : cartas) {
            painel.add(carta.getBotao());
        }
    }

    public JPanel getPainel() {
        return painel;
    }
}
