package com.company.booking.services;

import com.company.booking.domain.request.SearchRequest;
import com.company.booking.domain.response.SearchResponse;

public interface SearchService {

    SearchResponse search(SearchRequest searchRequest);
}
