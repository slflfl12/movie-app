package io.github.slflfl12.remote.source

import io.github.slflfl12.data.model.MovieData
import io.github.slflfl12.data.model.TvData
import io.github.slflfl12.data.remote.DiscoverRemoteDataSource
import io.github.slflfl12.remote.api.DiscoverApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DiscoverRemoteDataSourceImpl(
    private val discoverApiService: DiscoverApiService
) : DiscoverRemoteDataSource {

    override fun getDiscoverMovies(page: Int): Single<List<MovieData>> {
        return discoverApiService.getDiscoverMovie(page)
            .map {
                it.movies.map { from ->
                    MovieData(
                        page = page,
                        adult = from.adult,
                        backdropPath = from.backdropPath,
                        genreIds = from.genreIds,
                        id = from.id,
                        originalLanguage = from.originalLanguage,
                        originalTitle = from.originalTitle,
                        overview = from.overview,
                        popularity = from.popularity,
                        posterPath = from.posterPath,
                        releaseDate = from.releaseDate,
                        title = from.title,
                        video = from.video,
                        voteAverage = from.voteAverage,
                        voteCount = from.voteCount,
                        favorite = false
                    )
                }
            }.subscribeOn(Schedulers.io())
    }

    override fun getDiscoverTvs(page: Int): Single<List<TvData>> {
        return discoverApiService.getDiscoverTv(page)
            .map {
                it.discoverTvs.map { from ->
                    TvData(
                        page = page,
                        backdropPath = from.backdropPath,
                        firstAirDate = from.firstAirDate,
                        genreIds = from.genreIds,
                        id = from.id,
                        name= from.name,
                        originCountry = from.originCountry,
                        originalLanguage = from.originalLanguage,
                        originalName = from.originalName,
                        overview = from.overview,
                        popularity = from.popularity,
                        posterPath = from.posterPath,
                        voteCount = from.voteCount,
                        voteAverage = from.voteAverage,
                        favorite = false
                    )
                }
            }.subscribeOn(Schedulers.io())
    }
}