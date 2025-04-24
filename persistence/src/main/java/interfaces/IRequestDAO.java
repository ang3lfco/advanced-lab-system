/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Request;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface IRequestDAO {
    void create(Request request);
    Request read(Long id);
    void update(Request request);
    void delete(Long id);
    List<Request> getRequests();
}
