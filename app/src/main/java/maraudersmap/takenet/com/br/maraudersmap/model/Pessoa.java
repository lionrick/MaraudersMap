package maraudersmap.takenet.com.br.maraudersmap.model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private String macAddress;

    public Pessoa(String nome, String macAddress) {
        this.nome = nome;
        this.macAddress = macAddress;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
