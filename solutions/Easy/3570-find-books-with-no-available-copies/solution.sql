-- ──────────────────────────────────────────────────
-- Problem  : 3570. Find Books with No Available Copies
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/find-books-with-no-available-copies/
-- Runtime  : 656 ms (beats 30%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

WITH CTE AS (
    SELECT 
        book_id, 
        COUNT(record_id) AS current_borrowers
    FROM borrowing_records
    WHERE return_date IS NULL
    GROUP BY book_id
)
SELECT 
    l.book_id, 
    l.title, 
    l.author, 
    l.genre, 
    l.publication_year, 
    c.current_borrowers
FROM CTE c
JOIN library_books l
    ON c.book_id = l.book_id
WHERE c.current_borrowers = l.total_copies
ORDER BY 
    c.current_borrowers DESC, 
    l.title;