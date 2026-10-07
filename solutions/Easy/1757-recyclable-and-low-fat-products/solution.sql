-- ──────────────────────────────────────────────────
-- Problem  : 1757. Recyclable and Low Fat Products
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/recyclable-and-low-fat-products/
-- Runtime  : 567 ms (beats 59%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT product_id
FROM Products
WHERE low_fats = "Y" AND recyclable = "Y";