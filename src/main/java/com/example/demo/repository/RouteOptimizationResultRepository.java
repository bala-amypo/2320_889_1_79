package com.example.demo.repository;

import com.example.demo.entity.RouteOptimizationResult;
import java.util.*;

public interface RouteOptimizationResultRepository {
    RouteOptimizationResult save(RouteOptimizationResult r);
    Optional<RouteOptimizationResult> findById(Long id);
}
