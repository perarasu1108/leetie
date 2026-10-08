-- ──────────────────────────────────────────────────
-- Problem  : 1661. Average Time of Process per Machine
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/average-time-of-process-per-machine/
-- Runtime  : 723 ms (beats 5%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
select 
a.machine_id,
round(
      (select avg(a1.timestamp) from Activity a1 where a1.activity_type = 'end' and a1.machine_id = a.machine_id) - 
      (select avg(a1.timestamp) from Activity a1 where a1.activity_type = 'start' and a1.machine_id = a.machine_id)
,3) as processing_time
from Activity a
group by a.machine_id