package io.github.slflfl12.data.remote

import io.github.slflfl12.data.model.DiscoverMovieData
import io.reactivex.Single

interface DiscoverRemoteDataSource {

    fun getDiscoverMovies(page: Int): Single<List<DiscoverMovieData>>

}