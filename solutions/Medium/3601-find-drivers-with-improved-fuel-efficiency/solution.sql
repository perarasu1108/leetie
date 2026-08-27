-- ──────────────────────────────────────────────────
-- Problem  : 3601. Find Drivers with Improved Fuel Efficiency
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/find-drivers-with-improved-fuel-efficiency/
-- Runtime  : 767 ms (beats 12%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH efficiency AS(
    SELECT driver_id,
    AVG(CASE WHEN MONTH(trip_date) BETWEEN 1 AND 6 THEN distance_km / fuel_consumed END) AS first_half_avg,
    AVG(CASE WHEN MONTH(trip_date) BETWEEN 7 AND 12 THEN distance_km / fuel_consumed END) AS second_half_avg
    FROM trips
    GROUP BY driver_id)

SELECT d.driver_id, d.driver_name,
ROUND(e.first_half_avg, 2) AS first_half_avg,
ROUND(e.second_half_avg, 2) AS second_half_avg,
ROUND(e.second_half_avg - e.first_half_avg, 2) AS efficiency_improvement
FROM drivers d
LEFT JOIN efficiency e ON e.driver_id = d.driver_id
WHERE e.first_half_avg IS NOT NULL
AND e.second_half_avg IS NOT NULL
AND (e.second_half_avg - e.first_half_avg) > 0
ORDER BY efficiency_improvement DESC, d.driver_name