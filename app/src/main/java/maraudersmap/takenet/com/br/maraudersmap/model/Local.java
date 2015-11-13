package maraudersmap.takenet.com.br.maraudersmap.model;

import java.io.Serializable;

public class Local implements Serializable{

    private String nome;
    private String identificador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
