package com.grok.akm.cryptocurrency.presentation.coin_detail

import com.grok.akm.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
