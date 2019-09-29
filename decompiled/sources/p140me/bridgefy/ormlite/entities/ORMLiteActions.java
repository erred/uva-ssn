package p140me.bridgefy.ormlite.entities;

import com.j256.ormlite.dao.RuntimeExceptionDao;

/* renamed from: me.bridgefy.ormlite.entities.ORMLiteActions */
public abstract class ORMLiteActions<T, ID> {
    public abstract boolean delete(RuntimeExceptionDao<T, ID> runtimeExceptionDao);

    public abstract T set(RuntimeExceptionDao<T, ID> runtimeExceptionDao);

    public abstract boolean update(RuntimeExceptionDao<T, ID> runtimeExceptionDao);
}
