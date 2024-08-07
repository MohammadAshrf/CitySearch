package com.example.citysearch.data.structure

import com.example.citysearch.data.models.City
import java.util.Locale

class Trie {
    private val root = TrieNode()

    fun insert(city: City) {
        var node = root
        city.name.lowercase(Locale.ROOT).forEach { char ->
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.city = city
    }

    fun search(prefix: String): List<City> {
        var node = root
        prefix.lowercase(Locale.ROOT).forEach { char ->
            node = node.children[char] ?: return emptyList()
        }
        return collectAllCities(node)
    }

    private fun collectAllCities(node: TrieNode): List<City> {
        val cities = mutableListOf<City>()
        node.city?.let { cities.add(it) }
        node.children.values.forEach { child ->
            cities.addAll(collectAllCities(child))
        }
        return cities
    }

    private data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var city: City? = null
    )
}