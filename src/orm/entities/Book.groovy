package orm.entities

import orm.annotations.CrudField
import orm.annotations.CrudTable

@CrudTable(tableName = "author")
class Book {
    @CrudField(columnName = "id", pk = true)
    Long id
    @CrudField(columnName = "name")
    String name
    @CrudField(columnName = "author_id")
    Long author_id
    Author author
}
