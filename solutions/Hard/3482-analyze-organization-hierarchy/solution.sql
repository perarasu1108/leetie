-- ──────────────────────────────────────────────────
-- Problem  : 3482. Analyze Organization Hierarchy
-- Difficulty: Hard
-- Tags     : Database
-- Link     : https://leetcode.com/problems/analyze-organization-hierarchy/
-- Runtime  : 347 ms (beats 38%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH RECURSIVE
    -- Hierarchy_levels
cte AS (    
    SELECT              -- Anchor Member
        employee_id,
        employee_name,
        1 AS level
    FROM Employees
    WHERE manager_id IS NULL

        UNION ALL

    SELECT              -- Recursive Member
        e.employee_id,
        e.employee_name,
        c.level + 1 AS level
    FROM Employees e
    JOIN cte c
        ON e.manager_id = c.employee_id
),
    -- (manager, employee) pairs
cte1 AS (   
    SELECT              -- Anchor Member
        employee_id AS manager_id,
        employee_id,
        salary
    FROM Employees 

        UNION ALL

    SELECT              -- Recursive Member
        c1.manager_id,
        e.employee_id,
        e.salary
    FROM cte1 c1
    JOIN Employees e
        ON c1.employee_id = e.manager_id
),
    -- basic aggregation
cte2 AS (
    SELECT 
        c.manager_id AS employee_id,
        COUNT(*) - 1 AS team_size,
        SUM(c.salary) AS budget
    FROM cte1 c
    GROUP BY 1
)
SELECT
    c.employee_id,
    c.employee_name,
    c.level,
    c2.team_size,
    c2.budget
FROM cte2 c2
LEFT JOIN cte c
    ON c.employee_id = c2.employee_id
ORDER BY 3, 5 DESC, 2;

