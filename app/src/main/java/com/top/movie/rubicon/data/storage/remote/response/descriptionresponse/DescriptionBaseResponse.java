package com.top.movie.rubicon.data.storage.remote.response.descriptionresponse;

import android.net.Network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DescriptionBaseResponse implements Serializable {

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("created_by")
    @Expose
    private List<CreatedByResponse> mCreatedByResponses = null;
    @SerializedName("episode_run_time")
    @Expose
    private List<Long> episodeRunTime = null;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("genres")
    @Expose
    private List<GenreResponse> mGenreResponses = null;
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("in_production")
    @Expose
    private Boolean inProduction;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("last_air_date")
    @Expose
    private String lastAirDate;
    @SerializedName("last_episode_to_air")
    @Expose
    private LastEpisodeToAirResponse mLastEpisodeToAirResponse;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("next_episode_to_air")
    @Expose
    private NextEpisodeToAirResponse mNextEpisodeToAirResponse;
    @SerializedName("networks")
    @Expose
    private List<Network> networks = null;
    @SerializedName("number_of_episodes")
    @Expose
    private Long numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    private Long numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("production_companies")
    @Expose
    private List<ProductionCompanyResponse> mProductionCompanyResponses = null;
    @SerializedName("seasons")
    @Expose
    private List<SeasonResponse> mSeasonResponses = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Long voteCount;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<CreatedByResponse> getCreatedByResponses() {
        return mCreatedByResponses;
    }

    public void setCreatedByResponses(List<CreatedByResponse> createdByResponses) {
        mCreatedByResponses = createdByResponses;
    }

    public List<Long> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Long> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<GenreResponse> getGenreResponses() {
        return mGenreResponses;
    }

    public void setGenreResponses(List<GenreResponse> genreResponses) {
        mGenreResponses = genreResponses;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getInProduction() {
        return inProduction;
    }

    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public LastEpisodeToAirResponse getLastEpisodeToAirResponse() {
        return mLastEpisodeToAirResponse;
    }

    public void setLastEpisodeToAirResponse(LastEpisodeToAirResponse lastEpisodeToAirResponse) {
        mLastEpisodeToAirResponse = lastEpisodeToAirResponse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NextEpisodeToAirResponse getNextEpisodeToAirResponse() {
        return mNextEpisodeToAirResponse;
    }

    public void setNextEpisodeToAirResponse(NextEpisodeToAirResponse nextEpisodeToAirResponse) {
        mNextEpisodeToAirResponse = nextEpisodeToAirResponse;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public Long getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Long numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Long getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Long numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompanyResponse> getProductionCompanyResponses() {
        return mProductionCompanyResponses;
    }

    public void setProductionCompanyResponses(List<ProductionCompanyResponse> productionCompanyResponses) {
        mProductionCompanyResponses = productionCompanyResponses;
    }

    public List<SeasonResponse> getSeasonResponses() {
        return mSeasonResponses;
    }

    public void setSeasonResponses(List<SeasonResponse> seasonResponses) {
        mSeasonResponses = seasonResponses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
