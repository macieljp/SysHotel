package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.GrupoDeProduto;

public class DaoGrupoDeProduto extends DaoGenerics<GrupoDeProduto> {

    public DaoGrupoDeProduto() {
        super.alvo = GrupoDeProduto.class;
    }
}
