import java.util.List;
import java.util.Objects;

public class Resultado {
    private int RA;
    private int Cod;
    private int Nota;
    private int Freq;

    public Resultado(int RA, int cod, int nota, int freq) {
        this.RA = RA;
        Cod = cod;
        Nota = nota;
        Freq = freq;
    }

    public Resultado () { super(); }

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

    public int getNota() { return Nota; }

    public void setNota(int nota) {
        Nota = nota;
    }

    public int getFreq() {
        return Freq;
    }

    public void setFreq(int freq) {
        Freq = freq;
    }


    public static Resultado pegaInfoDoResultado() throws Exception {
        Fila fila = new Fila();
        Resultado resultado = new Resultado();

        System.out.println("Digite RA: ");
        int ra = Teclado.getUmInt();
        while (ra < 9999 || ra > 99999)
        {
            System.out.println("Digite um RA válido: ");
            ra = Teclado.getUmInt();
        }
        resultado.setRA(ra);

        System.out.println("Digite o código: ");
        int cod;
        cod = Teclado.getUmInt();
        while (cod < 99 || cod > 1000)
        {
            System.out.println("Digite um código válido: ");
            cod = Teclado.getUmInt();
        }
        resultado.setCod(cod);

        System.out.println("Digite a nota: ");
        int nota;
        nota = Teclado.getUmInt();
        while (nota < 0 || nota > 10)
        {
            System.out.println("Digite uma nota válida: ");
            nota = Teclado.getUmInt();
        }
        resultado.setNota(nota);

        System.out.println("Digite a frequência: ");
        int freq;
        freq = Teclado.getUmInt();
        while (freq < 0 || freq > 10)
        {
            System.out.println("Digite uma frequência válida: ");
            freq = Teclado.getUmInt();
        }
        resultado.setFreq(freq);

        fila.guardeUmItem(resultado);


        return resultado;
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


    public String toString() {
        return  "{" +
                "\"RA\":" + RA +
                " , \"Cod\":" + Cod +
                " , \"Nota\":" + Nota +
                " , \"Freq\":" + Freq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resultado resultado = (Resultado) o;
        return RA == resultado.RA && Cod == resultado.Cod && Nota == resultado.Nota && Freq == resultado.Freq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RA, Cod, Nota, Freq);
    }
}
