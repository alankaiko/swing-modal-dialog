package raven.modal.demo.model.laudos;

import raven.modal.demo.model.enuns.EnumModelo;
import raven.modal.demo.model.enuns.StatusLaudo;

import javax.persistence.*;

@Entity
@Table(name = "laudo")
public class Laudo {
    private Long codigo;
    private StatusLaudo status;
    private EnumModelo modelo;
    private String texto;
//    private Topico topico;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public StatusLaudo getStatus() {
        return status;
    }

    public void setStatus(StatusLaudo status) {
        this.status = status;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "tbl_topico_id", referencedColumnName = "codigo")
//    public Topico getTopico() {
//        return topico;
//    }
//
//    public void setTopico(Topico topico) {
//        this.topico = topico;
//    }

    @Enumerated(EnumType.STRING)
    public EnumModelo getModelo() {
        return modelo;
    }

    public void setModelo(EnumModelo modelo) {
        this.modelo = modelo;
    }
}
