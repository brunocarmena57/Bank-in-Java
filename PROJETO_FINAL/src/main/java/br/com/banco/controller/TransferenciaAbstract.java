package br.com.banco.controller;

public abstract class TransferenciaAbstract {

    private float valueTaxaFixa;

    public TransferenciaAbstract(float valueTaxaFixa) {
        this.valueTaxaFixa = valueTaxaFixa;
    }

    public float getValueTaxaFixa() {
        return valueTaxaFixa;
    }

    abstract float taxaTransferencia(float valor);
}
