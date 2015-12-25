package orm.entities

import orm.CrudEntity
import orm.annotations.CrudField
import orm.annotations.CrudTable


@CrudTable(tableName = "author")
class Author implements CrudEntity {
    @CrudField(columnName = "id", pk = true)
    Long id
    @CrudField(columnName = "name")
    String name
    List<Book> books
}
