package com.keepcoding.marvelsuperpoderes.data.network

import com.keepcoding.marvelsuperpoderes.domain.CharacterRemote
import com.keepcoding.marvelsuperpoderes.data.network.api.MarvelApi
import java.security.MessageDigest
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: MarvelApi,
) : NetworkDataSourceInterface {

    private val publicKey: String = "9e29a1b538598cc40c0eea1cb004c319"
    private val privateKey: String = "8618a98177baca915891777d0e4f95947ea79dcc"
    private val ts: String = "1"
    
    override suspend fun getCharacters(): List<CharacterRemote> {
        val hash = MD5("$ts$privateKey$publicKey")
        val response = api.getCharacters(publicKey, "1", hash, "")
        
        return response.data.results
    }
    
    private fun MD5(value: String): String {
        val md = MessageDigest.getInstance("MD5")
        val hashBytes = md.digest(value.toByteArray())

        return hashBytes.joinToString("") { "%02x".format(it) }
    }
}