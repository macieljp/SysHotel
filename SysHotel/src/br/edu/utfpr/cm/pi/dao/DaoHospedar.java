package br.edu.utfpr.cm.pi.dao;

import br.edu.utfpr.cm.pi.modal.Hospedar;

public class DaoHospedar extends DaoGenerics<Hospedar> {

    public DaoHospedar() {
        super.alvo = Hospedar.class;
    }
}
