-- ──────────────────────────────────────────────────
-- Problem  : 197. Rising Temperature
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/rising-temperature/
-- Runtime  : 524 ms (beats 49%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT today.id
FROM Weather yesterday 
CROSS JOIN Weather today

WHERE DATEDIFF(today.recordDate,yesterday.recordDate) = 1
    AND today.temperature > yesterday.temperature
;