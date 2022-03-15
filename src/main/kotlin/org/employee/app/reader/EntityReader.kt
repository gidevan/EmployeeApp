package org.employee.app.reader

interface EntityReader<T> {
    fun readEntities(fileName:String) : List<T>
}
