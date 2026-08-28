-- ──────────────────────────────────────────────────
-- Problem  : 3220. Odd and Even Transactions
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/odd-and-even-transactions/
-- Runtime  : 263 ms (beats 98%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT
    transaction_date,
    COALESCE(SUM(CASE WHEN amount % 2 = 1 THEN amount END), 0) AS odd_sum,
    COALESCE(SUM(CASE WHEN amount % 2 = 0 THEN amount END), 0) AS even_sum
FROM Transactions
GROUP BY transaction_date
ORDER BY transaction_date;