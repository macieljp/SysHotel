package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Telefone;

public class DaoTelefone extends DaoGenerics<Telefone> {

    public DaoTelefone() {
        super.alvo = Telefone.class;
    }
}
