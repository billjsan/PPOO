package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Objects;

public class MainWindow extends JFrame {

    private static final String TEXTO_DO_CABECALHO = "Algoritmos de ordenação";
    private final String TITULO_APP = "Algoritmos de ordenação";
    private String TEXTO_BOTAO = "click me";
    private JSpinner seletor;

    public MainWindow() throws HeadlessException {
        super();
        createWindow();
    }

    private void createWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1000, 700));
        this.setLocation(getWidth() / 2, getHeight() / 3);
        this.setTitle(TITULO_APP);
        Container janela = getContentPane();
        this.setLayout(new BoxLayout(janela, BoxLayout.Y_AXIS));


        //cria painel de titulo
        JPanel painelDeTitulo = new JPanel();
        painelDeTitulo.setLayout(new BoxLayout(painelDeTitulo, BoxLayout.X_AXIS));

        //cria painel de menus
        JPanel painelDeMenu = new JPanel();
        BoxLayout boxLayout = new BoxLayout(painelDeMenu, BoxLayout.X_AXIS);
        painelDeMenu.setLayout(boxLayout);

        //cria o texto para o painel de titulo
        JLabel textoDoCabecalho = new JLabel(TEXTO_DO_CABECALHO);
        textoDoCabecalho.setFont(new Font("default", Font.BOLD, 30));
        textoDoCabecalho.setToolTipText(TEXTO_DO_CABECALHO);

        //cria botao
        TEXTO_BOTAO = "Click me";
        JButton botao = new JButton(TEXTO_BOTAO);
        botao.setMaximumSize(new Dimension(100,50));
        botao.setToolTipText(TEXTO_BOTAO);

        //cria input
        seletor = new JSpinner(new SpinnerNumberModel(1,1,
                200,1));
        seletor.setMaximumSize(new Dimension(100,50));

        //cria parte desenhavel
        JPanel painel = new JPanel();
        painel.setBackground(Color.red);


        //acoes
        painelDeTitulo.add(textoDoCabecalho);

        painelDeMenu.add(seletor);
        painelDeMenu.add(botao);

        //painel desenhavel
        MyPanel myPanel = new MyPanel();

        janela.add(painelDeTitulo);
        janela.add(painelDeMenu);
        janela.add(myPanel);

        BotaoHandler botaoHandler = new BotaoHandler();
        botao.addActionListener(botaoHandler);

        this.setVisible(true);

    }

    private class BotaoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String actionCommand = event.getActionCommand();
            System.out.println(actionCommand);
            System.out.println(seletor.getValue());

        }
    }
//
//        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
//
        //this.setLayout(null);
//        painelSuperior.setBackground(Color.red);
//        //painelSuperior.setSize(200,2000);
//
//       // JLabel  label = new JLabel("Meu APP");
//        //label.setFont(new Font("serial", Font.BOLD, 35));
//
//
        //this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //panel_1.setPreferredSize(new Dimension(200,getHeight()));
//        JPanel novoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
//        panel_1.setMaximumSize(new Dimension(200,20));
        //panel_1.setSize(this.getWidth()/2,this.getHeight()/2);
//
//        this.add(novoPainel);
//
//        JPanel painelDoMeio = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        JSpinner jSpinner = new JSpinner(
//                new SpinnerNumberModel(1,1,200,1));
//
//        JButton button = new JButton("Olar");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                System.out.println(jSpinner.getValue());
//                System.out.println("lalala");
//            }
//        });
//        painelDoMeio.add(button);
//
//        painelDoMeio.add(jSpinner);
//
//        this.add(painelDoMeio);
//        //painelSuperior.add(label);
//        this.add(painelSuperior);
//
//         MyPanel meuPainel = new MyPanel();
//
//        this.add(meuPainel);
//    }

//    public static void main(String[] args) {


//        Inter teste = new A();
//        teste.teste();
//        teste = new B();
//        teste.teste();
//        teste = new C();
//        teste.teste();
//
//        teste = new Inter() {
//            @Override
//            public void teste() {
//                System.out.println("eu chero peido");
//            }
//        };
//
//        teste.teste();


//        String texto = criptografa("willian");
//
//        System.out.println(criptografa(texto));
//
//        System.out.println(decriptografa(texto));

//
//        MainWindow mw = new MainWindow();
//        mw.createWindow();
//
//        Object t = new Teste();
//
//        if(t instanceof Teste k){
//
//            k.teste();
//        }

//    }

//    private static String criptografa(String texto){
//
//        return new String(Base64.getEncoder().
//        encode(texto.getBytes(StandardCharsets.UTF_8)));
//
//    }
//
//    private static String decriptografa(String texto){
//        return new String(Base64.getDecoder()
//        .decode(texto.getBytes(StandardCharsets.UTF_8)));
//    }
//


}
