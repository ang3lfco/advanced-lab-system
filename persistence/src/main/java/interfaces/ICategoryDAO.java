/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Category;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface ICategoryDAO {
    void create(Category category);
    Category read(Long id);
    void update(Category category);
    void delete(Long id);
    List<Category> getCategories();
}
