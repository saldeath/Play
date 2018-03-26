package com.example.silwan.play.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Silwan on 21/03/2018.
 */

public class ApiResponse {
    @SerializedName("total_count")
    @Expose
    private int totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<RepoSearchResponse> items = null;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<RepoSearchResponse> getItems() {
        return items;
    }

    public void setItems(List<RepoSearchResponse> items) {
        this.items = items;
    }
}
