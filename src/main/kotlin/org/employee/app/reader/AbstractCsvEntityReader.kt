package org.employee.app.reader

import java.io.File


abstract class AbstractCsvEntityReader<T> : EntityReader<T> {

    val DELIMETER = ","

    override fun readEntities(fileName: String): List<T> {
        val lines = File(fileName).readLines()
        val headersMap = readHeaders(lines.first())
        val entities = ArrayList<T>();
        for((index, s) in lines.withIndex()) {
            if (index > 0) {
                val entity = readEntity(s, headersMap)
                entities.add(entity)
            }

        }
        return entities
    }

    private fun readHeaders(header: String): Map<String, Int> {
        val headers = header.split(DELIMETER)
        val headersMap = HashMap<String, Int>()
        for(i in headers.indices) {
            headersMap.put(headers[i], i)
        }
        return headersMap
    }

    abstract fun readEntity(entityString: String, headersMap: Map<String, Int>) : T

}
