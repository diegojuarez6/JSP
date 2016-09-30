/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Property;

/**
 *
 * @author Diego
 */
public interface PropertyDAO {
    void agregarProperty(Property property);
    void borrarProperty(int idSeq);
    void cambiarProperty(Property property);
    List<Property> desplegarProperties();
    Property elegirProperty(int idSeq);
}
