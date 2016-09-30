/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Diego
 */
public class Property {
    private int idSeq;
    private String propertyKey;
    private String propertyVal;

    
    public Property(){
        this(0,"","");
    }
            
    public Property(int idSeq, String propertyKey, String propertyVal) {
        this.idSeq = idSeq;
        this.propertyKey = propertyKey;
        this.propertyVal = propertyVal;
    }

    public int getIdSeq() {
        return idSeq;
    }

    public void setIdSeq(int idSeq) {
        this.idSeq = idSeq;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyVal() {
        return propertyVal;
    }

    public void setPropertyVal(String propertyVal) {
        this.propertyVal = propertyVal;
    }

    @Override
    public String toString() {
        return "Property{" + "idSeq=" + idSeq + ", propertyKey=" + propertyKey + ", propertyVal=" + propertyVal + '}';
    }
}
