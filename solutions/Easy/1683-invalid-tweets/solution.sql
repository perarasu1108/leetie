-- ──────────────────────────────────────────────────
-- Problem  : 1683. Invalid Tweets
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/invalid-tweets/
-- Runtime  : 589 ms (beats 84%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT tweet_id FROM Tweets
WHERE LENGTH(content) > 15;