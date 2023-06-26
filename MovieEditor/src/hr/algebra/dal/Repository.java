/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jo
 * @param <T>
 */
public interface Repository<T> {

    int createOne(T t) throws Exception;

    void createList(List<T> t) throws Exception;

    void updateOne(int id, T t) throws Exception;

    void deleteOne(int id) throws Exception;

    void deleteAll() throws Exception;

    Optional<T> selectOne(int id) throws Exception;

    List<T> selectList() throws Exception;
}
