/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.estudiantes.dao;

import java.util.List;
import mx.edu.utng.estudiantes.model.Materia;

/**
 *
 * @author Diego
 */
public interface MateriaDAO {
    void agregarMateria(Materia materia);
    void borrarMateria(int idMateria);
    void cambiarMateria(Materia materia);
    List<Materia> desplegarMaterias();
    Materia elegirMateria(int idMateria);
}
