-- ──────────────────────────────────────────────────
-- Problem  : 1378. Replace Employee ID With The Unique Identifier
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
-- Runtime  : 1591 ms (beats 19%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT euni.unique_id, e.name 
FROM Employees e  
LEFT JOIN EmployeeUNI euni  
ON e.id = euni.id;