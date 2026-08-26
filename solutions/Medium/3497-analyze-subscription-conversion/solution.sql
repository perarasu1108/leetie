-- ──────────────────────────────────────────────────
-- Problem  : 3497. Analyze Subscription Conversion 
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/analyze-subscription-conversion/
-- Runtime  : 449 ms (beats 14%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT u1.user_id, ROUND(AVG(u1.activity_duration), 2) AS 'trial_avg_duration', ROUND(AVG(u2.activity_duration), 2) AS 'paid_avg_duration' FROM UserActivity u1 JOIN UserActivity u2 ON u1.activity_type = 'free_trial' AND u2.activity_type = 'paid' AND u1.user_id = u2.user_id GROUP BY u1.user_id ORDER BY user_id; 
