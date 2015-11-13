package maraudersmap.takenet.com.br.maraudersmap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

public class Local implements Serializable{

    private String nome;
    private String identificador;

    private Object pessoas;

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

    public Object getPessoas() {
        return pessoas;
    }

    public void setPessoas(Object pessoas) {
        this.pessoas = pessoas;
    }
}
