package com.company.booking.web;

import com.company.booking.domain.request.SearchRequest;
import com.company.booking.domain.response.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.company.booking.services.impl.search.BusSearchService;

@Controller
public class BusSearchController {
    @Autowired
    private BusSearchService busSearchService;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public SearchResponse postNewBooking(@RequestBody SearchRequest searchRequest) {
        return busSearchService.search(searchRequest);
    }



    // other API's

}
