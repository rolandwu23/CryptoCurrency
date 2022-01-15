package com.grok.akm.cryptocurrency.domain.use_case.get_coins

import com.grok.akm.cryptocurrency.common.Resource
import com.grok.akm.cryptocurrency.data.remote.dto.toCoin
import com.grok.akm.cryptocurrency.domain.model.Coin
import com.grok.akm.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

   operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
       try{
           emit(Resource.Loading<List<Coin>>())
           val coins = repository.getCoins().map { it.toCoin() }
           emit(Resource.Success<List<Coin>>(coins))
       }catch(e: HttpException){
           emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error has occurred"))
       }catch (e: IOException){
           emit(Resource.Error<List<Coin>>("Couldn't reach server. Kindly check your connection."))
       }
   }

}