package com.top.movie.rubicon.data.storage.remote.response.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TvShowSearchBaseResponse implements Serializable {

    @SerializedName("page")
    @Expose
    private Long page;
    @SerializedName("total_results")
    @Expose
    private Long totalResults;
    @SerializedName("total_pages")
    @Expose
    private Long totalPages;
    @SerializedName("results")
    @Expose
    private List<TvShowSearchResponse> mTvShowSearchResponses = null;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public List<TvShowSearchResponse> getTvShowSearchResponses() {
        return mTvShowSearchResponses;
    }

    public void setTvShowSearchResponses(List<TvShowSearchResponse> tvShowSearchResponses) {
        mTvShowSearchResponses = tvShowSearchResponses;
    }
}
