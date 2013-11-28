package br.edu.utfpr.cm.pi.modal;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JoaoPaulo
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoLogradouro;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Municipio municipio;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio minicipio) {
        this.municipio = minicipio;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id 
                + ", tipoLogradouro=" + tipoLogradouro
                + ", logradouro=" + logradouro
                + ", numero=" + numero 
                + ", complemento=" + complemento 
                + ", cep=" + cep 
                + ", bairro=" + bairro 
                + ", municipio=" + municipio + '}';
    }

   
}

    
    
