-- ──────────────────────────────────────────────────
-- Problem  : 577. Employee Bonus
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/employee-bonus/
-- Runtime  : 937 ms (beats 91%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT Employee.name,Bonus.bonus FROM Employee 
LEFT JOIN Bonus ON Employee.empID = Bonus.empID
WHERE bonus < 1000 OR Bonus IS NULL ;