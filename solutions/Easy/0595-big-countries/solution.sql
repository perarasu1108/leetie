-- ──────────────────────────────────────────────────
-- Problem  : 595. Big Countries
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/big-countries/
-- Runtime  : 317 ms (beats 50%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────


select name,area,population from world where area>=3000000 or population >=25000000;