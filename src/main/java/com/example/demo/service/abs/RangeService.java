package com.example.demo.service.abs;

import com.example.demo.model.Range;

import java.util.List;

public interface RangeService {
    List<Range> getAllRanges();
    Range getRangeById(Integer id);
    Range saveRange(Range range);
    void deleteRange(Integer id);
}