package com.example.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {
    @GetMapping("/analytics")
    public String getHome(){
        return "analytics";
    }
    @GetMapping("/analytics/category/{category}")
    public String getCategoryAnalytics(@PathVariable String category, Model model) {
        Object categoryData = analyticsService.getCategoryData(category);
        model.addAttribute("categoryData", categoryData);
        return "categoryAnalytics";
    }

    @GetMapping("/analytics/summary")
    public String getSummary(@RequestParam(name = "start", required = false) String start, 
                             @RequestParam(name = "end", required = false) String end, 
                             Model model) {
        Object summaryData = analyticsService.getSummaryData(start, end);
        model.addAttribute("summaryData", summaryData);
        return "summary";
    }

    @PostMapping("/analytics/add")
    public String addAnalyticsRecord(@RequestParam String recordData, Model model) {
        analyticsService.addNewRecord(recordData);
        model.addAttribute("message", "Record added successfully");
        return "analytics";
    }

    @PutMapping("/analytics/update/{id}")
    public String updateAnalyticsRecord(@PathVariable int id, @RequestParam String newRecordData, Model model) {
        analyticsService.updateRecord(id, newRecordData);
        model.addAttribute("message", "Record updated successfully");
        return "analytics";
    }

    @DeleteMapping("/analytics/delete/{id}")
    public String deleteAnalyticsRecord(@PathVariable int id, Model model) {
        analyticsService.deleteRecord(id);
        model.addAttribute("message", "Record deleted successfully");
        return "analytics";
    }
}
