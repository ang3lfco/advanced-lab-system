/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Test;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface ITestDAO {
    void create(Test test);
    Test read(Long id);
    void update(Test test);
    void delete(Long id);
    List<Test> getTests();
}
