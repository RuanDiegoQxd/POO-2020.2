import java.util.Scanner;
import java.util.ArrayList;

class Conta {
    int senha;
    int saldo;

    Conta(int senha, int saldo){
        this.senha = senha;
        this.saldo = saldo;
    }

    void depositar(int x){
        if(x<0)
            System.out.println("Fail: depósito inválido");
        else{
            this.saldo += x;
        }
    }
    void tarifa(int x){
        if(x<0)
            System.out.println("Fail: tarifa inválida");
        if((this.saldo - x) < 0)
            System.out.println("Fail: tarifa inválida");
        else{
            this.saldo -= x;
        }
    }
    void sacar(int x){
        if(x<0)
            System.out.println("Fail: saque inválido");
        if((this.saldo - x) < 0)
            System.out.println("Fail: saque inválido");
        else{
            this.saldo -= x;
        }

    }

    public String toString() {
        return "Senha: " + senha + " Saldo: " + saldo;
    }


    public static void main(String[] args) {
        ArrayList<String> extrato = new ArrayList<>();
        extrato.add("0: abertura: 0: 0");
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta(0, 0);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("init")){
                conta = new Conta(Integer.parseInt(ui[1]), 0);
            }
            else if(ui[0].equals("show")){
                System.out.println(conta);
            }
            else if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("depositar")){
                conta.depositar(Integer.parseInt(ui[1]));
                extrato.add("\n" + extrato.size() + ": deposito: " + Integer.parseInt(ui[1]) + ": " + conta.saldo);
            }
            else if(ui[0].equals("sacar")){
                conta.sacar(Integer.parseInt(ui[1]));
                extrato.add("\n" + extrato.size() + ": saque: " + "-" + Integer.parseInt(ui[1]) + ": " + conta.saldo);
            }
            else if(ui[0].equals("tarifa")){
                conta.tarifa(Integer.parseInt(ui[1]));
                extrato.add("\n" + extrato.size() + ": tarifa: " + "-" + Integer.parseInt(ui[1]) + ": " + conta.saldo);
            }
            else if(ui[0].equals("extrato")){
                System.out.println(extrato);
            }
            else if(ui[0].equals("extratoN")){
                int i = extrato.size() - Integer.parseInt(ui[1]);
                for(; i<extrato.size(); i++)
                System.out.println(extrato.get(i));
            }
            else
                System.out.println("Fail: Comando inválido");
        }
        scanner.close();
    }
}

