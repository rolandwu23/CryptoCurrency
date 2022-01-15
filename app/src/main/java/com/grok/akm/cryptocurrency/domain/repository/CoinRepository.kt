package com.grok.akm.cryptocurrency.domain.repository

import com.grok.akm.cryptocurrency.data.remote.dto.CoinDetailDto
import com.grok.akm.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}