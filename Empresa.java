public class Empresa {
    private Cliente[] clientes = new Cliente[5];
    private Funcionario[] funcionarios = new Funcionario[10];

    private int qtdClientes = 0;
    private int qtdFuncionarios = 0;

    public void adicionarCliente(String nome, String email) {
        if (qtdClientes < clientes.length) {
            clientes[qtdClientes++] = new Cliente(nome, email);
        }
    }

    public String exibirClientes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtdClientes; i++) {
            sb.append("Cliente: ").append(clientes[i].getNome())
              .append(" - ").append(clientes[i].getEmail()).append("\n");
        }
        return sb.toString();
    }

    public void adicionarFuncionario(String nome, String cargo, double salario) {
        if (qtdFuncionarios < funcionarios.length) {
            funcionarios[qtdFuncionarios++] = new Funcionario(nome, cargo, salario);
        }
    }

    public String exibirFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtdFuncionarios; i++) {
            sb.append("Funcionário: ").append(funcionarios[i].getNome())
              .append(" - Cargo: ").append(funcionarios[i].getCargo())
              .append(" - Salário: R$").append(funcionarios[i].getSalario()).append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < qtdFuncionarios; i++) {
            total += funcionarios[i].getSalario();
        }
        return total;
    }

    public double calcularMediaSalarial() {
        if (qtdFuncionarios == 0) return 0;

        Calculadora calc = new Calculadora();
        double soma = 0;

        for (int i = 0; i < qtdFuncionarios; i++) {
            soma = calc.somar(soma, funcionarios[i].getSalario());
        }
        return soma / qtdFuncionarios;
    }
}
