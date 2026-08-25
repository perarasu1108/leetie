-- ──────────────────────────────────────────────────
-- Problem  : 1070. Product Sales Analysis III
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/product-sales-analysis-iii/
-- Runtime  : 955 ms (beats 13%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
select product_id,year as first_year, quantity, price
from Sales
where(product_id, year) in (select  product_id, min(year) from Sales group by product_id)