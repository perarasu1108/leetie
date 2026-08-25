-- ──────────────────────────────────────────────────
-- Problem  : 3586. Find COVID Recovery Patients
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/find-covid-recovery-patients/
-- Runtime  : 649 ms (beats 28%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH first_positive AS (
    SELECT patient_id,
           MIN(test_date) AS f_p
    FROM covid_tests
    WHERE result = 'Positive'
    GROUP BY patient_id
),
first_neg_after_pos AS (
    SELECT
        ct.patient_id,
        fp.f_p,
        MIN(ct.test_date) AS f_n
    FROM covid_tests ct
    JOIN first_positive fp
      ON ct.patient_id = fp.patient_id
    WHERE ct.result = 'Negative'
      AND ct.test_date > fp.f_p
    GROUP BY ct.patient_id, fp.f_p
)
SELECT
    fn.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(fn.f_n, fn.f_p) AS recovery_time
FROM first_neg_after_pos fn
JOIN patients p
  ON p.patient_id = fn.patient_id
ORDER BY recovery_time, patient_name;