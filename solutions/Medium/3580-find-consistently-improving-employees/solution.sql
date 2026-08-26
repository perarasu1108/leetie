-- ──────────────────────────────────────────────────
-- Problem  : 3580. Find Consistently Improving Employees
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/find-consistently-improving-employees/
-- Runtime  : 559 ms (beats 68%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH ranked AS 
(
    SELECT  * ,
    ROW_NUMBER() 
    OVER(
            PARTITION BY employee_id
            ORDER BY review_date DESC

        )   AS rn
    FROM performance_reviews
) , 
pivoted AS
(
    SELECT employee_id , 

    MAX(CASE WHEN rn=1 THEN rating END) AS latest,
    MAX(CASE WHEN rn=2 THEN rating END) AS middle,
    MAX(CASE WHEN rn=3 THEN rating END) AS oldest,

    COUNT(*) AS review_count
    FROM ranked
    WHERE rn<=3
    GROUP BY employee_id
)
SELECT e.employee_id ,
e.name ,
(p.latest - p.oldest) AS improvement_score
FROM pivoted p 
JOIN employees e 
ON p.employee_id = e.employee_id
WHERE review_count = 3
AND latest>middle 
AND middle>oldest 
ORDER BY improvement_score DESC , e.name;



