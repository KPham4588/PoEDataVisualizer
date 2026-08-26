# Data Retention Policy
## Status: Accepted
## Context:
as POEDataVisualizer continues to grow, it is prudent to consider database sizes in an attempt to optimize the cost-to-data ratio. As the project currently has no revenue, the maintenance cost becomes more important.

## Decision:
As of August 18th, 2026, the database will have a recurring event to wipe GGG API results that were inserted more than 14 days ago. The script is as follows:

```SQL
CREATE EVENT IF NOT EXISTS DeleteOldData
ON SCHEDULE EVERY 1 DAY  
ON COMPLETION PRESERVE  
DO  
DELETE FROM Result  
WHERE created_at < DATE_SUB(NOW(), INTERVAL 14 DAY)  
AND created_at <> '2026-04-15 03:52:25';  
```

The above script deletes old data daily and preserves a portion of data for testing. That part will also gradually be removed when testing is finished. Over the lifetime of this application, we will monitor to ensure that we can retain an acceptable amount of data. This means that the above event will change accordingly.
