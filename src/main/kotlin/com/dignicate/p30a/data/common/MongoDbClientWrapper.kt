package com.dignicate.p30a.data.common

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.client.model.Filters
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList
import org.bson.conversions.Bson

class MongoDbClientWrapper(
    connectionString: String,
    databaseName: String
) {
    private val client: MongoClient = MongoClient.create(connectionString)
    private val database: MongoDatabase = client.getDatabase(databaseName)

    private fun <T : Any> getCollection(collectionName: String, documentClass: Class<T>): MongoCollection<T> {
        return database.getCollection(collectionName, documentClass)
    }

    suspend fun <T : Any> insertOne(collectionName: String, document: T, documentClass: Class<T>) {
        val collection = getCollection(collectionName, documentClass)
        collection.insertOne(document)
    }

    suspend fun <T : Any> findOneById(collectionName: String, id: String, documentClass: Class<T>): T? {
        val collection = getCollection(collectionName, documentClass)
        val filter: Bson = Filters.eq("_id", id)
        return collection.find(filter).firstOrNull()
    }

    suspend fun <T : Any> findAll(
        collectionName: String,
        documentClass: Class<T>,
        limit: Int? = null,
        page: Int? = null
    ): List<T> {
        val collection = database.getCollection(collectionName, documentClass)
        val findFlow = collection.find()

        return if (limit != null && page != null) {
            findFlow
                .skip((page - 1) * limit)
                .limit(limit)
                .toList()
        } else {
            findFlow.toList() // 全件取得
        }
    }

}
