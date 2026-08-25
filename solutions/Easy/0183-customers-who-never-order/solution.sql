-- ──────────────────────────────────────────────────
-- Problem  : 183. Customers Who Never Order
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/customers-who-never-order/
-- Runtime  : 592 ms (beats 64%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT name as Customers
from Customers
where id not in (
    select customerId
    from Orders
);