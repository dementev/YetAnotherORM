package orm

import orm.annotations.association
import orm.annotations.Mapping
import orm.annotations.Param
import orm.annotations.Query
import orm.annotations.collection
import orm.entities.Author
import orm.entities.Book

interface SampleDAOService extends CrudDaoService<Author, Long> {

    /**
     * In execution of this method will be created and executed PreparedStatement.
     * After that result set will be mapped to java objects according to annotations.
     * In this case will be created List of Authors and for each Author will be filled list of books.
     * @param name
     * @return
     */
    @Query("""
        select a.*, ':', b.*
        from authors a
            left join books b on (b.author_id = a.id)
        where a.name = :name
        """)
    @Mapping(type = Author,
            collections = [
                    @collection(type = Book)
            ]
    )
    List<Author> getAuthors(@Param("name") String name)


    @Query("""
        select b.*, ':', a.*
        from books b
            left join authors a on (b.author_id = a.id)
        where b.id = :id
        """)
    @Mapping(type = Book,
            associations = [
                    @association(type = Author)
            ]
    )
    Book getBook(@Param("id") Long id)

}