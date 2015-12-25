package orm

interface CrudDaoService<T extends CrudEntity, ID extends Serializable> {
    /**
     * Persists entity to DB.
     * Creates INSERT INTO ON DUPLICATE KEY UPDATE prepared statement based on entity fields
     * @param entity
     * @return
     */
    T saveEntity(T entity)

    /**
     * Persists collections of entities to DB
     * Creates one insert statement for all entities.
     * TODO maybe if we will have too many entities we should use limit of rows to be inserted per one query
     * @param entities
     * @return
     */
    Iterable<T> save(Iterable<T> entities)

    /**
     * Finds entity by ID
     * @param id
     * @return
     */
    T findOne(ID id)

    boolean exists(ID id)

    Iterable<T> findAll()

    Iterable<T> findAll(Iterable<ID> ids)

    void delete(ID id)

    void delete(T entity)

}