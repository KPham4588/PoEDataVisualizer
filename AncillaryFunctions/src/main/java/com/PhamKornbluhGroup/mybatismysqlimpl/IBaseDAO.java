package com.PhamKornbluhGroup.mybatismysqlimpl;

public interface IBaseDAO<T> {
    T getEntityById(int id);
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(int id);
}
