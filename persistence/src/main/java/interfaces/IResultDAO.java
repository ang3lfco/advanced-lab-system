/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Result;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface IResultDAO {
    void create(Result result);
    Result read(Long id);
    void update(Result result);
    void delete(Long id);
    List<Result> getResults();
}
