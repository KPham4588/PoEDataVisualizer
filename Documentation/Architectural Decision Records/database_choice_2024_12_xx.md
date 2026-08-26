# Data Retention Policy
## Status: Accepted
## Context:
We are making POEDataVisualizer, an application that gets items from GGG and displays those items' pricing trend in charts. As we fetch and store data, we need to choose a database to store the data in. We chose to use SQL to accurately represent relationships between items and relationships between an individual item and its individual attributes.

## Decision:
As of December 2024, we chose to use MySQL due to our familiarity with it. We also installed MySQL Workbench as the client of choice.