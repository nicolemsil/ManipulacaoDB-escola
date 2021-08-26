import java.util.List;
import java.util.Objects;

public class Matricula {
    private int RA;
    private int Cod;

    public Matricula() {
        super ();
    }

    public Matricula(int RA, int Cod) {
        this.RA = RA;
        this.Cod = Cod;
    }

    public int getRA() {
        return RA;
    }


    public void setRA(int RA) {
        this.RA = RA;
    }

    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public static Matricula pegaInfoDaMatricula() throws Exception {
        Fila fila = new Fila();
        Matricula matricula = new Matricula();

        System.out.println("Digite RA: ");
        int ra = Teclado.getUmInt();
        while (ra < 9999 || ra > 99999)
        {
            System.out.println("Digite um RA válido: ");
            ra = Teclado.getUmInt();
        }
        matricula.setRA(ra);

        System.out.println("Digite o código: ");
        int cod;
        cod = Teclado.getUmInt();
        while (cod < 99 || cod > 1000)
        {
            System.out.println("Digite um código válido: ");
            cod = Teclado.getUmInt();
        }
        matricula.setCod(cod);

        fila.guardeUmItem(matricula);

        return matricula;
    }

    public static Matricula pegaRAParaDeletar() throws Exception {
        Matricula matricula = new Matricula();

        System.out.println("Digite RA: ");
        int ra = Teclado.getUmInt();
        while (ra < 9999 || ra > 99999)
        {
            System.out.println("Digite um RA válido: ");
            ra = Teclado.getUmInt();
        }
        matricula.setRA(ra);

        return matricula;
    }

    @Override
    public String toString() {
        return  "Matricula = {" +
                "RA:" + RA +
                " , Cod:" + Cod +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return RA == matricula.RA && Cod == matricula.Cod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RA, Cod);
    }
}
