import java.util.List;
import java.util.Objects;

public class Disciplina {
    private int Cod;
    private String Nome;

    public  Disciplina() {
        super();
    }

    public Disciplina(int cod, String nome) {
        Cod = cod;
        Nome = nome;
    }

    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    public static Disciplina pegaInfoDaDisciplina() throws Exception {
        Fila fila = new Fila();
        Disciplina disciplina = new Disciplina();

        System.out.println("Digite o código: ");
        int cod;
        cod = Teclado.getUmInt();
        while (cod < 99 || cod > 1000)
        {
            System.out.println("Digite um código válido: ");
            cod = Teclado.getUmInt();
        }
        disciplina.setCod(cod);

        System.out.println("Digite o nome da disciplina: ");
        String nome = Teclado.getUmString();
        disciplina.setNome(nome);

        fila.guardeUmItem(disciplina);

        return disciplina;
    }

    public static Disciplina pegaCodParaDeletar() throws Exception {
        Disciplina disciplina = new Disciplina();

        System.out.println("Digite o codigo: ");
        int cod = Teclado.getUmInt();
        while (cod < 99 || cod > 1000)
        {
            System.out.println("Digite um codigo válido: ");
            cod = Teclado.getUmInt();
        }
        disciplina.setCod(cod);

        return disciplina;
    }

    @Override
    public String toString() {
        return  "Disciplina = {" +
                "Cod:" + Cod +
                " , nome:" + '"' +  Nome + '"' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Cod == that.Cod && Objects.equals(Nome, that.Nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cod, Nome);
    }
}
