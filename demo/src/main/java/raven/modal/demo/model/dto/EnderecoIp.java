package raven.modal.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoIp {
    private String ip;

    public EnderecoIp(String ip) {
        this.ip = ip;
    }
}
