package com.grok.akm.cryptocurrency.presentation.coin_list

import com.grok.akm.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)