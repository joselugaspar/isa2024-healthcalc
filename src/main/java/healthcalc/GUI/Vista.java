package healthcalc.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField resultPesoIdeal;
    private JTextField resultBMR;
    private JSpinner sEdad;
    private JSpinner sAltura;
    private JSpinner sPeso;
    private JRadioButton rdbtnHombre;
    private JRadioButton rdbtnMujer;
    private JButton btnPesoIdeal;
    private JButton btnCalcularBmr;

    public Vista() {
        setTitle("<html><i>Welcome to your health calculator!</i></html>");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());

        JLabel lblNewLabel = new JLabel("Welcome to your health calculator");
        lblNewLabel.setForeground(new Color(147, 112, 219)); 
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
        panel.add(lblNewLabel, BorderLayout.NORTH);

        JPanel centralpanel = new JPanel();
        centralpanel.setLayout(new GridLayout(2, 1));
        panel.add(centralpanel, BorderLayout.CENTER);

        JPanel panel1 = new JPanel();
        centralpanel.add(panel1);
        panel1.setLayout(new GridLayout(4, 1));

        JPanel pAltura = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel1.add(pAltura);

        JLabel lblAltura = new JLabel("Altura");
        lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltura.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        sAltura = new JSpinner();
        sAltura.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        sAltura.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sAltura.setPreferredSize(new Dimension(60, sAltura.getPreferredSize().height));

        pAltura.add(lblAltura);
        pAltura.add(sAltura);

        JPanel pEdad = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel1.add(pEdad);

        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
        lblEdad.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        sEdad = new JSpinner();
        sEdad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sEdad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sEdad.setPreferredSize(new Dimension(60, sEdad.getPreferredSize().height));

        pEdad.add(lblEdad);
        pEdad.add(sEdad);

        JPanel pPeso = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel1.add(pPeso);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
        lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        SpinnerNumberModel model = new SpinnerNumberModel(0.1, 0.00001, null, 0.1);
        sPeso = new JSpinner(model);
        sPeso.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sPeso.setPreferredSize(new Dimension(60, sPeso.getPreferredSize().height));

        pPeso.add(lblPeso);
        pPeso.add(sPeso);

        JPanel pGenero = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5, 10));
        panel1.add(pGenero);

        JLabel lblGenero = new JLabel("Género");
        lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
        lblGenero.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        rdbtnMujer = new JRadioButton("Mujer");
        rdbtnMujer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtnMujer.setSelected(true);

        rdbtnHombre = new JRadioButton("Hombre");
        rdbtnHombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rdbtnHombre);
        grupoGenero.add(rdbtnMujer);

        pGenero.add(lblGenero);
        pGenero.add(rdbtnMujer);
        pGenero.add(rdbtnHombre);

        JPanel panel2 = new JPanel();
        centralpanel.add(panel2);
        panel2.setLayout(new GridLayout(2, 1));

        JPanel pPi = new JPanel();
        pPi.setLayout(new BoxLayout(pPi, BoxLayout.Y_AXIS));
        pPi.setBackground(new Color(255, 255, 255)); 
        pPi.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        panel2.add(pPi);

        JPanel pBmr = new JPanel();
        pBmr.setBackground(new Color(255, 255, 255)); 
        pBmr.setLayout(new BoxLayout(pBmr, BoxLayout.Y_AXIS));
        pBmr.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        panel2.add(pBmr);

        btnCalcularBmr = new JButton("BMR");
        btnCalcularBmr.setBackground(new Color(147, 112, 219));
        btnCalcularBmr.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCalcularBmr.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        btnPesoIdeal = new JButton("Peso Ideal");
        btnPesoIdeal.setBackground(new Color(147, 112, 219));
        btnPesoIdeal.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPesoIdeal.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        resultPesoIdeal = new JTextField();
        resultPesoIdeal.setHorizontalAlignment(SwingConstants.CENTER);
        resultPesoIdeal.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        resultBMR = new JTextField();
        resultBMR.setHorizontalAlignment(SwingConstants.CENTER);
        resultBMR.setFont(new Font("Times New Roman", Font.PLAIN, 15));


        pPi.add(Box.createVerticalStrut(20));
        pPi.add(btnPesoIdeal);
        pPi.add(Box.createVerticalStrut(15));
        pPi.add(resultPesoIdeal);
        pPi.add(Box.createVerticalStrut(20));
        pBmr.add(Box.createVerticalStrut(20));
        pBmr.add(btnCalcularBmr);
        pBmr.add(Box.createVerticalStrut(15));
        pBmr.add(resultBMR);
        pBmr.add(Box.createVerticalStrut(20));

        pack();
        setVisible(true);
    }

    public void setResultBMR(float resultado) {
        resultBMR.setText(String.valueOf(resultado) + " cal/día");
    }

    public void setResultPI(float resultado) {
        resultPesoIdeal.setText(String.valueOf(resultado) + " kg");
    }

    public void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int getEdad() {
        return (Integer) sEdad.getValue();
    }

    public int getAltura() {
        return (Integer) sAltura.getValue();

    }

    public float getPeso() {
        return ((Double) sPeso.getValue()).floatValue();

    }

    public char getGenero() {
        if (rdbtnMujer.isSelected()) {
            return 'w';
        } else {
            return 'm';
        }
    }

    public void registrarControlador(ActionListener controlador) {
        btnPesoIdeal.addActionListener(controlador);
        btnPesoIdeal.setActionCommand("Calcular Peso Ideal");
        btnCalcularBmr.addActionListener(controlador);
        btnCalcularBmr.setActionCommand("Calcular BMR");
    }
}
