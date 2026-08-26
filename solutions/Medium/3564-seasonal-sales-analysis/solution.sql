-- ──────────────────────────────────────────────────
-- Problem  : 3564. Seasonal Sales Analysis
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/seasonal-sales-analysis/
-- Runtime  : 628 ms (beats 37%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
WITH SeasonalAggregates AS (
    SELECT 
        CASE 
            WHEN MONTH(s.sale_date) IN (12, 1, 2) THEN 'Winter'
            WHEN MONTH(s.sale_date) IN (3, 4, 5) THEN 'Spring'
            WHEN MONTH(s.sale_date) IN (6, 7, 8) THEN 'Summer'
            ELSE 'Fall'
        END AS season,
        p.category,
        SUM(s.quantity) AS total_quantity,
        SUM(s.quantity * s.price) AS total_revenue
    FROM sales s
    JOIN products p ON s.product_id = p.product_id
    GROUP BY season, p.category
),
RankedSeasons AS (
    SELECT 
        season,
        category,
        total_quantity,
        total_revenue,
        ROW_NUMBER() OVER (
            PARTITION BY season 
            ORDER BY total_quantity DESC, total_revenue DESC, category ASC
        ) AS rnk
    FROM SeasonalAggregates
)
SELECT 
    season,
    category,
    total_quantity,
    total_revenue
FROM RankedSeasons
WHERE rnk = 1
ORDER BY season ASC;