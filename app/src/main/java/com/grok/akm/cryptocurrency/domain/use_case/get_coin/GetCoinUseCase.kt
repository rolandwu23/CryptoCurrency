package com.grok.akm.cryptocurrency.domain.use_case.get_coin

import com.grok.akm.cryptocurrency.common.Resource
import com.grok.akm.cryptocurrency.data.remote.dto.toCoin
import com.grok.akm.cryptocurrency.data.remote.dto.toCoinDetail
import com.grok.akm.cryptocurrency.domain.model.Coin
import com.grok.akm.cryptocurrency.domain.model.CoinDetail
import com.grok.akm.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch(e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error has occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Kindly check your connection."))
        }
    }

}