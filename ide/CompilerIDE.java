import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CompilerIDE extends JFrame {

    private JTextArea editorArea;
    private JTextArea outputArea;

    public CompilerIDE() {
        setTitle("IDE - Compilador");
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarComponentes();
    }

    private void criarComponentes() {
        // Cores
        Color fundoJanela = new Color(245, 247, 250);
        Color fundoEditor = Color.WHITE;
        Color fundoSaida = new Color(250, 250, 250);
        Color corBorda = new Color(180, 190, 200);
        Color corBotao = new Color(52, 120, 246);
        Color corTextoBotao = Color.WHITE;
        Color corTitulo = new Color(60, 63, 65);

        // Fonte
        Font fonteCodigo = new Font("Monospaced", Font.PLAIN, 14);
        Font fonteTitulo = new Font("SansSerif", Font.BOLD, 14);
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 14);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        painelPrincipal.setBackground(fundoJanela);

        // Editor de código
        editorArea = new JTextArea();
        editorArea.setFont(fonteCodigo);
        editorArea.setBackground(fundoEditor);
        editorArea.setForeground(Color.BLACK);
        editorArea.setCaretColor(Color.BLACK);
        editorArea.setTabSize(4);
        editorArea.setLineWrap(false);

        JScrollPane editorScroll = new JScrollPane(editorArea);
        editorScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(corBorda, 1),
                "Código-fonte",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fonteTitulo,
                corTitulo
        ));

        // Saída
        outputArea = new JTextArea();
        outputArea.setFont(fonteCodigo);
        outputArea.setEditable(false);
        outputArea.setBackground(fundoSaida);
        outputArea.setForeground(new Color(40, 40, 40));
        outputArea.setCaretColor(Color.BLACK);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(corBorda, 1),
                "Saída / Mensagens",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fonteTitulo,
                corTitulo
        ));

        // Split entre editor e saída
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editorScroll, outputScroll);
        splitPane.setDividerLocation(380);
        splitPane.setResizeWeight(0.7);
        splitPane.setBorder(null);

        // Botão compilar
        JButton botaoCompilar = new JButton("Compilar");
        botaoCompilar.setFont(fonteBotao);
        botaoCompilar.setFocusPainted(false);
        botaoCompilar.setBackground(corBotao);
        botaoCompilar.setForeground(corTextoBotao);
        botaoCompilar.setPreferredSize(new Dimension(140, 40));
        botaoCompilar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botaoCompilar.addActionListener(e -> compilar());

        // Painel inferior
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelInferior.setBackground(fundoJanela);
        painelInferior.add(botaoCompilar);

        // Cabeçalho simples
        JLabel titulo = new JLabel("Ambiente de Desenvolvimento Integrado - Compilador");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setForeground(new Color(35, 35, 35));

        JLabel subtitulo = new JLabel("Digite o código-fonte, execute a análise sintática e visualize as mensagens.");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitulo.setForeground(new Color(90, 90, 90));

        JPanel painelTopo = new JPanel();
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));
        painelTopo.setBackground(fundoJanela);
        painelTopo.add(titulo);
        painelTopo.add(Box.createVerticalStrut(5));
        painelTopo.add(subtitulo);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(splitPane, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        add(painelPrincipal);
    }

    private void compilar() {
        String codigo = editorArea.getText();

        try {
            GalsParserBridge parser = new GalsParserBridge();
            String resultado = parser.analisar(codigo);
            outputArea.setText(resultado);
        } catch (Exception ex) {
            outputArea.setText("Erro:\n" + ex.getMessage());
        }
    }
}