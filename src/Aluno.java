import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private int RA;

    public String getNome() {
        return nome;
    }

    public Aluno() {
        super();
    }

    public Aluno(String nome, int ra) {
        this.nome = nome;
        this.RA = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public static Aluno pegaInfoDoUsuario() throws Exception {
        Aluno aluno = new Aluno();

        System.out.println("Digite RA: ");
        int ra = Teclado.getUmInt();
        while (ra < 9999 || ra > 99999)
        {
            System.out.println("Digite um RA válido: ");
            ra = Teclado.getUmInt();
        }
        aluno.setRA(ra);

        System.out.println("Digite o nome do aluno: ");
        String nome = Teclado.getUmString();
        aluno.setNome(nome);

        return aluno;
    }

    public static Aluno pegaRAParaDeletar() throws Exception {
        Aluno aluno = new Aluno();

        System.out.println("Digite RA: ");
        int ra = Teclado.getUmInt();
        while (ra < 9999 || ra > 99999)
        {
            System.out.println("Digite um RA válido: ");
            ra = Teclado.getUmInt();
        }
        aluno.setRA(ra);

        return aluno;
    }

    @Override
    public String toString() {
        return  "{" +
                "\"nome\":\"" + nome + '"' +
                " , \"RA\":" + RA +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return RA == aluno.RA && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, RA);
    }
}
