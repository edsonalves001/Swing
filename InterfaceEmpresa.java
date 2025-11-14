import javax.swing.*;
import java.awt.*;

public class InterfaceEmpresa extends JFrame {

    Empresa empresa = new Empresa();

    public InterfaceEmpresa() {
        setTitle("Sistema Empresa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JButton btnAddCliente = new JButton("Adicionar Cliente");
        JButton btnExibirClientes = new JButton("Exibir Clientes");
        JButton btnAddFuncionario = new JButton("Adicionar Funcionário");
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        JButton btnFolha = new JButton("Calcular Folha Salarial");
        JButton btnMedia = new JButton("Exibir Média Salarial");

        btnAddCliente.addActionListener(e -> adicionarCliente());
        btnExibirClientes.addActionListener(e -> exibir(empresa.exibirClientes()));
        btnAddFuncionario.addActionListener(e -> adicionarFuncionario());
        btnExibirFuncionarios.addActionListener(e -> exibir(empresa.exibirFuncionarios()));
        btnFolha.addActionListener(e -> exibir("Folha Salarial Total: R$ " + empresa.calcularFolhaSalarial()));
        btnMedia.addActionListener(e -> exibir("Média Salarial: R$ " + empresa.calcularMediaSalarial()));

        add(btnAddCliente);
        add(btnExibirClientes);
        add(btnAddFuncionario);
        add(btnExibirFuncionarios);
        add(btnFolha);
        add(btnMedia);

        setVisible(true);
    }

    private void adicionarCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        String email = JOptionPane.showInputDialog("Email do cliente:");
        empresa.adicionarCliente(nome, email);
    }

    private void adicionarFuncionario() {
        String nome = JOptionPane.showInputDialog("Nome do funcionário:");
        String cargo = JOptionPane.showInputDialog("Cargo do funcionário:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário: "));
        empresa.adicionarFuncionario(nome, cargo, salario);
    }

    private void exibir(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }

    public static void main(String[] args) {
        new InterfaceEmpresa();
    }
}
