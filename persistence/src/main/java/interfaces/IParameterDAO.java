/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import javax.persistence.Parameter;

/**
 *
 * @author ang3lfco
 */
public interface IParameterDAO {
    void create(Parameter parameter);
    Parameter read(Long id);
    void update(Parameter parameter);
    void delete(Long id);
    List<Parameter> getParameters();
}
