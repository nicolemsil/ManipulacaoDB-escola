import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        String endereco = "http://localhost:3000";
        Fila fila = new Fila();

        String acaoDesejada;

        System.out.println("Digite uma letra de acordo com a ação que deseja realizar: \n" +
                "D - para deletar informações; ou \n" +
                "P - para adicionar alguma informação.");

        acaoDesejada = Teclado.getUmString().toUpperCase();

        while (!acaoDesejada.equals("D") && !acaoDesejada.equals("P") && !acaoDesejada.equals("PARAR"))
        {
            System.out.println("Opção inválida!");
            acaoDesejada = Teclado.getUmString().toUpperCase();
        }

        if(acaoDesejada.equals("D"))
        {
            String tabela;
            System.out.println("De qual tabela deseja deletar?\n" +
                    "A - para tabela alunos;\n" +
                    "DI - para tabela disciplinas;\n" +
                    "M - para tabela matrículas; e\n" +
                    "R - para tabela de resultados.");
            tabela = Teclado.getUmString().toUpperCase();

            System.out.println("Digite as informações que deseja adicionar, dando enter");

            String informacao = null;
            informacao = Teclado.getUmString();

            while (!informacao.toLowerCase().equals("parar"))
            {

                if (tabela.equals("A")) {
                    endereco = "http://localhost:3000/alunos";

                    fila.guardeUmItem(Aluno.pegaRAParaDeletar());
                }
                else if (tabela.equals("DI")) {
                    endereco = "http://localhost:3000/disciplinas";

                    Disciplina disciplina = Disciplina.pegaCodParaDeletar();

                    System.out.println("Deletado: " + informacao);
                }
                else if (tabela.equals("M")) {
                    Matricula matricula = Matricula.pegaRAParaDeletar();

                    endereco = "http://localhost:3000/matriculas";

                    System.out.println("Deletado: " + informacao);
                }
                else if (tabela.equals("R")) {
                    Resultado resultado = Resultado.pegaInfoDoResultado();
                    fila.guardeUmItem(resultado);
                    endereco = "http://localhost:3000/resultados";

                    System.out.println("Deletado: " + informacao);
                }

                informacao = Teclado.getUmString();
            }
            System.out.println(fila.toString());

        }
        else if(acaoDesejada.equals("P"))
        {
            String tabela;
            System.out.println("A qual tabela deseja inserir?\n" +
                    "A - para tabela alunos;\n" +
                    "DI - para tabela disciplinas;\n" +
                    "M - para tabela matrículas; e\n" +
                    "R - para tabela de resultados.");
            tabela = Teclado.getUmString().toUpperCase();

            while (!tabela.equals("A") && !tabela.equals("DI") && !tabela.equals("M") && !tabela.equals("R"))
            {
                System.out.println("Selecione uma tabela válida: ");
                tabela = Teclado.getUmString().toUpperCase();
            }


            String informacao = null;
            System.out.println("Para continuar adicionando dê enter, para parar digite 'parar'");
            informacao = Teclado.getUmString();


            while (!informacao.toLowerCase().equals("parar"))
            {

                if (tabela.equals("A")) {
                    Aluno aluno = Aluno.pegaInfoDoUsuario();
                    fila.guardeUmItem(aluno);

                    System.out.println("Adicionado: " + aluno.toString());

                    endereco = "http://localhost:3000/alunos";

                }
                else if (tabela.equals("DI")) {
                    Disciplina disciplina = Disciplina.pegaInfoDaDisciplina();
                    fila.guardeUmItem(disciplina);
                    System.out.println("Adicionado: " + disciplina.toString());

                    endereco = "http://localhost:3000/disciplinas";

                }

                else if (tabela.equals("M")) {
                    Matricula matricula = Matricula.pegaInfoDaMatricula();
                    fila.guardeUmItem(matricula);
                    System.out.println("Adicionado: " + matricula.toString());

                    endereco = "http://localhost:3000/matriculas";

                }

                else if (tabela.equals("R")) {
                    Resultado resultado = Resultado.pegaInfoDoResultado();
                    fila.guardeUmItem(resultado);
                    System.out.println("Adicionado: " + resultado.toString());

                    endereco = "http://localhost:3000/resultados";

                }

                informacao = Teclado.getUmString();
            }
        }

        //conexao com a API
        URL url = new URL (endereco);
        while(!fila.isVazia()) {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  //abre conexao

            if (acaoDesejada.equals("D")) {
                connection.setRequestMethod("DELETE");
            } else {
                connection.setRequestMethod("POST");
            }//fala que quer um post

            connection.setRequestProperty("Content-type", "application/json"); //fala o que vai mandar

            connection.setDoOutput(true); //fala que voce vai enviar algo


            PrintStream printStream = new PrintStream(connection.getOutputStream());

            System.out.println(fila.recupereUmItem().toString());
            printStream.println(fila.recupereUmItem().toString());//seta o que voce vai enviar
            fila.removaUmItem();
            connection.connect();//envia para o servidor
            String jsonDeResposta = new Scanner(connection.getInputStream()).next(); //pega resposta
        }

    }
}
