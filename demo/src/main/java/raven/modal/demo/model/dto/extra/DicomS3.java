package raven.modal.demo.model.dto.extra;

import java.io.InputStream;

public class DicomS3 {
    private String nome;
    private String tipo;
    private InputStream arquivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public InputStream getArquivo() {
        return arquivo;
    }

    public void setArquivo(InputStream arquivo) {
        this.arquivo = arquivo;
    }
}
