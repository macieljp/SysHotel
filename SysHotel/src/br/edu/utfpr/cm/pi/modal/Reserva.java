/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.pi.modal;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author JoaoPaulo
 */
@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String status;//estado atual da reserva
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDeEntrada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDeSaida;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Apartamento apt;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cli;

    /**
     * @param apt the apt to set
     */
    public void setApt(Apartamento apt) {
        this.apt = apt;
    }

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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dataDeEntrada
     */
    public Calendar getDataDeEntrada() {
        return dataDeEntrada;
    }

    /**
     * @param dataDeEntrada the dataDeEntrada to set
     */
    public void setDataDeEntrada(Calendar dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    /**
     * @return the dataDeSaida
     */
    public Calendar getDataDeSaida() {
        return dataDeSaida;
    }

    /**
     * @param dataDeSaida the dataDeSaida to set
     */
    public void setDataDeSaida(Calendar dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    /**
     * @return the apt
     */
    public Apartamento getApt() {
        return apt;
    }

    /**
     * @return the cli
     */
    public Cliente getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Cliente cli) {
        this.cli = cli;
    }
}
