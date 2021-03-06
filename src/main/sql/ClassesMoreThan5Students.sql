-- There is a table courses with columns: student and class
--
-- Please list out all classes which have more than or equal to 5 students.
--
-- For example, the table:
--
-- +---------+------------+
-- | student | class      |
-- +---------+------------+
-- | A       | Math       |
-- | B       | English    |
-- | C       | Math       |
-- | D       | Biology    |
-- | E       | Math       |
-- | F       | Computer   |
-- | G       | Math       |
-- | H       | Math       |
-- | I       | Math       |
-- +---------+------------+
--
-- Should output:
--
-- +---------+
-- | class   |
-- +---------+
-- | Math    |
-- +---------+
--
-- Note:
-- The students should not be counted duplicate in each course.
--
-- see LeetCode #596. Classes with More Than 5 Students: https://leetcode.com/problems/classes-more-than-5-students/

select class
from courses
group by class
having count(distinct student) >= 5
