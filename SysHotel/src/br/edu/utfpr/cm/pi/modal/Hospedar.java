/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.modal;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author JoaoPaulo
 */
@Entity
public class Hospedar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFim;
    @OneToOne
    private Cliente nome;
    @OneToOne
    private Apartamento Apartamento;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the dataInicio
     */
    public Calendar getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Calendar getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the nome
     */
    public Cliente getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(Cliente nome) {
        this.nome = nome;
    }

    /**
     * @return the Apartamento
     */
    public Apartamento getApartamento() {
        return Apartamento;
    }

    /**
     * @param Apartamento the Apartamento to set
     */
    public void setApartamento(Apartamento apartamento) {
        this.Apartamento = apartamento;
    }
}
